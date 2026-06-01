/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.specs.Securities.other

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.Securities._
import uk.gov.hmrc.cdsrc.pages.auth.AuthLoginStubPage
import uk.gov.hmrc.cdsrc.pages.common.{CheckEoriDetailsPage, SelectClaimTypePage}
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class ExploratorySpec extends BaseSpec {

  Feature("Securities Single Exploratory file") {

    Scenario("happy path - check importer/declarant eori pages") {

      Given("User navigates to the Auth Login Stub Page")
      go to AuthLoginStubPage

      When("User enters redirectURL on Auth Login Stub Page")
      AuthLoginStubPage.enterRedirectURL(TestConfiguration.url("cds-frontend") + "/start")

      And("User enters Enrollment Key, ID Name and ID Value on Auth Login Stub Page")
      AuthLoginStubPage.enrolments("HMRC-CUS-ORG", "EORINumber", "GB000000000000001")

      And("User clicks continue on Auth Login Stub Page")
      AuthLoginStubPage.waitForPageHeader
      AuthLoginStubPage.clickContinueButton()

      Then("User is presented with the Check Eori Details Page")
      CheckEoriDetailsPage.waitForPageHeader
      CheckEoriDetailsPage.checkURL
      CheckEoriDetailsPage.checkPageHeader()
      CheckEoriDetailsPage.checkPageTitle()

      When("User selects radio button yes on Check Eori Details Page")
      CheckEoriDetailsPage.waitForPageHeader
      CheckEoriDetailsPage.clickRadioButton("yes")

      And("User clicks continue on Check Eori Details Page")
      CheckEoriDetailsPage.waitForPageHeader
      CheckEoriDetailsPage.clickContinueButton()

      Then("User is presented with the Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.checkURL
      SelectClaimTypePage.checkPageHeader()
      SelectClaimTypePage.checkPageTitle()

      When("User selects radio button securities on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickRadioButton("securities")

      And("User clicks continue on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickContinueButton()

      Then("User is presented with the Securities Enter Movement Reference Number Page")
      Securities_EnterMovementReferenceNumberPage.waitForPageHeader
      Securities_EnterMovementReferenceNumberPage.checkURL
      Securities_EnterMovementReferenceNumberPage.checkPageHeader()
      Securities_EnterMovementReferenceNumberPage.checkPageTitle()

      When("User enters 01AAAAAAAAAAAAA110 on Securities Enter Movement Reference Number Page")
      Securities_EnterMovementReferenceNumberPage.waitForPageHeader
      Securities_EnterMovementReferenceNumberPage.enterDetails("01AAAAAAAAAAAAA110")

      And("User clicks continue on Securities Enter Movement Reference Number Page")
      Securities_EnterMovementReferenceNumberPage.waitForPageHeader
      Securities_EnterMovementReferenceNumberPage.clickContinueButton()

      Then("User is presented with the Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.checkURL
      Securities_ChooseReasonForSecurityPage.checkPageHeader()
      Securities_ChooseReasonForSecurityPage.checkPageTitle()

      When("User selects radio button Temporary Admission (24 months) on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickRadioButton("Temporary Admission (24 months)")

      And("User clicks continue on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickContinueButton()
    }
  }
}
