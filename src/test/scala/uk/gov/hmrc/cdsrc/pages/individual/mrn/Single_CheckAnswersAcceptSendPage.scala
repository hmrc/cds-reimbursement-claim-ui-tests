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

package uk.gov.hmrc.cdsrc.pages.individual.mrn

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Single_CheckAnswersAcceptSendPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/check-answers-accept-send"
  override val title = "Check your answers before sending your application"

  override def expectedPageErrorTitle: Option[String] = Some("Check your answers before sending your application - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Check your answers before sending your application - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Check your answers before sending your application")

  override def checkContent(content: String): Unit = {
    content match {
      case "check content for ni" =>
        driver.findElement(By.cssSelector("#main-content > div > div > h2.govuk-heading-m.govuk-\\!-margin-top-7")).getText should equal("Movement Reference Number (MRN)")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(3) > div > dt")).getText should equal("MRN")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(3) > div > dd.govuk-summary-list__value")).getText should equal("10AAAAAAAAAAAAAAA1")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(3) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nMRN")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(4)")).getText should equal("Declaration details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(1) > dt")).getText should equal("Import date")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(2) > dt")).getText should equal("Paid charges")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(3) > dt")).getText should equal("Importer name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(4) > dt")).getText should equal("Importer email")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(5) > dt")).getText should equal("Import phone number")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(6) > dt")).getText should equal("Importer contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(7) > dt")).getText should equal("Declarant name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(8) > dt")).getText should equal("Declarant contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(1) > dd")).getText should equal("12 February 2021")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(2) > dd")).getText should equal("£828.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(3) > dd")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(4) > dd")).getText should equal("automation@gmail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(5) > dd")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(6) > dd")).getText should equal("19 Bricks Road, Newcastle, NE12 5BT, GB")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(7) > dd")).getText should equal("Foxpro Central LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(8) > dd")).getText should equal("12 Skybricks Road, Coventry, CV3 6EA, GB")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(6)")).getText should equal("Claimant type")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(7) > div > dt")).getText should equal("Type of claimant")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(7) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nType of claimant")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(8)")).getText should equal("Claimant’s CDS details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(1) > dt")).getText should equal("Full name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(2) > dt")).getText should equal("Email address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(3) > dt")).getText should equal("Contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(2) > dd.govuk-summary-list__value")).getText should equal("someemail@mail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(3) > dd.govuk-summary-list__value")).getText should equal("19 Bricks Road, Newcastle, NE12 5BT, United Kingdom")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(1) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nFull name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(2) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nEmail address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(3) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nContact address")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(10)")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dt")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("Online Sales LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("someemail@mail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dt")).getText should equal("Contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("11 Mount Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("London")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("E10 7PP")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(4)")).getText should equal("United Kingdom")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact address")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(12)")).getText should equal("Basis for claim")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(13) > div > dt")).getText should equal("This is the basis behind the claim")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(13) > div > dd.govuk-summary-list__value")).getText should equal("Duplicate MRN")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(13) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nThis is the basis behind the claim")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(14)")).getText should equal("Were your goods imported into Northern Ireland?")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(15) > div > dt")).getText should equal("Were your goods imported into Northern Ireland?")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(15) > div > dd.govuk-summary-list__value")).getText should equal("Yes")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(15) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nWere your goods imported into Northern Ireland?")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(16)")).getText should equal("Commodity details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div > dt")).getText should equal("Details of the commodities")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div > dd.govuk-summary-list__value")).getText should equal("under 500 characters")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nDetails of the commodities")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(18)")).getText should equal("Claim calculation")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(1) > dt")).getText should equal("All UK duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(2) > dt")).getText should equal("All EU duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(3) > dt")).getText should equal("All excise duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(4) > dt")).getText should equal("Total claimed reimbursement")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("£0.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(2) > dd.govuk-summary-list__value")).getText should equal("£40.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(3) > dd.govuk-summary-list__value")).getText should equal("£0.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(4) > dd.govuk-summary-list__value")).getText should equal("£40.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(1) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAll UK duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(2) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAll EU duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(3) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAll excise duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(4) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nTotal claimed reimbursement")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(20)")).getText should equal("Bank details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div:nth-child(1) > dt")).getText should equal("Account name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div:nth-child(2) > dt")).getText should equal("Sort code")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div:nth-child(3) > dt")).getText should equal("Account number")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("CDS E2E To E2E Bank")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div:nth-child(2) > dd.govuk-summary-list__value")).getText should equal("Ending with 44")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div:nth-child(3) > dd.govuk-summary-list__value")).getText should equal("Ending with 5678")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div:nth-child(1) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAccount name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div:nth-child(2) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nSort code")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div:nth-child(3) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAccount number")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(22)")).getText should equal("Supporting documents")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(23) > div > dt")).getText should equal("Uploaded")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(23) > div > dd.govuk-summary-list__value")).getText should equal("document.pdf\nCommercial Invoice")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(23) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nUploaded")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(24)")).getText should equal("Now send your application")
        driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("By submitting this notification you are confirming that, to the best of your knowledge, the details you are providing are correct.")

        driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Accept and send")

      case "check content" =>
        driver.findElement(By.cssSelector("#main-content > div > div > h2.govuk-heading-m.govuk-\\!-margin-top-7")).getText should equal("Movement Reference Number (MRN)")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(3) > div > dt")).getText should equal("MRN")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(3) > div > dd.govuk-summary-list__value")).getText should equal("10AAAAAAAAAAAAAAA1")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(3) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nMRN")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(4)")).getText should equal("Declaration details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(1) > dt")).getText should equal("Import date")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(2) > dt")).getText should equal("Paid charges")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(3) > dt")).getText should equal("Importer name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(4) > dt")).getText should equal("Importer email")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(5) > dt")).getText should equal("Import phone number")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(6) > dt")).getText should equal("Importer contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(7) > dt")).getText should equal("Declarant name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(8) > dt")).getText should equal("Declarant contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(1) > dd")).getText should equal("12 February 2021")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(2) > dd")).getText should equal("£828.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(3) > dd")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(4) > dd")).getText should equal("automation@gmail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(5) > dd")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(6) > dd")).getText should equal("19 Bricks Road, Newcastle, NE12 5BT, GB")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(7) > dd")).getText should equal("Foxpro Central LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(8) > dd")).getText should equal("12 Skybricks Road, Coventry, CV3 6EA, GB")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(6)")).getText should equal("Claimant type")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(7) > div > dt")).getText should equal("Type of claimant")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(7) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nType of claimant")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(8)")).getText should equal("Claimant’s CDS details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(1) > dt")).getText should equal("Full name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(2) > dt")).getText should equal("Email address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(3) > dt")).getText should equal("Contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(2) > dd.govuk-summary-list__value")).getText should equal("someemail@mail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(3) > dd.govuk-summary-list__value")).getText should equal("19 Bricks Road, Newcastle, NE12 5BT, United Kingdom")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(1) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nFull name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(2) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nEmail address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(3) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nContact address")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(10)")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dt")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("Online Sales LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("someemail@mail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dt")).getText should equal("Contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("11 Mount Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("London")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("E10 7PP")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(4)")).getText should equal("United Kingdom")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact address")


        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(12)")).getText should equal("Basis for claim")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(13) > div > dt")).getText should equal("This is the basis behind the claim")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(13) > div > dd.govuk-summary-list__value")).getText should equal("Duplicate MRN")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(13) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nThis is the basis behind the claim")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(14)")).getText should equal("Commodity details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(15) > div > dt")).getText should equal("Details of the commodities")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(15) > div > dd.govuk-summary-list__value")).getText should equal("under 500 characters")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(15) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nDetails of the commodities")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(16)")).getText should equal("Claim calculation")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(1) > dt")).getText should equal("All UK duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(2) > dt")).getText should equal("All EU duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(3) > dt")).getText should equal("All excise duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(4) > dt")).getText should equal("Total claimed reimbursement")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("£0.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(2) > dd.govuk-summary-list__value")).getText should equal("£40.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(3) > dd.govuk-summary-list__value")).getText should equal("£0.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(4) > dd.govuk-summary-list__value")).getText should equal("£40.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(1) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAll UK duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(2) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAll EU duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(3) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAll excise duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(4) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nTotal claimed reimbursement")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(18)")).getText should equal("Bank details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(1) > dt")).getText should equal("Account name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(2) > dt")).getText should equal("Sort code")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(3) > dt")).getText should equal("Account number")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("CDS E2E To E2E Bank")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(2) > dd.govuk-summary-list__value")).getText should equal("Ending with 44")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(3) > dd.govuk-summary-list__value")).getText should equal("Ending with 5678")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(1) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAccount name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(2) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nSort code")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(3) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAccount number")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(20)")).getText should equal("Supporting documents")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div > dt")).getText should equal("Uploaded")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div > dd.govuk-summary-list__value")).getText should equal("document.pdf\nCommercial Invoice")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nUploaded")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(22)")).getText should equal("Now send your application")
        driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("By submitting this notification you are confirming that, to the best of your knowledge, the details you are providing are correct.")

        driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Accept and send")

      case "3 files" =>
        driver.findElement(By.cssSelector("#main-content > div > div > h2.govuk-heading-m.govuk-\\!-margin-top-7")).getText should equal("Movement Reference Number (MRN)")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(3) > div > dt")).getText should equal("MRN")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(3) > div > dd.govuk-summary-list__value")).getText should equal("10AAAAAAAAAAAAAAA1")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(3) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nMRN")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(4)")).getText should equal("Declaration details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(1) > dt")).getText should equal("Import date")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(2) > dt")).getText should equal("Paid charges")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(3) > dt")).getText should equal("Importer name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(4) > dt")).getText should equal("Importer email")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(5) > dt")).getText should equal("Import phone number")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(6) > dt")).getText should equal("Importer contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(7) > dt")).getText should equal("Declarant name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(8) > dt")).getText should equal("Declarant contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(1) > dd")).getText should equal("12 February 2021")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(2) > dd")).getText should equal("£828.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(3) > dd")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(4) > dd")).getText should equal("automation@gmail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(5) > dd")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(6) > dd")).getText should equal("19 Bricks Road, Newcastle, NE12 5BT, GB")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(7) > dd")).getText should equal("Foxpro Central LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(5) > div:nth-child(8) > dd")).getText should equal("12 Skybricks Road, Coventry, CV3 6EA, GB")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(6)")).getText should equal("Claimant type")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(7) > div > dt")).getText should equal("Type of claimant")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(7) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nType of claimant")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(8)")).getText should equal("Claimant’s CDS details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(1) > dt")).getText should equal("Full name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(2) > dt")).getText should equal("Email address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(3) > dt")).getText should equal("Contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("IT Solutions LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(2) > dd.govuk-summary-list__value")).getText should equal("someemail@mail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(3) > dd.govuk-summary-list__value")).getText should equal("19 Bricks Road, Newcastle, NE12 5BT, United Kingdom")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(1) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nFull name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(2) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nEmail address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(9) > div:nth-child(3) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nContact address")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(10)")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dt")).getText should equal("Contact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("Online Sales LTD")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("someemail@mail.com")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("+4420723934397")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(1) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dt")).getText should equal("Contact address")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("11 Mount Road")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("London")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("E10 7PP")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__value > p:nth-child(4)")).getText should equal("United Kingdom")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(11) > div:nth-child(2) > dd.govuk-summary-list__actions.govuk-link > a")).getText should equal("Change\nContact address")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(12)")).getText should equal("Basis for claim")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(13) > div > dt")).getText should equal("This is the basis behind the claim")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(13) > div > dd.govuk-summary-list__value")).getText should equal("Duty Suspension")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(13) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nThis is the basis behind the claim")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(14)")).getText should equal("Commodity details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(15) > div > dt")).getText should equal("Details of the commodities")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(15) > div > dd.govuk-summary-list__value")).getText should equal("under 500 characters")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(15) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nDetails of the commodities")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(16)")).getText should equal("Claim calculation")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(1) > dt")).getText should equal("All UK duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(2) > dt")).getText should equal("All EU duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(3) > dt")).getText should equal("All excise duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(4) > dt")).getText should equal("Total claimed reimbursement")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("£0.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(2) > dd.govuk-summary-list__value")).getText should equal("£40.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(3) > dd.govuk-summary-list__value")).getText should equal("£0.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(4) > dd.govuk-summary-list__value")).getText should equal("£40.00")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(1) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAll UK duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(2) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAll EU duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(3) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAll excise duties to reimburse claimed by you")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(17) > div:nth-child(4) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nTotal claimed reimbursement")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(18)")).getText should equal("Bank details")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(1) > dt")).getText should equal("Account name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(2) > dt")).getText should equal("Sort code")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(3) > dt")).getText should equal("Account number")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(1) > dd.govuk-summary-list__value")).getText should equal("CDS E2E To E2E Bank")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(2) > dd.govuk-summary-list__value")).getText should equal("Ending with 44")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(3) > dd.govuk-summary-list__value")).getText should equal("Ending with 5678")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(1) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAccount name")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(2) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nSort code")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(19) > div:nth-child(3) > dd.govuk-summary-list__actions > a")).getText should equal("Change\nAccount number")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(20)")).getText should equal("Supporting documents")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div > dt")).getText should equal("Uploaded")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div > dd.govuk-summary-list__value > p:nth-child(1)")).getText should equal("document.pdf\nPacking List")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div > dd.govuk-summary-list__value > p:nth-child(2)")).getText should equal("document.pdf\nImport and Export Declaration")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div > dd.govuk-summary-list__value > p:nth-child(3)")).getText should equal("document.pdf\nCommercial Invoice")
        driver.findElement(By.cssSelector("#main-content > div > div > dl:nth-child(21) > div > dd.govuk-summary-list__actions > a")).getText should equal("Change\nUploaded")

        driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(22)")).getText should equal("Now send your application")
        driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("By submitting this notification you are confirming that, to the best of your knowledge, the details you are providing are correct.")

        driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Accept and send")
      case _ =>
    }
  }

  override def clickButton(buttonText: String): Unit = {
    buttonText match {
      case "change reference number" => click on cssSelector("#main-content > div > div > dl:nth-child(3) > div > dd.govuk-summary-list__actions > a")
    }
  }

}
