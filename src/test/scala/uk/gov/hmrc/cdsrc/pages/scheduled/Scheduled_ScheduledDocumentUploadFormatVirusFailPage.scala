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

package uk.gov.hmrc.cdsrc.pages.scheduled

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Scheduled_ScheduledDocumentUploadFormatVirusFailPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/scheduled-document-upload/format-virus-fail"
  override val title = "There is a problem with your file"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("There is a problem with your file - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("There is a problem with your file - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("There is a problem with your file")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(2)")).getText should equal("The problem could be that:")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(1)")).getText should equal("the file had a virus or was corrupt")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(2)")).getText should equal("you did not select a file to upload")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(3)")).getText should equal("you uploaded the wrong type of file")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(4)")).getText should equal("We only accept these file types: JPG, PNG, and PDF.")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(5)")).getText should equal("You’ll need to try again.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Try again")
  }

}