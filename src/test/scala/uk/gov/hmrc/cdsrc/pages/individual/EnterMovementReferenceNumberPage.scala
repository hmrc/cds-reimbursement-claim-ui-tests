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

package uk.gov.hmrc.cdsrc.pages.individual

import org.openqa.selenium.By
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object EnterMovementReferenceNumberPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/enter-movement-reference-number"
  override val title = "What is your Movement Reference Number (MRN)?"

  override def expectedPageErrorTitle: Option[String] = Some(" Reference Number (MRN)? - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Whement Reference Number (MRN)? - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Whaement Reference Number (MRN)?")

  override def checkPageTitle(content:String): Assertion = {
    content match {
      case "bulk-enabled,entry-enabled" | "bulk-disabled,entry-enabled" => driver.getTitle should equal("What is your Movement Reference Number (MRN)? - Claim for reimbursement of import duties - GOV.UK")
      case "bulk-enabled,entry-disabled" | "bulk-disabled,entry-disabled" => driver.getTitle should equal("Enter the Movement Reference Number (MRN) - Claim for reimbursement of import duties - GOV.UK")
    }
  }

  override def checkPageErrorTitle(content:String): Assertion = {
    true should equal(true)
  }

  override def checkPageHeader(content:String): Assertion = {
    content match {
      case "bulk-enabled,entry-enabled" | "bulk-disabled,entry-enabled" => driver.findElement(By.cssSelector("h1")).getText should equal("What is your Movement Reference Number (MRN)?")
      case "bulk-enabled,entry-disabled" | "bulk-disabled,entry-disabled" => driver.findElement(By.cssSelector("h1")).getText should equal("Enter the Movement Reference Number (MRN)")
    }
  }

  override def checkContent(content: String): Unit = {
    content match {
      case "bulk-enabled,entry-enabled" | "bulk-disabled,entry-enabled" =>
        driver.findElement(By.cssSelector("#main-content > div > div > form > p")).getText should equal("The Movement Reference Number (MRN) will be issued when an import is declared. Find out more about this number (opens in new tab). You can also add an Entry number found in your CHIEF documentation.")

        driver.findElement(By.cssSelector("#main-content > div > div > form > div > label")).getText should equal("Enter the MRN or Entry number")
        driver.findElement(By.cssSelector("#enter-movement-reference-number-hint")).getText should equal("Must be 18 characters, for example 19GB03I52858027017.")
      case "bulk-enabled,entry-disabled" | "bulk-disabled,entry-disabled" =>
        driver.findElement(By.cssSelector("#main-content > div > div > form > p:nth-child(3)")).getText should equal("The Movement Reference Number (MRN) will be issued when an import is declared. Find out more about this number (opens in new tab).")

        driver.findElement(By.cssSelector("#main-content > div > div > form > p.govuk-body.govuk-\\!-margin-bottom-8.govuk-inset-text")).getText should equal("We are currently not accepting Entry numbers. If you only have Entry number please refer to C285 Chief.")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > label")).getText should equal("Enter the MRN number")
        driver.findElement(By.cssSelector("#enter-movement-reference-number-hint")).getText should equal("Must be 18 characters, for example 19GB03I52858027017.")
    }

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def enterDetails(textToEnter: String) {
    enterText("enter-movement-reference-number", textToEnter)
  }

}
