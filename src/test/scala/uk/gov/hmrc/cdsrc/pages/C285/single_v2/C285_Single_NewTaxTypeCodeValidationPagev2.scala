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

package uk.gov.hmrc.cdsrc.pages.C285.single_v2

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Single_NewTaxTypeCodeValidationPagev2 extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/overpayments/single/new-tax-type-code-validation"
  override val title = "Sorry, there is a problem with this MRN"

  override def expectedPageErrorTitle: Option[String] = Some("Sorry, there is a problem with this MRN - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Sorry, there is a problem with this MRN - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Sorry, there is a problem with this MRN")

  override def clickRadioButton(text: String): Unit = {
    text match {
      case "yes" => click on cssSelector("#problem-with-declaration")
      case "no" => click on cssSelector("#problem-with-declaration-2")
      case _ => throw new IllegalArgumentException(s"Unknown option: $text")
    }
  }

}


