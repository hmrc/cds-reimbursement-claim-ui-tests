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

package uk.gov.hmrc.cdsrc.pages.common

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object SelectNumberOfClaimsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/select-number-of-claims"
  override val title = "Select number of claims"

  override def expectedPageErrorTitle: Option[String] = Some("Select number of claims - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select number of claims - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select number of claims")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("You can make more than one claim. Multiple (bulk) claims must be from the same importer, have the same reason for overpayment and contain either MRNs or Entry numbers, but not mixed.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("Individual claim")
    driver.findElement(By.cssSelector("#select-number-of-claims-individual-item-hint")).getText should equal("Enter one claim only using an MRN or Entry number for one declaration.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("Multiple (bulk) claims - manual entry of MRNs or Entry numbers")
    driver.findElement(By.cssSelector("#select-number-of-claims-bulk-item-hint")).getText should equal("You can enter a bulk claim by manually adding multiple MRNs or Entry numbers for each declaration.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("Multiple (bulk) claims - upload a scheduled document")
    driver.findElement(By.cssSelector("#select-number-of-claims-scheduled-item-hint")).getText should equal("You can enter a bulk claim by uploading a document with MRNs or Entry numbers for multiple declarations.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def clickRadioButton(text: String) {
    text.toLowerCase() match {
      case "individual" => click on cssSelector("#select-number-of-claims-individual")
      case "bulk" => click on cssSelector("#select-number-of-claims-bulk")
      case "schedule" => click on cssSelector("#select-number-of-claims-scheduled")
    }
  }
}
