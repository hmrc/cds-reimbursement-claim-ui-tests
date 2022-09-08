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

package uk.gov.hmrc.cdsrc.pages.C285.multiple

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Multiple_CheckClaimPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/overpayments/multiple/check-claim"
  override val title = "Check the repayment claim totals for all MRNs"

  override def expectedPageErrorTitle: Option[String] = Some("Check the repayment claim totals for all MRNs - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check the repayment claim totals for all MRNs - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check the repayment claim totals for all MRNs")

  override def clickRadioButton(text: String): Unit = {
    text.toLowerCase() match {
      case "yes" => click on xpath(s"""//*[@id="multiple-check-claim-summary"]""")
      case "no" => click on xpath(s"""//*[@id="multiple-check-claim-summary-2"]""")
    }
  }

}
