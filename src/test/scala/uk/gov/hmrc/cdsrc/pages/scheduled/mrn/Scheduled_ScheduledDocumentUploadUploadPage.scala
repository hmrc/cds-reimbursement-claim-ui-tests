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

package uk.gov.hmrc.cdsrc.pages.scheduled.mrn

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Scheduled_ScheduledDocumentUploadUploadPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/scheduled-document-upload/upload"
  override val title = "Add a scheduled document"

  override def expectedPageErrorTitle: Option[String] = Some("Add a scheduled document - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Add a scheduled document - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Add a scheduled document")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p.govuk-body.govuk-\\!-margin-bottom-4")).getText should equal("Upload the scheduled document with all the MRNs. The documents can be up to a maximum of 10MB size per file. Valid file format: JPG, PNG, PDF.\n\nYour document should include a list of all MRNs linked with the claim.")

    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(4)")).getText should equal("Each MRN should show:")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(1)")).getText should equal("the amount of tax you paid on it")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(2)")).getText should equal("the amount you should have paid on it")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(3)")).getText should equal("which duty is being reclaimed on it")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div.govuk-form-group > label")).getText should equal("Select document")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div.govuk-\\!-margin-bottom-9 > button")).getText should equal("Continue")
  }

  override def clickContinueButton(): Unit = {
    click on cssSelector("#main-content > div > div > form > div.govuk-\\!-margin-bottom-9 > button")
  }

  override def checkBackButtonExistsIfItShould: Unit = {

  }

}
