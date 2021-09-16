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

package uk.gov.hmrc.cdsrc.pages.bulk.mrn

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Multiple_CheckDuplicateDeclarationDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/multiple/check-duplicate-declaration-details"
  override val title = "Check these details are correct"

  override def expectedPageErrorTitle: Option[String] = Some("Check these details are correct - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check these details are correct - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check these details are correct")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal(s"These are the declarant details we have from the MRN declaration. If they are incorrect, you can change them by contacting the CDS team (opens in new tab).")

    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(1) > dt")).getText should equal("MRN")
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(2) > dt")).getText should equal("Import date")
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(3) > dt")).getText should equal("Paid charges")
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(4) > dt")).getText should equal("Importer name")
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(5) > dt")).getText should equal("Importer email")
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(6) > dt")).getText should equal("Importer telephone")
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(7) > dt")).getText should equal("Importer contact address")
    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(8) > dt")).getText should equal("Declarant contact address")

    driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(1) > dd")).getText should equal(content)
    content match {
      case _ =>
        driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(2) > dd")).getText should equal("12 February 2021")
        driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(3) > dd")).getText should equal("£828.00")
        driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(4) > dd")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(5) > dd")).getText should equal("automation@gmail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(6) > dd")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(7) > dd")).getText should equal("19 Bricks Road, Newcastle, NE12 5BT, GB")
        driver.findElement(By.cssSelector("#main-content > div > div > form > dl > div:nth-child(8) > dd")).getText should equal("12 Skybricks Road, Coventry, CV3 6EA, GB")
    }

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def clickRadioButton(text: String): Unit = {
    text.toLowerCase() match {
      case "yes" => click on cssSelector("#check-declaration-details")
      case "no" => click on cssSelector("#check-declaration-details-eori-incorrect")
    }

  }

}
