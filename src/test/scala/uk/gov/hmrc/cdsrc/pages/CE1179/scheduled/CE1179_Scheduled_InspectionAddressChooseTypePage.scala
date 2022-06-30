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

package uk.gov.hmrc.cdsrc.pages.CE1179.scheduled

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

import scala.jdk.CollectionConverters.asScalaBufferConverter

object CE1179_Scheduled_InspectionAddressChooseTypePage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/scheduled/inspection-address/choose-type"
  override val title = "Choose an address for the inspection"

  override def expectedPageErrorTitle: Option[String] = Some("Choose an address for the inspection - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Choose an address for the inspection - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Choose an address for the inspection")

  override def clickRadioButton(selection: String): Unit = {
    selection.toLowerCase() match {
      case "importer" => driver.findElement(By.id("inspection-address.type-radio-Importer")).click()
      case "declarant" => driver.findElement(By.id("inspection-address.type-radio-Declarant")).click()
      case "other" => driver.findElement(By.id("inspection-address.type-radio-Other")).click()
      case _ => driver.findElements(By.tagName("label")).asScala.filter(_.getText.trim == selection).head.click()
    }
  }

}
