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

package uk.gov.hmrc.cdsrc.pages.Securities

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Securities_ChooseBankAccountTypePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/choose-bank-account-type"
  override val title       = "What type of account details are you providing?"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Error: What type of account details are you providing? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "What type of account details are you providing? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("What type of account details are you providing?")
  override def checkPageTitle(duty: String): Unit =
    driver.findElement(By cssSelector ".govuk-fieldset__heading").getText should equal(title)

  override def checkPageErrorTitle(duty: String): Unit =
    driver.findElement(By cssSelector ".govuk-fieldset__heading").getText should equal(title)

  override def clickRadioButton(buttonText: String): Unit = {
    buttonText.toLowerCase() match {
      case "business bank account" => click on cssSelector("input[data-id='select-bank-account-type-business-bank-account']")
      case "personal bank account" => click on cssSelector("input[data-id='select-bank-account-type-personal-bank-account'")
    }
  }
}