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

package uk.gov.hmrc.cdsrc.pages.individual.entry

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Entry_EnterBankAccountDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/enter-bank-account-details"
  override val title = "Enter bank account details"

  override def expectedPageErrorTitle: Option[String] = Some("Enter bank account details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter bank account details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter bank account details")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("This is where you would like reimbursements (repayments) to be made in the UK.\nTo use these bank details again, contact the CDS team (opens in new tab) via the imports and exports general enquiries.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(2) > label")).getText should equal("Bank account name")
    driver.findElement(By.cssSelector("#enter-bank-details\\.account-name-hint")).getText should equal("The name registered within the account")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > div > div > label")).getText should equal("Is business account")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(4) > label")).getText should equal("Sort Code")
    driver.findElement(By.cssSelector("#enter-bank-details\\.sort-code-hint")).getText should equal("Must be 6 digits long, for example 01 02 03")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(5) > label")).getText should equal("Account number")
    driver.findElement(By.cssSelector("#enter-bank-details\\.account-number-hint")).getText should equal("Must be between 6 and 8 digits long")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def enterDetails(data: String): Unit = {
    val bankAccountName: String = "Mr John Smith"
    val sortCode: String = "123456"
    val accountNumber: String = "11001001"

    enterText("enter-bank-details.account-name", bankAccountName)
    enterText("enter-bank-details.sort-code", sortCode)
    enterText("enter-bank-details.account-number", accountNumber)
  }

  override def selectCheckBox(): Unit = {
    click on cssSelector("#enter-bank-details_is-business-account")
  }

}
