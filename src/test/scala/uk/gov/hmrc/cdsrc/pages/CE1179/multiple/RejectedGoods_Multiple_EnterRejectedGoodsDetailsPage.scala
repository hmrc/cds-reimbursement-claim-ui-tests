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

package uk.gov.hmrc.cdsrc.pages.CE1179.multiple

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object RejectedGoods_Multiple_EnterRejectedGoodsDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/multiple/enter-rejected-goods-details"
  override val title = "Provide details of the rejected goods"

  override def expectedPageErrorTitle: Option[String] = Some("Provide details of the rejected goods - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Provide details of the rejected goods - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Provide details of the rejected goods")

  override def enterDetails(details: String): Unit = {
    details match {
      case "under 500 characters" => enterText("enter-rejected-goods-details.rejected-goods", "under 500 characters")
      case "over 500 characters" => enterText("enter-rejected-goods-details.rejected-goods",
        "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789" +
          "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789" +
          "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789" +
          "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789" +
          "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789" +
          "1"
      )
      case _ => enterText("enter-rejected-goods-details.rejected-goods", details)
    }
  }

}