/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.pages.Securities

import org.openqa.selenium.By
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Securities_EnterClaimSecurityIdTaxCodePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/enter-claim/..."
  override val title       = "Claim details for A20 - Additional Duty"

  override def expectedPageHeader: Option[String] = Some("Claim details for A20 - Additional Duty")

  override def expectedPageErrorTitle: Option[String] = Some("ERROR: Claim details for A20 - Additional Duty - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Claim details for A20 - Additional Duty - Claim back import duty and VAT - GOV.UK")

  override def checkPageHeader(): Assertion =
    true should equal(true)

  override def enterDetails(data: String): Unit = {
    val amounts: Array[String] = data.split(",")
    enterText("enter-claim.securities.claim-amount", amounts(0))
  }

  override def checkPageTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(s"Claim details for $duty")

  override def checkPageErrorTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(s"Claim details for $duty")
}