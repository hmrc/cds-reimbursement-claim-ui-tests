/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.pages.common

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object CheckEoriDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/check-eori-details"
  override val title = "Enter the declarant’s EORI number"

  override def expectedPageErrorTitle: Option[String] = Some("Check if this is the correct EORI - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check if this is the correct EORI - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check if this is the correct EORI")

  override def checkContent(content: String): Unit = {
    val eori = content.split(",")(0)
    val name = content.split(",")(1)

    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(1) > dt")).getText should equal("EORI")
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(1) > dd")).getText should equal(eori)
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(2) > dt")).getText should equal("Name")
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(2) > dd")).getText should equal(name)

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("Yes")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("No, sign in again")
  }

  override def clickRadioButton(text: String) {
    text.toLowerCase() match {
      case "yes" => click on cssSelector("#check-eori-details")
      case "no" => click on cssSelector("#check-eori-details-eori-incorrect")
    }
  }
}
