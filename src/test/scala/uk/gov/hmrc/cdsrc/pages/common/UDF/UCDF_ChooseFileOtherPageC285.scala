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

package uk.gov.hmrc.cdsrc.pages.common.UDF

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object UCDF_ChooseFileOtherPageC285 extends BasePage {

  override val url: String = TestConfiguration.url("upload-customs-frontend") + "/choose-files"
  override val title       = "Upload documents to support your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Upload documents to support your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Upload documents to support your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Upload documents to support your claim")

  override def clickRadioButton(text: String): Unit =
    text.toLowerCase() match {
      case "yes" => click on id("choice")
      case "no"  => click on id("choice-2")
    }

  override def clickContinueButton(): Unit = click on cssSelector("#upload-documents-submit")

  override def continuouslyClickContinue(): Unit = {
    waitForPageToLoad()
    while (driver.getCurrentUrl.equals(url))
      clickContinueButton()
  }

}
