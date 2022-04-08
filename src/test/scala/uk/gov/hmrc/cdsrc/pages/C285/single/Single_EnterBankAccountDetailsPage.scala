/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.pages.C285.single

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Single_EnterBankAccountDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/enter-bank-account-details"
  override val title = "Enter your bank account details"

  override def expectedPageErrorTitle: Option[String] = Some("Enter your bank account details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter your bank account details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter your bank account details")

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
