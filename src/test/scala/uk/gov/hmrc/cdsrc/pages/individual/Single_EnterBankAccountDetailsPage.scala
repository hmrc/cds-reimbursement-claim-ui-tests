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
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Single_EnterBankAccountDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/enter-bank-account-details"
  override val title = "Enter bank account details"

  override def expectedPageErrorTitle: Option[String] = Some("Enter bank account details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter bank account details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter bank account details")

  override def checkContent(content: String) {
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(2)")).getText should equal("This is where you would like reimbursements (repayments) to be made in the UK.")
    driver.findElement(By.cssSelector("#main-content > div > div > p.govuk-body.govuk-\\!-margin-bottom-8")).getText should equal("To use these bank details again, contact the CDS team (opens in new tab) via the imports and exports general enquiries. Updating your bank details will only affect this claim and not past and future claims.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(2) > label")).getText should equal("Name on the account")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > label")).getText should equal("Sort code")
    driver.findElement(By.cssSelector("#enter-bank-details\\.sort-code-hint")).getText should equal("Must be 6 digits long")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(4) > label")).getText should equal("Account number")
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
