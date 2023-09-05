/*
 * Copyright 2023 HM Revenue & Customs
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

object Securities_SelectSecuritiesSecurityIdPage2 extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/select-securities/..."
  override val title       = "Include this security deposit in your claim?"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Error: Security deposit: 2 of 5: Include this security deposit in your claim? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Security deposit: 2 of 5: Include this security deposit in your claim? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("""Security deposit: 2 of 5
Include this security deposit in your claim?""")

  override def checkURL: Assertion =
    true should equal(true)

  override def checkPageTitle(page: String): Unit = {
    val pageCaption: Array[String] = page.split(",")
    driver.findElement(By cssSelector "#main-content > div > div > h1 > span").getText should equal(
      s"""Security deposit: ${pageCaption(0)}"""
    )
    driver.findElement(By cssSelector "#main-content > div > div > form > h2").getText should equal(
      s"""Security deposit ID: ${pageCaption(1)}"""
    )
    driver.getCurrentUrl                                                               should equal(
      TestConfiguration.url("cds-frontend") + s"""/securities/select-securities/${pageCaption(1)}"""
    )
  }

  override def clickRadioButton(text: String): Unit =
    text.toLowerCase() match {
      case "yes" => click on cssSelector("input[data-id='select-securities-yes']")
      case "no"  => click on cssSelector("input[data-id='select-securities-no']")
    }
}
