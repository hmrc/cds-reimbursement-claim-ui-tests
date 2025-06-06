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
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Securities_SelectDutiesSecurityIdPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/securities/select-duties/..."
  override val title       = "Select the duties you want to claim for"

  override def expectedPageHeader: Option[String] = Some("Select the duties you want to claim for")

  override def expectedPageErrorTitle: Option[String] = Some(
    "Error: Select the duties you want to claim for - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Select the duties you want to claim for - Claim back import duty and VAT - GOV.UK"
  )

  override def checkPageHeader(): Assertion =
    true should equal(true)

  def checkSecurityId(securityID: String): Unit =
    driver.findElement(By cssSelector "#main-content > div > div > form > span").getText should equal(
      s"Security ID: $securityID"
    )
}
