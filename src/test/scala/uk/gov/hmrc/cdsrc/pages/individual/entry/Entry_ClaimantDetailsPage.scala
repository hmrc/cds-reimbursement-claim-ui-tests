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

package uk.gov.hmrc.cdsrc.pages.individual.entry

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Entry_ClaimantDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/claimant-details"
  override val title = "Check your details as registered with CDS"

  override def expectedPageErrorTitle: Option[String] = Some("Check your details as registered with CDS - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check your details as registered with CDS - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check your details as registered with CDS")


  override def checkContent(content: String): Unit = {
    content match {
      case "none" =>
      case _ =>
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dt")).getText should equal("Details as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(1)")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(2)")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(3)")).getText should equal("someemail@mail.com")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("Address as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(1)")).getText should equal("19 Bricks Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(2)")).getText should equal("Newcastle")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(3)")).getText should equal("NE12 5BT")
    }

    driver.findElement(By.cssSelector("#main-content > div > div > a")).getText should equal("Continue")
  }

  override def clickContinueButton(): Unit = {
    click on cssSelector("#main-content > div > div > a")
  }

}
