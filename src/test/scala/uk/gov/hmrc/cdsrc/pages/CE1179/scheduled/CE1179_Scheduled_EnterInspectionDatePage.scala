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

object CE1179_Scheduled_EnterInspectionDatePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/scheduled/enter-inspection-date"
  override val title = "Tell us when the goods will be available until for inspection"

  override def expectedPageErrorTitle: Option[String] = Some("Tell us when the goods will be available until for inspection - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Tell us when the goods will be available until for inspection - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Tell us when the goods will be available until for inspection")

  override def enterDetails(date: String): Unit = {
    enterText("enter-inspection-date.rejected-goods", date.split(",")(0))
    enterText("enter-inspection-date.rejected-goods-month", date.split(",")(1))
    enterText("enter-inspection-date.rejected-goods-year", date.split(",")(2))
  }

}
