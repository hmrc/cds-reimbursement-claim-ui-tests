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

package uk.gov.hmrc.cdsrc.pages.Securities

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Securities_EnterBankAccountDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/enter-bank-account-details"
  override val title       = "Enter the UK-based bank account details"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Error: Enter the UK-based bank account details - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Enter the UK-based bank account details - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Enter the UK-based bank account details")
  override def checkPageTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(title)

  override def checkPageErrorTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(title)

  override def enterDetails(data: String): Unit = {
    val bankAccountName: String = "Mr John Smith"
    val sortCode: String        = "123456"
    val accountNumber: String   = "11001001"

    enterText("enter-bank-account-details.account-name", bankAccountName)
    enterText("enter-bank-account-details.sort-code", sortCode)
    enterText("enter-bank-account-details.account-number", accountNumber)
  }
}
