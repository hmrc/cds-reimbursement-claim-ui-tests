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

package uk.gov.hmrc.cdsrc.pages.individual.mrn

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Mrn_EnterDuplicateMovementReferenceNumberPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/enter-duplicate-movement-reference-number"
  override val title = "Tell us your duplicate Movement Reference Number (MRN)"

  override def expectedPageErrorTitle: Option[String] = Some("Tell us your duplicate Movement Reference Number (MRN) - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Tell us your duplicate Movement Reference Number (MRN) - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Tell us your duplicate Movement Reference Number (MRN)")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > form > p")).getText should equal("This will help us to process your claim more efficiently.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > label")).getText should equal("Enter duplicate MRN")
    driver.findElement(By.cssSelector("#enter-duplicate-movement-reference-number-hint")).getText should equal("Must be 18 characters, for example 19GB03I52858027017.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def enterDetails(textToEnter: String) {
    enterText("enter-duplicate-movement-reference-number", textToEnter)
  }
}
