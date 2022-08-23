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
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Securities_ExportMethodPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/export-method"
  override val title       = "Tell us what you did with the goods"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Tell us what you did with the goods - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Tell us what you did with the goods - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Tell us what you did with the goods")
  override def checkPageTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(title)

  override def checkPageErrorTitle(duty: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(title)

  override def clickRadioButton(text: String): Unit =
    text.toLowerCase() match {
      case "exported in single shipment"                        => click on cssSelector("#choose-export-method")
      case "exported in multiple shipments"                     => click on cssSelector("#choose-export-method-2")
      case "declared to other trader under temporary admission" => click on cssSelector("#choose-export-method-3")
      case "declared to free circulation"                       =>
        click on cssSelector("#choose-export-method-4")
      case "declared to inward processing relief"               => click on cssSelector("#choose-export-method-5")
      case "declared to end use"                                => click on cssSelector("#choose-export-method-6")
      case "declared to a free zone"                            => click on cssSelector("#choose-export-method-7")
      case "declared to a customs warehouse"                    => click on cssSelector("#choose-export-method-8")
      case "destroyed"                                          => click on cssSelector("#choose-export-method-9")
      case "others"                                             => click on cssSelector("#choose-export-method-10")
      case "more than one of the above"                         => click on cssSelector("#choose-export-method-12")
    }
}