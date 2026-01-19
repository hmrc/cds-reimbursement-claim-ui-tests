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

package uk.gov.hmrc.cdsrc.cucumber.stepdefs

import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import uk.gov.hmrc.cdsrc.driver.BrowserDriver
import uk.gov.hmrc.cdsrc.pages.BasePage
import uk.gov.hmrc.cdsrc.pages.generic.PageObjectFinder
import uk.gov.hmrc.cdsrc.pages.generic.PageObjectFinder.DataTableConverters

import scala.jdk.CollectionConverters._

trait BaseStepDef
    extends ScalaDsl
    with EN
    with BrowserDriver
    with Eventually
    with Matchers
    with WebBrowser
    with BasePage {

  When("""I select Welsh translation on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).enableWelsh()
  }

  When("""I select English translation on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).enableEnglish()
  }

  When("""I select radio button {string} on {string}""") { (choice: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickRadioButton(choice)
  }

  When("""I select checkbox on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).selectCheckBox()
  }

  When("""I select {string} on {string}""") { (selection: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).selectBoxes(selection.replaceAll(" to ", "_").split(","))
  }

  When("""I click continue on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickContinueButton()
  }

  When("""I clickContinue on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickContinue()
  }

  When("""I click continue button on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).waitForUploadedFile
    PageObjectFinder.page(page).clickContinueButton()
  }

  When("""I click back button on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickBackButton()
  }

  When("""I click {string} on {string}""") { (button: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickButton(button)
  }

  When("""I enter {string} on {string}""") { (data: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).enterDetails(data)
  }

  When("""I select dropdown value {string} on {string}""") { (selection: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).dropdownSelect(selection)
  }

  Then("""I navigate to the {string}""") { (page: String) =>
    go to PageObjectFinder.page(page)
  }

  When("""I click continue if I'm on {string}""") { (page: String) =>
    PageObjectFinder.page(page).clickContinueButton()
    PageObjectFinder.page(page).continuouslyClickContinue()
  }

  When("""I upload a {string} file on {string}""") { (file: String, page: String) =>
    PageObjectFinder.page(page).uploadDocument(file)
    waitForPageToLoad()
  }

  When("""I upload a {int} {string} file on {string}""") { (docNumber: Int, file: String, page: String) =>
    PageObjectFinder.page(page).uploadDocument(docNumber, file)
    waitForPageToLoad()
  }

  Then("""I am presented with the {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).checkURL
    PageObjectFinder.page(page).checkPageHeader()
    PageObjectFinder.page(page).checkPageTitle()
  }

  Then("""I am presented with the {string} error page""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).checkURL
    PageObjectFinder.page(page).checkPageErrorTitle()
  }

  Then("""The error summary title is {string} and the error message is {string}""") {
    (errorSummaryTitle: String, errorMessage: String) =>
      PageObjectFinder.checkPageErrorSummaryTitle(errorSummaryTitle)
      PageObjectFinder.checkPageErrorMessage(errorMessage)
  }

  Then("""I am presented with the {string} {string}""") { (page: String, specificPage: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).checkURL
    PageObjectFinder.page(page).checkPageTitle(specificPage)
  }

  Then("""I go back on {string}""") { (page: String) =>
    PageObjectFinder.page(page).goBack()
  }

  Then("""I am presented with the {string} {string} error page""") { (page: String, duty: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).checkPageErrorTitle(duty)
  }

  Given("""the {string} feature is {string}""") { (feature: String, featureState: String) =>
    PageObjectFinder.page("FeatureSwitchPage").configure(feature, featureState)
    driver.navigate().back()
  }

  Given("""I enter upload customs documents service url""") {
    driver.get("http://localhost:10110/upload-customs-documents")
  }

  Then("""The page title should be {string}""") { (expectedPageTitle: String) =>
    val pageTitle = driver.getTitle
    pageTitle should equal(expectedPageTitle)
  }

  And("""^I should see the following details""") { (data: DataTable) =>
    val expectedData = data.asMaps().asScala.toList.flatMap(_.asScala.toMap).toMap
    val actualData   = PageObjectFinder.pageData
    actualData should be(expectedData)
  }

  Then("""I should see a cookie consent banner with the following details""") { (data: DataTable) =>
    val expectedText = data.asScalaListOfStrings
    PageObjectFinder.cookieBannerText() should be(expectedText)
  }

  And("""I should see the following {string} on the cookie banner""") { (bannerElement: String, data: DataTable) =>
    val expectedText = data.asScalaListOfStrings
    val tagName      = bannerElement match {
      case "links"   =>
        expectedText.map(link =>
          PageObjectFinder.cookieBannerLinkUrl(link) should endWith("/tracking-consent/cookie-settings")
        )
        "a"
      case "buttons" => "button"
    }
    PageObjectFinder.cookieBannerLinksButtonsText(tagName) should be(expectedText)
  }

  Then("""I click on {string} button""") { (buttonName: String) =>
    PageObjectFinder.button(buttonName).click()
  }

  And("""I should not see cookie consent banner""") { () =>
    PageObjectFinder.cookieBannerPresence() should be(false)
  }
}
