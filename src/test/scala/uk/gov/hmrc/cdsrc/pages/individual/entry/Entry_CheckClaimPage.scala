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

object Entry_CheckClaimPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/check-claim"
  override val title = "Check the reimbursement claim totals for all MRNs"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("Check the reimbursement claim totals for all MRNs - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check the reimbursement claim totals for all MRNs - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check the reimbursement claim totals for all MRNs")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p.govuk-body.govuk-\\!-margin-bottom-8")).getText should equal("These are the calculations based on the information you gave us.")

    content match {
      case "first box only" =>
        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(3)")).getText should equal("UK Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(1) > dt")).getText should equal("Total reimbursement")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(1) > dd")).getText should equal("£1.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(2) > dt")).getText should equal("Customs Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(2) > dd")).getText should equal("£1.00")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(7)")).getText should equal("Overall total")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(8) > div > dt")).getText should equal("Total reimbursement")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(8) > div > dd")).getText should equal("£1.00")

      case "all" | _ =>
        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(3)")).getText should equal("UK Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(1) > dt")).getText should equal("Total reimbursement")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(1) > dd")).getText should equal("£28.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(2) > dt")).getText should equal("Value Added Tax")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(2) > dd")).getText should equal("£7.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(3) > dt")).getText should equal("Provisional Countervailing Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(3) > dd")).getText should equal("£6.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(4) > dt")).getText should equal("Definitive Countervailing Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(4) > dd")).getText should equal("£5.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(5) > dt")).getText should equal("Provisional Anti-Dumping Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(5) > dd")).getText should equal("£4.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(6) > dt")).getText should equal("Definitive Anti-Dumping Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(6) > dd")).getText should equal("£3.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(7) > dt")).getText should equal("Additional Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(7) > dd")).getText should equal("£2.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(8) > dt")).getText should equal("Customs Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(8) > dd")).getText should equal("£1.00")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(5)")).getText should equal("EU Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dt")).getText should equal("Total reimbursement")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd")).getText should equal("£77.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dt")).getText should equal("Value Added Tax")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd")).getText should equal("£14.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(3) > dt")).getText should equal("Provisional Countervailing Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(3) > dd")).getText should equal("£13.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(4) > dt")).getText should equal("Definitive Countervailing Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(4) > dd")).getText should equal("£12.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(5) > dt")).getText should equal("Provisional Anti-Dumping Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(5) > dd")).getText should equal("£11.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(6) > dt")).getText should equal("Definitive Anti-Dumping Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(6) > dd")).getText should equal("£10.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(7) > dt")).getText should equal("Additional Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(7) > dd")).getText should equal("£9.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(8) > dt")).getText should equal("Customs Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(8) > dd")).getText should equal("£8.00")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(8)")).getText should equal("Overall total")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div > dt")).getText should equal("Total reimbursement")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div > dd")).getText should equal("£105.00")
    }

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > legend")).getText should equal("Are these duties correct?")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def clickRadioButton(text: String): Unit = {
    text.toLowerCase() match {
      case "yes" => click on xpath(s"""//*[@id="check-claim-summary"]""")
      case "no" => click on xpath(s"""//*[@id="check-claim-summary-eori-incorrect"]""")
    }
  }

}
