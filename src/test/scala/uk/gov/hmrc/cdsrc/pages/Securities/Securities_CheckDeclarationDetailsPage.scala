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

import scala.jdk.CollectionConverters.CollectionHasAsScala

object Securities_CheckDeclarationDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/check-declaration-details"
  override val title       = "Check these declaration details are correct"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Check these declaration details are correct - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Check these declaration details are correct - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Check these declaration details are correct")

  def changeLinks(page: String) = {
    val pageRows = driver
      .findElements(By.cssSelector(".govuk-summary-list__key"))
      .asScala
      .filter(_.getText.trim == page)
      .head
      .findElement(By.xpath(".."))
    pageRows.findElement(By.tagName("a")).click()
  }

  override def clickButton(buttonText: String): Unit =
    buttonText match {
      case "Change MRN"                  =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/enter-movement-reference-number']")
      case "Change reason for security"  =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/choose-reason-for-security']")
      case "Change claim for ABC0123456" =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/select-securities/ABC0123456']")
      case "Change claim for DEF6543213" =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/select-securities/DEF6543213']")
    }
}
