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

package uk.gov.hmrc.cdsrc.pages.common

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object SelectClaimTypePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/choose-claim-type"
  override val title       = "Start a new claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Error: Start a new claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Start a new claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Start a new claim")

  override def clickRadioButton(text: String): Unit =
    text.toLowerCase() match {
      case "c285"       => click on cssSelector("input[data-id='choose-claim-type-c285']")
      case "ce1179"     => click on cssSelector("input[data-id='choose-claim-type-ce1179")
      case "securities" => click on cssSelector("input[data-id='choose-claim-type-securities")
    }
}
