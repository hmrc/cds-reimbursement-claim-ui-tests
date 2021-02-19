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

object EnterClaimantDetailsAsCompanyPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/enter-claimant-details-as-company"
  override val title = "Enter your claimant details as an importer company"

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("Enter your claimant details as an importer company - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter your claimant details as an importer company")

  def enterDetails(
                    companyName: String = "Johnathon Smithson Co.",
                    emailAddress: String = "johnathonsmithsonco@email.com",
                    phoneNumber: String = "01234567891",
                    buildingName: String = "1",
                    addressLine1: String = "John Rd",
                    addressLine2: String = "",
                    addressLine3: String = "",
                    town: String = "Johnstown",
                    county: String = "Mercia",
                    postcode: String = "JO0 0HN",
                    country: String = "United Kingdom"
                  ): Unit = {
    enterText("enter-claimant-details-importer-company.importer-company-name", companyName)
    enterText("enter-claimant-details-importer-company.importer-email", emailAddress)
    enterText("enter-claimant-details-importer-company.importer-phone-number", phoneNumber)
    enterText("nonUkAddress-building", buildingName)
    enterText("nonUkAddress-line1", addressLine1)
    enterText("nonUkAddress-line2", addressLine2)
    enterText("nonUkAddress-line3", addressLine3)
    enterText("nonUkAddress-line4", town)
    enterText("nonUkAddress-line5", county)
    enterText("nonUkAddress-line6", postcode)
    enterText("countryCode", country)
  }

}
