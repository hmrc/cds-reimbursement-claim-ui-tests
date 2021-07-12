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

object Entry_SelectDutiesPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/select-duties"
  override val title = "Select the duties you want to claim for"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("Select the duties you want to claim for - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the duties you want to claim for - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the duties you want to claim for")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("These are the duties that have been paid in the import declaration.\nYou can select any of the paid duties.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("A00 - Customs Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("A20 - Additional Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("A30 - Definitive Anti-Dumping Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(4) > label")).getText should equal("A35 - Provisional Anti-Dumping Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(5) > label")).getText should equal("A40 - Definitive Countervailing Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(6) > label")).getText should equal("A45 - Provisional Countervailing Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(7) > label")).getText should equal("B00 - Value Added Tax")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(8) > label")).getText should equal("A50 - Customs Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(9) > label")).getText should equal("A70 - Additional Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(10) > label")).getText should equal("A80 - Definitive Anti-Dumping Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(11) > label")).getText should equal("A85 - Provisional Anti-Dumping Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(12) > label")).getText should equal("A90 - Definitive Countervailing Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(13) > label")).getText should equal("A95 - Provisional Countervailing Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(14) > label")).getText should equal("B05 - Value Added Tax")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  def enterDetails(): Unit = {

  }

}
