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
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

import scala.jdk.CollectionConverters.asScalaBufferConverter

object Entry_ChooseBasisForClaimPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/choose-basis-for-claim"
  override val title = "Select the basis for claim"

  override def expectedPageErrorTitle: Option[String] = Some("Select the basis for claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the basis for claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the basis for claim")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("This will help us to understand why you are making the claim so we can review and validate it. If you believe you are entitled to an excise claim that is not listed below, please contact the CDS team (opens in new tab).")

    driver.findElement(By.cssSelector("#main-content > div > div > details > summary > span")).getText should equal("Examples of basis of claim")
    driver.findElement(By.cssSelector("#main-content > div > div > details > summary > span")).click()
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(1)")).getText should equal("Duplicate Entry Number: A claim if a duplicate Entry Number has been made and a trader overpaid duties")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(2)")).getText should equal("Duty suspension: Goods liable to import charges but not collected until they leave the point of deferring payment of customs duties")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(3)")).getText should equal("End use relief: Gives a favourable rate of duty and/or levy on some goods imported from non-EU countries")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(4)")).getText should equal("Incorrect commodity code: A claim made if a trader originally entered an incorrect commodity code and overpaid duties")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(5)")).getText should equal("Incorrect customs procedure code: A claim made if a trader entered an incorrect CPC and overpaid duties")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(6)")).getText should equal("Incorrect value: A claim made if a trader originally entered an incorrect total customs value and overpaid duties")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(7)")).getText should equal("Incorrect EORI and deferment account number: A claim made if a trader entered a wrong EORI and/or deferment account number")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(8)")).getText should equal("Inward processing relief from Customs Duty: IPR and import VAT are on goods imported from outside the EU, and then exported outside the EU")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(9)")).getText should equal("Outward processing relief: Allows EU traders to temporarily export goods from the EU to process or repair in a third (non-EU) country and then claim duty relief")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(10)")).getText should equal("Preference: Post-clearance scrutiny and verification of documents to support customers claim to preferential duty rates")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(11)")).getText should equal("Proof of return/refund given: A claim made by a trader if they have provided a proof of return/refund and overpaid duties")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(12)")).getText should equal("Evidence that goods have not entered the EU - Northern Ireland claims only: Proof that the goods, classed as ‘at risk’ on the customs declaration, did not move into the EU’s customs territory")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(13)")).getText should equal("Incorrect excise value - Northern Ireland claims only: Claims for post-clearance cash repayment of excise differential because the trader made a genuine error when manually calculating excise. Note: under this basis for claim, if you imported into Northern Ireland, you can only claim under excise tax codes and not under customs tax codes or import VAT.")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(14)")).getText should equal("Incorrect Additional Information code (excluding NIAID) - Northern Ireland claims only: The trader has declared goods as at risk in error, pays the tariff themselves (i.e. does not use subsidy) and wants to correct this error post-clearance")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(15)")).getText should equal("Miscellaneous: For any other reason not detailed in this list")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("Duplicate Entry Number")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("Duty Suspension")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("End Use")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(4) > label")).getText should equal("Incorrect Commodity Code")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(5) > label")).getText should equal("Incorrect CPC")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(6) > label")).getText should equal("Incorrect Value")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(7) > label")).getText should equal("Incorrect EORI & Deferment Acc. Num.")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(8) > label")).getText should equal("IP")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(9) > label")).getText should equal("OPR")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(10) > label")).getText should equal("Personal Effects")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(11) > label")).getText should equal("Preference")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(12) > label")).getText should equal("RGR")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(13) > label")).getText should equal("Proof of Return/Refund Given")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(14) > label")).getText should equal("Miscellaneous")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Save and continue")
  }


  override def clickRadioButton(selection: String): Unit = {
    driver.findElements(By.tagName("label")).asScala.filter(_.getText.trim == selection).head.click()
  }

  override def clickContinueButton(): Unit = {
    click on cssSelector("#main-content > div > div > form > button")
  }

}
