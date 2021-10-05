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

object Single_SelectDutiesPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/select-duties"
  override val title = "Select the duties you want to claim for"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("Select the duties you want to claim for - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the duties you want to claim for - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the duties you want to claim for")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("These are the duties that have been paid in the import declaration.\nYou can select any of the paid duties.")
    content match {
      case "10AAAAAAAAAAAAAAA3" =>
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("A80 - Definitive Anti-Dumping Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("421 - Made-wine (sparkling), exceeding 8.5% vol. but not exceeding 15% vol.")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("623 - Smoking tobacco – other")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(4) > label")).getText should equal("99C - Gas supplied by a gas utility or any gas supplied in a gaseous state that is of a kind supplied by a gas utility Great Britain")
      case "10AAAAAAAAAAAAAAA3 - excise" =>
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("421 - Made-wine (sparkling), exceeding 8.5% vol. but not exceeding 15% vol.")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("623 - Smoking tobacco – other")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("99C - Gas supplied by a gas utility or any gas supplied in a gaseous state that is of a kind supplied by a gas utility Great Britain")
      case "50AAAAAAAAAAAAAAA1" =>
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("A20 - Additional Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("A35 - Provisional Anti-Dumping Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("A90 - Definitive Countervailing Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(4) > label")).getText should equal("A85 - Provisional Anti-Dumping Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(5) > label")).getText should equal("A95 - Provisional Countervailing Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(6) > label")).getText should equal("421 - Made-wine (sparkling), exceeding 8.5% vol. but not exceeding 15% vol.")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(7) > label")).getText should equal("623 - Smoking tobacco – other")
      case "10AAAAAAAAAAAAAAA1" | _ =>
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("A80 - Definitive Anti-Dumping Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("A95 - Provisional Countervailing Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("A90 - Definitive Countervailing Duty")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(4) > label")).getText should equal("A85 - Provisional Anti-Dumping Duty")
    }

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  def enterDetails(): Unit = {

  }

}
