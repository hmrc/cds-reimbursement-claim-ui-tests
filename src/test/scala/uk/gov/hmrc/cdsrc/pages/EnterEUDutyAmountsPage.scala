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

object EnterEUDutyAmountsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/enter-eu-duty-amounts"
  override val title = "Enter EU Duty Amounts to Calculate Your Claim"

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("Enter EU Duty Amounts to Calculate Your Claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter EU Duty Amounts to Calculate Your Claim")

  def enterDetails(
                      a50Paid: String = "10",
                      a50Claim: String = "5",
                      a70Paid: String = "10",
                      a70Claim: String = "5",
                      a80Paid: String = "10",
                      a80Claim: String = "5",
                      a85Paid: String = "10",
                      a85Claim: String = "5",
                      a90Paid: String = "10",
                      a90Claim: String = "5",
                      a95Paid: String = "10",
                      a95Claim: String = "5",
                      b05Paid: String = "10",
                      b05Claim: String = "5",
                  ): Unit = {
    enterText("enter-duty-and-claim-amounts-eu[0].paid", a50Paid)
    enterText("enter-duty-and-claim-amounts-eu[0].claim", a50Claim)
    enterText("enter-duty-and-claim-amounts-eu[1].paid", a70Paid)
    enterText("enter-duty-and-claim-amounts-eu[1].claim", a70Claim)
    enterText("enter-duty-and-claim-amounts-eu[2].paid", a80Paid)
    enterText("enter-duty-and-claim-amounts-eu[2].claim", a80Claim)
    enterText("enter-duty-and-claim-amounts-eu[3].paid", a85Paid)
    enterText("enter-duty-and-claim-amounts-eu[3].claim", a85Claim)
    enterText("enter-duty-and-claim-amounts-eu[4].paid", a90Paid)
    enterText("enter-duty-and-claim-amounts-eu[4].claim", a90Claim)
    enterText("enter-duty-and-claim-amounts-eu[5].paid", a95Paid)
    enterText("enter-duty-and-claim-amounts-eu[5].claim", a95Claim)
    enterText("enter-duty-and-claim-amounts-eu[6].paid", b05Paid)
    enterText("enter-duty-and-claim-amounts-eu[6].claim", b05Claim)
  }

}
