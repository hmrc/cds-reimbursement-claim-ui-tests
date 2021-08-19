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

import scala.jdk.CollectionConverters.asScalaBufferConverter

object Bulk_SupportingEvidenceSelectSupportingEvidenceTypePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/bulk/supporting-evidence/select-supporting-evidence-type/..."
  override val title = "Select the description of the file you just uploaded"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("Select the description of the file you just uploaded - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the description of the file you just uploaded - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the description of the file you just uploaded")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("Choose a definition of the file from this list. This will help us to process your claim more efficiently.")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("Commercial Invoice")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("Import and Export Declaration")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("Packing List")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(4) > label")).getText should equal("Air Waybill")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(5) > label")).getText should equal("Bill of Lading")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(6) > label")).getText should equal("Substitute Entry")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(7) > label")).getText should equal("Proof of Authority")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(8) > label")).getText should equal("Correspondence Trader")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(9) > label")).getText should equal("Other documents")
    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def clickRadioButton(selection : String): Unit = {
    driver.findElements(By.tagName("label")).asScala.filter(_.getText.trim == selection).head.click()
  }

}
