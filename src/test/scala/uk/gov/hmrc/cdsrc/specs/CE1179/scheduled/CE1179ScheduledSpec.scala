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

package uk.gov.hmrc.cdsrc.specs.CE1179.scheduled

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.C285.scheduled_V2.C285_Scheduled_SelectDutiesExciseDutyPagev2
import uk.gov.hmrc.cdsrc.pages.CE1179.multiple.CE1179_Multiple_EnterSpecialCircumstancesPage
import uk.gov.hmrc.cdsrc.pages.CE1179.scheduled._
import uk.gov.hmrc.cdsrc.pages.auth.AuthLoginStubPage
import uk.gov.hmrc.cdsrc.pages.common.{CheckEoriDetailsPage, SelectClaimTypePage}
import uk.gov.hmrc.cdsrc.pages.common.ALF.{ALF_LookupAddressConfirmPage, ALF_LookupAddressEditPage, ALF_LookupAddressLookupPage}
import uk.gov.hmrc.cdsrc.pages.common.UDF.{UDF_ChooseFilePage, UDF_ChooseFilesPage}
import uk.gov.hmrc.cdsrc.pages.CE1179.single.CE1179_ChooseHowManyMrnsPage
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class CE1179ScheduledSpec extends BaseSpec {

  Feature("C&E1179 Scheduled") {

    Scenario("happy path - check importer/declarant eori pages, Special circumstances") {

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

      And("User selects radio button Upload a file with a list of MRNs on CE1179 Choose How Many Mrns Page")
      CE1179_ChooseHowManyMrnsPage.waitForPageHeader
      CE1179_ChooseHowManyMrnsPage.clickRadioButton("Upload a file with a list of MRNs")

      And("User clicks continue on CE1179 Choose How Many Mrns Page")
      CE1179_ChooseHowManyMrnsPage.waitForPageHeader
      CE1179_ChooseHowManyMrnsPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Have Your Supporting Document Ready Page v2")
      CE1179_Scheduled_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      CE1179_Scheduled_HaveYourSupportingDocumentReadyPagev2.checkURL
      CE1179_Scheduled_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
      CE1179_Scheduled_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()

      When("User clicks continue on CE1179 Scheduled Have Your Supporting Document Ready Page v2")
      CE1179_Scheduled_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
      CE1179_Scheduled_HaveYourSupportingDocumentReadyPagev2.clickContinue()

      Then("User is presented with the CE1179 Scheduled Enter Movement Reference Number Page")
      CE1179_Scheduled_EnterMovementReferenceNumberPage.waitForPageHeader
      CE1179_Scheduled_EnterMovementReferenceNumberPage.checkURL
      CE1179_Scheduled_EnterMovementReferenceNumberPage.checkPageHeader()
      CE1179_Scheduled_EnterMovementReferenceNumberPage.checkPageTitle()

      When("User enters 10AAAAAAAAAAAAAAA2 on CE1179 Scheduled Enter Movement Reference Number Page")
      CE1179_Scheduled_EnterMovementReferenceNumberPage.waitForPageHeader
      CE1179_Scheduled_EnterMovementReferenceNumberPage.enterDetails("10AAAAAAAAAAAAAAA2")

      And("User clicks continue on CE1179 Scheduled Enter Movement Reference Number Page")
      CE1179_Scheduled_EnterMovementReferenceNumberPage.waitForPageHeader
      CE1179_Scheduled_EnterMovementReferenceNumberPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Enter Importer Eori Page")
      CE1179_Scheduled_EnterImporterEoriPage.waitForPageHeader
      CE1179_Scheduled_EnterImporterEoriPage.checkURL
      CE1179_Scheduled_EnterImporterEoriPage.checkPageHeader()
      CE1179_Scheduled_EnterImporterEoriPage.checkPageTitle()

      When("User enters GB000000000000002 on CE1179 Scheduled Enter Importer Eori Page")
      CE1179_Scheduled_EnterImporterEoriPage.waitForPageHeader
      CE1179_Scheduled_EnterImporterEoriPage.enterDetails("GB000000000000002")

      And("User clicks continue on CE1179 Scheduled Enter Importer Eori Page")
      CE1179_Scheduled_EnterImporterEoriPage.waitForPageHeader
      CE1179_Scheduled_EnterImporterEoriPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Enter Declarant Eori Page")
      CE1179_Scheduled_EnterDeclarantEoriPage.waitForPageHeader
      CE1179_Scheduled_EnterDeclarantEoriPage.checkURL
      CE1179_Scheduled_EnterDeclarantEoriPage.checkPageHeader()
      CE1179_Scheduled_EnterDeclarantEoriPage.checkPageTitle()

      When("User enters GB000000000000002 on CE1179 Scheduled Enter Declarant Eori Page")
      CE1179_Scheduled_EnterDeclarantEoriPage.waitForPageHeader
      CE1179_Scheduled_EnterDeclarantEoriPage.enterDetails("GB000000000000002")

      And("User clicks continue on CE1179 Scheduled Enter Declarant Eori Page")
      CE1179_Scheduled_EnterDeclarantEoriPage.waitForPageHeader
      CE1179_Scheduled_EnterDeclarantEoriPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Check Declaration Details Page")
      CE1179_Scheduled_CheckDeclarationDetailsPage.waitForPageHeader
      CE1179_Scheduled_CheckDeclarationDetailsPage.checkURL
      CE1179_Scheduled_CheckDeclarationDetailsPage.checkPageHeader()
      CE1179_Scheduled_CheckDeclarationDetailsPage.checkPageTitle()

      And("User clicks continue on CE1179 Scheduled Check Declaration Details Page")
      CE1179_Scheduled_CheckDeclarationDetailsPage.waitForPageHeader
      CE1179_Scheduled_CheckDeclarationDetailsPage.clickContinueButton()

      Then("User is presented with the UDF Choose File Page")
      UDF_ChooseFilePage.waitForPageHeader
      UDF_ChooseFilePage.checkURL
      UDF_ChooseFilePage.checkPageHeader()
      UDF_ChooseFilePage.checkPageTitle()

      When("User uploads a 1 image.jpg file on UDF Choose File Page")
      UDF_ChooseFilePage.uploadDocument(1, "image.jpg")
      UDF_ChooseFilePage.waitForPageToLoad()

      And("User clicks continue if I'm on UDF Choose File Page")
      UDF_ChooseFilePage.clickContinueButton()
      UDF_ChooseFilePage.continuouslyClickContinue()

      Then("User is presented with the CE1179 Scheduled Choose Basis For Claim Page")
      CE1179_Scheduled_ChooseBasisForClaimPage.waitForPageHeader
      CE1179_Scheduled_ChooseBasisForClaimPage.checkURL
      CE1179_Scheduled_ChooseBasisForClaimPage.checkPageHeader()
      CE1179_Scheduled_ChooseBasisForClaimPage.checkPageTitle()

      When("User selects radio button Special circumstances on CE1179 Scheduled Choose Basis For Claim Page")
      CE1179_Scheduled_ChooseBasisForClaimPage.waitForPageHeader
      CE1179_Scheduled_ChooseBasisForClaimPage.clickRadioButton("Special circumstances")

      And("User clicks continue on CE1179 Scheduled Choose Basis For Claim Page")
      CE1179_Scheduled_ChooseBasisForClaimPage.waitForPageHeader
      CE1179_Scheduled_ChooseBasisForClaimPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Enter Special Circumstances Page")
      CE1179_Scheduled_EnterSpecialCircumstancesPage.waitForPageHeader
      CE1179_Scheduled_EnterSpecialCircumstancesPage.checkURL
      CE1179_Scheduled_EnterSpecialCircumstancesPage.checkPageHeader()
      CE1179_Scheduled_EnterSpecialCircumstancesPage.checkPageTitle()

      When("User enters under 500 characters on CE1179 Multiple Enter Special Circumstances Page")
      CE1179_Multiple_EnterSpecialCircumstancesPage.waitForPageHeader
      CE1179_Multiple_EnterSpecialCircumstancesPage.enterDetails("under 500 characters")

      And("User clicks continue on CE1179 Multiple Enter Special Circumstances Page")
      CE1179_Multiple_EnterSpecialCircumstancesPage.waitForPageHeader
      CE1179_Multiple_EnterSpecialCircumstancesPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Choose Disposal Method Page")
      CE1179_Scheduled_ChooseDisposalMethodPage.waitForPageHeader
      CE1179_Scheduled_ChooseDisposalMethodPage.checkURL
      CE1179_Scheduled_ChooseDisposalMethodPage.checkPageHeader()
      CE1179_Scheduled_ChooseDisposalMethodPage.checkPageTitle()

      When("User selects radio button Return the goods by road, rail, air or ship on CE1179 Scheduled Choose Disposal Method Page")
      CE1179_Scheduled_ChooseDisposalMethodPage.waitForPageHeader
      CE1179_Scheduled_ChooseDisposalMethodPage.clickRadioButton("Return the goods by road, rail, air or ship")

      And("User clicks continue on CE1179 Scheduled Choose Disposal Method Page")
      CE1179_Scheduled_ChooseDisposalMethodPage.waitForPageHeader
      CE1179_Scheduled_ChooseDisposalMethodPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Enter Rejected Goods Details Page")
      CE1179_Scheduled_EnterRejectedGoodsDetailsPage.waitForPageHeader
      CE1179_Scheduled_EnterRejectedGoodsDetailsPage.checkURL
      CE1179_Scheduled_EnterRejectedGoodsDetailsPage.checkPageHeader()
      CE1179_Scheduled_EnterRejectedGoodsDetailsPage.checkPageTitle()

      When("User enters under 500 characters on CE1179 Scheduled Enter Rejected Goods Details Page")
      CE1179_Scheduled_EnterRejectedGoodsDetailsPage.waitForPageHeader
      CE1179_Scheduled_EnterRejectedGoodsDetailsPage.enterDetails("under 500 characters")

      And("User clicks continue on CE1179 Scheduled Enter Rejected Goods Details Page")
      CE1179_Scheduled_EnterRejectedGoodsDetailsPage.waitForPageHeader
      CE1179_Scheduled_EnterRejectedGoodsDetailsPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Select Duty Types Page")
      CE1179_Scheduled_SelectDutiesSelectDutyTypesPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesSelectDutyTypesPage.checkURL
      CE1179_Scheduled_SelectDutiesSelectDutyTypesPage.checkPageHeader()
      CE1179_Scheduled_SelectDutiesSelectDutyTypesPage.checkPageTitle()

      When("User selects uk-duty,eu-duty,excise-duty on CE1179 Scheduled Select Duties Select Duty Types Page")
      CE1179_Scheduled_SelectDutiesSelectDutyTypesPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesSelectDutyTypesPage.selectBoxes("uk-duty,eu-duty,excise-duty".split(","))

      And("User clicks continue on CE1179 Scheduled Select Duties Select Duty Types Page")
      CE1179_Scheduled_SelectDutiesSelectDutyTypesPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesSelectDutyTypesPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Uk Duty Page")
      CE1179_Scheduled_SelectDutiesUkDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesUkDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesUkDutyPage.checkPageHeader()
      CE1179_Scheduled_SelectDutiesUkDutyPage.checkPageTitle()

      When("User selects A00,B00 on CE1179 Scheduled Select Duties Uk Duty Page")
      CE1179_Scheduled_SelectDutiesUkDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesUkDutyPage.selectBoxes("A00,B00".split(","))

      And("User clicks continue on CE1179 Scheduled Select Duties Uk Duty Page")
      CE1179_Scheduled_SelectDutiesUkDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesUkDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - A00-Customs Duty")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("A00-Customs Duty")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - B00-Value Added Tax (VAT)")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("B00-Value Added Tax (VAT)")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Eu Duty Page")
      CE1179_Scheduled_SelectDutiesEuDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesEuDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesEuDutyPage.checkPageHeader()
      CE1179_Scheduled_SelectDutiesEuDutyPage.checkPageTitle()

      When("User selects A50,B05 on CE1179 Scheduled Select Duties Eu Duty Page")
      CE1179_Scheduled_SelectDutiesEuDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesEuDutyPage.selectBoxes("A50,B05".split(","))

      And("User clicks continue on CE1179 Scheduled Select Duties Eu Duty Page")
      CE1179_Scheduled_SelectDutiesEuDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesEuDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - A50-Customs Duty")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("A50-Customs Duty")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - B05-Value Added Tax (VAT)")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("B05-Value Added Tax (VAT)")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Excise Duty Page v2")
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.waitForPageHeader
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.checkURL
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.checkPageHeader()
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.checkPageTitle()

      When("User selects beer,wine,made-wine,miscellaneous-road-fuels,tobacco,climate-change-levy on C285 Scheduled Select Duties Excise Duty Page v2")
      C285_Scheduled_SelectDutiesExciseDutyPagev2.waitForPageHeader
      C285_Scheduled_SelectDutiesExciseDutyPagev2.selectBoxes(
        "beer,wine,made-wine,miscellaneous-road-fuels,tobacco,climate-change-levy".split(",")
      )

      And("User clicks continue on CE1179 Scheduled Select Duties Excise Duty Page v2")
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.waitForPageHeader
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Beer Page")
      CE1179_Scheduled_SelectDutiesBeerPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesBeerPage.checkURL
      CE1179_Scheduled_SelectDutiesBeerPage.checkPageHeader()
      CE1179_Scheduled_SelectDutiesBeerPage.checkPageTitle()

      When("User selects 407,447 on CE1179 Scheduled Select Duties Excise Duty Page v2")
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.waitForPageHeader
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.selectBoxes("407,447".split(","))

      And("User clicks continue on CE1179 Scheduled Select Duties Excise Duty Page v2")
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.waitForPageHeader
      CE1179_Scheduled_SelectDutiesExciseDutyPagev2.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-407 Beer")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-407 Beer")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-447 Beer")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-447 Beer")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Wine Page")
      CE1179_Scheduled_SelectDutiesWinePage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesWinePage.checkURL
      CE1179_Scheduled_SelectDutiesWinePage.checkPageHeader()
      CE1179_Scheduled_SelectDutiesWinePage.checkPageTitle()

      When("User selects 411,415 on CE1179 Scheduled Select Duties Wine Page")
      CE1179_Scheduled_SelectDutiesWinePage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesWinePage.selectBoxes("411,415".split(","))

      And("User clicks continue on CE1179 Scheduled Select Duties Wine Page")
      CE1179_Scheduled_SelectDutiesWinePage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesWinePage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-411 Wine")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-411 Wine")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-415 Wine")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-415 Wine")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Made Wine Page")
      CE1179_Scheduled_SelectDutiesMadeWinePage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesMadeWinePage.checkURL
      CE1179_Scheduled_SelectDutiesMadeWinePage.checkPageHeader()
      CE1179_Scheduled_SelectDutiesMadeWinePage.checkPageTitle()

      When("User selects 421,429 on CE1179 Scheduled Select Duties Made Wine Page")
      CE1179_Scheduled_SelectDutiesMadeWinePage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesMadeWinePage.selectBoxes("421,429".split(","))

      And("User clicks continue on CE1179 Scheduled Select Duties Made Wine Page")
      CE1179_Scheduled_SelectDutiesMadeWinePage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesMadeWinePage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-421 Made-wine")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-421 Made-wine")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-429 Made-wine")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-429 Made-wine")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Miscellaneous Road Fuels Page")
      CE1179_Scheduled_SelectDutiesMiscellaneousRoadFuelsPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesMiscellaneousRoadFuelsPage.checkURL
      CE1179_Scheduled_SelectDutiesMiscellaneousRoadFuelsPage.checkPageHeader()
      CE1179_Scheduled_SelectDutiesMiscellaneousRoadFuelsPage.checkPageTitle()

      When("User selects 591,592 on CE1179 Scheduled Select Duties Miscellaneous Road Fuels Page")
      CE1179_Scheduled_SelectDutiesMiscellaneousRoadFuelsPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesMiscellaneousRoadFuelsPage.selectBoxes("591,592".split(","))

      And("User clicks continue on CE1179 Scheduled Select Duties Miscellaneous Road Fuels Page")
      CE1179_Scheduled_SelectDutiesMiscellaneousRoadFuelsPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesMiscellaneousRoadFuelsPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-591 Miscellaneous road fuels")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-591 Miscellaneous road fuels")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-592 Miscellaneous road fuels")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-592 Miscellaneous road fuels")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Tobacco Page")
      CE1179_Scheduled_SelectDutiesTobaccoPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesTobaccoPage.checkURL
      CE1179_Scheduled_SelectDutiesTobaccoPage.checkPageHeader()
      CE1179_Scheduled_SelectDutiesTobaccoPage.checkPageTitle()

      When("User selects 611,633 on CE1179 Scheduled Select Duties Tobacco Page")
      CE1179_Scheduled_SelectDutiesTobaccoPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesTobaccoPage.selectBoxes("611,633".split(","))

      And("User clicks continue on CE1179 Scheduled Select Duties Tobacco Page")
      CE1179_Scheduled_SelectDutiesTobaccoPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesTobaccoPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-611 Tobacco products")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-611 Tobacco products")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-633 Tobacco products")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-633 Tobacco products")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties Climate Change Levy Page")
      CE1179_Scheduled_SelectDutiesClimateChangeLevyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesClimateChangeLevyPage.checkURL
      CE1179_Scheduled_SelectDutiesClimateChangeLevyPage.checkPageHeader()
      CE1179_Scheduled_SelectDutiesClimateChangeLevyPage.checkPageTitle()

      When("User selects 99A,99D on CE1179 Scheduled Select Duties Climate Change Levy Page")
      CE1179_Scheduled_SelectDutiesClimateChangeLevyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesClimateChangeLevyPage.selectBoxes("99A,99D".split(","))

      And("User clicks continue on CE1179 Scheduled Select Duties Climate Change Levy Page")
      CE1179_Scheduled_SelectDutiesClimateChangeLevyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesClimateChangeLevyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-99A Climate Change Levy")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-99A Climate Change Levy")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Select Duties DutyType Duty Page - Excise Duty-99D Climate Change Levy")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkURL
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.checkPageTitle("Excise Duty-99D Climate Change Levy ")

      When("User enters 10,5 on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.enterDetails("10,5")

      And("User clicks continue on CE1179 Scheduled Select Duties DutyType Duty Page")
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.waitForPageHeader
      CE1179_Scheduled_SelectDutiesDutyTypeDutyPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Check Claim Page")
      CE1179_Scheduled_CheckClaimPage.waitForPageHeader
      CE1179_Scheduled_CheckClaimPage.checkURL
      CE1179_Scheduled_CheckClaimPage.checkPageHeader()
      CE1179_Scheduled_CheckClaimPage.checkPageTitle()

      And("User clicks continue on CE1179 Scheduled Check Claim Page")
      CE1179_Scheduled_CheckClaimPage.waitForPageHeader
      CE1179_Scheduled_CheckClaimPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Enter Inspection Date Page")
      CE1179_Scheduled_EnterInspectionDatePage.waitForPageHeader
      CE1179_Scheduled_EnterInspectionDatePage.checkURL
      CE1179_Scheduled_EnterInspectionDatePage.checkPageHeader()
      CE1179_Scheduled_EnterInspectionDatePage.checkPageTitle()

      When("User enters 10,10,2020 on CE1179 Scheduled Enter Inspection Date Page")
      CE1179_Scheduled_EnterInspectionDatePage.waitForPageHeader
      CE1179_Scheduled_EnterInspectionDatePage.enterDetails("10,10,2020")

      And("User clicks continue on CE1179 Scheduled Enter Inspection Date Page")
      CE1179_Scheduled_EnterInspectionDatePage.waitForPageHeader
      CE1179_Scheduled_EnterInspectionDatePage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Inspection Address Choose Type Page")
      CE1179_Scheduled_InspectionAddressChooseTypePage.waitForPageHeader
      CE1179_Scheduled_InspectionAddressChooseTypePage.checkURL
      CE1179_Scheduled_InspectionAddressChooseTypePage.checkPageHeader()
      CE1179_Scheduled_InspectionAddressChooseTypePage.checkPageTitle()

      When("User selects radio button 11 Mount Road, London, E10 7PP on CE1179 Scheduled Inspection Address Choose Type Page")
      CE1179_Scheduled_InspectionAddressChooseTypePage.waitForPageHeader
      CE1179_Scheduled_InspectionAddressChooseTypePage.clickRadioButton("11 Mount Road, London, E10 7PP")

      And("User clicks continue on CE1179 Scheduled Inspection Address Choose Type Page")
      CE1179_Scheduled_InspectionAddressChooseTypePage.waitForPageHeader
      CE1179_Scheduled_InspectionAddressChooseTypePage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Choose Payee Type Page")
      CE1179_Scheduled_ChoosePayeeTypePage.waitForPageHeader
      CE1179_Scheduled_ChoosePayeeTypePage.checkURL
      CE1179_Scheduled_ChoosePayeeTypePage.checkPageHeader()
      CE1179_Scheduled_ChoosePayeeTypePage.checkPageTitle()

      And("User selects radio button Importer on CE1179 Scheduled Choose Payee Type Page")
      CE1179_Scheduled_ChoosePayeeTypePage.waitForPageHeader
      CE1179_Scheduled_ChoosePayeeTypePage.clickRadioButton("Importer")

      When("User clicks continue on CE1179 Scheduled Choose Payee Type Page")
      CE1179_Scheduled_ChoosePayeeTypePage.waitForPageHeader
      CE1179_Scheduled_ChoosePayeeTypePage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Enter Bank Account Details Page")
      CE1179_Scheduled_EnterBankAccountDetailsPage.waitForPageHeader
      CE1179_Scheduled_EnterBankAccountDetailsPage.checkURL
      CE1179_Scheduled_EnterBankAccountDetailsPage.checkPageHeader()
      CE1179_Scheduled_EnterBankAccountDetailsPage.checkPageTitle()

      When("User enters empty string on CE1179 Scheduled Enter Bank Account Details Page")
      CE1179_Scheduled_EnterBankAccountDetailsPage.waitForPageHeader
      CE1179_Scheduled_EnterBankAccountDetailsPage.enterDetails("")

      And("User clicks continue on CE1179 Scheduled Enter Bank Account Details Page")
      CE1179_Scheduled_EnterBankAccountDetailsPage.waitForPageHeader
      CE1179_Scheduled_EnterBankAccountDetailsPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Choose File Type Page")
      CE1179_Scheduled_ChooseFileTypePage.waitForPageHeader
      CE1179_Scheduled_ChooseFileTypePage.checkURL
      CE1179_Scheduled_ChooseFileTypePage.checkPageHeader()
      CE1179_Scheduled_ChooseFileTypePage.checkPageTitle()

      When("User selects radio button Commercial invoice on CE1179 Scheduled Choose File Type Page")
      CE1179_Scheduled_ChooseFileTypePage.waitForPageHeader
      CE1179_Scheduled_ChooseFileTypePage.clickRadioButton("Commercial invoice")

      And("User clicks continue on CE1179 Scheduled Choose File Type Page")
      CE1179_Scheduled_ChooseFileTypePage.waitForPageHeader
      CE1179_Scheduled_ChooseFileTypePage.clickContinueButton()

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

      Then("User is presented with the CE1179 Scheduled Claimant Details Change Contact Details Page")
      CE1179_Scheduled_ClaimantDetailsChangeContactDetailsPage.waitForPageHeader
      CE1179_Scheduled_ClaimantDetailsChangeContactDetailsPage.checkURL
      CE1179_Scheduled_ClaimantDetailsChangeContactDetailsPage.checkPageHeader()
      CE1179_Scheduled_ClaimantDetailsChangeContactDetailsPage.checkPageTitle()

      And("User enters empty string on CE1179 Scheduled Claimant Details Change Contact Details Page")
      CE1179_Scheduled_ClaimantDetailsChangeContactDetailsPage.waitForPageHeader
      CE1179_Scheduled_ClaimantDetailsChangeContactDetailsPage.enterDetails("")

      And("User clicks continue on CE1179 Scheduled Claimant Details Change Contact Details Page")
      CE1179_Scheduled_ClaimantDetailsChangeContactDetailsPage.waitForPageHeader
      CE1179_Scheduled_ClaimantDetailsChangeContactDetailsPage.clickContinueButton()

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

      Then("User is presented with the CE1179 Scheduled Check Your Answers Page")
      CE1179_Scheduled_CheckYourAnswersPage.waitForPageHeader
      CE1179_Scheduled_CheckYourAnswersPage.checkURL
      CE1179_Scheduled_CheckYourAnswersPage.checkPageHeader()
      CE1179_Scheduled_CheckYourAnswersPage.checkPageTitle()

      And("User should see the following details")
      val expectedData = Map(
        "Reason for claim"                          -> "Special circumstances",
        "Personal details"                          -> "John Smith,john@smith.com,01234567890",
        "Uploaded files"                            -> "Commercial invoice:,document.pdf",
        "Address"                                   -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
        "Total"                                     -> "£80.00",
        "First Movement Reference Number (MRN)"     -> "10AAAAAAAAAAAAAAA2",
        "Inspection date"                           -> "10 October 2020",
        "UK duty"                                   -> "£10.00",
        "EU duty"                                   -> "£10.00",
        "Excise duty"                               -> "£60.00",
        "Additional claim information"              -> "under 500 characters",
        "Inspection address"                        -> "Importer address:,11 Mount Road,London,E10 7PP,United Kingdom",
        "Disposal method"                           -> "Return the goods by road, rail, air or ship",
        "Details of the special circumstances"      -> "under 500 characters",
        "Bank details"                              -> "Mr John Smith,123456,11001001",
        "Payee"                                     -> "Importer",
        "Claim summary document"                    -> "image.jpg"
      )
      expectedData.foreach { case (k, v) => info(s"- $k: $v") }
      CE1179_Scheduled_CheckYourAnswersPage.pageData should be(expectedData)
      And("User clicks continue on CE1179 Scheduled Check Your Answers Page")
      CE1179_Scheduled_CheckYourAnswersPage.waitForPageHeader
      CE1179_Scheduled_CheckYourAnswersPage.clickContinueButton()

      Then("User is presented with the CE1179 Scheduled Claim Submitted Page")
      CE1179_Scheduled_ClaimSubmittedPage.waitForPageHeader
      CE1179_Scheduled_ClaimSubmittedPage.checkURL
      CE1179_Scheduled_ClaimSubmittedPage.checkPageHeader()
      CE1179_Scheduled_ClaimSubmittedPage.checkPageTitle()
    }
  }
}
