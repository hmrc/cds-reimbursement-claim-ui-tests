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

package uk.gov.hmrc.cdsrc.pages.Securities

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage
import uk.gov.hmrc.cdsrc.pages.Securities.Securities_ConfirmFullRepaymentSecurityIdPage.cssSelector

object Securities_ChooseFileTypePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/choose-file-type"
  override val title       = "Add supporting documents to your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Add supporting documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Add supporting documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Add supporting documents to your claim")
  override def checkPageTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(title)

  override def checkPageErrorTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(title)

  def selectDocumentType(text: String): Unit =
    text.toLowerCase() match {
      case "import declaration"             => click on cssSelector("input[id='choose-file-type.file-type.ImportDeclaration']")
      case "export declaration"             => click on cssSelector("input[id='choose-file-type.file-type.ExportDeclaration']")
      case "export packing list"            => click on cssSelector("input[id='choose-file-type.file-type.ExportPackingList']")
      case "substitute or diversion entry"  =>
        click on cssSelector("input[id='choose-file-type.file-type.SubstituteOrDiversionEntry']")
      case "bill of discharge 3"            => click on cssSelector("input[id='choose-file-type.file-type.BillOfDischarge3']")
      case "other documents"                => click on cssSelector("input[id='choose-file-type.file-type.Other']")
      case "evidence supporting your claim" => click on cssSelector("c")
    }
}
