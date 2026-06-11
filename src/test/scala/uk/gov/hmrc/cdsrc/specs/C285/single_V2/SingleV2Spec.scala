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

package uk.gov.hmrc.cdsrc.specs.C285.single_V2

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.C285.single_v2._
import uk.gov.hmrc.cdsrc.pages.auth.AuthLoginStubPage
import uk.gov.hmrc.cdsrc.pages.common.{CheckEoriDetailsPage, SelectClaimTypePage}
import uk.gov.hmrc.cdsrc.pages.common.ALF.{ALF_LookupAddressConfirmPage, ALF_LookupAddressEditPage, ALF_LookupAddressLookupPage}
import uk.gov.hmrc.cdsrc.pages.common.UDF.UCDF_ChooseFileOtherPage
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class SingleV2Spec extends BaseSpec {

  Feature("C285 Single V2") {

    Scenario("happy path with payee type and with only importer bank details") {

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

      When("User selects radio button c285 on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickRadioButton("c285")

      And("User clicks continue on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickContinueButton()

      Then("User is presented with the C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.checkURL
      C285_ChooseHowManyMrnsPagev2.checkPageHeader()
      C285_ChooseHowManyMrnsPagev2.checkPageTitle()

      When("User selects radio button individual on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickRadioButton("individual")

      And("User clicks continue on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickContinueButton()

      Then("User is presented with the C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.checkURL
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()

      When("User clicks continue on C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.clickContinue()

      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 60AAAAAAAAAAAAAAA5 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("60AAAAAAAAAAAAAAA5")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.checkURL
      C285_Single_ChooseBasisForClaimPagev2.checkPageHeader()
      C285_Single_ChooseBasisForClaimPagev2.checkPageTitle()

      When("User selects radio button End use relief on C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.clickRadioButton("End use relief")

      And("User clicks continue on C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Additional Details Page v2")
      C285_Single_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Single_EnterAdditionalDetailsPagev2.checkURL
      C285_Single_EnterAdditionalDetailsPagev2.checkPageHeader()
      C285_Single_EnterAdditionalDetailsPagev2.checkPageTitle()

      When("User enters under 500 characters on C285 Single Enter Additional Details Page v2")
      C285_Single_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Single_EnterAdditionalDetailsPagev2.enterDetails("under 500 characters")

      And("User clicks continue on C285 Single Enter Additional Details Page v2")
      C285_Single_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Single_EnterAdditionalDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Select Duties Page v2")
      C285_Single_SelectDutiesPagev2.waitForPageHeader
      C285_Single_SelectDutiesPagev2.checkURL
      C285_Single_SelectDutiesPagev2.checkPageHeader()
      C285_Single_SelectDutiesPagev2.checkPageTitle()

      When("User selects A80,A95,A90,A85 on C285 Single Select Duties Page v2")
      C285_Single_SelectDutiesPagev2.waitForPageHeader
      C285_Single_SelectDutiesPagev2.selectBoxes("A80,A95,A90,A85".split(","))

      And("User clicks continue on C285 Single Select Duties Page v2")
      C285_Single_SelectDutiesPagev2.waitForPageHeader
      C285_Single_SelectDutiesPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Claim Page v2 - A80 - Definitive Anti-Dumping Duty")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.checkURL
      C285_Single_EnterClaimPagev2.checkPageTitle("A80 - Definitive Anti-Dumping Duty")

      When("User enters 10 on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.enterDetails("10")

      And("User clicks continue on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Claim Page v2 - A95 - Provisional Countervailing Duty")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.checkURL
      C285_Single_EnterClaimPagev2.checkPageTitle("A95 - Provisional Countervailing Duty")

      When("User enters 10 on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.enterDetails("10")

      And("User clicks continue on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Claim Page v2 - A90 - Definitive Countervailing Duty")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.checkURL
      C285_Single_EnterClaimPagev2.checkPageTitle("A90 - Definitive Countervailing Duty")

      When("User enters 10 on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.enterDetails("10")

      And("User clicks continue on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Claim Page v2 - A85 - Provisional Anti-Dumping Duty")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.checkURL
      C285_Single_EnterClaimPagev2.checkPageTitle("A85 - Provisional Anti-Dumping Duty")

      When("User enters 10 on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.enterDetails("10")

      And("User clicks continue on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Claim Page v2")
      C285_Single_CheckClaimPagev2.waitForPageHeader
      C285_Single_CheckClaimPagev2.checkURL
      C285_Single_CheckClaimPagev2.checkPageHeader()
      C285_Single_CheckClaimPagev2.checkPageTitle()

      When("User clicks continue on C285 Single Check Claim Page v2")
      C285_Single_CheckClaimPagev2.waitForPageHeader
      C285_Single_CheckClaimPagev2.clickContinue()

      Then("User is presented with the C285 Single Choose Payee Type v2")
      C285_Single_ChoosePayeeTypev2.waitForPageHeader
      C285_Single_ChoosePayeeTypev2.checkURL
      C285_Single_ChoosePayeeTypev2.checkPageHeader()
      C285_Single_ChoosePayeeTypev2.checkPageTitle()

      And("User selects radio button Importer on C285 Single Choose Payee Type v2")
      C285_Single_ChoosePayeeTypev2.waitForPageHeader
      C285_Single_ChoosePayeeTypev2.clickRadioButton("Importer")

      When("User clicks continue on C285 Single Choose Payee Type v2")
      C285_Single_ChoosePayeeTypev2.waitForPageHeader
      C285_Single_ChoosePayeeTypev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Bank Account Details Page v2")
      C285_Single_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Single_EnterBankAccountDetailsPagev2.checkURL
      C285_Single_EnterBankAccountDetailsPagev2.checkPageHeader()
      C285_Single_EnterBankAccountDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Single Enter Bank Account Details Page v2")
      C285_Single_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Single_EnterBankAccountDetailsPagev2.enterDetails("")

      When("User clicks continue on C285 Single Enter Bank Account Details Page v2")
      C285_Single_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Single_EnterBankAccountDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()

      When("User selects radio button Commercial invoice on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Commercial invoice")

      And("User clicks continue on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

      Then("User is presented with the UCDF Choose File Other Page - Commercial invoice")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("Commercial invoice")

      When("User uploads a 1 document.pdf file on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.uploadDocument(1, "document.pdf")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()

      And("User selects radio button No on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("No")

      And("User clicks continue if I'm on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.clickContinueButton()
      UCDF_ChooseFileOtherPage.continuouslyClickContinue()

      Then("User is presented with the C285 Single Claimant Details Change Claimant Details Page v2")
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.checkURL
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageHeader()
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Single Claimant Details Change Claimant Details Page v2")
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.enterDetails("")

      And("User clicks continue on C285 Single Claimant Details Change Claimant Details Page v2")
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.clickContinueButton()

      And("User clicks Enter the address manually on ALF Lookup Address Lookup Page")
      ALF_LookupAddressLookupPage.waitForPageHeader
      ALF_LookupAddressLookupPage.clickButton("Enter the address manually")

      And("User enters empty string on ALF Lookup Address Edit Page")
      ALF_LookupAddressEditPage.waitForPageHeader
      ALF_LookupAddressEditPage.enterDetails("")

      And("User clicks continue on ALF Lookup Address Edit Page")
      ALF_LookupAddressEditPage.waitForPageHeader
      ALF_LookupAddressEditPage.clickContinueButton()

      And("User clicks continue on ALF Lookup Address Confirm Page")
      ALF_LookupAddressConfirmPage.waitForPageHeader
      ALF_LookupAddressConfirmPage.clickContinueButton()

      Then("User is presented with the C285 Single Check Answers Accept Send Page v2")
      C285_Single_CheckAnswersAcceptSendPagev2.waitForPageHeader
      C285_Single_CheckAnswersAcceptSendPagev2.checkURL
      C285_Single_CheckAnswersAcceptSendPagev2.checkPageHeader()
      C285_Single_CheckAnswersAcceptSendPagev2.checkPageTitle()

      And("User should see the following details")
      val expectedData = Map(
        "Reason for claim"          -> "End use relief",
        "Personal details"          -> "Mr John Smith,someemail@mail.com,01234567890",
        "Uploaded files"            -> "Commercial invoice:,document.pdf",
        "Address"                   -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Bank details"              -> "Mr John Smith,123456,11001001",
        "Payee"                     -> "Importer",
        "Additional claim information" -> "under 500 characters",
        "What do you want to claim?" -> "A80 - Definitive Anti-Dumping Duty,A95 - Provisional Countervailing Duty,A90 - Definitive Countervailing Duty,A85 - Provisional Anti-Dumping Duty",
        "A80 - Definitive Anti-Dumping Duty"      -> "£10.00",
        "A85 - Provisional Anti-Dumping Duty"     -> "£10.00",
        "A90 - Definitive Countervailing Duty"    -> "£10.00",
        "A95 - Provisional Countervailing Duty"   -> "£10.00",
        "Total"                     -> "£40.00",
        "Method"                    -> "Bank account transfer",
        "Movement Reference Number (MRN)" -> "60AAAAAAAAAAAAAAA5"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Single_CheckAnswersAcceptSendPagev2.pageData should be(expectedData)
      When("User clicks continue on C285 Single Check Answers Accept Send Page v2")
      C285_Single_CheckAnswersAcceptSendPagev2.waitForPageHeader
      C285_Single_CheckAnswersAcceptSendPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Claim Submitted Page v2")
      C285_Single_ClaimSubmittedPagev2.waitForPageHeader
      C285_Single_ClaimSubmittedPagev2.checkURL
      C285_Single_ClaimSubmittedPagev2.checkPageHeader()
      C285_Single_ClaimSubmittedPagev2.checkPageTitle()
    }

    Scenario("happy path with new payee type page - user selects CMA") {

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

      When("User selects radio button c285 on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickRadioButton("c285")

      And("User clicks continue on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickContinueButton()

      Then("User is presented with the C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.checkURL
      C285_ChooseHowManyMrnsPagev2.checkPageHeader()
      C285_ChooseHowManyMrnsPagev2.checkPageTitle()

      When("User selects radio button individual on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickRadioButton("individual")

      And("User clicks continue on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickContinueButton()

      Then("User is presented with the C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.checkURL
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()

      When("User clicks continue on C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.clickContinue()

      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 60AAAAAAAAAAAAAAA5 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("60AAAAAAAAAAAAAAA5")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.checkURL
      C285_Single_ChooseBasisForClaimPagev2.checkPageHeader()
      C285_Single_ChooseBasisForClaimPagev2.checkPageTitle()

      When("User selects radio button Duplicate Movement Reference Number (MRN) on C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.clickRadioButton("Duplicate Movement Reference Number (MRN)")

      And("User clicks continue on C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Duplicate Movement Reference Number Page v2")
      C285_Single_EnterDuplicateMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterDuplicateMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterDuplicateMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterDuplicateMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 20AAAAAAAAAAAAAAA1 on C285 Single Enter Duplicate Movement Reference Number Page v2")
      C285_Single_EnterDuplicateMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterDuplicateMovementReferenceNumberPagev2.enterDetails("20AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Single Enter Duplicate Movement Reference Number Page v2")
      C285_Single_EnterDuplicateMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterDuplicateMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Duplicate Declaration Details Page v2")
      C285_Single_CheckDuplicateDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDuplicateDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDuplicateDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDuplicateDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Single Check Duplicate Declaration Details Page v2")
      C285_Single_CheckDuplicateDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDuplicateDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Additional Details Page v2")
      C285_Single_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Single_EnterAdditionalDetailsPagev2.checkURL
      C285_Single_EnterAdditionalDetailsPagev2.checkPageHeader()
      C285_Single_EnterAdditionalDetailsPagev2.checkPageTitle()

      When("User enters under 500 characters on C285 Single Enter Additional Details Page v2")
      C285_Single_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Single_EnterAdditionalDetailsPagev2.enterDetails("under 500 characters")

      And("User clicks continue on C285 Single Enter Additional Details Page v2")
      C285_Single_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Single_EnterAdditionalDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Select Duties Page v2")
      C285_Single_SelectDutiesPagev2.waitForPageHeader
      C285_Single_SelectDutiesPagev2.checkURL
      C285_Single_SelectDutiesPagev2.checkPageHeader()
      C285_Single_SelectDutiesPagev2.checkPageTitle()

      When("User selects A95,A90,A85 on C285 Single Select Duties Page v2")
      C285_Single_SelectDutiesPagev2.waitForPageHeader
      C285_Single_SelectDutiesPagev2.selectBoxes("A95,A90,A85".split(","))

      And("User clicks continue on C285 Single Select Duties Page v2")
      C285_Single_SelectDutiesPagev2.waitForPageHeader
      C285_Single_SelectDutiesPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Claim Page v2 - A95 - Provisional Countervailing Duty")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.checkURL
      C285_Single_EnterClaimPagev2.checkPageTitle("A95 - Provisional Countervailing Duty")

      When("User enters 10 on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.enterDetails("10")

      And("User clicks continue on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Claim Page v2 - A90 - Definitive Countervailing Duty")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.checkURL
      C285_Single_EnterClaimPagev2.checkPageTitle("A90 - Definitive Countervailing Duty")

      When("User enters 10 on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.enterDetails("10")

      And("User clicks continue on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Claim Page v2 - A85 - Provisional Anti-Dumping Duty")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.checkURL
      C285_Single_EnterClaimPagev2.checkPageTitle("A85 - Provisional Anti-Dumping Duty")

      When("User enters 10 on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.enterDetails("10")

      And("User clicks continue on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Claim Page v2")
      C285_Single_CheckClaimPagev2.waitForPageHeader
      C285_Single_CheckClaimPagev2.checkURL
      C285_Single_CheckClaimPagev2.checkPageHeader()
      C285_Single_CheckClaimPagev2.checkPageTitle()

      When("User clicks continue on C285 Single Check Claim Page v2")
      C285_Single_CheckClaimPagev2.waitForPageHeader
      C285_Single_CheckClaimPagev2.clickContinue()

      Then("User is presented with the C285 Single Choose Payee Type v2")
      C285_Single_ChoosePayeeTypev2.waitForPageHeader
      C285_Single_ChoosePayeeTypev2.checkURL
      C285_Single_ChoosePayeeTypev2.checkPageHeader()
      C285_Single_ChoosePayeeTypev2.checkPageTitle()

      And("User selects radio button Importer on C285 Single Choose Payee Type v2")
      C285_Single_ChoosePayeeTypev2.waitForPageHeader
      C285_Single_ChoosePayeeTypev2.clickRadioButton("Importer")

      When("User clicks continue on C285 Single Choose Payee Type v2")
      C285_Single_ChoosePayeeTypev2.waitForPageHeader
      C285_Single_ChoosePayeeTypev2.clickContinueButton()

      Then("User is presented with the C285 Single Select Reimbursement Method Page v2")
      C285_Single_SelectReimbursementMethodPagev2.waitForPageHeader
      C285_Single_SelectReimbursementMethodPagev2.checkURL
      C285_Single_SelectReimbursementMethodPagev2.checkPageHeader()
      C285_Single_SelectReimbursementMethodPagev2.checkPageTitle()

      When("User selects radio button Current Month Adjustment (CMA) on C285 Single Select Reimbursement Method Page v2")
      C285_Single_SelectReimbursementMethodPagev2.waitForPageHeader
      C285_Single_SelectReimbursementMethodPagev2.clickRadioButton("Current Month Adjustment (CMA)")

      And("User clicks continue on C285 Single Select Reimbursement Method Page v2")
      C285_Single_SelectReimbursementMethodPagev2.waitForPageHeader
      C285_Single_SelectReimbursementMethodPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Bank Account Details Page v2")
      C285_Single_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Single_EnterBankAccountDetailsPagev2.checkURL
      C285_Single_EnterBankAccountDetailsPagev2.checkPageHeader()
      C285_Single_EnterBankAccountDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Single Enter Bank Account Details Page v2")
      C285_Single_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Single_EnterBankAccountDetailsPagev2.enterDetails("")

      When("User clicks continue on C285 Single Enter Bank Account Details Page v2")
      C285_Single_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Single_EnterBankAccountDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()

      When("User selects radio button Commercial invoice on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Commercial invoice")

      And("User clicks continue on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

      Then("User is presented with the UCDF Choose File Other Page - Commercial invoice")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("Commercial invoice")

      When("User uploads a 1 document.pdf file on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.uploadDocument(1, "document.pdf")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()

      And("User selects radio button No on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("No")

      And("User clicks continue if I'm on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.clickContinueButton()
      UCDF_ChooseFileOtherPage.continuouslyClickContinue()

      Then("User is presented with the C285 Single Claimant Details Change Claimant Details Page v2")
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.checkURL
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageHeader()
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Single Claimant Details Change Claimant Details Page v2")
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.enterDetails("")

      And("User clicks continue on C285 Single Claimant Details Change Claimant Details Page v2")
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.clickContinueButton()

      And("User clicks Enter the address manually on ALF Lookup Address Lookup Page")
      ALF_LookupAddressLookupPage.waitForPageHeader
      ALF_LookupAddressLookupPage.clickButton("Enter the address manually")

      And("User enters empty string on ALF Lookup Address Edit Page")
      ALF_LookupAddressEditPage.waitForPageHeader
      ALF_LookupAddressEditPage.enterDetails("")

      And("User clicks continue on ALF Lookup Address Edit Page")
      ALF_LookupAddressEditPage.waitForPageHeader
      ALF_LookupAddressEditPage.clickContinueButton()

      And("User clicks continue on ALF Lookup Address Confirm Page")
      ALF_LookupAddressConfirmPage.waitForPageHeader
      ALF_LookupAddressConfirmPage.clickContinueButton()

      Then("User is presented with the C285 Single Check Answers Accept Send Page v2")
      C285_Single_CheckAnswersAcceptSendPagev2.waitForPageHeader
      C285_Single_CheckAnswersAcceptSendPagev2.checkURL
      C285_Single_CheckAnswersAcceptSendPagev2.checkPageHeader()
      C285_Single_CheckAnswersAcceptSendPagev2.checkPageTitle()

      And("User should see the following details")
      val expectedData = Map(
        "Reason for claim"          -> "Duplicate Movement Reference Number (MRN)",
        "Personal details"          -> "Mr John Smith,someemail@mail.com,01234567890",
        "Bank details"              -> "Mr John Smith,123456,11001001",
        "Uploaded files"            -> "Commercial invoice:,document.pdf",
        "Address"                   -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Duplicate MRN"             -> "20AAAAAAAAAAAAAAA1",
        "Payee"                     -> "Importer",
        "Additional claim information" -> "under 500 characters",
        "What do you want to claim?" -> "A95 - Provisional Countervailing Duty,A90 - Definitive Countervailing Duty,A85 - Provisional Anti-Dumping Duty",
        "A85 - Provisional Anti-Dumping Duty"  -> "£10.00",
        "A90 - Definitive Countervailing Duty" -> "£10.00",
        "A95 - Provisional Countervailing Duty" -> "£10.00",
        "Total"                     -> "£30.00",
        "Movement Reference Number (MRN)" -> "60AAAAAAAAAAAAAAA5",
        "Method"                    -> "Current Month Adjustment (CMA)"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Single_CheckAnswersAcceptSendPagev2.pageData should be(expectedData)
      When("User clicks continue on C285 Single Check Answers Accept Send Page v2")
      C285_Single_CheckAnswersAcceptSendPagev2.waitForPageHeader
      C285_Single_CheckAnswersAcceptSendPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Claim Submitted Page v2")
      C285_Single_ClaimSubmittedPagev2.waitForPageHeader
      C285_Single_ClaimSubmittedPagev2.checkURL
      C285_Single_ClaimSubmittedPagev2.checkPageHeader()
      C285_Single_ClaimSubmittedPagev2.checkPageTitle()
    }

    Scenario("happy path with no bank details (user is both importer and declarant) - CMA not eligible - choose Bank account transfer") {

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

      When("User selects radio button c285 on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickRadioButton("c285")

      And("User clicks continue on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickContinueButton()

      Then("User is presented with the C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.checkURL
      C285_ChooseHowManyMrnsPagev2.checkPageHeader()
      C285_ChooseHowManyMrnsPagev2.checkPageTitle()

      When("User selects radio button individual on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickRadioButton("individual")

      And("User clicks continue on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickContinueButton()

      Then("User is presented with the C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.checkURL
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()

      When("User clicks continue on C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.clickContinue()

      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 60AAAAAAAAAAAAAAA1 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("60AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.checkURL
      C285_Single_ChooseBasisForClaimPagev2.checkPageHeader()
      C285_Single_ChooseBasisForClaimPagev2.checkPageTitle()

      When("User selects radio button End use relief on C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.clickRadioButton("End use relief")

      And("User clicks continue on C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Additional Details Page v2")
      C285_Single_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Single_EnterAdditionalDetailsPagev2.checkURL
      C285_Single_EnterAdditionalDetailsPagev2.checkPageHeader()
      C285_Single_EnterAdditionalDetailsPagev2.checkPageTitle()

      When("User enters under 500 characters on C285 Single Enter Additional Details Page v2")
      C285_Single_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Single_EnterAdditionalDetailsPagev2.enterDetails("under 500 characters")

      And("User clicks continue on C285 Single Enter Additional Details Page v2")
      C285_Single_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Single_EnterAdditionalDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Select Duties Page v2")
      C285_Single_SelectDutiesPagev2.waitForPageHeader
      C285_Single_SelectDutiesPagev2.checkURL
      C285_Single_SelectDutiesPagev2.checkPageHeader()
      C285_Single_SelectDutiesPagev2.checkPageTitle()

      When("User selects A80 on C285 Single Select Duties Page v2")
      C285_Single_SelectDutiesPagev2.waitForPageHeader
      C285_Single_SelectDutiesPagev2.selectBoxes("A80".split(","))

      And("User clicks continue on C285 Single Select Duties Page v2")
      C285_Single_SelectDutiesPagev2.waitForPageHeader
      C285_Single_SelectDutiesPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Claim Page v2 - A80 - Definitive Anti-Dumping Duty")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.checkURL
      C285_Single_EnterClaimPagev2.checkPageTitle("A80 - Definitive Anti-Dumping Duty")

      When("User enters 10 on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.enterDetails("10")

      And("User clicks continue on C285 Single Enter Claim Page v2")
      C285_Single_EnterClaimPagev2.waitForPageHeader
      C285_Single_EnterClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Claim Page v2")
      C285_Single_CheckClaimPagev2.waitForPageHeader
      C285_Single_CheckClaimPagev2.checkURL
      C285_Single_CheckClaimPagev2.checkPageHeader()
      C285_Single_CheckClaimPagev2.checkPageTitle()

      When("User clicks continue on C285 Single Check Claim Page v2")
      C285_Single_CheckClaimPagev2.waitForPageHeader
      C285_Single_CheckClaimPagev2.clickContinue()

      Then("User is presented with the C285 Single Choose Payee Type v2")
      C285_Single_ChoosePayeeTypev2.waitForPageHeader
      C285_Single_ChoosePayeeTypev2.checkURL
      C285_Single_ChoosePayeeTypev2.checkPageHeader()
      C285_Single_ChoosePayeeTypev2.checkPageTitle()

      And("User selects radio button Importer on C285 Single Choose Payee Type v2")
      C285_Single_ChoosePayeeTypev2.waitForPageHeader
      C285_Single_ChoosePayeeTypev2.clickRadioButton("Importer")

      When("User clicks continue on C285 Single Choose Payee Type v2")
      C285_Single_ChoosePayeeTypev2.waitForPageHeader
      C285_Single_ChoosePayeeTypev2.clickContinueButton()

      Then("User is presented with the C285 Single Enter Bank Account Details Page v2")
      C285_Single_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Single_EnterBankAccountDetailsPagev2.checkURL
      C285_Single_EnterBankAccountDetailsPagev2.checkPageHeader()
      C285_Single_EnterBankAccountDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Single Enter Bank Account Details Page v2")
      C285_Single_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Single_EnterBankAccountDetailsPagev2.enterDetails("")

      When("User clicks continue on C285 Single Enter Bank Account Details Page v2")
      C285_Single_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Single_EnterBankAccountDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()

      When("User selects radio button Commercial invoice on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Commercial invoice")

      And("User clicks continue on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

      Then("User is presented with the UCDF Choose File Other Page - Commercial invoice")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("Commercial invoice")

      When("User uploads a 1 document.pdf file on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.uploadDocument(1, "document.pdf")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()

      And("User selects radio button No on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("No")

      And("User clicks continue if I'm on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.clickContinueButton()
      UCDF_ChooseFileOtherPage.continuouslyClickContinue()

      Then("User is presented with the C285 Single Claimant Details Change Claimant Details Page v2")
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.checkURL
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageHeader()
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Single Claimant Details Change Claimant Details Page v2")
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.enterDetails("")

      And("User clicks continue on C285 Single Claimant Details Change Claimant Details Page v2")
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Single_ClaimantDetailsChangeClaimantDetailsPagev2.clickContinueButton()

      And("User clicks Enter the address manually on ALF Lookup Address Lookup Page")
      ALF_LookupAddressLookupPage.waitForPageHeader
      ALF_LookupAddressLookupPage.clickButton("Enter the address manually")

      And("User enters empty string on ALF Lookup Address Edit Page")
      ALF_LookupAddressEditPage.waitForPageHeader
      ALF_LookupAddressEditPage.enterDetails("")

      And("User clicks continue on ALF Lookup Address Edit Page")
      ALF_LookupAddressEditPage.waitForPageHeader
      ALF_LookupAddressEditPage.clickContinueButton()

      And("User clicks continue on ALF Lookup Address Confirm Page")
      ALF_LookupAddressConfirmPage.waitForPageHeader
      ALF_LookupAddressConfirmPage.clickContinueButton()

      Then("User is presented with the C285 Single Check Answers Accept Send Page v2")
      C285_Single_CheckAnswersAcceptSendPagev2.waitForPageHeader
      C285_Single_CheckAnswersAcceptSendPagev2.checkURL
      C285_Single_CheckAnswersAcceptSendPagev2.checkPageHeader()
      C285_Single_CheckAnswersAcceptSendPagev2.checkPageTitle()

      And("User should see the following details")
      val expectedData = Map(
        "Reason for claim"          -> "End use relief",
        "Personal details"          -> "Mr John Smith,someemail@mail.com,01234567890",
        "Uploaded files"            -> "Commercial invoice:,document.pdf",
        "Address"                   -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Bank details"              -> "Mr John Smith,123456,11001001",
        "Payee"                     -> "Importer",
        "Additional claim information" -> "under 500 characters",
        "What do you want to claim?" -> "A80 - Definitive Anti-Dumping Duty",
        "A80 - Definitive Anti-Dumping Duty" -> "£10.00",
        "Total"                     -> "£10.00",
        "Method"                    -> "Bank account transfer",
        "Movement Reference Number (MRN)" -> "60AAAAAAAAAAAAAAA1"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Single_CheckAnswersAcceptSendPagev2.pageData should be(expectedData)
      When("User clicks continue on C285 Single Check Answers Accept Send Page v2")
      C285_Single_CheckAnswersAcceptSendPagev2.waitForPageHeader
      C285_Single_CheckAnswersAcceptSendPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Claim Submitted Page v2")
      C285_Single_ClaimSubmittedPagev2.waitForPageHeader
      C285_Single_ClaimSubmittedPagev2.checkURL
      C285_Single_ClaimSubmittedPagev2.checkPageHeader()
      C285_Single_ClaimSubmittedPagev2.checkPageTitle()
    }

    Scenario("happy path - Method of payment displays specified value in declaration details page") {

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

      When("User selects radio button c285 on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickRadioButton("c285")

      And("User clicks continue on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickContinueButton()

      Then("User is presented with the C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.checkURL
      C285_ChooseHowManyMrnsPagev2.checkPageHeader()
      C285_ChooseHowManyMrnsPagev2.checkPageTitle()

      When("User selects radio button individual on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickRadioButton("individual")

      And("User clicks continue on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickContinueButton()

      Then("User is presented with the C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.checkURL
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()

      When("User clicks continue on C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.clickContinue()

      // MRN 00AA001AAAAAAAAA01 - Immediate payment
      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 00AA001AAAAAAAAA01 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("00AA001AAAAAAAAA01")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User should see the following details on C285 Single Check Declaration Details Page v2")
      val expectedData1 = Map(
        "MRN"                                  -> "00AA001AAAAAAAAA01",
        "Date of import"                       -> "12 February 2021",
        "Method of payment"                    -> "Immediate payment",
        "Total"                                -> "£828.00",
        "Email"                                -> "automation@gmail.com",
        "Name"                                 -> "Foxpro Central LTD",
        "Address"                              -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "A85 - Provisional Anti-Dumping Duty"  -> "£171.00",
        "A80 - Definitive Anti-Dumping Duty"   -> "£218.00",
        "A95 - Provisional Countervailing Duty" -> "£211.00",
        "A90 - Definitive Countervailing Duty" -> "£228.00"
      )
      expectedData1.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Single_CheckDeclarationDetailsPagev2.pageData should be(expectedData1)
      Then("User goes back on C285 Single Check Declaration Details Page v2")
      driver.navigate().back()

      // MRN 00AA002AAAAAAAAA01 - Deferment account
      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 00AA002AAAAAAAAA01 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("00AA002AAAAAAAAA01")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User should see the following details on C285 Single Check Declaration Details Page v2")
      val expectedData2 = Map(
        "MRN"                                  -> "00AA002AAAAAAAAA01",
        "Date of import"                       -> "12 February 2021",
        "Method of payment"                    -> "Deferment account",
        "Total"                                -> "£828.00",
        "Email"                                -> "automation@gmail.com",
        "Name"                                 -> "Foxpro Central LTD",
        "Address"                              -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "A85 - Provisional Anti-Dumping Duty"  -> "£171.00",
        "A80 - Definitive Anti-Dumping Duty"   -> "£218.00",
        "A95 - Provisional Countervailing Duty" -> "£211.00",
        "A90 - Definitive Countervailing Duty" -> "£228.00"
      )
      expectedData2.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Single_CheckDeclarationDetailsPagev2.pageData should be(expectedData2)
      Then("User goes back on C285 Single Check Declaration Details Page v2")
      driver.navigate().back()

      // MRN 00AA003AAAAAAAAA01 - Cash account
      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 00AA003AAAAAAAAA01 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("00AA003AAAAAAAAA01")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User should see the following details on C285 Single Check Declaration Details Page v2")
      val expectedData3 = Map(
        "MRN"                                  -> "00AA003AAAAAAAAA01",
        "Date of import"                       -> "12 February 2021",
        "Method of payment"                    -> "Cash account",
        "Total"                                -> "£828.00",
        "Email"                                -> "automation@gmail.com",
        "Name"                                 -> "Foxpro Central LTD",
        "Address"                              -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "A85 - Provisional Anti-Dumping Duty"  -> "£171.00",
        "A80 - Definitive Anti-Dumping Duty"   -> "£218.00",
        "A95 - Provisional Countervailing Duty" -> "£211.00",
        "A90 - Definitive Countervailing Duty" -> "£228.00"
      )
      expectedData3.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Single_CheckDeclarationDetailsPagev2.pageData should be(expectedData3)
      Then("User goes back on C285 Single Check Declaration Details Page v2")
      driver.navigate().back()

      // MRN 00AA001002AAAAAA01 - Immediate payment and Deferment account
      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 00AA001002AAAAAA01 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("00AA001002AAAAAA01")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User should see the following details on C285 Single Check Declaration Details Page v2")
      val expectedData4 = Map(
        "MRN"                                  -> "00AA001002AAAAAA01",
        "Date of import"                       -> "12 February 2021",
        "Method of payment"                    -> "Immediate payment and Deferment account",
        "Total"                                -> "£828.00",
        "Email"                                -> "automation@gmail.com",
        "Name"                                 -> "Foxpro Central LTD",
        "Address"                              -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "A85 - Provisional Anti-Dumping Duty"  -> "£171.00",
        "A80 - Definitive Anti-Dumping Duty"   -> "£218.00",
        "A95 - Provisional Countervailing Duty" -> "£211.00",
        "A90 - Definitive Countervailing Duty" -> "£228.00"
      )
      expectedData4.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Single_CheckDeclarationDetailsPagev2.pageData should be(expectedData4)
      Then("User goes back on C285 Single Check Declaration Details Page v2")
      driver.navigate().back()

      // MRN 00AA001003AAAAAA01 - Immediate payment and Cash account
      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 00AA001003AAAAAA01 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("00AA001003AAAAAA01")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User should see the following details on C285 Single Check Declaration Details Page v2")
      val expectedData5 = Map(
        "MRN"                                  -> "00AA001003AAAAAA01",
        "Date of import"                       -> "12 February 2021",
        "Method of payment"                    -> "Immediate payment and Cash account",
        "Total"                                -> "£828.00",
        "Email"                                -> "automation@gmail.com",
        "Name"                                 -> "Foxpro Central LTD",
        "Address"                              -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "A85 - Provisional Anti-Dumping Duty"  -> "£171.00",
        "A80 - Definitive Anti-Dumping Duty"   -> "£218.00",
        "A95 - Provisional Countervailing Duty" -> "£211.00",
        "A90 - Definitive Countervailing Duty" -> "£228.00"
      )
      expectedData5.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Single_CheckDeclarationDetailsPagev2.pageData should be(expectedData5)
      Then("User goes back on C285 Single Check Declaration Details Page v2")
      driver.navigate().back()

      // MRN 00AA002003AAAAAA01 - Deferment account and Cash account
      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 00AA002003AAAAAA01 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("00AA002003AAAAAA01")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User should see the following details on C285 Single Check Declaration Details Page v2")
      val expectedData6 = Map(
        "MRN"                                  -> "00AA002003AAAAAA01",
        "Date of import"                       -> "12 February 2021",
        "Method of payment"                    -> "Deferment account and Cash account",
        "Total"                                -> "£828.00",
        "Email"                                -> "automation@gmail.com",
        "Name"                                 -> "Foxpro Central LTD",
        "Address"                              -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "A85 - Provisional Anti-Dumping Duty"  -> "£171.00",
        "A80 - Definitive Anti-Dumping Duty"   -> "£218.00",
        "A95 - Provisional Countervailing Duty" -> "£211.00",
        "A90 - Definitive Countervailing Duty" -> "£228.00"
      )
      expectedData6.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Single_CheckDeclarationDetailsPagev2.pageData should be(expectedData6)
      Then("User goes back on C285 Single Check Declaration Details Page v2")
      driver.navigate().back()

      // MRN 00AA006AAAAAAAAA01 - Subsidy waiver page
      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 00AA006AAAAAAAAA01 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("00AA006AAAAAAAAA01")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Subsidy Waiver Pagev2")
      C285_Single_SubsidyWaiverPagev2.waitForPageHeader
      C285_Single_SubsidyWaiverPagev2.checkURL
      C285_Single_SubsidyWaiverPagev2.checkPageHeader()
      C285_Single_SubsidyWaiverPagev2.checkPageTitle()
    }

    Scenario("Error page when the MRN contains only new tax type codes") {

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

      When("User selects radio button c285 on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickRadioButton("c285")

      And("User clicks continue on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickContinueButton()

      Then("User is presented with the C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.checkURL
      C285_ChooseHowManyMrnsPagev2.checkPageHeader()
      C285_ChooseHowManyMrnsPagev2.checkPageTitle()

      When("User selects radio button individual on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickRadioButton("individual")

      And("User clicks continue on C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickContinueButton()

      Then("User is presented with the C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.checkURL
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
      C285_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()

      When("User clicks continue on C285 Have Your Supporting Document Ready Page v2")
      C285_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_HaveYourSupportingDocumentReadyPagev2.clickContinue()

      Then("User is presented with the C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.checkURL
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Single_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 10AAAAAAAAAAAAA301 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("10AAAAAAAAAAAAA301")

      And("User clicks continue on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Check Declaration Details Page v2")
      C285_Single_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Single_CheckDeclarationDetailsPagev2.checkURL
      C285_Single_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Single_CheckDeclarationDetailsPagev2.checkPageTitle()
    }
  }
}
