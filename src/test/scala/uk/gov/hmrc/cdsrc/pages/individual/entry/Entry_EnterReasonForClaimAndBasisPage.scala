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

package uk.gov.hmrc.cdsrc.pages.individual.entry

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Entry_EnterReasonForClaimAndBasisPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/enter-reason-for-claim-and-basis"
  override val title = "Select the reason and or basis for claim"

  override def expectedPageErrorTitle: Option[String] = Some("Select the reason and or basis for claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the reason and or basis for claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the reason and or basis for claim")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > form > p")).getText should equal("This will help us to understand why you are making the claim so we can review and validate it.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > summary > span")).getText should equal("Examples of basis of claim")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > summary > span")).click()
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(1)")).getText should equal("duplicate Entry Number (a claim if a duplicate Entry Number has been made and a trader overpaid duties)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(2)")).getText should equal("duty suspension (goods liable to import charges but not collected until they leave the point of deferring payment of customs duties)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(3)")).getText should equal("end use relief (gives a favourable rate of duty and/or levy on some goods imported from non-EU countries)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(4)")).getText should equal("incorrect commodity code (a claim made if a trader originally entered an incorrect commodity code and overpaid duties)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(5)")).getText should equal("incorrect customs procedure code (a claim made if a trader entered an incorrect CPC and overpaid duties)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(6)")).getText should equal("incorrect value (a claim made if a trader originally entered an incorrect total customs value and overpaid duties)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(7)")).getText should equal("incorrect EORI and deferment account number (a claim made if a trader entered a wrong EORI and/or deferment account number)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(8)")).getText should equal("inward processing relief from Customs Duty (IPR and import VAT are on goods imported from outside the EU, and then exported outside the EU)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(9)")).getText should equal("outward processing relief (allows EU traders to temporarily export goods from the EU to process or repair in a third (non-EU) country and then claim duty relief")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(4) > div > ul > li:nth-child(10)")).getText should equal("preference (post-clearance scrutiny and verification of documents to support customers claim to preferential duty rates)")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(5) > label")).getText should equal("Choose which basis for claim")

    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(6) > summary > span")).getText should equal("Examples of reasons to claim")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(6) > summary > span")).click()
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(6) > div > ul > li:nth-child(1)")).getText should equal("mail order goods - duties not due (for example you pay the duties but you ask HMRC to invalidate the customs declaration)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(6) > div > ul > li:nth-child(2)")).getText should equal("overpayment (for example you paid duties that were not due)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > details:nth-child(6) > div > ul > li:nth-child(3)")).getText should equal("special circumstances (situations such as outside normal commercial risk and not due to negligence or deception on your part)")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(7) > label")).getText should equal("Choose which reason for claim")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Save and continue")
  }

  override def dropdownSelect(selection: String): Unit = {
    val selections: Array[String] = selection.split(",")
    val dropdownBasis = new Select(driver.findElement(By.id("select-reason-and-basis-for-claim.basis")))
    dropdownBasis.selectByVisibleText(selections(0))
    val dropdownReason = new Select(driver.findElement(By.id("select-reason-and-basis-for-claim.reason")))
    dropdownReason.selectByVisibleText(selections(1))
  }

}
