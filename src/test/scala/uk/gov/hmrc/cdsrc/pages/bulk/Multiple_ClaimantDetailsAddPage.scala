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

package uk.gov.hmrc.cdsrc.pages.bulk

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Multiple_ClaimantDetailsAddPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/multiple/claimant-details/add"
  override val title = "Check your details as registered with CDS"

  override def expectedPageErrorTitle: Option[String] = Some("Check your details as registered with CDS - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check your details as registered with CDS - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check your details as registered with CDS")


  override def checkContent(content: String): Unit = {

    driver.findElement(By.cssSelector("#main-content > div > div > h2.govuk-heading-m.govuk-\\!-margin-bottom-6")).getText should equal("Details as registered with CDS")

    content match {
      case "missing details" =>
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dt")).getText should equal("Details as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(1)")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(2)")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(3)")).getText should equal("someemail@mail.com")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("Address as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(1)")).getText should equal("19 Bricks Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(2)")).getText should equal("Newcastle")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(3)")).getText should equal("NE12 5BT")

        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > legend > h1")).getText should equal("Do you wish to add different contact details which we will use to contact you about this claim?")
      case "10AAAAAAAAAAAAAAA1 - change details" =>
        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(4)")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("These are the details we will use to contact you about your claim.")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dt")).getText should equal("Details as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(1)")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(2)")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(3)")).getText should equal("someemail@mail.com")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("Address as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(1)")).getText should equal("19 Bricks Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(2)")).getText should equal("Newcastle")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(3)")).getText should equal("NE12 5BT")

        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dt")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("John Smith")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("john@smith.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("01234567890")

        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dt")).getText should equal("Contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("123 Fake Street")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("123 Fake Town")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("SW1A 1AA")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(4)")).getText should equal("United Kingdom")

        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact address")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > legend > h1")).getText should equal("Do you want to continue using these contact details?")
        driver.findElement(By.cssSelector("#claimant-details-hint")).getText should equal("If you select No we will contact you using your CDS registered details.")
      case "10AAAAAAAAAAAAAAA6" =>
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dt")).getText should equal("Details as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(1)")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(2)")).getText should equal("someemail@mail.com")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("Address as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(1)")).getText should equal("19 Bricks Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(2)")).getText should equal("Newcastle")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(3)")).getText should equal("NE12 5BT")

        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > legend > h1")).getText should equal("Do you wish to add different contact details which we will use to contact you about this claim?")
      case "10AAAAAAAAAAAAAAA6 - change details" =>
        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(4)")).getText should equal("Contact Details")
        driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("These are the details we will use to contact you about your claim.")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dt")).getText should equal("Details as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(1)")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(2)")).getText should equal("someemail@mail.com")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("Address as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(1)")).getText should equal("19 Bricks Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(2)")).getText should equal("Newcastle")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(3)")).getText should equal("NE12 5BT")

        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dt")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("John Smith")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("01234567890")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("john@smith.com")

        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dt")).getText should equal("Contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("123 Fake Street")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("123 Fake Town")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("SW1A 1AA")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(4)")).getText should equal("United Kingdom")

        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact address")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > legend > h1")).getText should equal("Do you want to continue using these contact details?")
        driver.findElement(By.cssSelector("#claimant-details-hint")).getText should equal("If you select No we will contact you using your CDS registered details.")
      case _ =>
        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(4)")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("These are the details we will use to contact you about your claim.")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dt")).getText should equal("Details as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(1)")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(2)")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(1) > dd > p:nth-child(3)")).getText should equal("someemail@mail.com")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("Address as registered with CDS")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(1)")).getText should equal("19 Bricks Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(2)")).getText should equal("Newcastle")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > p:nth-child(3)")).getText should equal("NE12 5BT")

        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dt")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("Online Sales LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("someemail@mail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("+4420723934397")

        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dt")).getText should equal("Contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("11 Mount Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("London")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("E10 7PP")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(4)")).getText should equal("United Kingdom")

        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact address")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > legend > h1")).getText should equal("Do you want to continue using these contact details?")
        driver.findElement(By.cssSelector("#claimant-details-hint")).getText should equal("If you select No we will contact you using your CDS registered details.")
    }

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def clickRadioButton(text: String): Unit = {
    text match {
      case "yes" => click on cssSelector("#claimant-details-yes")
      case "no" => click on cssSelector("#claimant-details-no")
    }
  }

}
