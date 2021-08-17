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

object Mrn_ClaimantDetailsDetailsContactPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/claimant-details/details-contact"
  override val title = "Add contact details"

  override def expectedPageErrorTitle: Option[String] = Some("Add contact details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Add contact details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Add contact details")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > h2")).getText should equal("Enter your personal details")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(2) > label")).getText should equal("Full Name")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > label")).getText should equal("Email address")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(4) > label")).getText should equal("Telephone (optional)")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def enterDetails(data: String): Unit = {
    val fullName: String = "John Smith"
    val emailAddress: String = "john@smith.com"
    val telephone: String = "01234567890"

    enterText("enter-or-change-contact-details.contact-name", fullName)
    enterText("enter-or-change-contact-details.contact-email", emailAddress)
    enterText("enter-or-change-contact-details.contact-phone-number", telephone)
  }

}
