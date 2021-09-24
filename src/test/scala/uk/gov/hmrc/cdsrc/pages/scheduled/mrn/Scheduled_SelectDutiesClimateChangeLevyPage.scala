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

package uk.gov.hmrc.cdsrc.pages.scheduled.mrn

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Scheduled_SelectDutiesClimateChangeLevyPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/select-duties/climate-change-levy"
  override val title = "Select the Climate Change Levy duties you want to claim for all MRNs in the file you uploaded"

  override def expectedPageErrorTitle: Option[String] = Some("Select the Climate Change Levy duties you want to claim for all MRNs in the file you uploaded - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the Climate Change Levy duties you want to claim for all MRNs in the file you uploaded - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the Climate Change Levy duties you want to claim for all MRNs in the file you uploaded")

}