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

package uk.gov.hmrc.cdsrc.pages.bulk.mrn

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Bulk_SupportingEvidenceUploadSupportingEvidencePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/bulk/supporting-evidence/upload-supporting-evidence"
  override val title = "Add documents to support your claim"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("Error: Add documents to support your claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Add documents to support your claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Add documents to support your claim")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("Upload supporting evidence you have received for the commodities you have imported. The documents can be up to a maximum of 10MB size per file. Valid file format: JPG, PNG, PDF.")

    driver.findElement(By.cssSelector("#main-content > div > div > details > summary > span")).getText should equal("Examples of file types")
    driver.findElement(By.cssSelector("#main-content > div > div > details > summary > span")).click()
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(1)")).getText should equal("Commercial Invoice: Proof of sale and describes the commodities being sold; their price, description and quantity")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(2)")).getText should equal("Import and Export Declaration: Proof of the import or export being declared")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(3)")).getText should equal("Packing List: A document that lists product type in each package")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(4)")).getText should equal("Air Waybill: Transport document that accompanies the commodities (goods) and provides information about them")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(5)")).getText should equal("Bill of Lading: Transport document that accompanies the commodities (goods) and provides information about them")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(6)")).getText should equal("Substitute Entry: A copy of the original customs declaration amended to show the correct details")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(7)")).getText should equal("Proof of Authority: In case you change your bank account details")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(8)")).getText should equal("Correspondence Trader: An email chain or letters between you and the trader")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(9)")).getText should equal("Other documents: If you have alternative supporting documents")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div.govuk-form-group > label")).getText should equal("Select document")
  }

  def uploadDocument(file: String): Unit = {
    if (file != "")
      enterText("file", System.getProperty("user.dir") + "/src/test/resources/files/" + file)
  }

  override def clickContinueButton(): Unit = {
    click on cssSelector("#main-content > div > div > form > div.govuk-\\!-margin-bottom-9 > button")
  }

}
