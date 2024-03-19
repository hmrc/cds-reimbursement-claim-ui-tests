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

object CE1179_Multiple_SelectDuties5Page extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/multiple/select-duties/5"
  override val title = "Claim details Which duties do you want to claim for?"

  override def expectedPageErrorTitle: Option[String] = Some("Which duties do you want to claim for? - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Which duties do you want to claim for? - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Claim details Which duties do you want to claim for?")

}
