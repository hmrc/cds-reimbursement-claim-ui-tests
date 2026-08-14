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

package uk.gov.hmrc.cdsrc.specs.CE1179.single

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.CE1179.single._
import uk.gov.hmrc.cdsrc.pages.auth.AuthLoginStubPage
import uk.gov.hmrc.cdsrc.pages.common.{CheckEoriDetailsPage, SelectClaimTypePage}
import uk.gov.hmrc.cdsrc.pages.common.ALF.{ALF_LookupAddressConfirmPage, ALF_LookupAddressEditPage, ALF_LookupAddressLookupPage}
import uk.gov.hmrc.cdsrc.pages.common.UDF.UDF_ChooseFilesPage
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class CE1179SingleSpec extends BaseSpec {

  Feature("C&E1179 Single") {

    Scenario("happy path - check importer/declarant eori pages, change contact details, change bank details") {

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

      And("User selects radio button One MRN on CE1179 Choose How Many Mrns Page")
      CE1179_ChooseHowManyMrnsPage.waitForPageHeader
      CE1179_ChooseHowManyMrnsPage.clickRadioButton("One MRN")

      And("User clicks continue on CE1179 Choose How Many Mrns Page")
      CE1179_ChooseHowManyMrnsPage.waitForPageHeader
      CE1179_ChooseHowManyMrnsPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Have Your Supporting Document Ready Page v2")
      CE1179_Single_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      CE1179_Single_HaveYourSupportingDocumentReadyPagev2.checkURL
      CE1179_Single_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
      CE1179_Single_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()

      When("User clicks continue on CE1179 Single Have Your Supporting Document Ready Page v2")
      CE1179_Single_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      CE1179_Single_HaveYourSupportingDocumentReadyPagev2.clickContinue()

      Then("User is presented with the CE1179 Single Enter Movement Reference Number Page")
      CE1179_Single_EnterMovementReferenceNumberPage.waitForPageHeader
      CE1179_Single_EnterMovementReferenceNumberPage.checkURL
      CE1179_Single_EnterMovementReferenceNumberPage.checkPageHeader()
      CE1179_Single_EnterMovementReferenceNumberPage.checkPageTitle()

      When("User enters 10AAAAAAAAAAAAAAA2 on CE1179 Single Enter Movement Reference Number Page")
      CE1179_Single_EnterMovementReferenceNumberPage.waitForPageHeader
      CE1179_Single_EnterMovementReferenceNumberPage.enterDetails("10AAAAAAAAAAAAAAA2")

      And("User clicks continue on CE1179 Single Enter Movement Reference Number Page")
      CE1179_Single_EnterMovementReferenceNumberPage.waitForPageHeader
      CE1179_Single_EnterMovementReferenceNumberPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Enter Importer Eori Page")
      CE1179_Single_EnterImporterEoriPage.waitForPageHeader
      CE1179_Single_EnterImporterEoriPage.checkURL
      CE1179_Single_EnterImporterEoriPage.checkPageHeader()
      CE1179_Single_EnterImporterEoriPage.checkPageTitle()

      When("User enters GB000000000000002 on CE1179 Single Enter Importer Eori Page")
      CE1179_Single_EnterImporterEoriPage.waitForPageHeader
      CE1179_Single_EnterImporterEoriPage.enterDetails("GB000000000000002")

      And("User clicks continue on CE1179 Single Enter Importer Eori Page")
      CE1179_Single_EnterImporterEoriPage.waitForPageHeader
      CE1179_Single_EnterImporterEoriPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Enter Declarant Eori Page")
      CE1179_Single_EnterDeclarantEoriPage.waitForPageHeader
      CE1179_Single_EnterDeclarantEoriPage.checkURL
      CE1179_Single_EnterDeclarantEoriPage.checkPageHeader()
      CE1179_Single_EnterDeclarantEoriPage.checkPageTitle()

      When("User enters GB000000000000002 on CE1179 Single Enter Declarant Eori Page")
      CE1179_Single_EnterDeclarantEoriPage.waitForPageHeader
      CE1179_Single_EnterDeclarantEoriPage.enterDetails("GB000000000000002")

      And("User clicks continue on CE1179 Single Enter Declarant Eori Page")
      CE1179_Single_EnterDeclarantEoriPage.waitForPageHeader
      CE1179_Single_EnterDeclarantEoriPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Check Declaration Details Page")
      CE1179_Single_CheckDeclarationDetailsPage.waitForPageHeader
      CE1179_Single_CheckDeclarationDetailsPage.checkURL
      CE1179_Single_CheckDeclarationDetailsPage.checkPageHeader()
      CE1179_Single_CheckDeclarationDetailsPage.checkPageTitle()

      And("User clicks continue on CE1179 Single Check Declaration Details Page")
      CE1179_Single_CheckDeclarationDetailsPage.waitForPageHeader
      CE1179_Single_CheckDeclarationDetailsPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Choose Basis For Claim Page")
      CE1179_Single_ChooseBasisForClaimPage.waitForPageHeader
      CE1179_Single_ChooseBasisForClaimPage.checkURL
      CE1179_Single_ChooseBasisForClaimPage.checkPageHeader()
      CE1179_Single_ChooseBasisForClaimPage.checkPageTitle()

      When("User selects radio button Goods are not in accordance with contract on CE1179 Single Choose Basis For Claim Page")
      CE1179_Single_ChooseBasisForClaimPage.waitForPageHeader
      CE1179_Single_ChooseBasisForClaimPage.clickRadioButton("Goods are not in accordance with contract")

      And("User clicks continue on CE1179 Single Choose Basis For Claim Page")
      CE1179_Single_ChooseBasisForClaimPage.waitForPageHeader
      CE1179_Single_ChooseBasisForClaimPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Choose Disposal Method Page")
      CE1179_Single_ChooseDisposalMethodPage.waitForPageHeader
      CE1179_Single_ChooseDisposalMethodPage.checkURL
      CE1179_Single_ChooseDisposalMethodPage.checkPageHeader()
      CE1179_Single_ChooseDisposalMethodPage.checkPageTitle()

      When("User selects radio button Return the goods by road, rail, air or ship on CE1179 Single Choose Disposal Method Page")
      CE1179_Single_ChooseDisposalMethodPage.waitForPageHeader
      CE1179_Single_ChooseDisposalMethodPage.clickRadioButton("Return the goods by road, rail, air or ship")

      And("User clicks continue on CE1179 Single Choose Disposal Method Page")
      CE1179_Single_ChooseDisposalMethodPage.waitForPageHeader
      CE1179_Single_ChooseDisposalMethodPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Enter Rejected Goods Details Page")
      CE1179_Single_EnterRejectedGoodsDetailsPage.waitForPageHeader
      CE1179_Single_EnterRejectedGoodsDetailsPage.checkURL
      CE1179_Single_EnterRejectedGoodsDetailsPage.checkPageHeader()
      CE1179_Single_EnterRejectedGoodsDetailsPage.checkPageTitle()

      When("User enters under 500 characters on CE1179 Single Enter Rejected Goods Details Page")
      CE1179_Single_EnterRejectedGoodsDetailsPage.waitForPageHeader
      CE1179_Single_EnterRejectedGoodsDetailsPage.enterDetails("under 500 characters")

      And("User clicks continue on CE1179 Single Enter Rejected Goods Details Page")
      CE1179_Single_EnterRejectedGoodsDetailsPage.waitForPageHeader
      CE1179_Single_EnterRejectedGoodsDetailsPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Select Duties Page")
      CE1179_Single_SelectDutiesPage.waitForPageHeader
      CE1179_Single_SelectDutiesPage.checkURL
      CE1179_Single_SelectDutiesPage.checkPageHeader()
      CE1179_Single_SelectDutiesPage.checkPageTitle()

      When("User selects A80,A95,A90,A85 on CE1179 Single Select Duties Page")
      CE1179_Single_SelectDutiesPage.waitForPageHeader
      CE1179_Single_SelectDutiesPage.selectBoxes("A80,A95,A90,A85".split(","))

      And("User clicks continue on CE1179 Single Select Duties Page")
      CE1179_Single_SelectDutiesPage.waitForPageHeader
      CE1179_Single_SelectDutiesPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Enter Claim Page - A80 - Definitive Anti-Dumping Duty")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.checkURL
      CE1179_Single_EnterClaimPage.checkPageTitle("A80 - Definitive Anti-Dumping Duty")

      When("User enters 10 on CE1179 Single Enter Claim Page")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.enterDetails("10")

      And("User clicks continue on CE1179 Single Enter Claim Page")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Enter Claim Page - A95 - Provisional Countervailing Duty")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.checkURL
      CE1179_Single_EnterClaimPage.checkPageTitle("A95 - Provisional Countervailing Duty")

      When("User enters 10 on CE1179 Single Enter Claim Page")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.enterDetails("10")

      And("User clicks continue on CE1179 Single Enter Claim Page")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Enter Claim Page - A90 - Definitive Countervailing Duty")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.checkURL
      CE1179_Single_EnterClaimPage.checkPageTitle("A90 - Definitive Countervailing Duty")

      When("User enters 10 on CE1179 Single Enter Claim Page")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.enterDetails("10")

      And("User clicks continue on CE1179 Single Enter Claim Page")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Enter Claim Page - A85 - Provisional Anti-Dumping Duty")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.checkURL
      CE1179_Single_EnterClaimPage.checkPageTitle("A85 - Provisional Anti-Dumping Duty")

      When("User enters 10 on CE1179 Single Enter Claim Page")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.enterDetails("10")

      And("User clicks continue on CE1179 Single Enter Claim Page")
      CE1179_Single_EnterClaimPage.waitForPageHeader
      CE1179_Single_EnterClaimPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Check Claim Page")
      CE1179_Single_CheckClaimPage.waitForPageHeader
      CE1179_Single_CheckClaimPage.checkURL
      CE1179_Single_CheckClaimPage.checkPageHeader()
      CE1179_Single_CheckClaimPage.checkPageTitle()

      And("User clicks continue on CE1179 Single Check Claim Page")
      CE1179_Single_CheckClaimPage.waitForPageHeader
      CE1179_Single_CheckClaimPage.clickContinue()

      Then("User is presented with the CE1179 Single Enter Inspection Date Page")
      CE1179_Single_EnterInspectionDatePage.waitForPageHeader
      CE1179_Single_EnterInspectionDatePage.checkURL
      CE1179_Single_EnterInspectionDatePage.checkPageHeader()
      CE1179_Single_EnterInspectionDatePage.checkPageTitle()

      When("User enters 10,10,2020 on CE1179 Single Enter Inspection Date Page")
      CE1179_Single_EnterInspectionDatePage.waitForPageHeader
      CE1179_Single_EnterInspectionDatePage.enterDetails("10,10,2020")

      And("User clicks continue on CE1179 Single Enter Inspection Date Page")
      CE1179_Single_EnterInspectionDatePage.waitForPageHeader
      CE1179_Single_EnterInspectionDatePage.clickContinueButton()

      Then("User is presented with the CE1179 Single Inspection Address Choose Type Page")
      CE1179_Single_InspectionAddressChooseTypePage.waitForPageHeader
      CE1179_Single_InspectionAddressChooseTypePage.checkURL
      CE1179_Single_InspectionAddressChooseTypePage.checkPageHeader()
      CE1179_Single_InspectionAddressChooseTypePage.checkPageTitle()

      When("User selects radio button 11 Mount Road, London, E10 7PP on CE1179 Single Inspection Address Choose Type Page")
      CE1179_Single_InspectionAddressChooseTypePage.waitForPageHeader
      CE1179_Single_InspectionAddressChooseTypePage.clickRadioButton("11 Mount Road, London, E10 7PP")

      And("User clicks continue on CE1179 Single Inspection Address Choose Type Page")
      CE1179_Single_InspectionAddressChooseTypePage.waitForPageHeader
      CE1179_Single_InspectionAddressChooseTypePage.clickContinueButton()

      Then("User is presented with the CE1179 Single Choose Payee Type Page")
      CE1179_Single_ChoosePayeeTypePage.waitForPageHeader
      CE1179_Single_ChoosePayeeTypePage.checkURL
      CE1179_Single_ChoosePayeeTypePage.checkPageHeader()
      CE1179_Single_ChoosePayeeTypePage.checkPageTitle()

      And("User selects radio button Importer on CE1179 Single Choose Payee Type Page")
      CE1179_Single_ChoosePayeeTypePage.waitForPageHeader
      CE1179_Single_ChoosePayeeTypePage.clickRadioButton("Importer")

      When("User clicks continue on CE1179 Single Choose Payee Type Page")
      CE1179_Single_ChoosePayeeTypePage.waitForPageHeader
      CE1179_Single_ChoosePayeeTypePage.clickContinueButton()

      Then("User is presented with the CE1179 Single Enter Bank Account Details Page")
      CE1179_Single_EnterBankAccountDetailsPage.waitForPageHeader
      CE1179_Single_EnterBankAccountDetailsPage.checkURL
      CE1179_Single_EnterBankAccountDetailsPage.checkPageHeader()
      CE1179_Single_EnterBankAccountDetailsPage.checkPageTitle()

      When("User enters empty string on CE1179 Single Enter Bank Account Details Page")
      CE1179_Single_EnterBankAccountDetailsPage.waitForPageHeader
      CE1179_Single_EnterBankAccountDetailsPage.enterDetails("")

      And("User clicks continue on CE1179 Single Enter Bank Account Details Page")
      CE1179_Single_EnterBankAccountDetailsPage.waitForPageHeader
      CE1179_Single_EnterBankAccountDetailsPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Choose File Type Page")
      CE1179_Single_ChooseFileTypePage.waitForPageHeader
      CE1179_Single_ChooseFileTypePage.checkURL
      CE1179_Single_ChooseFileTypePage.checkPageHeader()
      CE1179_Single_ChooseFileTypePage.checkPageTitle()

      When("User selects radio button Commercial invoice on CE1179 Single Choose File Type Page")
      CE1179_Single_ChooseFileTypePage.waitForPageHeader
      CE1179_Single_ChooseFileTypePage.clickRadioButton("Commercial invoice")

      And("User clicks continue on CE1179 Single Choose File Type Page")
      CE1179_Single_ChooseFileTypePage.waitForPageHeader
      CE1179_Single_ChooseFileTypePage.clickContinueButton()

      Then("User is presented with the UDF Choose Files Page - commercial invoice")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.checkURL
      UDF_ChooseFilesPage.checkPageTitle("commercial invoice")

      When("User uploads a 1 document.pdf file on UDF Choose Files Page")
      UDF_ChooseFilesPage.uploadDocument(1, "document.pdf")
      UDF_ChooseFilesPage.waitForPageToLoad()

      And("User selects radio button Yes on UDF Choose Files Page")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.clickRadioButton("Yes")

      And("User clicks continue if I'm on UDF Choose Files Page")
      UDF_ChooseFilesPage.clickContinueButton()
      UDF_ChooseFilesPage.continuouslyClickContinue()

      Then("User is presented with the CE1179 Single Choose File Type Page again")
      CE1179_Single_ChooseFileTypePage.waitForPageHeader
      CE1179_Single_ChooseFileTypePage.checkURL
      CE1179_Single_ChooseFileTypePage.checkPageHeader()
      CE1179_Single_ChooseFileTypePage.checkPageTitle()

      When("User selects radio button Import or export declaration on CE1179 Single Choose File Type Page")
      CE1179_Single_ChooseFileTypePage.waitForPageHeader
      CE1179_Single_ChooseFileTypePage.clickRadioButton("Import or export declaration")

      And("User clicks continue on CE1179 Single Choose File Type Page")
      CE1179_Single_ChooseFileTypePage.waitForPageHeader
      CE1179_Single_ChooseFileTypePage.clickContinueButton()

      Then("User is presented with the UDF Choose Files Page - import or export declaration")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.checkURL
      UDF_ChooseFilesPage.checkPageTitle("import or export declaration")

      When("User uploads a 2 image.jpg file on UDF Choose Files Page")
      UDF_ChooseFilesPage.uploadDocument(2, "image.jpg")
      UDF_ChooseFilesPage.waitForPageToLoad()

      And("User selects radio button No on UDF Choose Files Page")
      UDF_ChooseFilesPage.waitForPageHeader
      UDF_ChooseFilesPage.clickRadioButton("No")

      And("User clicks continue if I'm on UDF Choose Files Page")
      UDF_ChooseFilesPage.clickContinueButton()
      UDF_ChooseFilesPage.continuouslyClickContinue()

      Then("User is presented with the CE1179 Single Claimant Details Change Claimant Details Page")
      CE1179_Single_ClaimantDetailsChangeClaimantDetailsPage.waitForPageHeader
      CE1179_Single_ClaimantDetailsChangeClaimantDetailsPage.checkURL
      CE1179_Single_ClaimantDetailsChangeClaimantDetailsPage.checkPageHeader()
      CE1179_Single_ClaimantDetailsChangeClaimantDetailsPage.checkPageTitle()

      And("User enters empty string on CE1179 Single Claimant Details Change Claimant Details Page")
      CE1179_Single_ClaimantDetailsChangeClaimantDetailsPage.waitForPageHeader
      CE1179_Single_ClaimantDetailsChangeClaimantDetailsPage.enterDetails("")

      And("User clicks continue on CE1179 Single Claimant Details Change Claimant Details Page")
      CE1179_Single_ClaimantDetailsChangeClaimantDetailsPage.waitForPageHeader
      CE1179_Single_ClaimantDetailsChangeClaimantDetailsPage.clickContinueButton()

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

      Then("User is presented with the CE1179 Single Check Your Answers Page")
      CE1179_Single_CheckYourAnswersPage.waitForPageHeader
      CE1179_Single_CheckYourAnswersPage.checkURL
      CE1179_Single_CheckYourAnswersPage.checkPageHeader()
      CE1179_Single_CheckYourAnswersPage.checkPageTitle()

      And("User should see the following details")
      val expectedData = Map(
        "Reason for claim"                       -> "Goods are not in accordance with contract",
        "Personal details"                        -> "Mr John Smith,someemail@mail.com,01234567890",
        "Uploaded files"                          -> "Commercial invoice:,document.pdf,Import or export declaration:,image.jpg",
        "Address"                                 -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Bank details"                            -> "Mr John Smith,123456,11001001",
        "Payee"                                   -> "Importer",
        "Total"                                   -> "£40.00",
        "Method"                                  -> "Bank account transfer",
        "What do you want to claim?"              -> "A80 - Definitive Anti-Dumping Duty,A95 - Provisional Countervailing Duty,A90 - Definitive Countervailing Duty,A85 - Provisional Anti-Dumping Duty",
        "Movement Reference Number (MRN)"         -> "10AAAAAAAAAAAAAAA2",
        "A85 - Provisional Anti-Dumping Duty"     -> "£10.00",
        "Inspection date"                         -> "10 October 2020",
        "A90 - Definitive Countervailing Duty"    -> "£10.00",
        "Additional claim information"            -> "under 500 characters",
        "A80 - Definitive Anti-Dumping Duty"      -> "£10.00",
        "Inspection address"                      -> "Importer address:,11 Mount Road,London,E10 7PP,United Kingdom",
        "A95 - Provisional Countervailing Duty"   -> "£10.00",
        "Disposal method"                         -> "Return the goods by road, rail, air or ship"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      CE1179_Single_CheckYourAnswersPage.pageData should be(expectedData)
      And("User clicks continue on CE1179 Single Check Your Answers Page")
      CE1179_Single_CheckYourAnswersPage.waitForPageHeader
      CE1179_Single_CheckYourAnswersPage.clickContinueButton()

      Then("User is presented with the CE1179 Single Claim Submitted Page")
      CE1179_Single_ClaimSubmittedPage.waitForPageHeader
      CE1179_Single_ClaimSubmittedPage.checkURL
      CE1179_Single_ClaimSubmittedPage.checkPageHeader()
      CE1179_Single_ClaimSubmittedPage.checkPageTitle()
    }
  }
}
