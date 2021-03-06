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

object Entry_EnterYourDetailsAsRegisteredWithCDS extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/enter-your-details-as-registered-with-cds"
  override val title = "Enter your details as registered with CDS"

  override def expectedPageErrorTitle: Option[String] = Some("Enter your details as registered with CDS - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter your details as registered with CDS - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter your details as registered with CDS")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("These are the details you used when registering with CDS.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(2) > label")).getText should equal("Full name")
    driver.findElement(By.cssSelector("#enter-claimant-details-as-registered-with-cds\\.individual-full-name-hint")).getText should equal("This must be your legal name")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(3) > label")).getText should equal("Email address")
    driver.findElement(By.cssSelector("#main-content > div > div > form > fieldset > legend")).getText should equal("Contact address")
    driver.findElement(By.cssSelector("#main-content > div > div > form > fieldset > div:nth-child(2) > label")).getText should equal("Address Line 1")
    driver.findElement(By.cssSelector("#main-content > div > div > form > fieldset > div:nth-child(3) > label")).getText should equal("Address Line 2 (optional)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > fieldset > div:nth-child(4) > label")).getText should equal("Address Line 3 (optional)")
    driver.findElement(By.cssSelector("#main-content > div > div > form > fieldset > div:nth-child(5) > label")).getText should equal("Town or city")
    driver.findElement(By.cssSelector("#main-content > div > div > form > fieldset > div:nth-child(6) > label")).getText should equal("Postcode")
    driver.findElement(By.cssSelector("#main-content > div > div > form > fieldset > div.form-group.country-code-wrapper > label")).getText should equal("Country")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(5) > fieldset > legend")).getText should equal("Do you want to add contact details so we can contact you about this claim?")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(5) > fieldset > div > div:nth-child(1) > label")).getText should equal("Yes")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(5) > fieldset > div > div:nth-child(2) > label")).getText should equal("No")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def enterDetails(data: String): Unit = {
    val fullName: String = "Johnathon Smithson"
    val emailAddress: String = "johnathonsmithson@email.com"
    val addressLine1: String = "John Rd"
    val addressLine2: String = ""
    val addressLine3: String = ""
    val town: String = "Johnstown"
    val postcode: String = "JO0 0HN"
    val country: String = "United Kingdom"

    enterText("enter-claimant-details-as-registered-with-cds.individual-full-name", fullName)
    enterText("enter-claimant-details-as-registered-with-cds.individual-email", emailAddress)
    enterText("nonUkAddress-line1", addressLine1)
    enterText("nonUkAddress-line2", addressLine2)
    enterText("nonUkAddress-line3", addressLine3)
    enterText("nonUkAddress-line4", town)
    enterText("postcode", postcode)
    selectFromAutocomplete("countryCode", country)
  }

  override def clickRadioButton(selection: String): Unit = {
    click on cssSelector(
      s"""#enter-claimant-details-as-registered-with-cds\\.add-company-details${
        if (selection == "no") {
          "-no"
        } else {
          ""
        }
      }""")
  }

}
