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

package uk.gov.hmrc.cdsrc.specs.Securities

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.Securities._
import uk.gov.hmrc.cdsrc.pages.auth.AuthLoginStubPage
import uk.gov.hmrc.cdsrc.pages.common.{CheckEoriDetailsPage, SelectClaimTypePage}
import uk.gov.hmrc.cdsrc.pages.common.ALF.{ALF_LookupAddressConfirmPage, ALF_LookupAddressEditPage, ALF_LookupAddressLookupPage}
import uk.gov.hmrc.cdsrc.pages.common.UDF.UDF_ChooseFilesPage
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class SingleSecuritySpec extends BaseSpec {

  Feature("Securities Single") {

    ignore("happy path - ntas TA single check eori pages - with no Payment method") {

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

      Then("User is presented with the Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.checkURL
      Securities_CheckDeclarationDetailsPage.checkPageHeader()
      Securities_CheckDeclarationDetailsPage.checkPageTitle()

      And("User clicks continue on Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.clickContinueButton()

      Then("User is presented with the Securities HaveYourSupportingDocumentReadyPage")
      Securities_HaveYourSupportingDocumentReadyPage.waitForPageHeader
      Securities_HaveYourSupportingDocumentReadyPage.checkURL
      Securities_HaveYourSupportingDocumentReadyPage.checkPageHeader()
      Securities_HaveYourSupportingDocumentReadyPage.checkPageTitle()

      When("User clicks continue on Securities HaveYourSupportingDocumentReadyPage")
      Securities_HaveYourSupportingDocumentReadyPage.waitForPageHeader
      Securities_HaveYourSupportingDocumentReadyPage.clickContinue()

      Then("User is presented with the Securities ConfirmFullRepayment")
      Securities_ConfirmFullRepayment.waitForPageHeader
      Securities_ConfirmFullRepayment.checkURL
      Securities_ConfirmFullRepayment.checkPageHeader()
      Securities_ConfirmFullRepayment.checkPageTitle()

      When("User selects radio button Yes on Securities ConfirmFullRepayment")
      Securities_ConfirmFullRepayment.waitForPageHeader
      Securities_ConfirmFullRepayment.clickRadioButton("Yes")

      And("User clicks continue on Securities ConfirmFullRepayment")
      Securities_ConfirmFullRepayment.waitForPageHeader
      Securities_ConfirmFullRepayment.clickContinueButton()

      Then("User is presented with the Securities Export Method Page")
      Securities_ExportMethodPage.waitForPageHeader
      Securities_ExportMethodPage.checkURL
      Securities_ExportMethodPage.checkPageHeader()
      Securities_ExportMethodPage.checkPageTitle()

      When("User selects radio button Declared to a customs warehouse on Securities Export Method Page")
      Securities_ExportMethodPage.waitForPageHeader
      Securities_ExportMethodPage.clickRadioButton("Declared to a customs warehouse")

      And("User clicks continue on Securities Export Method Page")
      Securities_ExportMethodPage.waitForPageHeader
      Securities_ExportMethodPage.clickContinueButton()

      Then("User is presented with the Securities Choose Payee Type Page")
      Securities_ChoosePayeeTypePage.waitForPageHeader
      Securities_ChoosePayeeTypePage.checkURL
      Securities_ChoosePayeeTypePage.checkPageHeader()
      Securities_ChoosePayeeTypePage.checkPageTitle()

      And("User selects radio button Importer on Securities Choose Payee Type Page")
      Securities_ChoosePayeeTypePage.waitForPageHeader
      Securities_ChoosePayeeTypePage.clickRadioButton("Importer")

      When("User clicks continue on Securities Choose Payee Type Page")
      Securities_ChoosePayeeTypePage.waitForPageHeader
      Securities_ChoosePayeeTypePage.clickContinueButton()

      Then("User is presented with the Securities EnterBankAccountDetailsPage")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.checkURL
      Securities_EnterBankAccountDetailsPage.checkPageHeader()
      Securities_EnterBankAccountDetailsPage.checkPageTitle()

      And("User enters empty string on Securities EnterBankAccountDetailsPage")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.enterDetails("")

      When("User clicks continue on Securities EnterBankAccountDetailsPage")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.clickContinueButton()

      Then("User is presented with the Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.checkURL
      Securities_ChooseFileTypePage.checkPageHeader()
      Securities_ChooseFileTypePage.checkPageTitle()

      When("User selects radio button Import declaration on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickRadioButton("Import declaration")

      And("User clicks continue on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickContinueButton()

      Then("User is presented with the UDF Choose Files Page - import declaration")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.checkURL
      UDF_ChooseFilesPage.checkPageTitle("import declaration")

      When("User uploads a 1 document.pdf file on UDF Choose Files Page")
      UDF_ChooseFilesPage.uploadDocument(1, "document.pdf")
      UDF_ChooseFilesPage.waitForPageToLoad()

      And("User selects radio button Yes on UDF Choose Files Page")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.clickRadioButton("Yes")

      And("User clicks continue if I'm on UDF Choose Files Page")
      UDF_ChooseFilesPage.clickContinueButton()
      UDF_ChooseFilesPage.continuouslyClickContinue()

      Then("User is presented with the Securities Choose File Type Page again")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.checkURL
      Securities_ChooseFileTypePage.checkPageHeader()
      Securities_ChooseFileTypePage.checkPageTitle()

      When("User selects radio button Export declaration on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickRadioButton("Export declaration")

      And("User clicks continue on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickContinueButton()

      Then("User is presented with the UDF Choose Files Page - export declaration")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.checkURL
      UDF_ChooseFilesPage.checkPageTitle("export declaration")

      When("User uploads a 2 image.jpg file on UDF Choose Files Page")
      UDF_ChooseFilesPage.uploadDocument(2, "image.jpg")
      UDF_ChooseFilesPage.waitForPageToLoad()

      And("User selects radio button No on UDF Choose Files Page")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.clickRadioButton("No")

      When("User clicks continue if I'm on UDF Choose Files Page")
      UDF_ChooseFilesPage.clickContinueButton()
      UDF_ChooseFilesPage.continuouslyClickContinue()

      Then("User is presented with the Securities EnterAdditionalDetailsPage")
      Securities_EnterAdditionalDetailsPage.waitForPageHeader
      Securities_EnterAdditionalDetailsPage.checkURL
      Securities_EnterAdditionalDetailsPage.checkPageHeader()
      Securities_EnterAdditionalDetailsPage.checkPageTitle()

      When("User enters under 500 characters on Securities EnterAdditionalDetailsPage")
      Securities_EnterAdditionalDetailsPage.waitForPageHeader
      Securities_EnterAdditionalDetailsPage.enterDetails("under 500 characters")

      And("User clicks continue on Securities EnterAdditionalDetailsPage")
      Securities_EnterAdditionalDetailsPage.waitForPageHeader
      Securities_EnterAdditionalDetailsPage.clickContinueButton()

      Then("User is presented with the Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.checkURL
      Securities_ChangeContactDetailsPage.checkPageHeader()
      Securities_ChangeContactDetailsPage.checkPageTitle()

      And("User enters empty string on Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.enterDetails("")

      And("User clicks continue on Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.clickContinueButton()

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

      Then("User is presented with the Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.checkURL
      Securities_CheckYourAnswersPage.checkPageHeader()
      Securities_CheckYourAnswersPage.checkPageTitle()

      And("User should see the following details")
      val expectedData = Map(
        "Movement Reference Number (MRN)"    -> "01AAAAAAAAAAAAA110",
        "Do you want to claim back the full amount?" -> "Yes",
        "Uploaded files"                     -> "Import declaration:,document.pdf,Export declaration:,image.jpg",
        "Why was a security deposit needed?" -> "Temporary Admission (24 months)",
        "Address"                            -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Payee"                              -> "Importer",
        "Do you want to provide more detail?" -> "under 500 characters",
        "What did you do with the goods?"    -> "Declared to a customs warehouse",
        "Total"                              -> "£6,000.00",
        "What do you want to claim?"         -> "A00 - Customs Duty",
        "A00 - Customs Duty"                 -> "£6,000.00",
        "Personal details"                   -> "Mr John Smith,someemail@mail.com,01234567890",
        "Bank details"                       -> "Mr John Smith,123456,11001001"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      Securities_CheckYourAnswersPage.pageData should be(expectedData)
      When("User clicks continue on Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.clickContinueButton()

      Then("User is presented with the Securities Claim Submitted Page")
      Securities_ClaimSubmittedPage.waitForPageHeader
      Securities_ClaimSubmittedPage.checkURL
      Securities_ClaimSubmittedPage.checkPageHeader()
      Securities_ClaimSubmittedPage.checkPageTitle()
    }

    ignore("happy path - nidac mdp single check eori pages - with no Payment method") {

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

      When("User selects radio button Missing proof of origin on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickRadioButton("Missing proof of origin")

      And("User clicks continue on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickContinueButton()

      Then("User is presented with the Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.checkURL
      Securities_CheckDeclarationDetailsPage.checkPageHeader()
      Securities_CheckDeclarationDetailsPage.checkPageTitle()

      And("User clicks continue on Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.clickContinueButton()

      Then("User is presented with the Securities HaveYourSupportingDocumentReadyPage")
      Securities_HaveYourSupportingDocumentReadyPage.waitForPageHeader
      Securities_HaveYourSupportingDocumentReadyPage.checkURL
      Securities_HaveYourSupportingDocumentReadyPage.checkPageHeader()
      Securities_HaveYourSupportingDocumentReadyPage.checkPageTitle()

      When("User clicks continue on Securities HaveYourSupportingDocumentReadyPage")
      Securities_HaveYourSupportingDocumentReadyPage.waitForPageHeader
      Securities_HaveYourSupportingDocumentReadyPage.clickContinue()

      Then("User is presented with the Securities ConfirmFullRepayment")
      Securities_ConfirmFullRepayment.waitForPageHeader
      Securities_ConfirmFullRepayment.checkURL
      Securities_ConfirmFullRepayment.checkPageHeader()
      Securities_ConfirmFullRepayment.checkPageTitle()

      When("User selects radio button Yes on Securities ConfirmFullRepayment")
      Securities_ConfirmFullRepayment.waitForPageHeader
      Securities_ConfirmFullRepayment.clickRadioButton("Yes")

      And("User clicks continue on Securities ConfirmFullRepayment")
      Securities_ConfirmFullRepayment.waitForPageHeader
      Securities_ConfirmFullRepayment.clickContinueButton()

      Then("User is presented with the Securities Choose Payee Type Page")
      Securities_ChoosePayeeTypePage.waitForPageHeader
      Securities_ChoosePayeeTypePage.checkURL
      Securities_ChoosePayeeTypePage.checkPageHeader()
      Securities_ChoosePayeeTypePage.checkPageTitle()

      And("User selects radio button Importer on Securities Choose Payee Type Page")
      Securities_ChoosePayeeTypePage.waitForPageHeader
      Securities_ChoosePayeeTypePage.clickRadioButton("Importer")

      When("User clicks continue on Securities Choose Payee Type Page")
      Securities_ChoosePayeeTypePage.waitForPageHeader
      Securities_ChoosePayeeTypePage.clickContinueButton()

      Then("User is presented with the Securities EnterBankAccountDetailsPage")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.checkURL
      Securities_EnterBankAccountDetailsPage.checkPageHeader()
      Securities_EnterBankAccountDetailsPage.checkPageTitle()

      And("User enters empty string on Securities EnterBankAccountDetailsPage")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.enterDetails("")

      When("User clicks continue on Securities EnterBankAccountDetailsPage")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.clickContinueButton()

      Then("User is presented with the Securities AddProofOfOrigin - Proof of origin")
      Securities_AddProofOfOrigin.waitForPageHeader
      Securities_AddProofOfOrigin.checkURL
      Securities_AddProofOfOrigin.checkPageTitle("Proof of origin")

      When("User uploads a 1 document.pdf file on Securities AddProofOfOrigin")
      Securities_AddProofOfOrigin.uploadDocument(1, "document.pdf")
      Securities_AddProofOfOrigin.waitForPageToLoad()

      And("User clicks continue if I'm on Securities AddProofOfOrigin")
      Securities_AddProofOfOrigin.clickContinueButton()
      Securities_AddProofOfOrigin.continuouslyClickContinue()

      Then("User is presented with the Securities NidacAddOtherDocument")
      Securities_NidacAddOtherDocument.waitForPageHeader
      Securities_NidacAddOtherDocument.checkURL
      Securities_NidacAddOtherDocument.checkPageHeader()
      Securities_NidacAddOtherDocument.checkPageTitle()

      When("User selects radio button yes on Securities NidacAddOtherDocument")
      Securities_NidacAddOtherDocument.waitForPageHeader
      Securities_NidacAddOtherDocument.clickRadioButton("yes")

      And("User clicks continue on Securities NidacAddOtherDocument")
      Securities_NidacAddOtherDocument.waitForPageHeader
      Securities_NidacAddOtherDocument.clickContinueButton()

      Then("User is presented with the Securities NidacChooseFileTypePage")
      Securities_NidacChooseFileTypePage.waitForPageHeader
      Securities_NidacChooseFileTypePage.checkURL
      Securities_NidacChooseFileTypePage.checkPageHeader()
      Securities_NidacChooseFileTypePage.checkPageTitle()

      When("User selects radio button Commercial invoice on Securities NidacChooseFileTypePage")
      Securities_NidacChooseFileTypePage.waitForPageHeader
      Securities_NidacChooseFileTypePage.clickRadioButton("Commercial invoice")

      And("User clicks continue on Securities NidacChooseFileTypePage")
      Securities_NidacChooseFileTypePage.waitForPageHeader
      Securities_NidacChooseFileTypePage.clickContinueButton()

      Then("User is presented with the UDF Choose Files Page - commercial invoice")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.checkURL
      UDF_ChooseFilesPage.checkPageTitle("commercial invoice")

      When("User uploads a 1 document.pdf file on UDF Choose Files Page")
      UDF_ChooseFilesPage.uploadDocument(1, "document.pdf")
      UDF_ChooseFilesPage.waitForPageToLoad()

      And("User selects radio button No on UDF Choose Files Page")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.clickRadioButton("No")

      When("User clicks continue if I'm on UDF Choose Files Page")
      UDF_ChooseFilesPage.clickContinueButton()
      UDF_ChooseFilesPage.continuouslyClickContinue()

      Then("User is presented with the Securities EnterAdditionalDetailsPage")
      Securities_EnterAdditionalDetailsPage.waitForPageHeader
      Securities_EnterAdditionalDetailsPage.checkURL
      Securities_EnterAdditionalDetailsPage.checkPageHeader()
      Securities_EnterAdditionalDetailsPage.checkPageTitle()

      When("User enters under 500 characters on Securities EnterAdditionalDetailsPage")
      Securities_EnterAdditionalDetailsPage.waitForPageHeader
      Securities_EnterAdditionalDetailsPage.enterDetails("under 500 characters")

      And("User clicks continue on Securities EnterAdditionalDetailsPage")
      Securities_EnterAdditionalDetailsPage.waitForPageHeader
      Securities_EnterAdditionalDetailsPage.clickContinueButton()

      Then("User is presented with the Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.checkURL
      Securities_ChangeContactDetailsPage.checkPageHeader()
      Securities_ChangeContactDetailsPage.checkPageTitle()

      And("User enters empty string on Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.enterDetails("")

      And("User clicks continue on Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.clickContinueButton()

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

      Then("User is presented with the Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.checkURL
      Securities_CheckYourAnswersPage.checkPageHeader()
      Securities_CheckYourAnswersPage.checkPageTitle()

      And("User should see the following details")
      val expectedData = Map(
        "Movement Reference Number (MRN)"                   -> "01AAAAAAAAAAAAA110",
        "Do you want to claim back the full amount?"        -> "Yes",
        "Proof of origin"                                   -> "document.pdf",
        "Other uploaded files"                              -> "Commercial invoice:,document.pdf",
        "Why was a security deposit needed?"                -> "Missing proof of origin",
        "Address"                                           -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Payee"                                             -> "Importer",
        "Do you want to provide more detail?"               -> "under 500 characters",
        "What do you want to claim?"                        -> "A00 - Customs Duty",
        "Total"                                             -> "£6,000.00",
        "A00 - Customs Duty"                                -> "£6,000.00",
        "Do you want to add other documents to your claim?" -> "Yes",
        "Personal details"                                  -> "Mr John Smith,someemail@mail.com,01234567890",
        "Bank details"                                      -> "Mr John Smith,123456,11001001"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      Securities_CheckYourAnswersPage.pageData should be(expectedData)
      When("User clicks continue on Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.clickContinueButton()

      Then("User is presented with the Securities Claim Submitted Page")
      Securities_ClaimSubmittedPage.waitForPageHeader
      Securities_ClaimSubmittedPage.checkURL
      Securities_ClaimSubmittedPage.checkPageHeader()
      Securities_ClaimSubmittedPage.checkPageTitle()
    }

    ignore("happy path - Temporary admission and Exported in multiple shipment") {

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

      When("User selects radio button Temporary Admission (2 months) on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickRadioButton("Temporary Admission (2 months)")

      And("User clicks continue on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickContinueButton()

      Then("User is presented with the Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.checkURL
      Securities_CheckDeclarationDetailsPage.checkPageHeader()
      Securities_CheckDeclarationDetailsPage.checkPageTitle()

      And("User clicks continue on Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.clickContinueButton()

      Then("User is presented with the Securities HaveYourSupportingDocumentReadyPage")
      Securities_HaveYourSupportingDocumentReadyPage.waitForPageHeader
      Securities_HaveYourSupportingDocumentReadyPage.checkURL
      Securities_HaveYourSupportingDocumentReadyPage.checkPageHeader()
      Securities_HaveYourSupportingDocumentReadyPage.checkPageTitle()

      When("User clicks continue on Securities HaveYourSupportingDocumentReadyPage")
      Securities_HaveYourSupportingDocumentReadyPage.waitForPageHeader
      Securities_HaveYourSupportingDocumentReadyPage.clickContinue()

      Then("User is presented with the Securities ConfirmFullRepayment")
      Securities_ConfirmFullRepayment.waitForPageHeader
      Securities_ConfirmFullRepayment.checkURL
      Securities_ConfirmFullRepayment.checkPageHeader()
      Securities_ConfirmFullRepayment.checkPageTitle()

      When("User selects radio button No on Securities ConfirmFullRepayment")
      Securities_ConfirmFullRepayment.waitForPageHeader
      Securities_ConfirmFullRepayment.clickRadioButton("No")

      And("User clicks continue on Securities ConfirmFullRepayment")
      Securities_ConfirmFullRepayment.waitForPageHeader
      Securities_ConfirmFullRepayment.clickContinueButton()

      Then("User is presented with the Securities ConfirmPartialpayment")
      Securities_ConfirmPartialpayment.waitForPageHeader
      Securities_ConfirmPartialpayment.checkURL
      Securities_ConfirmPartialpayment.checkPageHeader()
      Securities_ConfirmPartialpayment.checkPageTitle()

      When("User selects radio button Yes on Securities ConfirmPartialpayment")
      Securities_ConfirmPartialpayment.waitForPageHeader
      Securities_ConfirmPartialpayment.clickRadioButton("Yes")

      And("User clicks continue on Securities ConfirmPartialpayment")
      Securities_ConfirmPartialpayment.waitForPageHeader
      Securities_ConfirmPartialpayment.clickContinueButton()

      Then("User is presented with the Securities Enter Claim Security Id Tax Code Page - A00 - Customs Duty")
      Securities_EnterClaimSecurityIdTaxCodePage.waitForPageHeader
      Securities_EnterClaimSecurityIdTaxCodePage.checkURL
      Securities_EnterClaimSecurityIdTaxCodePage.checkPageTitle("A00 - Customs Duty")

      When("User enters 500 on Securities Enter Claim Security Id Tax Code Page")
      Securities_EnterClaimSecurityIdTaxCodePage.waitForPageHeader
      Securities_EnterClaimSecurityIdTaxCodePage.enterDetails("500")

      And("User clicks continue on Securities Enter Claim Security Id Tax Code Page")
      Securities_EnterClaimSecurityIdTaxCodePage.waitForPageHeader
      Securities_EnterClaimSecurityIdTaxCodePage.clickContinueButton()

      Then("User is presented with the Securities CheckClaimPage")
      Securities_CheckClaimPage.waitForPageHeader
      Securities_CheckClaimPage.checkURL
      Securities_CheckClaimPage.checkPageHeader()
      Securities_CheckClaimPage.checkPageTitle()

      And("User clicks continue on Securities CheckClaimPage")
      Securities_CheckClaimPage.waitForPageHeader
      Securities_CheckClaimPage.clickContinueButton()

      Then("User is presented with the Securities Export Method Page")
      Securities_ExportMethodPage.waitForPageHeader
      Securities_ExportMethodPage.checkURL
      Securities_ExportMethodPage.checkPageHeader()
      Securities_ExportMethodPage.checkPageTitle()

      When("User selects radio button Exported in single or multiple shipments on Securities Export Method Page")
      Securities_ExportMethodPage.waitForPageHeader
      Securities_ExportMethodPage.clickRadioButton("Exported in single or multiple shipments")

      And("User clicks continue on Securities Export Method Page")
      Securities_ExportMethodPage.waitForPageHeader
      Securities_ExportMethodPage.clickContinueButton()

      Then("User is presented with the Securities Enter Export Movement Reference Number Multiple Page")
      Securities_EnterExportMovementReferenceNumberMultiplePage.waitForPageHeader
      Securities_EnterExportMovementReferenceNumberMultiplePage.checkURL
      Securities_EnterExportMovementReferenceNumberMultiplePage.checkPageHeader()
      Securities_EnterExportMovementReferenceNumberMultiplePage.checkPageTitle()

      When("User enters 41ABCDEFGHIJKLMNO1 on Securities Enter Export Movement Reference Number Multiple Page")
      Securities_EnterExportMovementReferenceNumberMultiplePage.waitForPageHeader
      Securities_EnterExportMovementReferenceNumberMultiplePage.enterDetails("41ABCDEFGHIJKLMNO1")

      And("User selects radio button No on Securities Enter Export Movement Reference Number Multiple Page")
      Securities_EnterExportMovementReferenceNumberMultiplePage.waitForPageHeader
      Securities_EnterExportMovementReferenceNumberMultiplePage.clickRadioButton("No")

      And("User clicks continue on Securities Enter Export Movement Reference Number Multiple Page")
      Securities_EnterExportMovementReferenceNumberMultiplePage.waitForPageHeader
      Securities_EnterExportMovementReferenceNumberMultiplePage.clickContinueButton()

      Then("User is presented with the Securities Choose Payee Type Page")
      Securities_ChoosePayeeTypePage.waitForPageHeader
      Securities_ChoosePayeeTypePage.checkURL
      Securities_ChoosePayeeTypePage.checkPageHeader()
      Securities_ChoosePayeeTypePage.checkPageTitle()

      And("User selects radio button Importer on Securities Choose Payee Type Page")
      Securities_ChoosePayeeTypePage.waitForPageHeader
      Securities_ChoosePayeeTypePage.clickRadioButton("Importer")

      When("User clicks continue on Securities Choose Payee Type Page")
      Securities_ChoosePayeeTypePage.waitForPageHeader
      Securities_ChoosePayeeTypePage.clickContinueButton()

      Then("User is presented with the Securities EnterBankAccountDetailsPage")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.checkURL
      Securities_EnterBankAccountDetailsPage.checkPageHeader()
      Securities_EnterBankAccountDetailsPage.checkPageTitle()

      And("User enters empty string on Securities EnterBankAccountDetailsPage")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.enterDetails("")

      When("User clicks continue on Securities EnterBankAccountDetailsPage")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.clickContinueButton()

      Then("User is presented with the Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.checkURL
      Securities_ChooseFileTypePage.checkPageHeader()
      Securities_ChooseFileTypePage.checkPageTitle()

      When("User selects radio button Import declaration on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickRadioButton("Import declaration")

      And("User clicks continue on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickContinueButton()

      Then("User is presented with the UDF Choose Files Page - import declaration")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.checkURL
      UDF_ChooseFilesPage.checkPageTitle("import declaration")

      When("User uploads a 1 document.pdf file on UDF Choose Files Page")
      UDF_ChooseFilesPage.uploadDocument(1, "document.pdf")
      UDF_ChooseFilesPage.waitForPageToLoad()

      And("User selects radio button Yes on UDF Choose Files Page")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.clickRadioButton("Yes")

      And("User clicks continue if I'm on UDF Choose Files Page")
      UDF_ChooseFilesPage.clickContinueButton()
      UDF_ChooseFilesPage.continuouslyClickContinue()

      Then("User is presented with the Securities Choose File Type Page again")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.checkURL
      Securities_ChooseFileTypePage.checkPageHeader()
      Securities_ChooseFileTypePage.checkPageTitle()

      When("User selects radio button Export declaration on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickRadioButton("Export declaration")

      And("User clicks continue on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickContinueButton()

      Then("User is presented with the UDF Choose Files Page - export declaration")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.checkURL
      UDF_ChooseFilesPage.checkPageTitle("export declaration")

      When("User uploads a 2 image.jpg file on UDF Choose Files Page")
      UDF_ChooseFilesPage.uploadDocument(2, "image.jpg")
      UDF_ChooseFilesPage.waitForPageToLoad()

      And("User selects radio button No on UDF Choose Files Page")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.clickRadioButton("No")

      When("User clicks continue if I'm on UDF Choose Files Page")
      UDF_ChooseFilesPage.clickContinueButton()
      UDF_ChooseFilesPage.continuouslyClickContinue()

      Then("User is presented with the Securities EnterAdditionalDetailsPage")
      Securities_EnterAdditionalDetailsPage.waitForPageHeader
      Securities_EnterAdditionalDetailsPage.checkURL
      Securities_EnterAdditionalDetailsPage.checkPageHeader()
      Securities_EnterAdditionalDetailsPage.checkPageTitle()

      When("User enters under 500 characters on Securities EnterAdditionalDetailsPage")
      Securities_EnterAdditionalDetailsPage.waitForPageHeader
      Securities_EnterAdditionalDetailsPage.enterDetails("under 500 characters")

      And("User clicks continue on Securities EnterAdditionalDetailsPage")
      Securities_EnterAdditionalDetailsPage.waitForPageHeader
      Securities_EnterAdditionalDetailsPage.clickContinueButton()

      Then("User is presented with the Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.checkURL
      Securities_ChangeContactDetailsPage.checkPageHeader()
      Securities_ChangeContactDetailsPage.checkPageTitle()

      And("User enters empty string on Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.enterDetails("")

      And("User clicks continue on Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.clickContinueButton()

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

      Then("User is presented with the Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.checkURL
      Securities_CheckYourAnswersPage.checkPageHeader()
      Securities_CheckYourAnswersPage.checkPageTitle()

      And("User should see the following details")
      val expectedData = Map(
        "Movement Reference Number (MRN)"    -> "01AAAAAAAAAAAAA110",
        "Do you want to claim back the full amount?" -> "No",
        "Uploaded files"                     -> "Import declaration:,document.pdf,Export declaration:,image.jpg",
        "Why was a security deposit needed?" -> "Temporary Admission (2 months)",
        "Address"                            -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Payee"                              -> "Importer",
        "Do you want to provide more detail?" -> "under 500 characters",
        "What did you do with the goods?"    -> "Exported in single shipment",
        "1st export MRN"                     -> "41ABCDEFGHIJKLMNO1",
        "Total"                              -> "£500.00",
        "What do you want to claim?"         -> "A00 - Customs Duty",
        "A00 - Customs Duty"                 -> "£500.00",
        "Personal details"                   -> "Mr John Smith,someemail@mail.com,01234567890",
        "Bank details"                       -> "Mr John Smith,123456,11001001"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      Securities_CheckYourAnswersPage.pageData should be(expectedData)
      When("User clicks continue on Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.clickContinueButton()

      Then("User is presented with the Securities Claim Submitted Page")
      Securities_ClaimSubmittedPage.waitForPageHeader
      Securities_ClaimSubmittedPage.checkURL
      Securities_ClaimSubmittedPage.checkPageHeader()
      Securities_ClaimSubmittedPage.checkPageTitle()
    }
  }
}
