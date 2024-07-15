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

package uk.gov.hmrc.cdsrc.pages.C285.multiple_V2

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Multiple_EnterMovementReferenceNumber5Pagev2 extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/overpayments/multiple/enter-movement-reference-number/5"
  override val title = "Enter the fifth Movement Reference Number (MRN)"

  override def expectedPageErrorTitle: Option[String] = Some("ERROR: Enter the fifth Movement Reference Number (MRN) - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter the fifth Movement Reference Number (MRN) - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter the fifth Movement Reference Number (MRN)")

  override def enterDetails(textToEnter: String) {
    enterText("enter-movement-reference-number", textToEnter)
  }

}
