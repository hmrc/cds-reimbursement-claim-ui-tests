/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.cdsrc.pages

import org.openqa.selenium.support.ui._
import org.openqa.selenium.{By, Keys, WebDriver, WebElement}
import org.scalatest.Assertion
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.{Page, WebBrowser}
import uk.gov.hmrc.cdsrc.driver.BrowserDriver

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

trait BasePage extends Page with Matchers with BrowserDriver with Eventually with WebBrowser {
  override val url: String = ""
  val title: String        = ""

  /** Fluent Wait config * */
  def fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(50))
    .pollingEvery(Duration.ofMillis(500))

//  def waitForPageHeader: WebElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))


  protected object Waits {
    val defaultWait: Duration = Duration.ofSeconds(100) // You can make this configurable
  }

  def waitForPageHeader: WebElement = {
    //val fluentWait = new WebDriverWait(driver, Waits.defaultWait)

    fluentWait.until(
      ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))
    )
  }


  object WaitConfig {
    val defaultWait: Duration = Duration.ofSeconds(50) // You can load this from config if needed
  }

  def waitForUploadedFile: WebElement = {
    //val wait = new WebDriverWait(driver, WaitConfig.defaultWait)

    fluentWait.until(
      ExpectedConditions.visibilityOfElementLocated(
        By.xpath("(//span[@class='multi-file-upload__uploaded-tag govuk-tag'][normalize-space()='Uploaded'])[2]")
      )
    )
  }

  /*def waitForUploadedFile: WebElement = fluentWait.until(
    ExpectedConditions.visibilityOfElementLocated(
      By.xpath("(//span[@class='multi-file-upload__uploaded-tag govuk-tag'][normalize-space()='Uploaded'])[2]")
    )
  )*/

  /** Page assertions * */
  def expectedPageTitle: Option[String] = None

  def expectedPageErrorTitle: Option[String] = None

  def expectedPageHeader: Option[String] = None

  def pageHeader: Option[String] = {
    waitForPageHeader
    val header: Option[String] = find(tagName("h1")).map(_.text)
    if (header.get.takeRight(2) == " ?")
      Some(header.get.replaceAll(" \\?$", "?"))
    else
      header
  }

  private val expectedPageTitleList      = expectedPageTitle.map(_.split(";").toList)
  private val expectedPageErrorTitleList = expectedPageErrorTitle.map(_.split(";").toList)
  private val expectedPageHeaderList     = expectedPageHeader.map(_.split(";").toList)

  //def checkPageTitle(): Assertion = {
   // fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))
    //expectedPageTitleList should contain(List(pageTitle))
  //}


  def checkPageTitle(): Assertion = {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))
    expectedPageTitleList should contain (List(pageTitle))
  }


  def checkPageErrorTitle(): Assertion = {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))
    expectedPageErrorTitleList should contain(List(pageTitle))
  }

  def checkPageTitle(page: String): Unit = {
    fluentWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main-content > div > div > h1")))
    driver.findElement(By.cssSelector("#main-content > div > div > h1"))
  }


  def checkPageErrorTitle(page: String): Unit = {}

 // def checkURL: Assertion =
  //  if (url.contains("...")) {
  //    driver.getCurrentUrl should fullyMatch regex (url.replace("...", "") + ".*").r
  //  } else {
  //    driver.getCurrentUrl should equal(url)
  //  }
  //def checkURL(): Unit = {
   // fluentWait.until(ExpectedConditions.urlToBe(url))
   // driver.getCurrentUrl should equal(url)
  //}

  def checkURL: Assertion = {
    // Wait until the URL contains or equals the expected value
    if (url.contains("...")) {
     fluentWait.until(ExpectedConditions.urlMatches(url.replace("...", "") + ".*"))
      driver.getCurrentUrl should fullyMatch regex (url.replace("...", "") + ".*").r
    } else {
      fluentWait.until(ExpectedConditions.urlToBe(url))
      driver.getCurrentUrl should equal(url)
    }
  }


  def uploadDocument(file: String): Unit                 =
    if (file != "") {
      enterText("file", System.getProperty("user.dir") + "/src/test/resources/files/" + file)
    }


  def uploadDocument(docNumber: Int, file: String): Unit = {
    if (file.nonEmpty) {
      val wait = new WebDriverWait(driver, Duration.ofSeconds(90))

      // Wait for the file input to be present and visible
      val fileInput: WebElement = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id(s"file-$docNumber"))
      )
      val filePath = System.getProperty("user.dir") + s"/src/test/resources/files/$file"
      fileInput.sendKeys(filePath)
    }
  }

  //def continuouslyClickContinue(): Unit = {
    //while (find(tagName("h1")).map(_.text).contains("We are checking your document"))
   //   clickContinueButton()
  //}

  def continuouslyClickContinue(): Unit = {
    //val wait = new WebDriverWait(driver, Duration.ofSeconds(120))

    var headingText = fluentWait.until(
      ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))
    ).getText

    while (headingText == "We are checking your document") {
      clickContinueButton()

      // Re-wait for the heading to update after clicking
      headingText = fluentWait.until(
        ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))
      ).getText
    }
  }


  def checkPageHeader(): Assertion = {
    val expectedText = expectedPageHeader.get.trim.replaceAll("\\s+", " ")

    val condition = new ExpectedCondition[Boolean] {
      override def apply(driver: WebDriver): Boolean = {
        val element    = driver.findElement(By.cssSelector("h1"))
        val actualText = element.getText.trim.replaceAll("\\s+", " ")
        actualText.equals(expectedText)
      }
    }

    fluentWait.until(condition)

    val actualText = pageHeader.get.trim.replaceAll("\\s+", " ")
    actualText shouldEqual expectedText

    // Additional debugging information
    println(s"Expected Text: [$expectedText]")
    println(s"Actual Text: [$actualText]")

    expectedPageHeaderList should contain(List(actualText))
  }

 // def waitForPageToLoad(): lang.Boolean =
    //fluentWait.until(ExpectedConditions.textToBe(By.cssSelector(".multi-file-upload__uploaded-tag"), "Uploaded"))


  def waitForPageToLoad(): java.lang.Boolean = {
    //val wait = new WebDriverWait(driver, Duration.ofSeconds(90))
    fluentWait.until(ExpectedConditions.textToBe(By.cssSelector(".multi-file-upload__uploaded-tag"), "Uploaded"))
  }

  //def clickContinueButton(): Unit =
  //click on cssSelector("#main-content > div > div > form > button")

  /*def clickContinueButton(): Unit = {
    val wait = new WebDriverWait(driver, Duration.ofSeconds(100))
    val continueButton = wait.until(
      ExpectedConditions.elementToBeClickable(By.cssSelector("#main-content > div > div > form > button"))
    )
    continueButton.click()
  }*/


  def clickContinueButton(): Unit = {
    //val wait = new WebDriverWait(driver, Duration.ofSeconds(150))
    fluentWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main-content > div > div > form > button")))
    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).click()
  }


  //def clickContinue(): Unit =
  //click on cssSelector("#main-content > div > div > a")

  def clickContinue(): Unit = {
    //val wait = new WebDriverWait(driver, Duration.ofSeconds(150))
    val continueLink: WebElement = fluentWait.until(
      ExpectedConditions.elementToBeClickable(By.cssSelector("#main-content > div > div > a"))
    )

    continueLink.click()
  }

  def clickBackButton(): Unit =
  click on cssSelector(".govuk-back-link")


  def clickButton(buttonText: String): Unit =
    click on partialLinkText(buttonText)


 // def clickRadioButton(text: String): Unit =
   // driver.findElements(By.tagName("label")).asScala.filter(_.getText.trim == text).head.click()

  def clickRadioButton(text: String): Unit = {
    //val wait = new WebDriverWait(driver, Duration.ofSeconds(85))

    val label: WebElement = fluentWait.until { _ =>
      val labels = driver.findElements(By.tagName("label")).asScala
      labels.find(_.getText.trim == text).orNull
    }

    fluentWait.until(ExpectedConditions.elementToBeClickable(label)).click()
  }


  def selectCheckBox(): Unit = {}

  def elementText(query: Query): String    = find(query).get.underlying.getText

  def selectBoxes(toSelect: Array[String]): Unit =
    for (i <- toSelect.indices)
      click on xpath(s"//input[@value='${toSelect(i)}']")

  def textField(id: String, value: String): Unit = {
    val elem = find(id)
    if (elem.isDefined) {
      val e = new TextField(elem.get.underlying)
      if (e.isDisplayed) e.value = value
    }
  }

  def enterText(id: String, textToEnter: String): Unit = {
    driver.findElement(By.id(id)).clear()
    driver.findElement(By.id(id)).sendKeys(textToEnter)
  }

  def selectFromAutocomplete(id: String, textToSelect: String): Unit =
    driver.findElement(By.id(id)).sendKeys(textToSelect + Keys.ENTER)

  def enterDetails(data: String): Unit = {}

  def dropdownSelect(selection: String): Unit = {}

  def enableWelsh(): Unit                                            =
    if (System.getProperty("welsh", "false") == "true")
      click on cssSelector("body > div:nth-child(5) > nav > ul > li:nth-child(2) > a > span:nth-child(2)")

  def enableEnglish(): Unit =
    if (System.getProperty("welsh", "false") == "false")
      click on cssSelector("body > div:nth-child(5) > nav > ul > li:nth-child(1) > a > span:nth-child(2)")

  def clickOnLinkText(text: String): Unit = click on linkText(text)

  def configure(feature: String, featureState: String): Unit = {}

  def checkPageErrorSummaryTitle(errorSummaryTitle: String): Unit = {
    val actualErrorSummaryTitle = driver.findElement(By.className("govuk-error-summary__title")).getText
    actualErrorSummaryTitle should be(errorSummaryTitle)
  }

  def checkPageErrorMessage(errorMessage: String): Unit = {
    val actualErrorMessage = driver.findElement(By.cssSelector(".govuk-error-summary__body")).getText
    assert(actualErrorMessage.contains(errorMessage))
  }

  def pageData: Map[String, String] = driver
    .findElements(By.cssSelector(".govuk-summary-list__row"))
    .asScala
    .flatMap { row =>
      val key   = row.findElement(By.cssSelector(".govuk-summary-list__key")).getText.trim.replace("\n", "")
      val value = row.findElement(By.cssSelector(".govuk-summary-list__value")).getText.trim.replace("\n", ",")
      //val value = row.findElement(By.cssSelector(".govuk-summary-list__value")).getText.trim.replace("\n", ",")
      Map(key -> value)
    }
    .toMap

  def cookieBanner() = driver.findElement(By.cssSelector(".cbanner-govuk-cookie-banner"))

  def cookieBannerText(): Seq[String] = cookieBanner().getText.split("\n").toList

  def cookieBannerLinkUrl(linkText: String): String = cookieBanner()
    .findElement(By.partialLinkText(linkText))
    .getAttribute("href")
    .trim

  def cookieBannerPresence(): Boolean = !driver.findElements(By.cssSelector(".cbanner-govuk-cookie-banner")).isEmpty

  def cookieBannerLinksButtonsText(tag: String): Seq[String] = cookieBanner()
    .findElements(By.tagName(tag))
    .asScala
    .map(_.getText.trim)
    .toList

  def button(buttonName: String): WebElement =
    cookieBanner().findElements(By.tagName("button")).asScala.filter(_.getText == buttonName).head
  //fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")))
}
