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

  override val url: String = TestConfiguration.url("cds-frontend") + "/choose-how-many-mrns"
  override val title = "How many MRNs do you want to submit in this claim?"

  override def expectedPageErrorTitle: Option[String] = Some("SHow many MRNs do you want to submit in this claim? - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("How many MRNs do you want to submit in this claim? - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("How many MRNs do you want to submit in this claim?")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(2)")).getText should equal("A Movement Reference Number (MRN) is issued when an import is declared. Find out more about this number (opens in a new tab).")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(3)")).getText should equal("Multiple MRNs must all be from the same importer and have the same reason for overpayment.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("One MRN")
    driver.findElement(By.cssSelector("#select-number-of-claims-individual-item-hint")).getText should equal("Enter one MRN manually.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("Multiple/bulk MRNs - Manual entry")
    driver.findElement(By.cssSelector("#select-number-of-claims-bulk-item-hint")).getText should equal("Enter each number manually.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("Multiple/bulk MRNs - Document upload")
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
