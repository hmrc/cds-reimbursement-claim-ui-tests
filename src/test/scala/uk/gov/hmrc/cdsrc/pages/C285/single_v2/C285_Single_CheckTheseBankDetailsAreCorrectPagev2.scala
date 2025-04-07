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

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedCondition, FluentWait}
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage


import java.time.Duration

object C285_Single_CheckTheseBankDetailsAreCorrectPagev2 extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/overpayments/single/check-bank-details"
  override val title = "Check these bank details are correct"

  override def expectedPageErrorTitle: Option[String] = Some("Check these bank details are correct - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check these bank details are correct - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check these bank details are correct")

  override def clickContinueButton(): Unit = click on cssSelector("#main-content > div > div > form > button")

  override def clickRadioButton(text: String): Unit = {
    val radioButtonSelector = text.toLowerCase() match {
      case "yes" => By.cssSelector("#bank-details-yes-no input[value='true']")
      case "no" => By.cssSelector("#bank-details-yes-no input[value='false']")
      case _ => throw new IllegalArgumentException("Invalid option: " + text)
    }

    val wait: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .pollingEvery(Duration.ofMillis(500))
      .ignoring(classOf[org.openqa.selenium.NoSuchElementException])

    val radioButton: WebElement = wait.until(new ExpectedCondition[WebElement] {
      override def apply(driver: WebDriver): WebElement = {
        driver.findElement(radioButtonSelector)
      }
    })

    // Use JavaScript to click
    val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
    jsExecutor.executeScript("arguments[0].click();", radioButton)

  }

}
