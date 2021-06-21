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

object Entry_EnterClaimPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/enter-claim"
  override val title = "Enter the claim amount for duty A20 - Additional Duty"

  override def expectedPageErrorTitle: Option[String] = Some("Enter the claim amount for duty A20")

  override def expectedPageTitle: Option[String] = Some("Enter the claim amount for duty A20")

  override def expectedPageHeader: Option[String] = Some("Enter the claim amount for duty A20 - Additional Duty")

  override def enterDetails(data: String): Unit = {
    val amounts: Array[String] = data.split(",")
    amounts.length match {
      case 2 =>
        enterText("enter-claim.paid-amount", amounts(0))
        enterText("enter-claim.claim-amount", amounts(1))
      case 1 =>
        enterText("enter-claim", amounts(0))
    }
  }

  override def checkDutyPage(duty: String): Unit = {
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(s"Enter the claim amount for duty $duty")
  }

  override def checkDutyPageError(duty: String): Unit = {
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(s"Enter the claim amount for duty $duty")
  }

  override def checkBackButtonExistsIfItShould: Any = {
    //Legacy journey shows back button, but MRN does not
    //This method is just to stop it using the standard method, since ^^^ was an unexpected circumstance
  }

}
