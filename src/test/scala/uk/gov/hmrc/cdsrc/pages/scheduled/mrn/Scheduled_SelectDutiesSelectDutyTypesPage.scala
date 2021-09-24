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

package uk.gov.hmrc.cdsrc.pages.scheduled.mrn

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Scheduled_SelectDutiesSelectDutyTypesPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/select-duties/select-duty-types"
  override val title = "Select the duty types you want to claim for all MRNs in the file you uploaded"

  override def expectedPageErrorTitle: Option[String] = Some("Select the duty types you want to claim for all MRNs in the file you uploaded - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the duty types you want to claim for all MRNs in the file you uploaded - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the duty types you want to claim for all MRNs in the file you uploaded")


  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p.govuk-body.govuk-\\!-margin-bottom-8")).getText should equal("These are the duties that have been paid in the import declaration. You may not see all the other extra taxes that you have paid for. You can select one or more of the paid duty types.")
    driver.findElement(By.cssSelector("#main-content > div > div > p.govuk-inset-text")).getText should equal("You can find more information about duties in our UK Trade Tariff guidance (opens in new tab)")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(2) > fieldset > legend > h1")).getText should equal("Customs, Additional, VAT & Anti-Subsidy")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(2) > fieldset > div > div:nth-child(1) > label")).getText should equal("UK Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(2) > fieldset > div > div:nth-child(2) > label")).getText should equal("EU Duty")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > legend > h1")).getText should equal("Excise Duties")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(1) > label")).getText should equal("Beer")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(2) > label")).getText should equal("Wine")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(3) > label")).getText should equal("Made-wine")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(4) > label")).getText should equal("Low alcohol beverages")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(5) > label")).getText should equal("Spirits")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(6) > label")).getText should equal("Cider and perry")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(7) > label")).getText should equal("Hydrocarbon oils")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(8) > label")).getText should equal("Biofuels")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(9) > label")).getText should equal("Miscellaneous road fuels")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(10) > label")).getText should equal("Tobacco products")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > fieldset > div > div:nth-child(11) > label")).getText should equal("Climate Change Levy")
    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

}