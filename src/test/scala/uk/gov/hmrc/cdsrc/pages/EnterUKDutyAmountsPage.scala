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

package uk.gov.hmrc.cdsrc.pages

import uk.gov.hmrc.cdsrc.conf.TestConfiguration

object EnterUKDutyAmountsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/enter-uk-duty-amounts"
  override val title = "Enter UK Duty Amounts to Calculate Your Claim"

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("Enter UK Duty Amounts to Calculate Your Claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter UK Duty Amounts to Calculate Your Claim")

  def enterDetails(
                      a00Paid: String = "10",
                      a00Claim: String = "5",
                      a20Paid: String = "10",
                      a20Claim: String = "5",
                      a30Paid: String = "10",
                      a30Claim: String = "5",
                      a35Paid: String = "10",
                      a35Claim: String = "5",
                      a40Paid: String = "10",
                      a40Claim: String = "5",
                      a45Paid: String = "10",
                      a45Claim: String = "5",
                      b00Paid: String = "10",
                      b00Claim: String = "5",
                  ): Unit = {
    enterText("enter-duty-and-claim-amounts[0].paid", a00Paid)
    enterText("enter-duty-and-claim-amounts[0].claim", a00Claim)
    enterText("enter-duty-and-claim-amounts[1].paid", a20Paid)
    enterText("enter-duty-and-claim-amounts[1].claim", a20Claim)
    enterText("enter-duty-and-claim-amounts[2].paid", a30Paid)
    enterText("enter-duty-and-claim-amounts[2].claim", a30Claim)
    enterText("enter-duty-and-claim-amounts[3].paid", a35Paid)
    enterText("enter-duty-and-claim-amounts[3].claim", a35Claim)
    enterText("enter-duty-and-claim-amounts[4].paid", a40Paid)
    enterText("enter-duty-and-claim-amounts[4].claim", a40Claim)
    enterText("enter-duty-and-claim-amounts[5].paid", a45Paid)
    enterText("enter-duty-and-claim-amounts[5].claim", a45Claim)
    enterText("enter-duty-and-claim-amounts[6].paid", b00Paid)
    enterText("enter-duty-and-claim-amounts[6].claim", b00Claim)
  }

  override def clickRadioButton(choice: String): Unit = {
    choice match {
      case "Yes" =>click on xpath(s"""//*[@id="enter-duty-and-claim-amounts.make-eu-duty-claim-true"]""")
      case "No" =>click on xpath(s"""//*[@id="enter-duty-and-claim-amounts.make-eu-duty-claim-false"]""")
    }
  }
}
