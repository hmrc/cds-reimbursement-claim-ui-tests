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

package uk.gov.hmrc.cdsrc.specs.C285.multiple_V2

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.C285.multiple_V2._
import uk.gov.hmrc.cdsrc.pages.C285.single_v2.C285_ChooseHowManyMrnsPagev2
import uk.gov.hmrc.cdsrc.pages.auth.AuthLoginStubPage
import uk.gov.hmrc.cdsrc.pages.common.{CheckEoriDetailsPage, SelectClaimTypePage}
import uk.gov.hmrc.cdsrc.pages.common.ALF.{ALF_LookupAddressConfirmPage, ALF_LookupAddressEditPage, ALF_LookupAddressLookupPage}
import uk.gov.hmrc.cdsrc.pages.common.UDF.UCDF_ChooseFileOtherPage
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class MultipleV2Spec extends BaseSpec {

  private def loginAndNavigateToMultiple(): Unit = {
    go to AuthLoginStubPage
    AuthLoginStubPage.enterRedirectURL(TestConfiguration.url("cds-frontend") + "/start")
    AuthLoginStubPage.enrolments("HMRC-CUS-ORG", "EORINumber", "GB000000000000001")
    AuthLoginStubPage.waitForPageHeader
    AuthLoginStubPage.clickContinueButton()

    CheckEoriDetailsPage.waitForPageHeader
    CheckEoriDetailsPage.checkURL
    CheckEoriDetailsPage.checkPageHeader()
    CheckEoriDetailsPage.checkPageTitle()
    CheckEoriDetailsPage.waitForPageHeader
    CheckEoriDetailsPage.clickRadioButton("yes")
    CheckEoriDetailsPage.waitForPageHeader
    CheckEoriDetailsPage.clickContinueButton()

    SelectClaimTypePage.waitForPageHeader
    SelectClaimTypePage.checkURL
    SelectClaimTypePage.checkPageHeader()
    SelectClaimTypePage.checkPageTitle()
    SelectClaimTypePage.waitForPageHeader
    SelectClaimTypePage.clickRadioButton("c285")
    SelectClaimTypePage.waitForPageHeader
    SelectClaimTypePage.clickContinueButton()

    C285_ChooseHowManyMrnsPagev2.waitForPageHeader
    C285_ChooseHowManyMrnsPagev2.checkURL
    C285_ChooseHowManyMrnsPagev2.checkPageHeader()
    C285_ChooseHowManyMrnsPagev2.checkPageTitle()
    C285_ChooseHowManyMrnsPagev2.waitForPageHeader
    C285_ChooseHowManyMrnsPagev2.clickRadioButton("bulk")
    C285_ChooseHowManyMrnsPagev2.waitForPageHeader
    C285_ChooseHowManyMrnsPagev2.clickContinueButton()

    C285_Multiple_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
    C285_Multiple_HaveYourSupportingDocumentReadyPagev2.checkURL
    C285_Multiple_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
    C285_Multiple_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()
    C285_Multiple_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
    C285_Multiple_HaveYourSupportingDocumentReadyPagev2.clickContinue()
  }

  private def performBasisAndAdditionalDetails(): Unit = {
    C285_Multiple_ChooseBasisForClaimPagev2.waitForPageHeader
    C285_Multiple_ChooseBasisForClaimPagev2.checkURL
    C285_Multiple_ChooseBasisForClaimPagev2.checkPageHeader()
    C285_Multiple_ChooseBasisForClaimPagev2.checkPageTitle()
    C285_Multiple_ChooseBasisForClaimPagev2.waitForPageHeader
    C285_Multiple_ChooseBasisForClaimPagev2.clickRadioButton("Outward processing relief")
    C285_Multiple_ChooseBasisForClaimPagev2.waitForPageHeader
    C285_Multiple_ChooseBasisForClaimPagev2.clickContinueButton()

    C285_Multiple_EnterAdditionalDetailsPagev2.waitForPageHeader
    C285_Multiple_EnterAdditionalDetailsPagev2.checkURL
    C285_Multiple_EnterAdditionalDetailsPagev2.checkPageHeader()
    C285_Multiple_EnterAdditionalDetailsPagev2.checkPageTitle()
    C285_Multiple_EnterAdditionalDetailsPagev2.waitForPageHeader
    C285_Multiple_EnterAdditionalDetailsPagev2.enterDetails("under 500 characters")
    C285_Multiple_EnterAdditionalDetailsPagev2.waitForPageHeader
    C285_Multiple_EnterAdditionalDetailsPagev2.clickContinueButton()
  }

  private def performStandardDuties12(): Unit = {
    C285_Multiple_SelectDuties1Pagev2.waitForPageHeader
    C285_Multiple_SelectDuties1Pagev2.checkURL
    C285_Multiple_SelectDuties1Pagev2.checkPageHeader()
    C285_Multiple_SelectDuties1Pagev2.checkPageTitle()
    C285_Multiple_SelectDuties1Pagev2.waitForPageHeader
    C285_Multiple_SelectDuties1Pagev2.selectBoxes("A80,A95".split(","))
    C285_Multiple_SelectDuties1Pagev2.waitForPageHeader
    C285_Multiple_SelectDuties1Pagev2.clickContinueButton()

    C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties1DutyPagev2.checkPageTitle("A80 - Definitive Anti-Dumping Duty")
    C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties1DutyPagev2.enterDetails("10")
    C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties1DutyPagev2.clickContinueButton()

    C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties1DutyPagev2.checkPageTitle("A95 - Provisional Countervailing Duty")
    C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties1DutyPagev2.enterDetails("10")
    C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties1DutyPagev2.clickContinueButton()

    C285_Multiple_SelectDuties2Pagev2.waitForPageHeader
    C285_Multiple_SelectDuties2Pagev2.checkURL
    C285_Multiple_SelectDuties2Pagev2.checkPageHeader()
    C285_Multiple_SelectDuties2Pagev2.checkPageTitle()
    C285_Multiple_SelectDuties2Pagev2.waitForPageHeader
    C285_Multiple_SelectDuties2Pagev2.selectBoxes("A90,A85".split(","))
    C285_Multiple_SelectDuties2Pagev2.waitForPageHeader
    C285_Multiple_SelectDuties2Pagev2.clickContinueButton()

    C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties2DutyPagev2.checkPageTitle("A90 - Definitive Countervailing Duty")
    C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties2DutyPagev2.enterDetails("10")
    C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties2DutyPagev2.clickContinueButton()

    C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties2DutyPagev2.checkPageTitle("A85 - Provisional Anti-Dumping Duty")
    C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties2DutyPagev2.enterDetails("10")
    C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
    C285_Multiple_SelectDuties2DutyPagev2.clickContinueButton()
  }

  private def performCheckClaimPage(): Unit = {
    C285_Multiple_CheckClaimPagev2.waitForPageHeader
    C285_Multiple_CheckClaimPagev2.checkURL
    C285_Multiple_CheckClaimPagev2.checkPageHeader()
    C285_Multiple_CheckClaimPagev2.checkPageTitle()
    C285_Multiple_CheckClaimPagev2.waitForPageHeader
    C285_Multiple_CheckClaimPagev2.clickContinue()
  }

  private def performPayeeAndBankDetails(payee: String): Unit = {
    C285_Multiple_ChoosePayeeTypev2.waitForPageHeader
    C285_Multiple_ChoosePayeeTypev2.checkURL
    C285_Multiple_ChoosePayeeTypev2.checkPageHeader()
    C285_Multiple_ChoosePayeeTypev2.checkPageTitle()
    C285_Multiple_ChoosePayeeTypev2.waitForPageHeader
    C285_Multiple_ChoosePayeeTypev2.clickRadioButton(payee)
    C285_Multiple_ChoosePayeeTypev2.waitForPageHeader
    C285_Multiple_ChoosePayeeTypev2.clickContinueButton()

    C285_Multiple_EnterBankAccountDetailsPagev2.waitForPageHeader
    C285_Multiple_EnterBankAccountDetailsPagev2.checkURL
    C285_Multiple_EnterBankAccountDetailsPagev2.checkPageHeader()
    C285_Multiple_EnterBankAccountDetailsPagev2.checkPageTitle()
    C285_Multiple_EnterBankAccountDetailsPagev2.waitForPageHeader
    C285_Multiple_EnterBankAccountDetailsPagev2.enterDetails("")
    C285_Multiple_EnterBankAccountDetailsPagev2.waitForPageHeader
    C285_Multiple_EnterBankAccountDetailsPagev2.clickContinueButton()
  }

  private def uploadAndContactDetails(): Unit = {
    C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
    C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
    C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
    C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()
    C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
    C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Commercial invoice")
    C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
    C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

    UCDF_ChooseFileOtherPage.waitForPageHeader
    UCDF_ChooseFileOtherPage.checkURL
    UCDF_ChooseFileOtherPage.checkPageTitle("Commercial invoice")
    UCDF_ChooseFileOtherPage.uploadDocument(1, "document.pdf")
    UCDF_ChooseFileOtherPage.waitForPageToLoad()
    UCDF_ChooseFileOtherPage.waitForPageHeader
    UCDF_ChooseFileOtherPage.clickRadioButton("No")
    UCDF_ChooseFileOtherPage.clickContinueButton()
    UCDF_ChooseFileOtherPage.continuouslyClickContinue()

    C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.waitForPageHeader
    C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.checkURL
    C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.checkPageHeader()
    C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.checkPageTitle()
    C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.waitForPageHeader
    C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.enterDetails("")
    C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.waitForPageHeader
    C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.clickContinueButton()

    ALF_LookupAddressLookupPage.waitForPageHeader
    ALF_LookupAddressLookupPage.clickButton("Enter the address manually")

    ALF_LookupAddressEditPage.waitForPageHeader
    ALF_LookupAddressEditPage.enterDetails("")
    ALF_LookupAddressEditPage.waitForPageHeader
    ALF_LookupAddressEditPage.clickContinueButton()

    ALF_LookupAddressConfirmPage.waitForPageHeader
    ALF_LookupAddressConfirmPage.clickContinueButton()
  }

  private def checkAnswersAndSubmit(expectedData: Map[String, String]): Unit = {
    C285_Multiple_CheckAnswersAcceptSendPagev2.waitForPageHeader
    C285_Multiple_CheckAnswersAcceptSendPagev2.checkURL
    C285_Multiple_CheckAnswersAcceptSendPagev2.checkPageHeader()
    C285_Multiple_CheckAnswersAcceptSendPagev2.checkPageTitle()
    expectedData.foreach { case (k, v) => info(s"- $k: $v") }
    C285_Multiple_CheckAnswersAcceptSendPagev2.pageData should be(expectedData)    
    C285_Multiple_CheckAnswersAcceptSendPagev2.waitForPageHeader
    C285_Multiple_CheckAnswersAcceptSendPagev2.clickContinueButton()

    C285_Multiple_ClaimSubmittedPagev2.waitForPageHeader
    C285_Multiple_ClaimSubmittedPagev2.checkURL
    C285_Multiple_ClaimSubmittedPagev2.checkPageHeader()
    C285_Multiple_ClaimSubmittedPagev2.checkPageTitle()
  }

  Feature("C285 Multiple V2") {

    Scenario("happy path - check importer/declarant eori pages") {

      Given("User navigates to the Auth Login Stub Page")
      loginAndNavigateToMultiple()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 10AAAAAAAAAAAAAAA2 on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.enterDetails("10AAAAAAAAAAAAAAA2")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Importer Eori Page v2")
      C285_Multiple_EnterImporterEoriPagev2.waitForPageHeader
      C285_Multiple_EnterImporterEoriPagev2.checkURL
      C285_Multiple_EnterImporterEoriPagev2.checkPageHeader()
      C285_Multiple_EnterImporterEoriPagev2.checkPageTitle()

      When("User enters GB000000000000002 on C285 Multiple Enter Importer Eori Page v2")
      C285_Multiple_EnterImporterEoriPagev2.waitForPageHeader
      C285_Multiple_EnterImporterEoriPagev2.enterDetails("GB000000000000002")

      And("User clicks continue on C285 Multiple Enter Importer Eori Page v2")
      C285_Multiple_EnterImporterEoriPagev2.waitForPageHeader
      C285_Multiple_EnterImporterEoriPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Declarant Eori Page v2")
      C285_Multiple_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Multiple_EnterDeclarantEoriPagev2.checkURL
      C285_Multiple_EnterDeclarantEoriPagev2.checkPageHeader()
      C285_Multiple_EnterDeclarantEoriPagev2.checkPageTitle()

      When("User enters GB000000000000002 on C285 Multiple Enter Declarant Eori Page v2")
      C285_Multiple_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Multiple_EnterDeclarantEoriPagev2.enterDetails("GB000000000000002")

      And("User clicks continue on C285 Multiple Enter Declarant Eori Page v2")
      C285_Multiple_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Multiple_EnterDeclarantEoriPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.checkURL
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageTitle()

      When("User enters 20AAAAAAAAAAAAAAA2 on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.enterDetails("20AAAAAAAAAAAAAAA2")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkURL
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageHeader()
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageTitle()

      When("User selects radio button No on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickRadioButton("No")

      And("User clicks continue on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Choose Basis For Claim Page v2")
      performBasisAndAdditionalDetails()

      Then("User is presented with the C285 Multiple Select Duties 1 Page v2")
      performStandardDuties12()

      Then("User is presented with the C285 Multiple Check Claim Page v2")
      performCheckClaimPage()

      Then("User is presented with the C285 Multiple Choose Payee Type v2")
      performPayeeAndBankDetails("Importer")

      Then("User is presented with the C285 Multiple Supporting Evidence Select Supporting Evidence Type Page v2")
      uploadAndContactDetails()

      Then("User is presented with the C285 Multiple Check Answers Accept Send Page v2")
      checkAnswersAndSubmit(Map(
        "Reason for claim"                    -> "Outward processing relief",
        "Personal details"                    -> "John Smith,john@smith.com,01234567890",
        "Address"                             -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Bank details"                        -> "Mr John Smith,123456,11001001",
        "Additional claim information"        -> "under 500 characters",
        "Total"                               -> "£40.00",
        "1st Movement Reference Number (MRN)" -> "10AAAAAAAAAAAAAAA2",
        "2nd MRN"                             -> "20AAAAAAAAAAAAAAA2",
        "Uploaded files"                      -> "Commercial invoice:,document.pdf",
        "1st MRN10AAAAAAAAAAAAAAA2"           -> "£20.00",
        "2nd MRN20AAAAAAAAAAAAAAA2"           -> "£20.00",
        "Payee"                               -> "Importer"
      ))
    }

    Scenario("happy path - with no bank details (user is both importer and declarant)") {

      Given("User navigates to the Auth Login Stub Page")
      loginAndNavigateToMultiple()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 60AAAAAAAAAAAAAAA1 on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.enterDetails("60AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.checkURL
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageTitle()

      When("User enters 20AAAAAAAAAAAAAAA1 on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.enterDetails("20AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkURL
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageHeader()
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageTitle()

      When("User selects radio button No on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickRadioButton("No")

      And("User clicks continue on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Choose Basis For Claim Page v2")
      performBasisAndAdditionalDetails()

      Then("User is presented with the C285 Multiple Select Duties 1 Page v2")
      performStandardDuties12()

      Then("User is presented with the C285 Multiple Check Claim Page v2")
      performCheckClaimPage()

      Then("User is presented with the C285 Multiple Choose Payee Type v2")
      performPayeeAndBankDetails("Importer")

      Then("User is presented with the C285 Multiple Supporting Evidence Select Supporting Evidence Type Page v2")
      uploadAndContactDetails()

      Then("User is presented with the C285 Multiple Check Answers Accept Send Page v2")
      checkAnswersAndSubmit(Map(
        "Reason for claim"                    -> "Outward processing relief",
        "Personal details"                    -> "John Smith,john@smith.com,01234567890",
        "Address"                             -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Bank details"                        -> "Mr John Smith,123456,11001001",
        "Additional claim information"        -> "under 500 characters",
        "Total"                               -> "£40.00",
        "1st Movement Reference Number (MRN)" -> "60AAAAAAAAAAAAAAA1",
        "2nd MRN"                             -> "20AAAAAAAAAAAAAAA1",
        "2nd MRN20AAAAAAAAAAAAAAA1"           -> "£20.00",
        "1st MRN60AAAAAAAAAAAAAAA1"           -> "£20.00",
        "Uploaded files"                      -> "Commercial invoice:,document.pdf",
        "Payee"                               -> "Importer"
      ))
    }

    Scenario("error scenario - second mrn not linked to eori") {

      Given("User navigates to the Auth Login Stub Page")
      loginAndNavigateToMultiple()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 10AAAAAAAAAAAAAAA1 on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.enterDetails("10AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.checkURL
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageTitle()

      When("User enters 10AAAAAAAAAAAAAAA2 on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.enterDetails("10AAAAAAAAAAAAAAA2")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 2 Page v2 error page")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageErrorTitle()
    }

    Scenario("error scenario - second mrn not linked to importer/declarant eori") {

      Given("User navigates to the Auth Login Stub Page")
      loginAndNavigateToMultiple()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 10AAAAAAAAAAAAAAA2 on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.enterDetails("10AAAAAAAAAAAAAAA2")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Importer Eori Page v2")
      C285_Multiple_EnterImporterEoriPagev2.waitForPageHeader
      C285_Multiple_EnterImporterEoriPagev2.checkURL
      C285_Multiple_EnterImporterEoriPagev2.checkPageHeader()
      C285_Multiple_EnterImporterEoriPagev2.checkPageTitle()

      When("User enters GB000000000000002 on C285 Multiple Enter Importer Eori Page v2")
      C285_Multiple_EnterImporterEoriPagev2.waitForPageHeader
      C285_Multiple_EnterImporterEoriPagev2.enterDetails("GB000000000000002")

      And("User clicks continue on C285 Multiple Enter Importer Eori Page v2")
      C285_Multiple_EnterImporterEoriPagev2.waitForPageHeader
      C285_Multiple_EnterImporterEoriPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Declarant Eori Page v2")
      C285_Multiple_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Multiple_EnterDeclarantEoriPagev2.checkURL
      C285_Multiple_EnterDeclarantEoriPagev2.checkPageHeader()
      C285_Multiple_EnterDeclarantEoriPagev2.checkPageTitle()

      When("User enters GB000000000000002 on C285 Multiple Enter Declarant Eori Page v2")
      C285_Multiple_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Multiple_EnterDeclarantEoriPagev2.enterDetails("GB000000000000002")

      And("User clicks continue on C285 Multiple Enter Declarant Eori Page v2")
      C285_Multiple_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Multiple_EnterDeclarantEoriPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.checkURL
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User selects radio button yes on C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.clickRadioButton("yes")

      And("User clicks continue on C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageTitle()

      When("User enters 10AAAAAAAAAAAAAAA1 on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.enterDetails("10AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 2 Page v2 error page")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageErrorTitle()
    }

    Scenario("happy path with many MRNs and duties") {

      Given("User navigates to the Auth Login Stub Page")
      loginAndNavigateToMultiple()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 01AAAAAAAAAAAAAAA1 on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.enterDetails("01AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.checkURL
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageTitle()

      When("User enters 02AAAAAAAAAAAAAAA1 on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.enterDetails("02AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkURL
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageHeader()
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageTitle()

      When("User selects radio button Yes on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickRadioButton("Yes")

      And("User clicks continue on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 3 Page v2")
      C285_Multiple_EnterMovementReferenceNumber3Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber3Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber3Pagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumber3Pagev2.checkPageTitle()

      When("User enters 10XXXXXXXXXXXXXXX1 on C285 Multiple Enter Movement Reference Number 3 Page v2")
      C285_Multiple_EnterMovementReferenceNumber3Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber3Pagev2.enterDetails("10XXXXXXXXXXXXXXX1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number 3 Page v2")
      C285_Multiple_EnterMovementReferenceNumber3Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber3Pagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickRadioButton("Yes")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 4 Page v2")
      C285_Multiple_EnterMovementReferenceNumber4Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber4Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber4Pagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumber4Pagev2.checkPageTitle()

      When("User enters 10YYYYYYYYYYYYYYY1 on C285 Multiple Enter Movement Reference Number 4 Page v2")
      C285_Multiple_EnterMovementReferenceNumber4Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber4Pagev2.enterDetails("10YYYYYYYYYYYYYYY1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number 4 Page v2")
      C285_Multiple_EnterMovementReferenceNumber4Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber4Pagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickRadioButton("Yes")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 5 Page v2")
      C285_Multiple_EnterMovementReferenceNumber5Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber5Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber5Pagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumber5Pagev2.checkPageTitle()

      When("User enters 10ZZZZZZZZZZZZZZZ1 on C285 Multiple Enter Movement Reference Number 5 Page v2")
      C285_Multiple_EnterMovementReferenceNumber5Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber5Pagev2.enterDetails("10ZZZZZZZZZZZZZZZ1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number 5 Page v2")
      C285_Multiple_EnterMovementReferenceNumber5Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber5Pagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkURL
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageHeader()
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageTitle()

      When("User selects radio button No on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickRadioButton("No")

      And("User clicks continue on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Choose Basis For Claim Page v2")
      performBasisAndAdditionalDetails()

      Then("User is presented with the C285 Multiple Select Duties 1 Page v2")
      C285_Multiple_SelectDuties1Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties1Pagev2.checkURL
      C285_Multiple_SelectDuties1Pagev2.checkPageHeader()
      C285_Multiple_SelectDuties1Pagev2.checkPageTitle()
      C285_Multiple_SelectDuties1Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties1Pagev2.selectBoxes("A80,A95".split(","))
      C285_Multiple_SelectDuties1Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties1Pagev2.clickContinueButton()

      C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties1DutyPagev2.checkPageTitle("A80 - Definitive Anti-Dumping Duty")
      C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties1DutyPagev2.enterDetails("10")
      C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties1DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties1DutyPagev2.checkPageTitle("A95 - Provisional Countervailing Duty")
      C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties1DutyPagev2.enterDetails("10")
      C285_Multiple_SelectDuties1DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties1DutyPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Select Duties 2 Page v2")
      C285_Multiple_SelectDuties2Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties2Pagev2.checkURL
      C285_Multiple_SelectDuties2Pagev2.checkPageHeader()
      C285_Multiple_SelectDuties2Pagev2.checkPageTitle()
      C285_Multiple_SelectDuties2Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties2Pagev2.selectBoxes("A90,A85".split(","))
      C285_Multiple_SelectDuties2Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties2Pagev2.clickContinueButton()

      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.checkPageTitle("A90 - Definitive Countervailing Duty")
      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.enterDetails("5")
      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.checkPageTitle("A85 - Provisional Anti-Dumping Duty")
      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.enterDetails("10")
      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Select Duties 3 Page v2")
      C285_Multiple_SelectDuties3Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties3Pagev2.checkURL
      C285_Multiple_SelectDuties3Pagev2.checkPageHeader()
      C285_Multiple_SelectDuties3Pagev2.checkPageTitle()
      C285_Multiple_SelectDuties3Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties3Pagev2.selectBoxes("591,433,463".split(","))
      C285_Multiple_SelectDuties3Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties3Pagev2.clickContinueButton()

      C285_Multiple_SelectDuties3DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties3DutyPagev2.checkPageTitle("Excise Duty - 591 Miscellaneous road fuels")
      C285_Multiple_SelectDuties3DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties3DutyPagev2.enterDetails("10")
      C285_Multiple_SelectDuties3DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties3DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties3DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties3DutyPagev2.checkPageTitle("Excise Duty - 433 Low alcohol beverages")
      C285_Multiple_SelectDuties3DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties3DutyPagev2.enterDetails("5")
      C285_Multiple_SelectDuties3DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties3DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties3DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties3DutyPagev2.checkPageTitle("Excise Duty - 463 Spirits")
      C285_Multiple_SelectDuties3DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties3DutyPagev2.enterDetails("20")
      C285_Multiple_SelectDuties3DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties3DutyPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Select Duties 4 Page v2")
      C285_Multiple_SelectDuties4Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties4Pagev2.checkURL
      C285_Multiple_SelectDuties4Pagev2.checkPageHeader()
      C285_Multiple_SelectDuties4Pagev2.checkPageTitle()
      C285_Multiple_SelectDuties4Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties4Pagev2.selectBoxes("A70,421,422,435,487".split(","))
      C285_Multiple_SelectDuties4Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties4Pagev2.clickContinueButton()

      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.checkPageTitle("A70 - Additional Duty")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.enterDetails("10")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.checkPageTitle("Excise Duty - 421 Made-wine")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.enterDetails("5")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.checkPageTitle("Excise Duty - 422 Made-wine")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.enterDetails("20")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.checkPageTitle("Excise Duty - 435 Low alcohol beverages")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.enterDetails("30")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.checkPageTitle("Excise Duty - 487 Cider and perry")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.enterDetails("5")
      C285_Multiple_SelectDuties4DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties4DutyPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Select Duties 5 Page v2")
      C285_Multiple_SelectDuties5Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties5Pagev2.checkURL
      C285_Multiple_SelectDuties5Pagev2.checkPageHeader()
      C285_Multiple_SelectDuties5Pagev2.checkPageTitle()
      C285_Multiple_SelectDuties5Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties5Pagev2.selectBoxes("561,589,595,591,592".split(","))
      C285_Multiple_SelectDuties5Pagev2.waitForPageHeader
      C285_Multiple_SelectDuties5Pagev2.clickContinueButton()

      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.checkPageTitle("Excise Duty - 561 Hydrocarbon oil")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.enterDetails("10")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.checkPageTitle("Excise Duty - 589 Biofuels")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.enterDetails("5")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.checkPageTitle("Excise Duty - 595 Biofuels")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.enterDetails("15")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.checkPageTitle("Excise Duty - 591 Miscellaneous road fuels")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.enterDetails("5")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.checkPageTitle("Excise Duty - 592 Miscellaneous road fuels")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.enterDetails("10")
      C285_Multiple_SelectDuties5DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties5DutyPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Claim Page v2")
      performCheckClaimPage()

      Then("User is presented with the C285 Multiple Choose Payee Type v2")
      performPayeeAndBankDetails("Importer")

      Then("User is presented with the C285 Multiple Supporting Evidence Select Supporting Evidence Type Page v2")
      uploadAndContactDetails()

      Then("User is presented with the C285 Multiple Check Answers Accept Send Page v2")
      checkAnswersAndSubmit(Map(
        "Reason for claim"                    -> "Outward processing relief",
        "Personal details"                    -> "John Smith,john@smith.com,01234567890",
        "Address"                             -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Bank details"                        -> "Mr John Smith,123456,11001001",
        "Payee"                               -> "Importer",
        "Additional claim information"        -> "under 500 characters",
        "Total"                               -> "£185.00",
        "1st Movement Reference Number (MRN)" -> "01AAAAAAAAAAAAAAA1",
        "2nd MRN"                             -> "02AAAAAAAAAAAAAAA1",
        "3rd MRN"                             -> "10XXXXXXXXXXXXXXX1",
        "4th MRN"                             -> "10YYYYYYYYYYYYYYY1",
        "5th MRN"                             -> "10ZZZZZZZZZZZZZZZ1",
        "1st MRN01AAAAAAAAAAAAAAA1"           -> "£20.00",
        "2nd MRN02AAAAAAAAAAAAAAA1"           -> "£15.00",
        "3rd MRN10XXXXXXXXXXXXXXX1"           -> "£35.00",
        "4th MRN10YYYYYYYYYYYYYYY1"           -> "£70.00",
        "5th MRN10ZZZZZZZZZZZZZZZ1"           -> "£45.00",
        "Uploaded files"                      -> "Commercial invoice:,document.pdf"
      ))
    }

    ignore("test temp pages - confirm ALF data works in journey (no contact details)") {
      // Tagged @testFail in feature file - requires pages not yet implemented:
      // C285_Multiple_ClaimantDetailsAddPagev2, C285_Multiple_ClaimantDetailsPagev2,
      // C285_Multiple_CheckTheseBankDetailsAreCorrectPagev2, ALF v2 pages,
      // C285_Multiple_SupportingEvidenceUploadSupportingEvidencePagev2,
      // C285_Multiple_SupportingEvidenceCheckYourAnswersPagev2
    }

    Scenario("happy path with new payee type page - user with only importer bank details and selects declarant user - CMA not eligible") {

      Given("User navigates to the Auth Login Stub Page")
      loginAndNavigateToMultiple()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 60AAAAAAAAAAAAAAA5 on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.enterDetails("60AAAAAAAAAAAAAAA5")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.checkURL
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Multiple_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Multiple Check Declaration Details Page v2")
      C285_Multiple_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Multiple_CheckDeclarationDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.checkPageTitle()

      When("User enters 20AAAAAAAAAAAAAAA1 on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.enterDetails("20AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkURL
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageHeader()
      C285_Multiple_CheckMovementReferenceNumbersPagev2.checkPageTitle()

      When("User selects radio button No on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickRadioButton("No")

      And("User clicks continue on C285 Multiple Check Movement Reference Numbers Page v2")
      C285_Multiple_CheckMovementReferenceNumbersPagev2.waitForPageHeader
      C285_Multiple_CheckMovementReferenceNumbersPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Choose Basis For Claim Page v2")
      performBasisAndAdditionalDetails()

      Then("User is presented with the C285 Multiple Select Duties 1 Page v2")
      performStandardDuties12()

      Then("User is presented with the C285 Multiple Check Claim Page v2")
      performCheckClaimPage()

      Then("User is presented with the C285 Multiple Choose Payee Type v2")
      performPayeeAndBankDetails("Declarant")

      Then("User is presented with the C285 Multiple Supporting Evidence Select Supporting Evidence Type Page v2")
      uploadAndContactDetails()

      Then("User is presented with the C285 Multiple Check Answers Accept Send Page v2")
      checkAnswersAndSubmit(Map(
        "Reason for claim"                    -> "Outward processing relief",
        "Personal details"                    -> "John Smith,john@smith.com,01234567890",
        "Address"                             -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Bank details"                        -> "Mr John Smith,123456,11001001",
        "Payee"                               -> "Declarant",
        "Additional claim information"        -> "under 500 characters",
        "Total"                               -> "£40.00",
        "1st Movement Reference Number (MRN)" -> "60AAAAAAAAAAAAAAA5",
        "2nd MRN"                             -> "20AAAAAAAAAAAAAAA1",
        "2nd MRN20AAAAAAAAAAAAAAA1"           -> "£20.00",
        "1st MRN60AAAAAAAAAAAAAAA5"           -> "£20.00",
        "Uploaded files"                      -> "Commercial invoice:,document.pdf"
      ))
    }
  }
}
