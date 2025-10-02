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

object Securities_ConfirmPartialpayment extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/partial-claims"
  override val title       = "Partial claims"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Partial claims - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Partial claims - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Partial claims")

  def changeLinks(page: String): Unit = {
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
      case "A00 - Customs Duty" =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/enter-claim/ABC0123456/A00']")
      case "Your claim details have not been saved" =>
        click on cssSelector("a[href='/claim-back-import-duty-vat/securities/claim-deleted']")

    }
}
