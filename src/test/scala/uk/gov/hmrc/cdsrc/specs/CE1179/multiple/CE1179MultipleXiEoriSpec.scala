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

package uk.gov.hmrc.cdsrc.specs.CE1179.multiple

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.CE1179.multiple._
import uk.gov.hmrc.cdsrc.pages.CE1179.single.CE1179_ChooseHowManyMrnsPage
import uk.gov.hmrc.cdsrc.pages.auth.AuthLoginStubPage
import uk.gov.hmrc.cdsrc.pages.common.{CheckEoriDetailsPage, SelectClaimTypePage}
import uk.gov.hmrc.cdsrc.pages.common.ALF.{ALF_LookupAddressConfirmPage, ALF_LookupAddressEditPage, ALF_LookupAddressLookupPage}
import uk.gov.hmrc.cdsrc.pages.common.UDF.UDF_ChooseFilesPage
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class CE1179MultipleXiEoriSpec extends BaseSpec {

  Feature("C&E1179 Multiple - XIEORI") {

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

      When("User selects radio button ce1179 on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickRadioButton("ce1179")

      And("User clicks continue on Select Claim Type Page")
      SelectClaimTypePage.waitForPageHeader
      SelectClaimTypePage.clickContinueButton()

      Then("User is presented with the CE1179 Choose How Many Mrns Page")
      CE1179_ChooseHowManyMrnsPage.waitForPageHeader
      CE1179_ChooseHowManyMrnsPage.checkURL
      CE1179_ChooseHowManyMrnsPage.checkPageHeader()
      CE1179_ChooseHowManyMrnsPage.checkPageTitle()

      When("User selects radio button Up to 20 MRNs on CE1179 Choose How Many Mrns Page")
      CE1179_ChooseHowManyMrnsPage.waitForPageHeader
      CE1179_ChooseHowManyMrnsPage.clickRadioButton("Up to 20 MRNs")

      And("User clicks continue on CE1179 Choose How Many Mrns Page")
      CE1179_ChooseHowManyMrnsPage.waitForPageHeader
      CE1179_ChooseHowManyMrnsPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Have Your Supporting Document Ready Page v2")
      CE1179_Multiple_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      CE1179_Multiple_HaveYourSupportingDocumentReadyPagev2.checkURL
      CE1179_Multiple_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
      CE1179_Multiple_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()

      When("User clicks continue on CE1179 Multiple Have Your Supporting Document Ready Page v2")
      CE1179_Multiple_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      CE1179_Multiple_HaveYourSupportingDocumentReadyPagev2.clickContinue()

      Then("User is presented with the CE1179 Multiple Enter Movement Reference Number Page")
      CE1179_Multiple_EnterMovementReferenceNumberPage.waitForPageHeader
      CE1179_Multiple_EnterMovementReferenceNumberPage.checkURL
      CE1179_Multiple_EnterMovementReferenceNumberPage.checkPageHeader()
      CE1179_Multiple_EnterMovementReferenceNumberPage.checkPageTitle()

      When("User enters 10XIDCAAAAAAAAAAA1 on CE1179 Multiple Enter Movement Reference Number Page")
      CE1179_Multiple_EnterMovementReferenceNumberPage.waitForPageHeader
      CE1179_Multiple_EnterMovementReferenceNumberPage.enterDetails("10XIDCAAAAAAAAAAA1")

      And("User clicks continue on CE1179 Multiple Enter Movement Reference Number Page")
      CE1179_Multiple_EnterMovementReferenceNumberPage.waitForPageHeader
      CE1179_Multiple_EnterMovementReferenceNumberPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Enter Importer Eori Page")
      CE1179_Multiple_EnterImporterEoriPage.waitForPageHeader
      CE1179_Multiple_EnterImporterEoriPage.checkURL
      CE1179_Multiple_EnterImporterEoriPage.checkPageHeader()
      CE1179_Multiple_EnterImporterEoriPage.checkPageTitle()

      When("User enters XI000000000000001 on CE1179 Multiple Enter Importer Eori Page")
      CE1179_Multiple_EnterImporterEoriPage.waitForPageHeader
      CE1179_Multiple_EnterImporterEoriPage.enterDetails("XI000000000000001")

      And("User clicks continue on CE1179 Multiple Enter Importer Eori Page")
      CE1179_Multiple_EnterImporterEoriPage.waitForPageHeader
      CE1179_Multiple_EnterImporterEoriPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Enter Declarant Eori Page")
      CE1179_Multiple_EnterDeclarantEoriPage.waitForPageHeader
      CE1179_Multiple_EnterDeclarantEoriPage.checkURL
      CE1179_Multiple_EnterDeclarantEoriPage.checkPageHeader()
      CE1179_Multiple_EnterDeclarantEoriPage.checkPageTitle()

      When("User enters XI000000000000001 on CE1179 Multiple Enter Declarant Eori Page")
      CE1179_Multiple_EnterDeclarantEoriPage.waitForPageHeader
      CE1179_Multiple_EnterDeclarantEoriPage.enterDetails("XI000000000000001")

      And("User clicks continue on CE1179 Multiple Enter Declarant Eori Page")
      CE1179_Multiple_EnterDeclarantEoriPage.waitForPageHeader
      CE1179_Multiple_EnterDeclarantEoriPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Check Declaration Details Page")
      CE1179_Multiple_CheckDeclarationDetailsPage.waitForPageHeader
      CE1179_Multiple_CheckDeclarationDetailsPage.checkURL
      CE1179_Multiple_CheckDeclarationDetailsPage.checkPageHeader()
      CE1179_Multiple_CheckDeclarationDetailsPage.checkPageTitle()

      And("User clicks continue on CE1179 Multiple Check Declaration Details Page")
      CE1179_Multiple_CheckDeclarationDetailsPage.waitForPageHeader
      CE1179_Multiple_CheckDeclarationDetailsPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Enter Movement Reference Number 2 Page")
      CE1179_Multiple_EnterMovementReferenceNumber2Page.waitForPageHeader
      CE1179_Multiple_EnterMovementReferenceNumber2Page.checkURL
      CE1179_Multiple_EnterMovementReferenceNumber2Page.checkPageHeader()
      CE1179_Multiple_EnterMovementReferenceNumber2Page.checkPageTitle()

      When("User enters 20XIDCAAAAAAAAAAA1 on CE1179 Multiple Enter Movement Reference Number 2 Page")
      CE1179_Multiple_EnterMovementReferenceNumber2Page.waitForPageHeader
      CE1179_Multiple_EnterMovementReferenceNumber2Page.enterDetails("20XIDCAAAAAAAAAAA1")

      And("User clicks continue on CE1179 Multiple Enter Movement Reference Number 2 Page")
      CE1179_Multiple_EnterMovementReferenceNumber2Page.waitForPageHeader
      CE1179_Multiple_EnterMovementReferenceNumber2Page.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Check Movement Reference Numbers Page")
      CE1179_Multiple_CheckMovementReferenceNumbersPage.waitForPageHeader
      CE1179_Multiple_CheckMovementReferenceNumbersPage.checkURL
      CE1179_Multiple_CheckMovementReferenceNumbersPage.checkPageHeader()
      CE1179_Multiple_CheckMovementReferenceNumbersPage.checkPageTitle()

      When("User selects radio button No on CE1179 Multiple Check Movement Reference Numbers Page")
      CE1179_Multiple_CheckMovementReferenceNumbersPage.waitForPageHeader
      CE1179_Multiple_CheckMovementReferenceNumbersPage.clickRadioButton("No")

      And("User clicks continue on CE1179 Multiple Check Movement Reference Numbers Page")
      CE1179_Multiple_CheckMovementReferenceNumbersPage.waitForPageHeader
      CE1179_Multiple_CheckMovementReferenceNumbersPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Choose Basis For Claim Page")
      CE1179_Multiple_ChooseBasisForClaimPage.waitForPageHeader
      CE1179_Multiple_ChooseBasisForClaimPage.checkURL
      CE1179_Multiple_ChooseBasisForClaimPage.checkPageHeader()
      CE1179_Multiple_ChooseBasisForClaimPage.checkPageTitle()

      When("User selects radio button Goods are defective on CE1179 Multiple Choose Basis For Claim Page")
      CE1179_Multiple_ChooseBasisForClaimPage.waitForPageHeader
      CE1179_Multiple_ChooseBasisForClaimPage.clickRadioButton("Goods are defective")

      And("User clicks continue on CE1179 Multiple Choose Basis For Claim Page")
      CE1179_Multiple_ChooseBasisForClaimPage.waitForPageHeader
      CE1179_Multiple_ChooseBasisForClaimPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Choose Disposal Method Page")
      CE1179_Multiple_ChooseDisposalMethodPage.waitForPageHeader
      CE1179_Multiple_ChooseDisposalMethodPage.checkURL
      CE1179_Multiple_ChooseDisposalMethodPage.checkPageHeader()
      CE1179_Multiple_ChooseDisposalMethodPage.checkPageTitle()

      When("User selects radio button Return the goods by road, rail, air or ship on CE1179 Multiple Choose Disposal Method Page")
      CE1179_Multiple_ChooseDisposalMethodPage.waitForPageHeader
      CE1179_Multiple_ChooseDisposalMethodPage.clickRadioButton("Return the goods by road, rail, air or ship")

      And("User clicks continue on CE1179 Multiple Choose Disposal Method Page")
      CE1179_Multiple_ChooseDisposalMethodPage.waitForPageHeader
      CE1179_Multiple_ChooseDisposalMethodPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Enter Rejected Goods Details Page")
      CE1179_Multiple_EnterRejectedGoodsDetailsPage.waitForPageHeader
      CE1179_Multiple_EnterRejectedGoodsDetailsPage.checkURL
      CE1179_Multiple_EnterRejectedGoodsDetailsPage.checkPageHeader()
      CE1179_Multiple_EnterRejectedGoodsDetailsPage.checkPageTitle()

      When("User enters under 500 characters on CE1179 Multiple Enter Rejected Goods Details Page")
      CE1179_Multiple_EnterRejectedGoodsDetailsPage.waitForPageHeader
      CE1179_Multiple_EnterRejectedGoodsDetailsPage.enterDetails("under 500 characters")

      And("User clicks continue on CE1179 Multiple Enter Rejected Goods Details Page")
      CE1179_Multiple_EnterRejectedGoodsDetailsPage.waitForPageHeader
      CE1179_Multiple_EnterRejectedGoodsDetailsPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Select Duties 1 Page")
      CE1179_Multiple_SelectDuties1Page.waitForPageHeader
      CE1179_Multiple_SelectDuties1Page.checkURL
      CE1179_Multiple_SelectDuties1Page.checkPageHeader()
      CE1179_Multiple_SelectDuties1Page.checkPageTitle()

      When("User selects A80,A95 on CE1179 Multiple Select Duties 1 Page")
      CE1179_Multiple_SelectDuties1Page.waitForPageHeader
      CE1179_Multiple_SelectDuties1Page.selectBoxes("A80,A95".split(","))

      And("User clicks continue on CE1179 Multiple Select Duties 1 Page")
      CE1179_Multiple_SelectDuties1Page.waitForPageHeader
      CE1179_Multiple_SelectDuties1Page.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Select Duties 1 Duty Page - A80 - Definitive Anti-Dumping Duty")
      CE1179_Multiple_SelectDuties1DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties1DutyPage.checkURL
      CE1179_Multiple_SelectDuties1DutyPage.checkPageTitle("A80 - Definitive Anti-Dumping Duty")

      When("User enters 10 on CE1179 Multiple Select Duties 1 Duty Page")
      CE1179_Multiple_SelectDuties1DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties1DutyPage.enterDetails("10")

      And("User clicks continue on CE1179 Multiple Select Duties 1 Duty Page")
      CE1179_Multiple_SelectDuties1DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties1DutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Select Duties 1 Duty Page - A95 - Provisional Countervailing Duty")
      CE1179_Multiple_SelectDuties1DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties1DutyPage.checkURL
      CE1179_Multiple_SelectDuties1DutyPage.checkPageTitle("A95 - Provisional Countervailing Duty")

      When("User enters 10 on CE1179 Multiple Select Duties 1 Duty Page")
      CE1179_Multiple_SelectDuties1DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties1DutyPage.enterDetails("10")

      And("User clicks continue on CE1179 Multiple Select Duties 1 Duty Page")
      CE1179_Multiple_SelectDuties1DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties1DutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Select Duties 2 Page")
      CE1179_Multiple_SelectDuties2Page.waitForPageHeader
      CE1179_Multiple_SelectDuties2Page.checkURL
      CE1179_Multiple_SelectDuties2Page.checkPageHeader()
      CE1179_Multiple_SelectDuties2Page.checkPageTitle()

      When("User selects A90,A85 on CE1179 Multiple Select Duties 2 Page")
      CE1179_Multiple_SelectDuties2Page.waitForPageHeader
      CE1179_Multiple_SelectDuties2Page.selectBoxes("A90,A85".split(","))

      And("User clicks continue on CE1179 Multiple Select Duties 2 Page")
      CE1179_Multiple_SelectDuties2Page.waitForPageHeader
      CE1179_Multiple_SelectDuties2Page.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Select Duties 2 Duty Page - A90 - Definitive Countervailing Duty")
      CE1179_Multiple_SelectDuties2DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties2DutyPage.checkURL
      CE1179_Multiple_SelectDuties2DutyPage.checkPageTitle("A90 - Definitive Countervailing Duty")

      When("User enters 10 on CE1179 Multiple Select Duties 2 Duty Page")
      CE1179_Multiple_SelectDuties2DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties2DutyPage.enterDetails("10")

      And("User clicks continue on CE1179 Multiple Select Duties 2 Duty Page")
      CE1179_Multiple_SelectDuties2DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties2DutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Select Duties 2 Duty Page - A85 - Provisional Anti-Dumping Duty")
      CE1179_Multiple_SelectDuties2DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties2DutyPage.checkURL
      CE1179_Multiple_SelectDuties2DutyPage.checkPageTitle("A85 - Provisional Anti-Dumping Duty")

      When("User enters 10 on CE1179 Multiple Select Duties 2 Duty Page")
      CE1179_Multiple_SelectDuties2DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties2DutyPage.enterDetails("10")

      And("User clicks continue on CE1179 Multiple Select Duties 2 Duty Page")
      CE1179_Multiple_SelectDuties2DutyPage.waitForPageHeader
      CE1179_Multiple_SelectDuties2DutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Check Claim Page")
      CE1179_Multiple_CheckClaimPage.waitForPageHeader
      CE1179_Multiple_CheckClaimPage.checkURL
      CE1179_Multiple_CheckClaimPage.checkPageHeader()
      CE1179_Multiple_CheckClaimPage.checkPageTitle()

      When("User clicks continue on CE1179 Multiple Check Claim Page")
      CE1179_Multiple_CheckClaimPage.waitForPageHeader
      CE1179_Multiple_CheckClaimPage.clickContinue()

      Then("User is presented with the CE1179 Multiple Enter Inspection Date Page")
      CE1179_Multiple_EnterInspectionDatePage.waitForPageHeader
      CE1179_Multiple_EnterInspectionDatePage.checkURL
      CE1179_Multiple_EnterInspectionDatePage.checkPageHeader()
      CE1179_Multiple_EnterInspectionDatePage.checkPageTitle()

      When("User enters 10,10,2020 on CE1179 Multiple Enter Inspection Date Page")
      CE1179_Multiple_EnterInspectionDatePage.waitForPageHeader
      CE1179_Multiple_EnterInspectionDatePage.enterDetails("10,10,2020")

      And("User clicks continue on CE1179 Multiple Enter Inspection Date Page")
      CE1179_Multiple_EnterInspectionDatePage.waitForPageHeader
      CE1179_Multiple_EnterInspectionDatePage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Inspection Address Choose Type Page")
      CE1179_Multiple_InspectionAddressChooseTypePage.waitForPageHeader
      CE1179_Multiple_InspectionAddressChooseTypePage.checkURL
      CE1179_Multiple_InspectionAddressChooseTypePage.checkPageHeader()
      CE1179_Multiple_InspectionAddressChooseTypePage.checkPageTitle()

      When("User selects radio button 11 Mount Road, London, E10 7PP on CE1179 Multiple Inspection Address Choose Type Page")
      CE1179_Multiple_InspectionAddressChooseTypePage.waitForPageHeader
      CE1179_Multiple_InspectionAddressChooseTypePage.clickRadioButton("11 Mount Road, London, E10 7PP")

      And("User clicks continue on CE1179 Multiple Inspection Address Choose Type Page")
      CE1179_Multiple_InspectionAddressChooseTypePage.waitForPageHeader
      CE1179_Multiple_InspectionAddressChooseTypePage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Choose Payee Type Page")
      CE1179_Multiple_ChoosePayeeTypePage.waitForPageHeader
      CE1179_Multiple_ChoosePayeeTypePage.checkURL
      CE1179_Multiple_ChoosePayeeTypePage.checkPageHeader()
      CE1179_Multiple_ChoosePayeeTypePage.checkPageTitle()

      And("User selects radio button Importer on CE1179 Multiple Choose Payee Type Page")
      CE1179_Multiple_ChoosePayeeTypePage.waitForPageHeader
      CE1179_Multiple_ChoosePayeeTypePage.clickRadioButton("Importer")

      When("User clicks continue on CE1179 Multiple Choose Payee Type Page")
      CE1179_Multiple_ChoosePayeeTypePage.waitForPageHeader
      CE1179_Multiple_ChoosePayeeTypePage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Enter Bank Account Details Page")
      CE1179_Multiple_EnterBankAccountDetailsPage.waitForPageHeader
      CE1179_Multiple_EnterBankAccountDetailsPage.checkURL
      CE1179_Multiple_EnterBankAccountDetailsPage.checkPageHeader()
      CE1179_Multiple_EnterBankAccountDetailsPage.checkPageTitle()

      When("User enters empty string on CE1179 Multiple Enter Bank Account Details Page")
      CE1179_Multiple_EnterBankAccountDetailsPage.waitForPageHeader
      CE1179_Multiple_EnterBankAccountDetailsPage.enterDetails("")

      And("User clicks continue on CE1179 Multiple Enter Bank Account Details Page")
      CE1179_Multiple_EnterBankAccountDetailsPage.waitForPageHeader
      CE1179_Multiple_EnterBankAccountDetailsPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Choose File Type Page")
      CE1179_Multiple_ChooseFileTypePage.waitForPageHeader
      CE1179_Multiple_ChooseFileTypePage.checkURL
      CE1179_Multiple_ChooseFileTypePage.checkPageHeader()
      CE1179_Multiple_ChooseFileTypePage.checkPageTitle()

      When("User selects radio button Commercial invoice on CE1179 Multiple Choose File Type Page")
      CE1179_Multiple_ChooseFileTypePage.waitForPageHeader
      CE1179_Multiple_ChooseFileTypePage.clickRadioButton("Commercial invoice")

      And("User clicks continue on CE1179 Multiple Choose File Type Page")
      CE1179_Multiple_ChooseFileTypePage.waitForPageHeader
      CE1179_Multiple_ChooseFileTypePage.clickContinueButton()

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

      And("User clicks continue if I'm on UDF Choose Files Page")
      UDF_ChooseFilesPage.clickContinueButton()
      UDF_ChooseFilesPage.continuouslyClickContinue()

      Then("User is presented with the CE1179 Multiple Claimant Details Enter Contact Details Page")
      CE1179_Multiple_ClaimantDetailsEnterContactDetailsPage.waitForPageHeader
      CE1179_Multiple_ClaimantDetailsEnterContactDetailsPage.checkURL
      CE1179_Multiple_ClaimantDetailsEnterContactDetailsPage.checkPageHeader()
      CE1179_Multiple_ClaimantDetailsEnterContactDetailsPage.checkPageTitle()

      And("User enters empty string on CE1179 Multiple Claimant Details Enter Contact Details Page")
      CE1179_Multiple_ClaimantDetailsEnterContactDetailsPage.waitForPageHeader
      CE1179_Multiple_ClaimantDetailsEnterContactDetailsPage.enterDetails("")

      And("User clicks continue on CE1179 Multiple Claimant Details Enter Contact Details Page")
      CE1179_Multiple_ClaimantDetailsEnterContactDetailsPage.waitForPageHeader
      CE1179_Multiple_ClaimantDetailsEnterContactDetailsPage.clickContinueButton()

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

      Then("User is presented with the CE1179 Multiple Check Your Answers Page")
      CE1179_Multiple_CheckYourAnswersPage.waitForPageHeader
      CE1179_Multiple_CheckYourAnswersPage.checkURL
      CE1179_Multiple_CheckYourAnswersPage.checkPageHeader()
      CE1179_Multiple_CheckYourAnswersPage.checkPageTitle()

      And("User should see the following details")
      val expectedData = Map(
        "Reason for claim"                   -> "Goods are defective",
        "Personal details"                   -> "John Smith,john@smith.com,01234567890",
        "Uploaded files"                     -> "Commercial invoice:,document.pdf",
        "Address"                            -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Bank details"                       -> "Mr John Smith,123456,11001001",
        "Payee"                              -> "Importer",
        "Total"                              -> "£40.00",
        "2nd MRN20XIDCAAAAAAAAAAA1"          -> "£20.00",
        "1st MRN10XIDCAAAAAAAAAAA1"          -> "£20.00",
        "1st Movement Reference Number (MRN)" -> "10XIDCAAAAAAAAAAA1",
        "2nd MRN"                            -> "20XIDCAAAAAAAAAAA1",
        "Inspection date"                    -> "10 October 2020",
        "Additional claim information"       -> "under 500 characters",
        "Inspection address"                 -> "Importer address:,11 Mount Road,London,E10 7PP,United Kingdom",
        "Disposal method"                    -> "Return the goods by road, rail, air or ship"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      CE1179_Multiple_CheckYourAnswersPage.pageData should be(expectedData)
      And("User clicks continue on CE1179 Multiple Check Your Answers Page")
      CE1179_Multiple_CheckYourAnswersPage.waitForPageHeader
      CE1179_Multiple_CheckYourAnswersPage.clickContinueButton()

      Then("User is presented with the CE1179 Multiple Claim Submitted Page")
      CE1179_Multiple_ClaimSubmittedPage.waitForPageHeader
      CE1179_Multiple_ClaimSubmittedPage.checkURL
      CE1179_Multiple_ClaimSubmittedPage.checkPageHeader()
      CE1179_Multiple_ClaimSubmittedPage.checkPageTitle()
    }
  }
}
