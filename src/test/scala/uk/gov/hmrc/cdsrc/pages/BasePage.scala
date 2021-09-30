/*
 * Copyright 2021 HM Revenue & Customs
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

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.openqa.selenium.{By, Keys, WebDriver, WebElement}
import org.scalatest.Assertion
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.{Page, WebBrowser}
import uk.gov.hmrc.cdsrc.driver.BrowserDriver

import java.time.Duration
import java.util.concurrent.TimeUnit
import scala.jdk.CollectionConverters.asScalaBufferConverter

trait BasePage extends Page with Matchers with BrowserDriver with Eventually with WebBrowser {
  override val url: String = ""
  val title: String = ""
  val pageShouldHaveBackButton: Boolean = true //"0 was not greater than 0" error requires this to be overriden with false

  /** Fluent Wait config * */
  var fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(10))
    .pollingEvery(Duration.ofMillis(500))

  def waitForPageHeader: WebElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))

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

  private val expectedPageTitleList = expectedPageTitle.map(_.split(";").toList)
  private val expectedPageErrorTitleList = expectedPageErrorTitle.map(_.split(";").toList)
  private val expectedPageHeaderList = expectedPageHeader.map(_.split(";").toList)

  def checkPageTitle(content: String): Assertion = {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))
    expectedPageTitleList should contain(List(pageTitle))
  }

  def checkPageErrorTitle(content: String): Assertion = {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))
    expectedPageErrorTitleList should contain(List(pageTitle))
  }

  def checkURL: Assertion = {
    if (url.contains("...")) {
      driver.getCurrentUrl should fullyMatch regex (url.replace("...","") + ".*").r
    } else {
      driver.getCurrentUrl should equal(url)
    }
  }

  def uploadDocument(file: String): Unit = {
    if (file != "")
      enterText("file", System.getProperty("user.dir") + "/src/test/resources/files/" + file)
  }

  def continuouslyClickContinue(): Unit = {
    waitForPageToLoad()
    while (find(tagName("h1")).map(_.text).contains("We are checking your document")) {
      clickContinueButton()
    }
  }

  def checkPageHeader(content: String): Assertion = {
    fluentWait.until(ExpectedConditions.textToBe(By.cssSelector("h1"), expectedPageHeader.get))
    expectedPageHeaderList should contain(List(pageHeader.get))
  }

  //if page should have back button, then there should be more than 1 back button on that page
  def checkBackButtonExistsIfItShould: Any = {
    if (pageShouldHaveBackButton) {
      driver.findElements(By.cssSelector("#cdsr-back-link > a")).size() should be > 0
    } else {
      driver.findElements(By.cssSelector("#cdsr-back-link > a")).size() should equal(0)
    }
  }

  def checkContent(content: String): Unit = {
    println("Page is missing content checks and overriding function")
    //uncomment the below line to make it easier to find missing content pages
    //driver.findElement(By.cssSelector("")).getText should equal("")
  }

  def waitForPageToLoad(): WebDriver.Timeouts = {
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS)
  }

  def clickContinueButton(): Unit = click on cssSelector("#main-content > div > div > form > button")

  def clickButton(buttonText: String): Unit = click on partialLinkText(buttonText)

  def clickRadioButton(text: String): Unit = {
    driver.findElements(By.tagName("label")).asScala.filter(_.getText.trim == text).head.click()
  }

  def selectCheckBox(): Unit = {
  }

  def elementText(query: Query): String = find(query).get.underlying.getText

  //for multiple check boxes (might not be needed)
  def selectBoxes(toSelect: Array[String]): Unit = {
    for (i <- toSelect.indices) {
      click on xpath(s"//input[@value='${toSelect(i)}']")
    }
  }

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

  def selectFromAutocomplete(id: String, textToSelect: String): Unit = {
    driver.findElement(By.id(id)).sendKeys(textToSelect + Keys.ENTER)
  }

  def enterDetails(data: String): Unit = {
  }

  def dropdownSelect(selection: String): Unit = {
  }

  def enableWelsh(): Unit = {
    if (System.getProperty("welsh", "false") == "true")
      click on cssSelector("body > div:nth-child(5) > nav > ul > li:nth-child(2) > a > span:nth-child(2)")
  }

  def enableEnglish(): Unit = {
    if (System.getProperty("welsh", "false") == "false")
      click on cssSelector("body > div:nth-child(5) > nav > ul > li:nth-child(1) > a > span:nth-child(2)")
  }

  def clickOnLinkText(text: String): Unit = click on linkText(text)

  def checkDutyPage(duty: String): Unit = {
  }

  def checkDutyPageError(duty: String): Unit = {
  }

  def configure(feature: String, featureState: String): Unit = {
  }

}
