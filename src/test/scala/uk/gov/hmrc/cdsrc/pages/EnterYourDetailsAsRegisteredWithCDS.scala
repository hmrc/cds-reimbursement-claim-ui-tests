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

object EnterYourDetailsAsRegisteredWithCDS extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/enter-your-details-as-registered-with-cds"
  override val title = "Enter your details as registered with CDS"

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("Enter your details as registered with CDS - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter your details as registered with CDS")

  override def enterDetails(data: String): Unit = {
    val fullName: String = "Johnathon Smithson"
    val emailAddress: String = "johnathonsmithson@email.com"
    val addressLine1: String = "John Rd"
    val addressLine2: String = ""
    val addressLine3: String = ""
    val town: String = "Johnstown"
    val postcode: String = "JO0 0HN"
    val country: String = "United Kingdom"

    enterText("enter-claimant-details-as-registered-with-cds.individual-full-name", fullName)
    enterText("enter-claimant-details-as-registered-with-cds.individual-email", emailAddress)
    enterText("nonUkAddress-line1", addressLine1)
    enterText("nonUkAddress-line2", addressLine2)
    enterText("nonUkAddress-line3", addressLine3)
    enterText("nonUkAddress-line4", town)
    enterText("postcode", postcode)
    selectFromAutocomplete("countryCode", country)
  }

  override def clickRadioButton(selection: String): Unit = {
    click on xpath(s"""//*[@id="enter-claimant-details-as-registered-with-cds.add-company-details-$selection"]""")
  }

}
