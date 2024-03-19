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

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Securities_CheckYourAnswersPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/check-your-answers"
  override val title       = "Check your answers before sending your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Check your answers before sending your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Check your answers before sending your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Check your answers before sending your claim")

  override def clickButton(buttonText: String): Unit = {
    buttonText.toLowerCase() match {
      case "change import mrn"                  =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/enter-movement-reference-number']")
      case "change reason for security deposit" =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/choose-reason-for-security']")
      case "change claim for abc0123456"        =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/select-securities/ABC0123456']")
      case "change claim for def6543210"        =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/select-securities/DEF6543210']")
      case "change contact details"             =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/claimant-details/change-contact-details']")
      case "change contact address"             =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/claimant-details/lookup-address']")
      case "change claim full amount"           =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/confirm-full-repayment/ABC0123456']")
      case "change duties selected"             =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/confirm-full-repayment/ABC0123456']")
      case "change a00 customs duty"            =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/enter-claim/ABC0123456/A00']")
      case "change b00 customs duty"            =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/enter-claim/ABC0123456/B00']")
      case "change bank details"                =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/check-bank-details']")
      case "change document"                    =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/upload-summary']")
    }
  }
}
