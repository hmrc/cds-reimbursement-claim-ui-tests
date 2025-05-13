/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.pages.CE1179.scheduled

import org.openqa.selenium.By
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object CE1179_Scheduled_SelectDutiesDutyTypeDutyPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/scheduled/enter-claim/..."
  override val title       = ""

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("")

  override def expectedPageHeader: Option[String] = Some("")

  override def checkPageHeader(): Assertion =
    true should equal(true)

  override def enterDetails(data: String): Unit = {
    val amounts: Array[String] = data.split(",")
    driver.findElement(By.name("enter-claim.scheduled.paid-amount")).sendKeys(amounts(0))
    driver.findElement(By.name("enter-claim.scheduled.claim-amount")).sendKeys(amounts(1))
  }

  override def checkPageTitle(duty: String): Unit = {
    val expectedTitle = s"$duty".replaceAll("\\s", "")
    val actualTitle   = driver.findElement(By.cssSelector("#main-content > div > div > h1")).getText.replaceAll("\\s", "")

    actualTitle shouldEqual expectedTitle
  }

  override def checkPageErrorTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(
      s"Claim details for all MRNs under $duty"
    )

}
