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

import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, StaleElementReferenceException}
import org.slf4j.LoggerFactory
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage


object UCDF_ChooseFileOtherPage extends BasePage {
  private val log = LoggerFactory.getLogger(getClass)


  override val url: String = TestConfiguration.url("upload-customs-frontend") + "/choose-files"
  override val title       = "Add documents to support your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Add documents to support your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Add documents to support your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Add documents to support your claim")


  override def clickContinueButton(): Unit = {
    var attempts = 0
    var success = false

    while (!success && attempts < 3) {
      try {
        log.info(s"Attempting to click continue button on attempt $attempts")
        fluentWait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id(("upload-documents-submit")))).andThen(_.click()))
        success = true
      } catch {
        case e: StaleElementReferenceException =>
          log.warn(s"StaleElementReferenceException on attempt $attempts: ${e.getMessage}")
          attempts += 1
          Thread.sleep(100)
        case e: Exception =>
          log.error(s"Unexpected error while clicking continue: ${e.getMessage}")
          throw e
      }
    }

    if (!success) {
      throw new RuntimeException("Failed to click continue button after 3 attempts due to stale element.")
    }
  }

}
