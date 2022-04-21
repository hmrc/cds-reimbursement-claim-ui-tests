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
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object UploadDocuments_SummaryPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/upload-documents/summary"
  override val title = "You have successfully uploaded a document showing all the MRNs in this claim"

  override def expectedPageErrorTitle: Option[String] = Some("You have successfully uploaded a document showing all the MRNs in this claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("You have successfully uploaded a document showing all the MRNs in this claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("You have successfully uploaded a document showing all the MRNs in this claim")

  override def checkPageTitle(page: String): Unit = { //triggers on supporting evidence upload
    waitForPageToLoad()
    page match {
      case "1" => driver.findElement(By tagName "h1").getText should equal(s"""You have added $page document to your claim""")
      case _ => driver.findElement(By tagName "h1").getText should equal(s"""You have added $page documents to your claim""")
    }
  }

}
