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

class MultipleV2XiEoriSpec extends BaseSpec {

  Feature("C285 Multiple V2 - XI EORI") {

    Scenario("happy path - check importer/declarant eori pages") {

      Given("User navigates to the Auth Login Stub Page")
      go to AuthLoginStubPage
      AuthLoginStubPage.enterRedirectURL(TestConfiguration.url("cds-frontend") + "/start")
      AuthLoginStubPage.enrolments("HMRC-CUS-ORG", "EORINumber", "GB000000000000001")
      AuthLoginStubPage.waitForPageHeader
      AuthLoginStubPage.clickContinueButton()

      Then("User is presented with the Check Eori Details Page")
      CheckEoriDetailsPage.waitForPageHeader
      CheckEoriDetailsPage.checkURL
      CheckEoriDetailsPage.checkPageHeader()
      CheckEoriDetailsPage.checkPageTitle()
      CheckEoriDetailsPage.waitForPageHeader
      CheckEoriDetailsPage.clickRadioButton("yes")
      CheckEoriDetailsPage.waitForPageHeader
      CheckEoriDetailsPage.clickContinueButton()

      Then("User is presented with the Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.checkURL
      SelectClaimTypePage.checkPageHeader()
      SelectClaimTypePage.checkPageTitle()
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickRadioButton("c285")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickContinueButton()

      Then("User is presented with the C285 Choose How Many Mrns Page v2")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.checkURL
      C285_ChooseHowManyMrnsPagev2.checkPageHeader()
      C285_ChooseHowManyMrnsPagev2.checkPageTitle()
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickRadioButton("bulk")
      C285_ChooseHowManyMrnsPagev2.waitForPageHeader
      C285_ChooseHowManyMrnsPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Have Your Supporting Document Ready Page v2")
      C285_Multiple_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_Multiple_HaveYourSupportingDocumentReadyPagev2.checkURL
      C285_Multiple_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
      C285_Multiple_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()
      C285_Multiple_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      C285_Multiple_HaveYourSupportingDocumentReadyPagev2.clickContinue()

      Then("User is presented with the C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkURL
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Multiple_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 10XIDCAAAAAAAAAAA1 on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.enterDetails("10XIDCAAAAAAAAAAA1")

      And("User clicks continue on C285 Multiple Enter Movement Reference Number Page v2")
      C285_Multiple_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Importer Eori Page v2")
      C285_Multiple_EnterImporterEoriPagev2.waitForPageHeader
      C285_Multiple_EnterImporterEoriPagev2.checkURL
      C285_Multiple_EnterImporterEoriPagev2.checkPageHeader()
      C285_Multiple_EnterImporterEoriPagev2.checkPageTitle()

      When("User enters XI000000000000001 on C285 Multiple Enter Importer Eori Page v2")
      C285_Multiple_EnterImporterEoriPagev2.waitForPageHeader
      C285_Multiple_EnterImporterEoriPagev2.enterDetails("XI000000000000001")

      And("User clicks continue on C285 Multiple Enter Importer Eori Page v2")
      C285_Multiple_EnterImporterEoriPagev2.waitForPageHeader
      C285_Multiple_EnterImporterEoriPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Declarant Eori Page v2")
      C285_Multiple_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Multiple_EnterDeclarantEoriPagev2.checkURL
      C285_Multiple_EnterDeclarantEoriPagev2.checkPageHeader()
      C285_Multiple_EnterDeclarantEoriPagev2.checkPageTitle()

      When("User enters XI000000000000001 on C285 Multiple Enter Declarant Eori Page v2")
      C285_Multiple_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Multiple_EnterDeclarantEoriPagev2.enterDetails("XI000000000000001")

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

      When("User enters 20XIDCAAAAAAAAAAA1 on C285 Multiple Enter Movement Reference Number 2 Page v2")
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.waitForPageHeader
      C285_Multiple_EnterMovementReferenceNumber2Pagev2.enterDetails("20XIDCAAAAAAAAAAA1")

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
      C285_Multiple_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Multiple_ChooseBasisForClaimPagev2.checkURL
      C285_Multiple_ChooseBasisForClaimPagev2.checkPageHeader()
      C285_Multiple_ChooseBasisForClaimPagev2.checkPageTitle()
      C285_Multiple_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Multiple_ChooseBasisForClaimPagev2.clickRadioButton("Outward processing relief")
      C285_Multiple_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Multiple_ChooseBasisForClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Additional Details Page v2")
      C285_Multiple_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Multiple_EnterAdditionalDetailsPagev2.checkURL
      C285_Multiple_EnterAdditionalDetailsPagev2.checkPageHeader()
      C285_Multiple_EnterAdditionalDetailsPagev2.checkPageTitle()
      C285_Multiple_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Multiple_EnterAdditionalDetailsPagev2.enterDetails("under 500 characters")
      C285_Multiple_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Multiple_EnterAdditionalDetailsPagev2.clickContinueButton()

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
      C285_Multiple_SelectDuties2DutyPagev2.enterDetails("10")
      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.clickContinueButton()

      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.checkPageTitle("A85 - Provisional Anti-Dumping Duty")
      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.enterDetails("10")
      C285_Multiple_SelectDuties2DutyPagev2.waitForPageHeader
      C285_Multiple_SelectDuties2DutyPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Claim Page v2")
      C285_Multiple_CheckClaimPagev2.waitForPageHeader
      C285_Multiple_CheckClaimPagev2.checkURL
      C285_Multiple_CheckClaimPagev2.checkPageHeader()
      C285_Multiple_CheckClaimPagev2.checkPageTitle()
      C285_Multiple_CheckClaimPagev2.waitForPageHeader
      C285_Multiple_CheckClaimPagev2.clickContinue()

      Then("User is presented with the C285 Multiple Choose Payee Type v2")
      C285_Multiple_ChoosePayeeTypev2.waitForPageHeader
      C285_Multiple_ChoosePayeeTypev2.checkURL
      C285_Multiple_ChoosePayeeTypev2.checkPageHeader()
      C285_Multiple_ChoosePayeeTypev2.checkPageTitle()
      C285_Multiple_ChoosePayeeTypev2.waitForPageHeader
      C285_Multiple_ChoosePayeeTypev2.clickRadioButton("Importer")
      C285_Multiple_ChoosePayeeTypev2.waitForPageHeader
      C285_Multiple_ChoosePayeeTypev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Enter Bank Account Details Page v2")
      C285_Multiple_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Multiple_EnterBankAccountDetailsPagev2.checkURL
      C285_Multiple_EnterBankAccountDetailsPagev2.checkPageHeader()
      C285_Multiple_EnterBankAccountDetailsPagev2.checkPageTitle()
      C285_Multiple_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Multiple_EnterBankAccountDetailsPagev2.enterDetails("")
      C285_Multiple_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Multiple_EnterBankAccountDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
      C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
      C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()
      C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Commercial invoice")
      C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

      Then("User is presented with the UCDF Choose File Other Page - commercial invoice")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("commercial invoice")
      UCDF_ChooseFileOtherPage.uploadDocument(1, "document.pdf")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("No")
      UCDF_ChooseFileOtherPage.clickContinueButton()
      UCDF_ChooseFileOtherPage.continuouslyClickContinue()

      Then("User is presented with the C285 Multiple Claimant Details Enter Contact Details Page v2")
      C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.waitForPageHeader
      C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.checkURL
      C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.checkPageHeader()
      C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.checkPageTitle()
      C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.waitForPageHeader
      C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.enterDetails("")
      C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.waitForPageHeader
      C285_Multiple_ClaimantDetailsEnterContactDetailsPagev2.clickContinueButton()

      And("User clicks Enter the address manually on ALF Lookup Address Lookup Page")
      ALF_LookupAddressLookupPage.waitForPageHeader
      ALF_LookupAddressLookupPage.clickButton("Enter the address manually")

      And("User enters on ALF Lookup Address Edit Page")
      ALF_LookupAddressEditPage.waitForPageHeader
      ALF_LookupAddressEditPage.enterDetails("")
      ALF_LookupAddressEditPage.waitForPageHeader
      ALF_LookupAddressEditPage.clickContinueButton()

      And("User clicks continue on ALF Lookup Address Confirm Page")
      ALF_LookupAddressConfirmPage.waitForPageHeader
      ALF_LookupAddressConfirmPage.clickContinueButton()

      Then("User is presented with the C285 Multiple Check Answers Accept Send Page v2")
      C285_Multiple_CheckAnswersAcceptSendPagev2.waitForPageHeader
      C285_Multiple_CheckAnswersAcceptSendPagev2.checkURL
      C285_Multiple_CheckAnswersAcceptSendPagev2.checkPageHeader()
      C285_Multiple_CheckAnswersAcceptSendPagev2.checkPageTitle()

      val expectedData = Map(
        "Reason for claim"                    -> "Outward processing relief",
        "Personal details"                    -> "John Smith,john@smith.com,01234567890",
        "Address"                             -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Bank details"                        -> "Mr John Smith,123456,11001001",
        "Payee"                               -> "Importer",
        "Additional claim information"        -> "under 500 characters",
        "Total"                               -> "£40.00",
        "1st Movement Reference Number (MRN)" -> "10XIDCAAAAAAAAAAA1",
        "2nd MRN"                             -> "20XIDCAAAAAAAAAAA1",
        "Uploaded files"                      -> "Commercial invoice:,document.pdf",
        "2nd MRN20XIDCAAAAAAAAAAA1"           -> "£20.00",
        "1st MRN10XIDCAAAAAAAAAAA1"           -> "£20.00"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      C285_Multiple_CheckAnswersAcceptSendPagev2.pageData should be(expectedData)      
      C285_Multiple_CheckAnswersAcceptSendPagev2.waitForPageHeader
      C285_Multiple_CheckAnswersAcceptSendPagev2.clickContinueButton()

      Then("User is presented with the C285 Multiple Claim Submitted Page v2")
      C285_Multiple_ClaimSubmittedPagev2.waitForPageHeader
      C285_Multiple_ClaimSubmittedPagev2.checkURL
      C285_Multiple_ClaimSubmittedPagev2.checkPageHeader()
      C285_Multiple_ClaimSubmittedPagev2.checkPageTitle()
    }
  }
}
