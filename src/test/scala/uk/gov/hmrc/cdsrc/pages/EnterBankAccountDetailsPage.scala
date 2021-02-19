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

package uk.gov.hmrc.cdsrc.pages

import uk.gov.hmrc.cdsrc.conf.TestConfiguration

object EnterBankAccountDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/enter-bank-account-details"
  override val title = "Enter bank account details"

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("Enter bank account details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter bank account details")

  def enterDetails(
                      bankAccountName: String = "Mr John Smith",
                      sortCode1: String = "01",
                      sortCode2: String = "02",
                      sortCode3: String = "03",
                      accountNumber: String = "12345678"
                  ): Unit = {
    enterText("enter-bank-details.account-name", bankAccountName)
    enterText("enter-bank-details-sort-code-1", sortCode1)
    enterText("enter-bank-details-sort-code-2", sortCode2)
    enterText("enter-bank-details-sort-code-3", sortCode3)
    enterText("enter-bank-details.account-number", accountNumber)
  }

  override def selectCheckBox(): Unit ={
    click on cssSelector("#enter-bank-details\\.is-business-account-0")
  }

}
