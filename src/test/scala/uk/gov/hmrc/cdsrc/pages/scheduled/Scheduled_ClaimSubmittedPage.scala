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

object Scheduled_ClaimSubmittedPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/claim-submitted"
  override val title = "Claim submitted"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("Claim submitted - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Claim submitted - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Claim submitted")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > div > h1")).getText should equal("Claim submitted")

    driver.findElement(By.cssSelector("#main-content > div > div > div > div:nth-child(2) > span")).getText should equal("Reimbursement amount")
    driver.findElement(By.cssSelector("#main-content > div > div > div > div:nth-child(2) > strong")).getText should equal(content)
    driver.findElement(By.cssSelector("#main-content > div > div > div > div:nth-child(4) > span")).getText should equal("Your claim reference number")

    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(2)")).getText should equal("We have sent you a confirmation email. If you have not received it, check your SPAM folder or contact HMRC.")

    driver.findElement(By.cssSelector("#main-content > div > div > h2")).getText should equal("What happens next?")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(4)")).getText should equal("Your application will be reviewed by HMRC and we will aim to email or write a letter to you to tell you the outcome within 30 working days. We will contact you to either:")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(1)")).getText should equal("confirm your claim and bank transfer")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(2)")).getText should equal("ask for more information")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(3)")).getText should equal("explain why your claim was rejected")

    driver.findElement(By.cssSelector("#main-content > div > div > p.govuk-body.govuk-\\!-margin-bottom-9 > a")).getText should equal("Start another claim")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(7) > a")).getText should equal("What did you think of this service?")
  }

}
