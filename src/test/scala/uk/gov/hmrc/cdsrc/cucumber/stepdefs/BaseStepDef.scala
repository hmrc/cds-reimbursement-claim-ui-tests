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
    PageObjectFinder.page(page.replaceAll(" ", "")).enableWelsh()
  }

  When("""I select English translation on {string}""") { (page: String) =>
    PageObjectFinder.page(page.replaceAll(" ", "")).enableEnglish()
  }

  When("""I select radio button {string} on {string}""") { (choice: String, page: String) =>
    PageObjectFinder.page(page.replaceAll(" ", "")).clickRadioButton(choice)
  }

  When("""I select checkbox on {string}""") { (page: String) =>
    PageObjectFinder.page(page.replaceAll(" ", "")).selectCheckBox()
  }

  When("""I select {string} on {string}""") { (selection: String, page: String) =>
    PageObjectFinder.page(page.replaceAll(" ", "")).selectBoxes(selection.replaceAll(" to ", "_").split(","))
  }

  When("""I click continue on {string}""") { (page: String) =>
    PageObjectFinder.page(page.replaceAll(" ", "")).clickContinueButton()
  }

  When("""I click {string} on {string}""") { (button: String, page: String) =>
    PageObjectFinder.page(page.replaceAll(" ", "")).clickButton(button)
  }

  Then("""I navigate to the {string}""") { text: String =>
    val pageName = text.replaceAll(" ", "")
    go to PageObjectFinder.page(pageName)
  }

  Then("""I am presented with the {string}""") { text: String =>
    val pageName = text.replaceAll(" ", "")
    waitForPageHeader
    PageObjectFinder.page(pageName).checkPageHeader
    PageObjectFinder.page(pageName).checkPageTitle
  }

  Then("""I am presented with the {string} error page""") { text: String =>
    val pageName = text.replaceAll(" ", "")
    waitForPageHeader
    PageObjectFinder.page(pageName).checkPageErrorTitle
  }


}
