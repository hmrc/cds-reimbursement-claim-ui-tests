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

package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Multiple_ClaimantDetailsAddPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/multiple/claimant-details/add"
  override val title       = "Check your details as registered with CDS"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Check your details as registered with CDS - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Check your details as registered with CDS - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Check your details as registered with CDS")

  override def clickRadioButton(text: String): Unit =
    text match {
      case "yes" => click on cssSelector("#claimant-details-yes")
      case "no"  => click on cssSelector("#claimant-details-no")
    }

}