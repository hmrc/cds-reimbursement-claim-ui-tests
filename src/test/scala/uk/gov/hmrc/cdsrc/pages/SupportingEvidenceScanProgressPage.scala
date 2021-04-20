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

package uk.gov.hmrc.cdsrc.pages

import uk.gov.hmrc.cdsrc.conf.TestConfiguration

object SupportingEvidenceScanProgressPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/supporting-evidence/scan-progress"
  override val title = "Wait a few seconds and then select ‘continue’"

  override def expectedPageErrorTitle: Option[String] = Some("Wait a few seconds and then select ‘continue’ - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Wait a few seconds and then select ‘continue’ - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Wait a few seconds and then select ‘continue’")

  def continuouslyClickContinue(): Unit = {
    waitForPageToLoad()
    while (find(tagName("h1")).map(_.text).contains("Wait a few seconds and then select ‘continue’")) {
      clickContinueButton()
    }
  }

}
