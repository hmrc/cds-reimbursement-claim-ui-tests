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
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Securities_ConfirmFullRepaymentSecurityIdPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/confirm-full-repayment/..."
  override val title       = "Do you want to claim back all of this security deposit?"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Error: Do you want to claim back all of this security deposit? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Do you want to claim back all of this security deposit? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Do you want to claim back all of this security deposit?")
  override def checkPageTitle(page: String): Unit = {
    val pageCaption: Array[String] = page.split(",")
    driver.findElement(By cssSelector "#main-content > div > div > form > h1 > span").getText should equal(
      s"""Security deposit: 1 of 2"""
    )
    driver.getCurrentUrl should equal(
      TestConfiguration.url("cds-frontend") + s"""/securities/confirm-full-repayment/${pageCaption(0)}"""
    )
  }

  override def checkPageErrorTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > form > h1").getText should equal(title)

  override def clickRadioButton(text: String): Unit =
    text.toLowerCase() match {
      case "yes" => click on cssSelector("#confirm-full-repayment")
      case "no"  => click on cssSelector("#confirm-full-repayment-2")
    }
}