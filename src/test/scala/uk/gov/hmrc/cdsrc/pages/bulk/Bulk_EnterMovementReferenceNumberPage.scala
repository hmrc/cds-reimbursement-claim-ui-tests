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

package uk.gov.hmrc.cdsrc.pages.bulk

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Bulk_EnterMovementReferenceNumberPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/bulk/enter-movement-reference-number"
  override val title = "Enter the lead Movement Reference Number (MRN)"

  override def expectedPageErrorTitle: Option[String] = Some("Enter the lead Movement Reference Number (MRN) - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter the lead Movement Reference Number (MRN) - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter the lead Movement Reference Number (MRN)")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > form > p")).getText should equal("The Movement Reference Number (MRN) will be issued when an import is declared. Find out more about this number (opens in new tab).\n\nThe lead MRN is the one with the highest paid amount of duties.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > label")).getText should equal("Enter the MRN or Entry number")
    driver.findElement(By.cssSelector("#enter-movement-reference-number-hint")).getText should equal("Must be 18 characters, for example 19GB03I52858027017.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def enterDetails(textToEnter: String) {
    enterText("enter-movement-reference-number", textToEnter)
  }
}
