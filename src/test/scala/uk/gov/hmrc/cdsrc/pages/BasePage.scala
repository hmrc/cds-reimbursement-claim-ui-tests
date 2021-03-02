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

import java.time.Duration
import java.util.concurrent.TimeUnit
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatest.Assertion
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.{Page, WebBrowser}
import uk.gov.hmrc.cdsrc.driver.BrowserDriver

trait BasePage extends Page with Matchers with BrowserDriver with Eventually with WebBrowser {
  override val url: String = ""
  val title: String = ""

  /** Fluent Wait config **/
  var fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(10))
    .pollingEvery(Duration.ofMillis(500))

  def waitForPageHeader: WebElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))

  /** Page assertions **/
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

  def checkPageTitle: Assertion = {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))
    expectedPageTitleList should contain(List(pageTitle))
  }

  def checkPageErrorTitle: Assertion = {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))
    expectedPageErrorTitleList should contain(List(pageTitle))
  }

  def checkPageHeader: Assertion = {
    fluentWait.until(ExpectedConditions.textToBe(By.cssSelector("h1"), expectedPageHeader.get))
    expectedPageHeaderList should contain(List(pageHeader.get))
  }

  def waitForPageToLoad(): WebDriver.Timeouts = {
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS)
  }

  def clickContinueButton(): Unit = click on cssSelector("#submitButton")

  def clickButton(buttonText: String): Unit = click on partialLinkText(buttonText)

  def clickRadioButton(text: String): Unit = {
    text.toLowerCase() match {
      case _ => click on xpath(s"//input[@value='$text']")
    }
  }

  def selectCheckBox(): Unit = {
    click on cssSelector("")
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
    driver.findElement(By.id(id)).sendKeys(textToEnter)
  }

  def enterDetails(data: String): Unit = {
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

}
