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
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object UploadDocuments_ChooseFilePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/upload-documents/choose-file"
  override val title = "Add a document which shows all the MRNs in this claim"

  override def expectedPageErrorTitle: Option[String] = Some("Add a document which shows all the MRNs in this claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Add a document which shows all the MRNs in this claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Add a document which shows all the MRNs in this claim")

  override def clickContinueButton(): Unit = {
    click on cssSelector("#main-content > div > div > form > div.govuk-\\!-margin-bottom-9 > button")
//    waitForPageToLoad()
//    var n : Int = 0 //to avoid an infinite loop if the file cannot upload
//    while (driver.getCurrentUrl.equals("http://localhost:10100/upload-documents/choose-files") & n < 100) {
//      click on cssSelector("#upload-documents-submit")
//      Thread.sleep(500)
//      n += 1
//    }
  }

}
