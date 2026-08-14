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

class SingleFileUploadV2Spec extends BaseSpec {

  Feature("C285 Single file upload V2") {

    Scenario("happy path - upload 3 files") {

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

      When("User enters 10AAAAAAAAAAAAAAA1 on C285 Single Enter Movement Reference Number Page v2")
      C285_Single_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Single_EnterMovementReferenceNumberPagev2.enterDetails("10AAAAAAAAAAAAAAA1")

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

      When("User selects radio button Duty suspension on C285 Single Choose Basis For Claim Page v2")
      C285_Single_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Single_ChooseBasisForClaimPagev2.clickRadioButton("Duty suspension")

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

      // upload file 1
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

      Then("User is presented with the UCDF Choose File Other Page - commercial invoice")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("commercial invoice")

      When("User uploads a 1 image.jpg file on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.uploadDocument(1, "image.jpg")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()

      And("User selects radio button Yes on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("Yes")

      And("User clicks continue if I'm on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.clickContinueButton()
      UCDF_ChooseFileOtherPage.continuouslyClickContinue()

      // upload file 2
      Then("User is presented with the C285 Single Supporting Evidence Select Supporting Evidence Type Page v2 again")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()

      When("User selects radio button Bill of lading on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Bill of lading")

      And("User clicks continue on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

      Then("User is presented with the UCDF Choose File Other Page - bill of landing")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("bill of landing")

      When("User uploads a 2 document.pdf file on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.uploadDocument(2, "document.pdf")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()

      And("User selects radio button Yes on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("Yes")

      And("User clicks continue if I'm on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.clickContinueButton()
      UCDF_ChooseFileOtherPage.continuouslyClickContinue()

      // upload file 3
      Then("User is presented with the C285 Single Supporting Evidence Select Supporting Evidence Type Page v2 again for file 3")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()

      When("User selects radio button Packing list on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Packing list")

      And("User clicks continue on C285 Single Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Single_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

      Then("User is presented with the UCDF Choose File Other Page - packing list")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("packing list")

      When("User uploads a 3 image.png file on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.uploadDocument(3, "image.png")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()

      And("User selects radio button No on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("No")

      And("User clicks continue if I'm on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.clickContinueButton()
      UCDF_ChooseFileOtherPage.continuouslyClickContinue()

      // continue journey
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

      When("User clicks continue on C285 Single Check Answers Accept Send Page v2")
      C285_Single_CheckAnswersAcceptSendPagev2.waitForPageHeader
      C285_Single_CheckAnswersAcceptSendPagev2.clickContinueButton()

      Then("User is presented with the C285 Single Claim Submitted Page v2")
      C285_Single_ClaimSubmittedPagev2.waitForPageHeader
      C285_Single_ClaimSubmittedPagev2.checkURL
      C285_Single_ClaimSubmittedPagev2.checkPageHeader()
      C285_Single_ClaimSubmittedPagev2.checkPageTitle()
    }
  }
}
