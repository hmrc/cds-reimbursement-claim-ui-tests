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

package uk.gov.hmrc.cdsrc.pages.CE1179.scheduled

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object RejectedGoods_Scheduled_ClaimantDetailsChangeContactDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/scheduled/claimant-details/change-contact-details"
  override val title = "Change contact details"

  override def expectedPageErrorTitle: Option[String] = Some("Change contact details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Change contact details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Change contact details")

  override def enterDetails(data: String): Unit = {
    val fullName: String = "John Smith"
    val emailAddress: String = "john@smith.com"
    val telephone: String = "01234567890"

    enterText("enter-contact-details-rejected-goods.contact-name", fullName)
    enterText("enter-contact-details-rejected-goods.contact-email", emailAddress)
    enterText("enter-contact-details-rejected-goods.contact-phone-number", telephone)
  }

}
