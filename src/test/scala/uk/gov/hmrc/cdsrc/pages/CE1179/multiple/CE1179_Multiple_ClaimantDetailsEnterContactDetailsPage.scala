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

package uk.gov.hmrc.cdsrc.pages.CE1179.multiple

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object CE1179_Multiple_ClaimantDetailsEnterContactDetailsPage extends BasePage {

  override val url: String =
    TestConfiguration.url("cds-frontend") + "/rejected-goods/multiple/claimant-details/change-contact-details"
  override val title       = "Who should we contact about this claim?"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Who should we contact about this claim? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Who should we contact about this claim? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Who should we contact about this claim?")

  override def enterDetails(data: String): Unit = {
    val fullName: String     = "John Smith"
    val emailAddress: String = "john@smith.com"
    val telephone: String    = "01234567890"

    enterText("enter-contact-details.contact-name", fullName)
    enterText("enter-contact-details.contact-email", emailAddress)
    enterText("enter-contact-details.contact-phone-number", telephone)
  }

}
