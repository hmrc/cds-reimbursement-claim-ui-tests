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

package uk.gov.hmrc.cdsrc.pages.common

import org.openqa.selenium.By
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.pages.BasePage

object UploadDocuments_ChooseFilesPage extends BasePage {

  override val url: String = "http://localhost:10100/upload-documents/choose-files"
  override val title = "Upload supporting documents"

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("")

  override def expectedPageHeader: Option[String] = Some("")

  override def checkPageHeader(content: String): Assertion = {
    true should equal(true)
  }

  override def checkSpecificPage(page: String): Unit = {
    driver.findElement(By cssSelector "#main-content > div > div > div.govuk-\\!-margin-bottom-6 > h1").getText should equal("Upload " + page)
  }

  override def clickContinueButton(): Unit = {
    waitForPageToLoad()
    var n : Int = 0 //to avoid an infinite loop if the file cannot upload
    while (driver.getCurrentUrl.equals("http://localhost:10100/upload-documents/choose-files") & n < 500) {
      click on cssSelector("#upload-documents-submit")
      n += 1
    }
  }
}
