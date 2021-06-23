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

package uk.gov.hmrc.cdsrc.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import uk.gov.hmrc.cdsrc.driver.BrowserDriver
import uk.gov.hmrc.cdsrc.pages.BasePage
import uk.gov.hmrc.cdsrc.pages.generic.PageObjectFinder

trait BaseStepDef extends ScalaDsl with EN with BrowserDriver with Eventually with Matchers with WebBrowser with BasePage {

  When("""I select Welsh translation on {string}""") { (page: String) =>
    PageObjectFinder.page(page).enableWelsh()
  }

  When("""I select English translation on {string}""") { (page: String) =>
    PageObjectFinder.page(page).enableEnglish()
  }

  When("""I select radio button {string} on {string}""") { (choice: String, page: String) =>
    PageObjectFinder.page(page).clickRadioButton(choice)
  }

  When("""I select checkbox on {string}""") { (page: String) =>
    PageObjectFinder.page(page).selectCheckBox()
  }

  When("""I select {string} on {string}""") { (selection: String, page: String) =>
    PageObjectFinder.page(page).selectBoxes(selection.replaceAll(" to ", "_").split(","))
  }

  When("""I click continue on {string}""") { (page: String) =>
    PageObjectFinder.page(page).clickContinueButton()
  }

  When("""I click {string} on {string}""") { (button: String, page: String) =>
    PageObjectFinder.page(page).clickButton(button)
  }

  When("""I enter {string} on {string}""") { (data: String, page: String) =>
    PageObjectFinder.page(page).enterDetails(data)
  }

  When("""I select dropdown value {string} on {string}""") { (selection: String, page: String) =>
    PageObjectFinder.page(page).dropdownSelect(selection)
  }

  Then("""I navigate to the {string}""") { page: String =>
    go to PageObjectFinder.page(page)
  }

  Then("""I am presented with the {string}""") { page: String =>
    waitForPageHeader
    PageObjectFinder.page(page).checkPageHeader
    PageObjectFinder.page(page).checkPageTitle
    PageObjectFinder.page(page).checkBackButtonExistsIfItShould
    PageObjectFinder.page(page).checkContent("")
  }

  Then("""I am presented with the {string} and content {string}""") { (page: String, content: String) =>
    waitForPageHeader
    PageObjectFinder.page(page).checkPageHeader
    PageObjectFinder.page(page).checkPageTitle
    PageObjectFinder.page(page).checkBackButtonExistsIfItShould
    PageObjectFinder.page(page).checkContent(content)
  }

  Then("""I am presented with the {string} error page""") { page: String =>
    waitForPageHeader
    PageObjectFinder.page(page).checkPageErrorTitle
  }

  Then("""I am presented with the {string} {string}""") { (page: String, duty: String) =>
    waitForPageHeader
    PageObjectFinder.page(page).checkDutyPage(duty)
    PageObjectFinder.page(page).checkBackButtonExistsIfItShould
  }

  Then("""I am presented with the {string} {string} error page""") { (page: String, duty: String) =>
    waitForPageHeader
    PageObjectFinder.page(page).checkDutyPageError(duty)
  }

  Given("""the {string} feature is {string}""") { (feature: String, featureState: String) =>
    PageObjectFinder.page("FeatureSwitchPage").configure(feature, featureState)
  }

}
