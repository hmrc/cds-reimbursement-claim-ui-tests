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

object Entry_EnterDeclarationDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/enter-declaration-details"
  override val title = "Enter declaration details"

  override def expectedPageErrorTitle: Option[String] = Some("Enter declaration details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter declaration details - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter declaration details")

  override def checkContent(content: String): Unit ={
    driver.findElement(By.cssSelector("#main-content > div > div > form > p")).getText should equal(s"""These are the import date and place of import related to the entry number: $content.""")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(4) > fieldset > legend")).getText should equal("Date of import")
    driver.findElement(By.cssSelector("#enter-declaration-details-hint")).getText should equal("This is the date when the commodities arrived in the UK.")
    driver.findElement(By.cssSelector("#enter-declaration-details > div:nth-child(1) > div > label")).getText should equal("Day")
    driver.findElement(By.cssSelector("#enter-declaration-details > div:nth-child(2) > div > label")).getText should equal("Month")
    driver.findElement(By.cssSelector("#enter-declaration-details > div:nth-child(3) > div > label")).getText should equal("Year")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(5) > label")).getText should equal("Place of import")
    driver.findElement(By.cssSelector("#enter-declaration-details\\.place-of-import-hint")).getText should equal("This is where the commodities arrived in the UK. You can find the location on import documents.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(6) > label")).getText should equal("Importer name")
    driver.findElement(By.cssSelector("#enter-declaration-details\\.importer-name-hint")).getText should equal("This is the legal name of the importer company or individual.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(7) > label")).getText should equal("Importer email address")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(8) > label")).getText should equal("Importer phone number")
    driver.findElement(By.cssSelector("#enter-declaration-details\\.importer-phone-number-hint")).getText should equal("For international numbers include the country code.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(9) > label")).getText should equal("Declarant name")
    driver.findElement(By.cssSelector("#enter-declaration-details\\.declarant-name-hint")).getText should equal("This is the name of the person who made the declaration.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(10) > label")).getText should equal("Declarant email address")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div:nth-child(11) > label")).getText should equal("Declarant phone number")
    driver.findElement(By.cssSelector("#enter-declaration-details\\.declarant-phone-number-hint")).getText should equal("For international numbers include the country code.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }

  override def enterDetails(data: String): Unit = {
    val importDate: String = "1"
    val importMonth: String = "1"
    val importYear: String = "2021"
    val placeOfImport: String = "Dover"
    val importerName: String = "John Smith"
    val importerEmailAddress: String = "johnsmith@email.com"
    val importerPhoneNumber: String = "01234567890"
    val declarantName: String = "Johnathon Smithson"
    val declarantEmailAddress: String = "johnathonsmithson@email.com"
    val declarantPhoneNumber: String = "01234567891"

    enterText("enter-declaration-details.day", importDate)
    enterText("enter-declaration-details.month", importMonth)
    enterText("enter-declaration-details.year", importYear)
    enterText("enter-declaration-details.place-of-import", placeOfImport)
    enterText("enter-declaration-details.importer-name", importerName)
    enterText("enter-declaration-details.importer-email-address", importerEmailAddress)
    enterText("enter-declaration-details.importer-phone-number", importerPhoneNumber)
    enterText("enter-declaration-details.declarant-name", declarantName)
    enterText("enter-declaration-details.declarant-email-address", declarantEmailAddress)
    enterText("enter-declaration-details.declarant-phone-number", declarantPhoneNumber)
  }

}
