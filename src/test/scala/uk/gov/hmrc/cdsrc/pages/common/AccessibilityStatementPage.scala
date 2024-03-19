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

import uk.gov.hmrc.cdsrc.pages.BasePage

object AccessibilityStatementPage extends BasePage {

  override val url: String = "http://localhost:12346/accessibility-statement/cds-reimbursement-claim"
  override val title = "Accessibility statement for Claim back import duty and VAT service"

  override def expectedPageErrorTitle: Option[String] = Some("Accessibility statement for Claim back import duty and VAT service – GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Accessibility statement for Claim back import duty and VAT service – GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Accessibility statement for Claim back import duty and VAT service")

}
