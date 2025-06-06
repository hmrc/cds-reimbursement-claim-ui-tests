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
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

import scala.jdk.CollectionConverters.CollectionHasAsScala

object C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2 extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/overpayments/single/choose-file-type"
  override val title       = "Add supporting documents to your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Add supporting documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Add supporting documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Add supporting documents to your claim")

  override def checkURL: Assertion =
    driver.getCurrentUrl should fullyMatch regex (url + ".*?").r

  override def clickRadioButton(selection: String): Unit =
    driver.findElements(By.tagName("label")).asScala.filter(_.getText.trim == selection).head.click()

}
