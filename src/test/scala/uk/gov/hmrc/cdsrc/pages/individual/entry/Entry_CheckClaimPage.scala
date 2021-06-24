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

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Entry_CheckClaimPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/check-claim"
  override val title = "Check the reimbursement claim totals for all MRNs"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("Check the reimbursement claim totals for all MRNs - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check the reimbursement claim totals for all MRNs - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check the reimbursement claim totals for all MRNs")

  override def checkContent(content: String): Unit = {
    println("Page is missing content checks")
//    driver.findElement(By.cssSelector("#main-content > div > div > p.govuk-body.govuk-\\!-margin-bottom-8")).getText should equal("These are the calculations based on the information you gave us.")
//
//    val duties = content.split("UK Duty")
//    val duties1 = duties(0)//.split("EU Duty")
//    val duties2 = duties(1)//.split("NI Duty")
//    println()
//    println("uk stuff" + duties1)
//    println("eu stuff" + duties2)
//
//
//
//
////    driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(3)")).getText should equal("UK Duty")
////    driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(1) > dt")).getText should equal("")
////    driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("")
////    driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(4) > div:nth-child(2) > dt")).getText should equal("")
////
////
////    driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(5)")).getText should equal("EU Duty")
//    driver.findElement(By.cssSelector("poiu")).getText should equal("")
//
//
//
//    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def clickRadioButton(text: String): Unit = {
    text.toLowerCase() match {
      case "yes" => click on xpath(s"""//*[@id="check-claim-summary"]""")
      case "no" => click on xpath(s"""//*[@id="check-claim-summary-eori-incorrect"]""")
    }
  }

}
