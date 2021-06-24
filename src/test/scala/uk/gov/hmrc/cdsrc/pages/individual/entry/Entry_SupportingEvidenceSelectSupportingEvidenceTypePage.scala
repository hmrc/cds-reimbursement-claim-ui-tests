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
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Entry_SupportingEvidenceSelectSupportingEvidenceTypePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/supporting-evidence/select-supporting-evidence-type"
  override val title = "Select the description of the file you just uploaded"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("Select the description of the file you just uploaded - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the description of the file you just uploaded - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the description of the file you just uploaded")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > form > p")).getText should equal("Choose a definition of the file from this list. This will help us to process your claim more efficiently.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > label")).getText should equal("Choose document type")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type")).click()
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(1)")).getText should equal("Choose")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(2)")).getText should equal("C88/E2")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(3)")).getText should equal("Commercial Invoice")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(4)")).getText should equal("Packing List")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(5)")).getText should equal("Air Waybill")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(6)")).getText should equal("Bill of Lading")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(7)")).getText should equal("Substitute Entry")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(8)")).getText should equal("Proof of Authority")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(9)")).getText should equal("Correspondence Trader")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(10)")).getText should equal("Import and Export Declaration")
    driver.findElement(By.cssSelector("#supporting-evidence\\.choose-document-type > option:nth-child(11)")).getText should equal("Other documents")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Save and continue")
  }

  override def dropdownSelect(selection: String): Unit = {
    val dropdown = new Select(driver.findElement(By.id("supporting-evidence.choose-document-type")))
    dropdown.selectByVisibleText(selection)
  }

}
