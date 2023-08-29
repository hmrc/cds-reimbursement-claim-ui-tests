/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.pages.Securities

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Securities_ChooseFileTypePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/choose-file-type"
  override val title       = "Add supporting documents to your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Error: Add supporting documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Add supporting documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Add supporting documents to your claim")
  override def checkPageTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(title)

  override def checkPageErrorTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(title)

  override def clickRadioButton(text: String): Unit =
    text.toLowerCase() match {
      case "import declaration"             => click on cssSelector("input[value='ImportDeclaration']")
      case "export declaration"             => click on cssSelector("input[value='ExportDeclaration']")
      case "export packing list"            => click on cssSelector("input[value='ExportPackingList']")
      case "substitute or diversion entry"  =>
        click on cssSelector("input[value='='SubstituteOrDiversionEntry']")
      case "bill of discharge 3"            => click on cssSelector("input[value='BillOfDischarge3']")
      case "other documents"                => click on cssSelector("input[value='Other']")
      case "evidence supporting your claim" =>
        click on cssSelector("input[value='SupportingEvidence']")
      case "proof of authority"             => click on cssSelector("input[value='ProofOfAuthority']")
      case "commercial invoice"             => click on cssSelector("input[value='CommercialInvoice']")
    }
}
