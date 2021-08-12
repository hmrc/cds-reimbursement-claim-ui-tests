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

package uk.gov.hmrc.cdsrc.pages.bulk.mrn

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Bulk_CheckTheseBankDetailsAreCorrectPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/bulk/check-these-bank-details-are-correct"
  override val title = "Check these bank details are correct"

  override def expectedPageErrorTitle: Option[String] = Some("Check these bank details are correct - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check these bank details are correct - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check these bank details are correct")

  override def checkContent(content: String) {
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(2)")).getText should equal("These are the details of where your reimbursements (repayments) will be made in the UK based on our records.")

    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(3)")).getText should equal("If you are a representative and want to change these bank details, then you will need to provide:")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(1)")).getText should equal("a letter of authority from the company you represent that proves you are their representative")
    driver.findElement(By.cssSelector("#main-content > div > div > ul > li:nth-child(2)")).getText should equal("a letter from the company you represent to their bank to confirm what the bank details should be changed to")
    driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dt")).getText should equal("Name on the account")
    driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("Sort code")
    driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(3) > dt")).getText should equal("Account number")
    driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("CDS E2E To E2E Bank")
    driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd")).getText should equal("Ending with 44")
    driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(3) > dd")).getText should equal("Ending with 5678")
    driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change")
    driver.findElement(By.cssSelector("#main-content > div > div > a")).getText should equal("Continue")
  }

  override def clickContinueButton(): Unit = click on cssSelector("#main-content > div > div > a")

}
