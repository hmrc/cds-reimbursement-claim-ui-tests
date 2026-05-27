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
import uk.gov.hmrc.cdsrc.pages.common.ALF.{ALF_LookupAddressConfirmPage, ALF_LookupAddressEditPage, ALF_LookupAddressLookupPage}
import uk.gov.hmrc.cdsrc.pages.common.UDF.UDF_ChooseFilesPage
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class ChangeLinkTestsSpec extends BaseSpec {

  Feature("Securities Single Change Link Tests") {

    Scenario("Happy path - Change link tests") {

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

      When("User enters 01AAAAAAAAAAAAAAA1 on Securities Enter Movement Reference Number Page")
      Securities_EnterMovementReferenceNumberPage.waitForPageHeader
      Securities_EnterMovementReferenceNumberPage.enterDetails("01AAAAAAAAAAAAAAA1")

      And("User clicks continue on Securities Enter Movement Reference Number Page")
      Securities_EnterMovementReferenceNumberPage.waitForPageHeader
      Securities_EnterMovementReferenceNumberPage.clickContinueButton()

      Then("User is presented with the Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.checkURL
      Securities_ChooseReasonForSecurityPage.checkPageHeader()
      Securities_ChooseReasonForSecurityPage.checkPageTitle()

      When("User selects radio button Manual override of duty amount on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickRadioButton("Manual override of duty amount")

      And("User clicks continue on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickContinueButton()

      Then("User is presented with the Securities Select Securities Security Id Page - 1 of 5,ABC0123456")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.checkURL
      Securities_SelectSecuritiesSecurityIdPage.checkPageTitle("1 of 5,ABC0123456")

      When("User selects radio button yes on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickRadioButton("yes")

      And("User clicks continue on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickContinueButton()

      Then("User is presented with the Securities Select Securities Security Id Page - 2 of 5,DEF6543213")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.checkURL
      Securities_SelectSecuritiesSecurityIdPage.checkPageTitle("2 of 5,DEF6543213")

      When("User selects radio button yes on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickRadioButton("yes")

      And("User clicks continue on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickContinueButton()

      Then("User is presented with the Securities Select Securities Security Id Page - 3 of 5,DEF6543212")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.checkURL
      Securities_SelectSecuritiesSecurityIdPage.checkPageTitle("3 of 5,DEF6543212")

      When("User selects radio button no on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickRadioButton("no")

      And("User clicks continue on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickContinueButton()

      Then("User is presented with the Securities Select Securities Security Id Page - 4 of 5,DEF6543210")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.checkURL
      Securities_SelectSecuritiesSecurityIdPage.checkPageTitle("4 of 5,DEF6543210")

      When("User selects radio button no on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickRadioButton("no")

      And("User clicks continue on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickContinueButton()

      Then("User is presented with the Securities Select Securities Security Id Page - 5 of 5,DEF6543211")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.checkURL
      Securities_SelectSecuritiesSecurityIdPage.checkPageTitle("5 of 5,DEF6543211")

      When("User selects radio button no on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickRadioButton("no")

      And("User clicks continue on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickContinueButton()

      Then("User is presented with the Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.checkURL
      Securities_CheckDeclarationDetailsPage.checkPageHeader()
      Securities_CheckDeclarationDetailsPage.checkPageTitle()

      When("User clicks Change MRN on Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.clickButton("Change MRN")

      Then("User is presented with the Securities Enter Movement Reference Number Page")
      Securities_EnterMovementReferenceNumberPage.waitForPageHeader
      Securities_EnterMovementReferenceNumberPage.checkURL
      Securities_EnterMovementReferenceNumberPage.checkPageHeader()
      Securities_EnterMovementReferenceNumberPage.checkPageTitle()

      And("User clicks continue on Securities Enter Movement Reference Number Page")
      Securities_EnterMovementReferenceNumberPage.waitForPageHeader
      Securities_EnterMovementReferenceNumberPage.clickContinueButton()

      Then("User is presented with the Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.checkURL
      Securities_CheckDeclarationDetailsPage.checkPageHeader()
      Securities_CheckDeclarationDetailsPage.checkPageTitle()

      When("User clicks Change reason for security on Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.clickButton("Change reason for security")

      Then("User is presented with the Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.checkURL
      Securities_ChooseReasonForSecurityPage.checkPageHeader()
      Securities_ChooseReasonForSecurityPage.checkPageTitle()

      And("User clicks continue on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickContinueButton()

      Then("User is presented with the Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.checkURL
      Securities_CheckDeclarationDetailsPage.checkPageHeader()
      Securities_CheckDeclarationDetailsPage.checkPageTitle()

      When("User clicks Change claim for ABC0123456 on Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.clickButton("Change claim for ABC0123456")

      Then("User is presented with the Securities Select Securities Security Id Page1")
      Securities_SelectSecuritiesSecurityIdPage1.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage1.checkURL
      Securities_SelectSecuritiesSecurityIdPage1.checkPageHeader()
      Securities_SelectSecuritiesSecurityIdPage1.checkPageTitle()

      When("User selects radio button yes on Securities Select Securities Security Id Page1")
      Securities_SelectSecuritiesSecurityIdPage1.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage1.clickRadioButton("yes")

      And("User clicks continue on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickContinueButton()

      Then("User is presented with the Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.checkURL
      Securities_CheckDeclarationDetailsPage.checkPageHeader()
      Securities_CheckDeclarationDetailsPage.checkPageTitle()

      When("User clicks Change claim for DEF6543213 on Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.clickButton("Change claim for DEF6543213")

      Then("User is presented with the Securities Select Securities Security Id Page2")
      Securities_SelectSecuritiesSecurityIdPage2.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage2.checkURL
      Securities_SelectSecuritiesSecurityIdPage2.checkPageHeader()
      Securities_SelectSecuritiesSecurityIdPage2.checkPageTitle()

      When("User selects radio button no on Securities Select Securities Security Id Page2")
      Securities_SelectSecuritiesSecurityIdPage2.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage2.clickRadioButton("no")

      And("User clicks continue on Securities Select Securities Security Id Page2")
      Securities_SelectSecuritiesSecurityIdPage2.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage2.clickContinueButton()

      Then("User is presented with the Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.checkURL
      Securities_CheckDeclarationDetailsPage.checkPageHeader()
      Securities_CheckDeclarationDetailsPage.checkPageTitle()

      And("User clicks continue on Securities Check Declaration Details Page")
      Securities_CheckDeclarationDetailsPage.waitForPageHeader
      Securities_CheckDeclarationDetailsPage.clickContinueButton()

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

      Then("User is presented with the Securities Claimant Details Page")
      Securities_ClaimantDetailsChangeContactDetailsPage.waitForPageHeader
      Securities_ClaimantDetailsChangeContactDetailsPage.checkURL
      Securities_ClaimantDetailsChangeContactDetailsPage.checkPageHeader()
      Securities_ClaimantDetailsChangeContactDetailsPage.checkPageTitle()

      When("User clicks Change contact details on Securities Claimant Details Page")
      Securities_ClaimantDetailsChangeContactDetailsPage.waitForPageHeader
      Securities_ClaimantDetailsChangeContactDetailsPage.clickButton("Change contact details")

      Then("User is presented with the Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.checkURL
      Securities_ChangeContactDetailsPage.checkPageHeader()
      Securities_ChangeContactDetailsPage.checkPageTitle()

      And("User clicks continue on Securities Change Contact Details Page")
      Securities_ChangeContactDetailsPage.waitForPageHeader
      Securities_ChangeContactDetailsPage.clickContinueButton()

      Then("User is presented with the Securities Claimant Details Page")
      Securities_ClaimantDetailsChangeContactDetailsPage.waitForPageHeader
      Securities_ClaimantDetailsChangeContactDetailsPage.checkURL
      Securities_ClaimantDetailsChangeContactDetailsPage.checkPageHeader()
      Securities_ClaimantDetailsChangeContactDetailsPage.checkPageTitle()

      And("User clicks continue on Securities Claimant Details Page")
      Securities_ClaimantDetailsChangeContactDetailsPage.waitForPageHeader
      Securities_ClaimantDetailsChangeContactDetailsPage.clickContinueButton()

      Then("User is presented with the Securities Confirm Full Repayment Security Id Page3 - ABC0123456")
      Securities_ConfirmFullRepaymentSecurityIdPage3.waitForPageHeader
      Securities_ConfirmFullRepaymentSecurityIdPage3.checkURL
      Securities_ConfirmFullRepaymentSecurityIdPage3.checkPageTitle("ABC0123456")

      When("User selects radio button Yes on Securities Confirm Full Repayment Security Id Page3")
      Securities_ConfirmFullRepaymentSecurityIdPage3.waitForPageHeader
      Securities_ConfirmFullRepaymentSecurityIdPage3.clickRadioButton("Yes")

      And("User clicks continue on Securities Confirm Full Repayment Security Id Page3")
      Securities_ConfirmFullRepaymentSecurityIdPage3.waitForPageHeader
      Securities_ConfirmFullRepaymentSecurityIdPage3.clickContinueButton()

      Then("User is presented with the Securities Check Claim Page")
      Securities_CheckClaimPage.waitForPageHeader
      Securities_CheckClaimPage.checkURL
      Securities_CheckClaimPage.checkPageHeader()
      Securities_CheckClaimPage.checkPageTitle()

      And("User clicks continue on Securities Check Claim Page")
      Securities_CheckClaimPage.waitForPageHeader
      Securities_CheckClaimPage.clickContinueButton()

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

      Then("User is presented with the Securities Check Bank Details Page")
      Securities_CheckBankDetailsPage.waitForPageHeader
      Securities_CheckBankDetailsPage.checkURL
      Securities_CheckBankDetailsPage.checkPageHeader()
      Securities_CheckBankDetailsPage.checkPageTitle()

      When("User clicks Change bank details on Securities Check Bank Details Page")
      Securities_CheckBankDetailsPage.waitForPageHeader
      Securities_CheckBankDetailsPage.clickButton("Change bank details")

      Then("User is presented with the Securities Letter Of Authority Confirmation Page")
      Securities_LetterOfAuthorityConfirmationPage.waitForPageHeader
      Securities_LetterOfAuthorityConfirmationPage.checkURL
      Securities_LetterOfAuthorityConfirmationPage.checkPageHeader()
      Securities_LetterOfAuthorityConfirmationPage.checkPageTitle()

      When("User selects radio button Yes on Securities Letter Of Authority Confirmation Page")
      Securities_LetterOfAuthorityConfirmationPage.waitForPageHeader
      Securities_LetterOfAuthorityConfirmationPage.clickRadioButton("Yes")

      And("User clicks continue on Securities Letter Of Authority Confirmation Page")
      Securities_LetterOfAuthorityConfirmationPage.waitForPageHeader
      Securities_LetterOfAuthorityConfirmationPage.clickContinueButton()

      Then("User is presented with the Securities Choose Bank Account Type Page")
      Securities_ChooseBankAccountTypePage.waitForPageHeader
      Securities_ChooseBankAccountTypePage.checkURL
      Securities_ChooseBankAccountTypePage.checkPageHeader()
      Securities_ChooseBankAccountTypePage.checkPageTitle()

      When("User selects radio button Business bank account on Securities Choose Bank Account Type Page")
      Securities_ChooseBankAccountTypePage.waitForPageHeader
      Securities_ChooseBankAccountTypePage.clickRadioButton("Business bank account")

      And("User clicks continue on Securities Choose Bank Account Type Page")
      Securities_ChooseBankAccountTypePage.waitForPageHeader
      Securities_ChooseBankAccountTypePage.clickContinueButton()

      Then("User is presented with the Securities Enter Bank Account Details Page")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.checkURL
      Securities_EnterBankAccountDetailsPage.checkPageHeader()
      Securities_EnterBankAccountDetailsPage.checkPageTitle()

      When("User enters empty string on Securities Enter Bank Account Details Page")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.enterDetails("")

      And("User clicks continue on Securities Enter Bank Account Details Page")
      Securities_EnterBankAccountDetailsPage.waitForPageHeader
      Securities_EnterBankAccountDetailsPage.clickContinueButton()

      Then("User is presented with the Securities Check Bank Details Page")
      Securities_CheckBankDetailsPage.waitForPageHeader
      Securities_CheckBankDetailsPage.checkURL
      Securities_CheckBankDetailsPage.checkPageHeader()
      Securities_CheckBankDetailsPage.checkPageTitle()

      And("User selects radio button yes on Securities Check Bank Details Page")
      Securities_CheckBankDetailsPage.waitForPageHeader
      Securities_CheckBankDetailsPage.clickRadioButton("yes")

      And("User clicks continue on Securities Check Bank Details Page")
      Securities_CheckBankDetailsPage.waitForPageHeader
      Securities_CheckBankDetailsPage.clickContinueButton()

      Then("User is presented with the Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.checkURL
      Securities_ChooseFileTypePage.checkPageHeader()
      Securities_ChooseFileTypePage.checkPageTitle()

      When("User selects radio button Proof of authority on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickRadioButton("Proof of authority")

      And("User clicks continue on Securities Choose File Type Page")
      Securities_ChooseFileTypePage.waitForPageHeader
      Securities_ChooseFileTypePage.clickContinueButton()

      Then("User is presented with the UDF Choose Files Page - letter of authority")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.checkURL
      UDF_ChooseFilesPage.checkPageTitle("letter of authority")

      When("User uploads a 1 document.pdf file on UDF Choose Files Page")
      UDF_ChooseFilesPage.uploadDocument(1, "document.pdf")
      UDF_ChooseFilesPage.waitForPageToLoad()

      And("User selects radio button No on UDF Choose Files Page")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.clickRadioButton("No")

      And("User clicks continue if I'm on UDF Choose Files Page")
      UDF_ChooseFilesPage.clickContinueButton()
      UDF_ChooseFilesPage.continuouslyClickContinue()

      Then("User is presented with the Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.checkURL
      Securities_CheckYourAnswersPage.checkPageHeader()
      Securities_CheckYourAnswersPage.checkPageTitle()

      When("User clicks Change import MRN on Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.clickButton("Change import MRN")

      Then("User is presented with the Securities Enter Movement Reference Number Page")
      Securities_EnterMovementReferenceNumberPage.waitForPageHeader
      Securities_EnterMovementReferenceNumberPage.checkURL
      Securities_EnterMovementReferenceNumberPage.checkPageHeader()
      Securities_EnterMovementReferenceNumberPage.checkPageTitle()

      And("User clicks continue on Securities Enter Movement Reference Number Page")
      Securities_EnterMovementReferenceNumberPage.waitForPageHeader
      Securities_EnterMovementReferenceNumberPage.clickContinueButton()

      Then("User is presented with the Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.checkURL
      Securities_CheckYourAnswersPage.checkPageHeader()
      Securities_CheckYourAnswersPage.checkPageTitle()

      When("User clicks Change reason for security deposit on Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.clickButton("Change reason for security deposit")

      Then("User is presented with the Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.checkURL
      Securities_ChooseReasonForSecurityPage.checkPageHeader()
      Securities_ChooseReasonForSecurityPage.checkPageTitle()

      And("User clicks continue on Securities Choose Reason For Security Page")
      Securities_ChooseReasonForSecurityPage.waitForPageHeader
      Securities_ChooseReasonForSecurityPage.clickContinueButton()

      Then("User is presented with the Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.checkURL
      Securities_CheckYourAnswersPage.checkPageHeader()
      Securities_CheckYourAnswersPage.checkPageTitle()

      When("User clicks Change claim for ABC0123456 on Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.clickButton("Change claim for ABC0123456")

      Then("User is presented with the Securities Select Securities Security Id Page - 1 of 5,ABC0123456")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.checkURL
      Securities_SelectSecuritiesSecurityIdPage.checkPageTitle("1 of 5,ABC0123456")

      And("User clicks continue on Securities Select Securities Security Id Page")
      Securities_SelectSecuritiesSecurityIdPage.waitForPageHeader
      Securities_SelectSecuritiesSecurityIdPage.clickContinueButton()

      Then("User is presented with the Securities Check Your Answers Page")
      Securities_CheckYourAnswersPage.waitForPageHeader
      Securities_CheckYourAnswersPage.checkURL
      Securities_CheckYourAnswersPage.checkPageHeader()
      Securities_CheckYourAnswersPage.checkPageTitle()

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
