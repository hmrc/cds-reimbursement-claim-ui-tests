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

object EnterDuplicateDeclarationDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/enter-declaration-details"
  override val title = "Enter Declaration Details"

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("Enter Declaration Details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter Declaration Details")

  def enterDetails(
                    importDate: String = "1", importMonth: String = "1", importYear: String = "2021",
                    placeOfImport: String = "Dover",
                    importerName: String = "John Smith",
                    importerEmailAddress: String = "johnsmith@email.com",
                    importerPhoneNumber: String = "01234567890",
                    declarantName: String = "Johnathon Smithson",
                    declarantEmailAddress: String = "johnathonsmithson@email.com",
                    declarantPhoneNumber: String = "01234567891"
                  ): Unit = {
    enterText("enter-declaration-details-month", importMonth)
    enterText("enter-declaration-details-day", importDate)
    enterText("enter-declaration-details-year", importYear)
    enterText("enter-declaration-details.place-of-import", placeOfImport)
    enterText("enter-declaration-details.importer-name", importerName)
    enterText("enter-declaration-details.importer-email-address", importerEmailAddress)
    enterText("enter-declaration-details.importer-phone-number", importerPhoneNumber)
    enterText("enter-declaration-details.declarant-name", declarantName)
    enterText("enter-declaration-details.declarant-email-address", declarantEmailAddress)
    enterText("enter-declaration-details.declarant-phone-number", declarantPhoneNumber)
  }

}
