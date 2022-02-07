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

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage
import uk.gov.hmrc.cdsrc.pages.CE1179.single.RejectedGoods_Single_ClaimantDetailsPage.cssSelector

object UploadDocuments_ChooseFilePage extends BasePage {

  override val url: String = "http://localhost:10100/upload-documents/choose-file"
  override val title = "Upload supporting documents"

  override def expectedPageErrorTitle: Option[String] = Some("Upload supporting documents - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Upload supporting documents - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Upload supporting documents")

  override def clickContinueButton(): Unit = click on cssSelector("#main-content > div > div > div.govuk-\\!-margin-bottom-6 > form > div:nth-child(21) > button")

}
