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

object Securities_ClaimantDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/claimant-details"
  override val title       = "Confirm contact details for this claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Confirm contact details for this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Confirm contact details for this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Confirm contact details for this claim")

  override def clickButton(buttonText: String): Unit =
    buttonText.toLowerCase() match {
      case "change contact details" =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/claimant-details/change-contact-details']")
      case "change contact address" =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/claimant-details/lookup-address']")
    }
}
