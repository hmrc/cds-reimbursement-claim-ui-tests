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

package uk.gov.hmrc.cdsrc.pages.C285.single

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Single_EnterYourContactDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/enter-your-contact-details"
  override val title = "Enter your contact details"

  override def expectedPageErrorTitle: Option[String] = Some("Enter your contact details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter your contact details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter your contact details")

  override def enterDetails(data: String): Unit = {
    val companyName: String = "Johnathon Smithson Co."
    val emailAddress: String = "johnathonsmithsonco@email.com"
    val phoneNumber: String = "01234567891"
    val addressLine1: String = "John Rd"
    val addressLine2: String = ""
    val addressLine3: String = ""
    val town: String = "Johnstown"
    val postcode: String = "JO0 0HN"
    val country: String = "United Kingdom"

    enterText("enter-your-contact-details.contact-name", companyName)
    enterText("enter-your-contact-details.contact-email", emailAddress)
    enterText("enter-your-contact-details.contact-phone-number", phoneNumber)
    enterText("nonUkAddress-line1", addressLine1)
    enterText("nonUkAddress-line2", addressLine2)
    enterText("nonUkAddress-line3", addressLine3)
    enterText("nonUkAddress-line4", town)
    enterText("postcode", postcode)
    selectFromAutocomplete("countryCode", country)
  }

}
