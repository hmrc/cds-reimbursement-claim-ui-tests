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

package uk.gov.hmrc.cdsrc.pages.individual.entry

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Entry_SupportingEvidenceUploadSupportingEvidencePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/supporting-evidence/upload-supporting-evidence"
  override val title = "Upload files to support your claim"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("Error: Upload files to support your claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Upload files to support your claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Upload files to support your claim")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("Upload supporting evidence you have received for the commodities you have imported. Files can be up to 10MB.")

    driver.findElement(By.cssSelector("#main-content > div > div > details > summary > span")).getText should equal("Examples of file types")
    driver.findElement(By.cssSelector("#main-content > div > div > details > summary > span")).click()
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(1)")).getText should equal("Commercial Invoice (proof of sale and describes the commodities being sold; their price, description and quantity)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(2)")).getText should equal("Import and Export Declaration (proof of the import or export being declared)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(3)")).getText should equal("C88/E2 (proof to authorise imports from the country of destination)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(4)")).getText should equal("Packing List (a document that lists product type in each package)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(5)")).getText should equal("Air Waybill (transport document that accompanies the commodities (goods) and provides information about them)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(6)")).getText should equal("Bill of Lading (transport document that accompanies the commodities (goods) and provides information about them)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(7)")).getText should equal("Substitute Entry (a copy of the original customs declaration amended to show the correct details)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(8)")).getText should equal("Proof of Authority (in case you change your bank account details)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(9)")).getText should equal("Correspondence Trader (an email chain or letters between you and the trader)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(10)")).getText should equal("Other documents (if you have alternative supporting documents)")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div.govuk-form-group > label")).getText should equal("Upload files to support your claim")
    driver.findElement(By.cssSelector("#file-hint")).getText should equal("We accept these file types JPG, PNG, and PDF.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div.govuk-\\!-margin-bottom-9 > button")).getText should equal("Save and continue")
  }

  def uploadDocument(file: String): Unit = {
    if (file != "")
      enterText("file", System.getProperty("user.dir") + "/src/test/resources/files/" + file)
  }

  override def clickContinueButton(): Unit = {
    click on cssSelector("#main-content > div > div > form > div.govuk-\\!-margin-bottom-9 > button")
  }

}
