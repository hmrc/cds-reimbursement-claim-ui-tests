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

package uk.gov.hmrc.cdsrc.specs.C285.scheduled_V2

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.C285.scheduled_V2._
import uk.gov.hmrc.cdsrc.pages.C285.single_v2.C285_ChooseHowManyMrnsPagev2
import uk.gov.hmrc.cdsrc.pages.auth.AuthLoginStubPage
import uk.gov.hmrc.cdsrc.pages.common.{CheckEoriDetailsPage, SelectClaimTypePage}
import uk.gov.hmrc.cdsrc.pages.common.ALF.{ALF_LookupAddressConfirmPage, ALF_LookupAddressEditPage, ALF_LookupAddressLookupPage}
import uk.gov.hmrc.cdsrc.pages.common.UDF.{UCDF_ChooseFileOtherPage, UDF_ChooseFilePage}
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class ScheduledV2Spec extends BaseSpec {

  private def loginAndNavigateToScheduled(): Unit = {
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
    C285_ChooseHowManyMrnsPagev2.clickRadioButton("schedule")
    C285_ChooseHowManyMrnsPagev2.waitForPageHeader
    C285_ChooseHowManyMrnsPagev2.clickContinueButton()

    C285_Scheduled_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
    C285_Scheduled_HaveYourSupportingDocumentReadyPagev2.checkURL
    C285_Scheduled_HaveYourSupportingDocumentReadyPagev2.checkPageHeader()
    C285_Scheduled_HaveYourSupportingDocumentReadyPagev2.checkPageTitle()
    C285_Scheduled_HaveYourSupportingDocumentReadyPagev2.waitForPageHeader
    C285_Scheduled_HaveYourSupportingDocumentReadyPagev2.clickContinue()
  }

  private def performDutySelection(): Unit = {
    C285_Scheduled_SelectDutiesSelectDutyTypesPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesSelectDutyTypesPagev2.checkURL
    C285_Scheduled_SelectDutiesSelectDutyTypesPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesSelectDutyTypesPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesSelectDutyTypesPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesSelectDutyTypesPagev2.selectBoxes("uk-duty,eu-duty,excise-duty".split(","))
    C285_Scheduled_SelectDutiesSelectDutyTypesPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesSelectDutyTypesPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesUkDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesUkDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesUkDutyPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesUkDutyPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesUkDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesUkDutyPagev2.selectBoxes("A00,B00".split(","))
    C285_Scheduled_SelectDutiesUkDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesUkDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("A00-Customs Duty")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("B00-Value Added Tax (VAT)")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesEuDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesEuDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesEuDutyPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesEuDutyPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesEuDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesEuDutyPagev2.selectBoxes("A50,B05".split(","))
    C285_Scheduled_SelectDutiesEuDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesEuDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("A50 - Customs Duty")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("B05 - Value Added Tax (VAT)")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesExciseDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesExciseDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesExciseDutyPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesExciseDutyPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesExciseDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesExciseDutyPagev2.selectBoxes("beer,wine,made-wine,low-alcohol-beverages,spirits,cider-perry,other-fermented-products,hydrocarbon-oils,biofuels,miscellaneous-road-fuels,tobacco,climate-change-levy".split(","))
    C285_Scheduled_SelectDutiesExciseDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesExciseDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesBeerPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesBeerPagev2.checkURL
    C285_Scheduled_SelectDutiesBeerPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesBeerPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesBeerPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesBeerPagev2.selectBoxes("407,447".split(","))
    C285_Scheduled_SelectDutiesBeerPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesBeerPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty -407 Beer")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-447 Beer")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesWinePagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesWinePagev2.checkURL
    C285_Scheduled_SelectDutiesWinePagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesWinePagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesWinePagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesWinePagev2.selectBoxes("411,415".split(","))
    C285_Scheduled_SelectDutiesWinePagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesWinePagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-411 Wine")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-415 Wine")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesMadeWinePagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesMadeWinePagev2.checkURL
    C285_Scheduled_SelectDutiesMadeWinePagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesMadeWinePagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesMadeWinePagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesMadeWinePagev2.selectBoxes("421,429".split(","))
    C285_Scheduled_SelectDutiesMadeWinePagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesMadeWinePagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-421 Made-wine")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-429 Made-wine")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesLowAlcoholBeveragesPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesLowAlcoholBeveragesPagev2.checkURL
    C285_Scheduled_SelectDutiesLowAlcoholBeveragesPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesLowAlcoholBeveragesPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesLowAlcoholBeveragesPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesLowAlcoholBeveragesPagev2.selectBoxes("301,431".split(","))
    C285_Scheduled_SelectDutiesLowAlcoholBeveragesPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesLowAlcoholBeveragesPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-301 Low alcohol beverages")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-431 Low alcohol beverages")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesSpiritsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesSpiritsPagev2.checkURL
    C285_Scheduled_SelectDutiesSpiritsPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesSpiritsPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesSpiritsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesSpiritsPagev2.selectBoxes("315,325".split(","))
    C285_Scheduled_SelectDutiesSpiritsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesSpiritsPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-315 Spirits")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-325 Spirits")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesCiderPerryPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesCiderPerryPagev2.checkURL
    C285_Scheduled_SelectDutiesCiderPerryPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesCiderPerryPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesCiderPerryPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesCiderPerryPagev2.selectBoxes("312,322".split(","))
    C285_Scheduled_SelectDutiesCiderPerryPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesCiderPerryPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-312 Cider and perry")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-322 Cider and perry")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesOtherFermentedProductsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesOtherFermentedProductsPagev2.checkURL
    C285_Scheduled_SelectDutiesOtherFermentedProductsPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesOtherFermentedProductsPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesOtherFermentedProductsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesOtherFermentedProductsPagev2.selectBoxes("314,324".split(","))
    C285_Scheduled_SelectDutiesOtherFermentedProductsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesOtherFermentedProductsPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-314 Other fermented products")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-324 Other fermented products")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.checkURL
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.selectBoxes("511,520".split(","))
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-511 Hydrocarbon oil")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-520 Hydrocarbon oil")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    // Biofuels - feature file uses Hydrocarbon Oils page name for select/continue steps
    C285_Scheduled_SelectDutiesBiofuelsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesBiofuelsPagev2.checkURL
    C285_Scheduled_SelectDutiesBiofuelsPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesBiofuelsPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.selectBoxes("589".split(","))
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesHydrocarbonOilsPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-589 Biofuels")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesMiscellaneousRoadFuelsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesMiscellaneousRoadFuelsPagev2.checkURL
    C285_Scheduled_SelectDutiesMiscellaneousRoadFuelsPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesMiscellaneousRoadFuelsPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesMiscellaneousRoadFuelsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesMiscellaneousRoadFuelsPagev2.selectBoxes("591,592".split(","))
    C285_Scheduled_SelectDutiesMiscellaneousRoadFuelsPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesMiscellaneousRoadFuelsPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-591 Miscellaneous road fuels")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-592 Miscellaneous road fuels")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesTobaccoPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesTobaccoPagev2.checkURL
    C285_Scheduled_SelectDutiesTobaccoPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesTobaccoPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesTobaccoPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesTobaccoPagev2.selectBoxes("611,633".split(","))
    C285_Scheduled_SelectDutiesTobaccoPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesTobaccoPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-611 Tobacco products")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-633 Tobacco products")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesClimateChangeLevyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesClimateChangeLevyPagev2.checkURL
    C285_Scheduled_SelectDutiesClimateChangeLevyPagev2.checkPageHeader()
    C285_Scheduled_SelectDutiesClimateChangeLevyPagev2.checkPageTitle()
    C285_Scheduled_SelectDutiesClimateChangeLevyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesClimateChangeLevyPagev2.selectBoxes("99A,99D".split(","))
    C285_Scheduled_SelectDutiesClimateChangeLevyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesClimateChangeLevyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-99A Climate Change Levy")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()

    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkURL
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.checkPageTitle("Excise Duty-99D Climate Change Levy")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.enterDetails("10,5")
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.waitForPageHeader
    C285_Scheduled_SelectDutiesDutyTypeDutyPagev2.clickContinueButton()
  }

  private def checkAnswersAndSubmit(mrn: String, payee: String, uploadedFile: String): Unit = {
    C285_Scheduled_CheckAnswersAcceptSendPagev2.waitForPageHeader
    C285_Scheduled_CheckAnswersAcceptSendPagev2.checkURL
    C285_Scheduled_CheckAnswersAcceptSendPagev2.checkPageHeader()
    C285_Scheduled_CheckAnswersAcceptSendPagev2.checkPageTitle()

    val expectedData = Map(
      "Reason for claim"               -> "Outward processing relief",
      "Personal details"               -> "Mr John Smith,someemail@mail.com,01234567890",
      "Uploaded files"                 -> s"Commercial invoice:,$uploadedFile",
      "Address"                        -> "12 Skybricks Road,Coventry,CV3 6EA,United Kingdom",
      "Bank details"                   -> "Mr John Smith,123456,11001001",
      "Payee"                          -> payee,
      "Additional claim information"   -> "under 500 characters",
      "EU duty"                        -> "£10.00",
      "UK duty"                        -> "£10.00",
      "Excise duty"                    -> "£115.00",
      "Total"                          -> "£135.00",
      "First Movement Reference Number (MRN)" -> mrn,
      "Claim summary document"         -> "image.jpg"
    )
    expectedData.foreach { case (k, v) => info(s"- $k: $v") }
    C285_Scheduled_CheckAnswersAcceptSendPagev2.pageData should be(expectedData)
    C285_Scheduled_CheckAnswersAcceptSendPagev2.waitForPageHeader
    C285_Scheduled_CheckAnswersAcceptSendPagev2.clickContinueButton()

    C285_Scheduled_ClaimSubmittedPagev2.waitForPageHeader
    C285_Scheduled_ClaimSubmittedPagev2.checkURL
    C285_Scheduled_ClaimSubmittedPagev2.checkPageHeader()
    C285_Scheduled_ClaimSubmittedPagev2.checkPageTitle()
  }

  Feature("C285 Scheduled") {

    Scenario("happy path - check importer/declarant eori pages") {

      Given("User navigates to the Auth Login Stub Page")
      loginAndNavigateToScheduled()

      Then("User is presented with the C285 Scheduled Enter Movement Reference Number Page v2")
      C285_Scheduled_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Scheduled_EnterMovementReferenceNumberPagev2.checkURL
      C285_Scheduled_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Scheduled_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 10AAAAAAAAAAAAAAA2 on C285 Scheduled Enter Movement Reference Number Page v2")
      C285_Scheduled_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Scheduled_EnterMovementReferenceNumberPagev2.enterDetails("10AAAAAAAAAAAAAAA2")

      And("User clicks continue on C285 Scheduled Enter Movement Reference Number Page v2")
      C285_Scheduled_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Scheduled_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Enter Importer Eori Page v2")
      C285_Scheduled_EnterImporterEoriPagev2.waitForPageHeader
      C285_Scheduled_EnterImporterEoriPagev2.checkURL
      C285_Scheduled_EnterImporterEoriPagev2.checkPageHeader()
      C285_Scheduled_EnterImporterEoriPagev2.checkPageTitle()

      When("User enters GB000000000000002 on C285 Scheduled Enter Importer Eori Page v2")
      C285_Scheduled_EnterImporterEoriPagev2.waitForPageHeader
      C285_Scheduled_EnterImporterEoriPagev2.enterDetails("GB000000000000002")

      And("User clicks continue on C285 Scheduled Enter Importer Eori Page v2")
      C285_Scheduled_EnterImporterEoriPagev2.waitForPageHeader
      C285_Scheduled_EnterImporterEoriPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Enter Declarant Eori Page v2")
      C285_Scheduled_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Scheduled_EnterDeclarantEoriPagev2.checkURL
      C285_Scheduled_EnterDeclarantEoriPagev2.checkPageHeader()
      C285_Scheduled_EnterDeclarantEoriPagev2.checkPageTitle()

      When("User enters GB000000000000002 on C285 Scheduled Enter Declarant Eori Page v2")
      C285_Scheduled_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Scheduled_EnterDeclarantEoriPagev2.enterDetails("GB000000000000002")

      And("User clicks continue on C285 Scheduled Enter Declarant Eori Page v2")
      C285_Scheduled_EnterDeclarantEoriPagev2.waitForPageHeader
      C285_Scheduled_EnterDeclarantEoriPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Check Declaration Details Page v2")
      C285_Scheduled_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Scheduled_CheckDeclarationDetailsPagev2.checkURL
      C285_Scheduled_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Scheduled_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Scheduled Check Declaration Details Page v2")
      C285_Scheduled_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Scheduled_CheckDeclarationDetailsPagev2.clickContinueButton()

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

      Then("User is presented with the C285 Scheduled Choose Basis For Claim Page v2")
      C285_Scheduled_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Scheduled_ChooseBasisForClaimPagev2.checkURL
      C285_Scheduled_ChooseBasisForClaimPagev2.checkPageHeader()
      C285_Scheduled_ChooseBasisForClaimPagev2.checkPageTitle()

      When("User selects radio button Outward processing relief on C285 Scheduled Choose Basis For Claim Page v2")
      C285_Scheduled_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Scheduled_ChooseBasisForClaimPagev2.clickRadioButton("Outward processing relief")

      And("User clicks continue on C285 Scheduled Choose Basis For Claim Page v2")
      C285_Scheduled_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Scheduled_ChooseBasisForClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Enter Additional Details Page v2")
      C285_Scheduled_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterAdditionalDetailsPagev2.checkURL
      C285_Scheduled_EnterAdditionalDetailsPagev2.checkPageHeader()
      C285_Scheduled_EnterAdditionalDetailsPagev2.checkPageTitle()

      When("User enters under 500 characters on C285 Scheduled Enter Additional Details Page v2")
      C285_Scheduled_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterAdditionalDetailsPagev2.enterDetails("under 500 characters")

      And("User clicks continue on C285 Scheduled Enter Additional Details Page v2")
      C285_Scheduled_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterAdditionalDetailsPagev2.clickContinueButton()

      And("User selects all duties")
      performDutySelection()

      Then("User is presented with the C285 Scheduled Check Claim Page v2")
      C285_Scheduled_CheckClaimPagev2.waitForPageHeader
      C285_Scheduled_CheckClaimPagev2.checkURL
      C285_Scheduled_CheckClaimPagev2.checkPageHeader()
      C285_Scheduled_CheckClaimPagev2.checkPageTitle()

      And("User clicks continue on C285 Scheduled Check Claim Page v2")
      C285_Scheduled_CheckClaimPagev2.waitForPageHeader
      C285_Scheduled_CheckClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Choose Payee Type v2")
      C285_Scheduled_ChoosePayeeTypev2.waitForPageHeader
      C285_Scheduled_ChoosePayeeTypev2.checkURL
      C285_Scheduled_ChoosePayeeTypev2.checkPageHeader()
      C285_Scheduled_ChoosePayeeTypev2.checkPageTitle()

      And("User selects radio button Importer on C285 Scheduled Choose Payee Type v2")
      C285_Scheduled_ChoosePayeeTypev2.waitForPageHeader
      C285_Scheduled_ChoosePayeeTypev2.clickRadioButton("Importer")

      When("User clicks continue on C285 Scheduled Choose Payee Type v2")
      C285_Scheduled_ChoosePayeeTypev2.waitForPageHeader
      C285_Scheduled_ChoosePayeeTypev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Enter Bank Account Details Page v2")
      C285_Scheduled_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterBankAccountDetailsPagev2.checkURL
      C285_Scheduled_EnterBankAccountDetailsPagev2.checkPageHeader()
      C285_Scheduled_EnterBankAccountDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Scheduled Enter Bank Account Details Page v2")
      C285_Scheduled_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterBankAccountDetailsPagev2.enterDetails("")

      When("User clicks continue on C285 Scheduled Enter Bank Account Details Page v2")
      C285_Scheduled_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterBankAccountDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()

      When("User selects radio button Commercial invoice on C285 Scheduled Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Commercial invoice")

      And("User clicks continue on C285 Scheduled Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

      Then("User is presented with the UCDF Choose File Other Page - commercial invoice")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("commercial invoice")

      When("User uploads a 1 document.doc file on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.uploadDocument(1, "document.doc")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()

      And("User selects radio button No on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("No")

      And("User clicks continue if I'm on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.clickContinueButton()
      UCDF_ChooseFileOtherPage.continuouslyClickContinue()

      Then("User is presented with the C285 Scheduled Claimant Details Change Claimant Details Page v2")
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.checkURL
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageHeader()
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Scheduled Claimant Details Change Claimant Details Page v2")
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.enterDetails("")

      And("User clicks continue on C285 Scheduled Claimant Details Change Claimant Details Page v2")
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.clickContinueButton()

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

      And("User should see the following details and submit")
      checkAnswersAndSubmit("10AAAAAAAAAAAAAAA2", "Importer", "document.doc")
    }

    Scenario("happy path - with no bank details (user is both importer and declarant)") {

      Given("User navigates to the Auth Login Stub Page")
      loginAndNavigateToScheduled()

      Then("User is presented with the C285 Scheduled Enter Movement Reference Number Page v2")
      C285_Scheduled_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Scheduled_EnterMovementReferenceNumberPagev2.checkURL
      C285_Scheduled_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Scheduled_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 60AAAAAAAAAAAAAAA1 on C285 Scheduled Enter Movement Reference Number Page v2")
      C285_Scheduled_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Scheduled_EnterMovementReferenceNumberPagev2.enterDetails("60AAAAAAAAAAAAAAA1")

      And("User clicks continue on C285 Scheduled Enter Movement Reference Number Page v2")
      C285_Scheduled_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Scheduled_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Check Declaration Details Page v2")
      C285_Scheduled_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Scheduled_CheckDeclarationDetailsPagev2.checkURL
      C285_Scheduled_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Scheduled_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Scheduled Check Declaration Details Page v2")
      C285_Scheduled_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Scheduled_CheckDeclarationDetailsPagev2.clickContinueButton()

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

      Then("User is presented with the C285 Scheduled Choose Basis For Claim Page v2")
      C285_Scheduled_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Scheduled_ChooseBasisForClaimPagev2.checkURL
      C285_Scheduled_ChooseBasisForClaimPagev2.checkPageHeader()
      C285_Scheduled_ChooseBasisForClaimPagev2.checkPageTitle()

      When("User selects radio button Outward processing relief on C285 Scheduled Choose Basis For Claim Page v2")
      C285_Scheduled_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Scheduled_ChooseBasisForClaimPagev2.clickRadioButton("Outward processing relief")

      And("User clicks continue on C285 Scheduled Choose Basis For Claim Page v2")
      C285_Scheduled_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Scheduled_ChooseBasisForClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Enter Additional Details Page v2")
      C285_Scheduled_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterAdditionalDetailsPagev2.checkURL
      C285_Scheduled_EnterAdditionalDetailsPagev2.checkPageHeader()
      C285_Scheduled_EnterAdditionalDetailsPagev2.checkPageTitle()

      When("User enters under 500 characters on C285 Scheduled Enter Additional Details Page v2")
      C285_Scheduled_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterAdditionalDetailsPagev2.enterDetails("under 500 characters")

      And("User clicks continue on C285 Scheduled Enter Additional Details Page v2")
      C285_Scheduled_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterAdditionalDetailsPagev2.clickContinueButton()

      And("User selects all duties")
      performDutySelection()

      Then("User is presented with the C285 Scheduled Check Claim Page v2")
      C285_Scheduled_CheckClaimPagev2.waitForPageHeader
      C285_Scheduled_CheckClaimPagev2.checkURL
      C285_Scheduled_CheckClaimPagev2.checkPageHeader()
      C285_Scheduled_CheckClaimPagev2.checkPageTitle()

      And("User clicks continue on C285 Scheduled Check Claim Page v2")
      C285_Scheduled_CheckClaimPagev2.waitForPageHeader
      C285_Scheduled_CheckClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Choose Payee Type v2")
      C285_Scheduled_ChoosePayeeTypev2.waitForPageHeader
      C285_Scheduled_ChoosePayeeTypev2.checkURL
      C285_Scheduled_ChoosePayeeTypev2.checkPageHeader()
      C285_Scheduled_ChoosePayeeTypev2.checkPageTitle()

      And("User selects radio button Importer on C285 Scheduled Choose Payee Type v2")
      C285_Scheduled_ChoosePayeeTypev2.waitForPageHeader
      C285_Scheduled_ChoosePayeeTypev2.clickRadioButton("Importer")

      When("User clicks continue on C285 Scheduled Choose Payee Type v2")
      C285_Scheduled_ChoosePayeeTypev2.waitForPageHeader
      C285_Scheduled_ChoosePayeeTypev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Enter Bank Account Details Page v2")
      C285_Scheduled_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterBankAccountDetailsPagev2.checkURL
      C285_Scheduled_EnterBankAccountDetailsPagev2.checkPageHeader()
      C285_Scheduled_EnterBankAccountDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Scheduled Enter Bank Account Details Page v2")
      C285_Scheduled_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterBankAccountDetailsPagev2.enterDetails("")

      When("User clicks continue on C285 Scheduled Enter Bank Account Details Page v2")
      C285_Scheduled_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterBankAccountDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()

      When("User selects radio button Commercial invoice on C285 Scheduled Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Commercial invoice")

      And("User clicks continue on C285 Scheduled Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

      Then("User is presented with the UCDF Choose File Other Page - commercial invoice")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("commercial invoice")

      When("User uploads a 1 document.pdf file on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.uploadDocument(1, "document.pdf")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()

      And("User selects radio button No on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("No")

      And("User clicks continue if I'm on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.clickContinueButton()
      UCDF_ChooseFileOtherPage.continuouslyClickContinue()

      Then("User is presented with the C285 Scheduled Claimant Details Change Claimant Details Page v2")
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.checkURL
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageHeader()
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Scheduled Claimant Details Change Claimant Details Page v2")
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.enterDetails("")

      And("User clicks continue on C285 Scheduled Claimant Details Change Claimant Details Page v2")
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.clickContinueButton()

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

      And("User should see the following details and submit")
      checkAnswersAndSubmit("60AAAAAAAAAAAAAAA1", "Importer", "document.pdf")
    }

    Scenario("happy path with new payee type page - user with only importer bank details and selects declarant user - CMA not eligible") {

      Given("User navigates to the Auth Login Stub Page")
      loginAndNavigateToScheduled()

      Then("User is presented with the C285 Scheduled Enter Movement Reference Number Page v2")
      C285_Scheduled_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Scheduled_EnterMovementReferenceNumberPagev2.checkURL
      C285_Scheduled_EnterMovementReferenceNumberPagev2.checkPageHeader()
      C285_Scheduled_EnterMovementReferenceNumberPagev2.checkPageTitle()

      When("User enters 60AAAAAAAAAAAAAAA5 on C285 Scheduled Enter Movement Reference Number Page v2")
      C285_Scheduled_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Scheduled_EnterMovementReferenceNumberPagev2.enterDetails("60AAAAAAAAAAAAAAA5")

      And("User clicks continue on C285 Scheduled Enter Movement Reference Number Page v2")
      C285_Scheduled_EnterMovementReferenceNumberPagev2.waitForPageHeader
      C285_Scheduled_EnterMovementReferenceNumberPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Check Declaration Details Page v2")
      C285_Scheduled_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Scheduled_CheckDeclarationDetailsPagev2.checkURL
      C285_Scheduled_CheckDeclarationDetailsPagev2.checkPageHeader()
      C285_Scheduled_CheckDeclarationDetailsPagev2.checkPageTitle()

      And("User clicks continue on C285 Scheduled Check Declaration Details Page v2")
      C285_Scheduled_CheckDeclarationDetailsPagev2.waitForPageHeader
      C285_Scheduled_CheckDeclarationDetailsPagev2.clickContinueButton()

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

      Then("User is presented with the C285 Scheduled Choose Basis For Claim Page v2")
      C285_Scheduled_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Scheduled_ChooseBasisForClaimPagev2.checkURL
      C285_Scheduled_ChooseBasisForClaimPagev2.checkPageHeader()
      C285_Scheduled_ChooseBasisForClaimPagev2.checkPageTitle()

      When("User selects radio button Outward processing relief on C285 Scheduled Choose Basis For Claim Page v2")
      C285_Scheduled_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Scheduled_ChooseBasisForClaimPagev2.clickRadioButton("Outward processing relief")

      And("User clicks continue on C285 Scheduled Choose Basis For Claim Page v2")
      C285_Scheduled_ChooseBasisForClaimPagev2.waitForPageHeader
      C285_Scheduled_ChooseBasisForClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Enter Additional Details Page v2")
      C285_Scheduled_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterAdditionalDetailsPagev2.checkURL
      C285_Scheduled_EnterAdditionalDetailsPagev2.checkPageHeader()
      C285_Scheduled_EnterAdditionalDetailsPagev2.checkPageTitle()

      When("User enters under 500 characters on C285 Scheduled Enter Additional Details Page v2")
      C285_Scheduled_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterAdditionalDetailsPagev2.enterDetails("under 500 characters")

      And("User clicks continue on C285 Scheduled Enter Additional Details Page v2")
      C285_Scheduled_EnterAdditionalDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterAdditionalDetailsPagev2.clickContinueButton()

      And("User selects all duties")
      performDutySelection()

      Then("User is presented with the C285 Scheduled Check Claim Page v2")
      C285_Scheduled_CheckClaimPagev2.waitForPageHeader
      C285_Scheduled_CheckClaimPagev2.checkURL
      C285_Scheduled_CheckClaimPagev2.checkPageHeader()
      C285_Scheduled_CheckClaimPagev2.checkPageTitle()

      And("User clicks continue on C285 Scheduled Check Claim Page v2")
      C285_Scheduled_CheckClaimPagev2.waitForPageHeader
      C285_Scheduled_CheckClaimPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Choose Payee Type v2")
      C285_Scheduled_ChoosePayeeTypev2.waitForPageHeader
      C285_Scheduled_ChoosePayeeTypev2.checkURL
      C285_Scheduled_ChoosePayeeTypev2.checkPageHeader()
      C285_Scheduled_ChoosePayeeTypev2.checkPageTitle()

      And("User selects radio button Declarant on C285 Scheduled Choose Payee Type v2")
      C285_Scheduled_ChoosePayeeTypev2.waitForPageHeader
      C285_Scheduled_ChoosePayeeTypev2.clickRadioButton("Declarant")

      When("User clicks continue on C285 Scheduled Choose Payee Type v2")
      C285_Scheduled_ChoosePayeeTypev2.waitForPageHeader
      C285_Scheduled_ChoosePayeeTypev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Enter Bank Account Details Page v2")
      C285_Scheduled_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterBankAccountDetailsPagev2.checkURL
      C285_Scheduled_EnterBankAccountDetailsPagev2.checkPageHeader()
      C285_Scheduled_EnterBankAccountDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Scheduled Enter Bank Account Details Page v2")
      C285_Scheduled_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterBankAccountDetailsPagev2.enterDetails("")

      When("User clicks continue on C285 Scheduled Enter Bank Account Details Page v2")
      C285_Scheduled_EnterBankAccountDetailsPagev2.waitForPageHeader
      C285_Scheduled_EnterBankAccountDetailsPagev2.clickContinueButton()

      Then("User is presented with the C285 Scheduled Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkURL
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageHeader()
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.checkPageTitle()

      When("User selects radio button Commercial invoice on C285 Scheduled Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickRadioButton("Commercial invoice")

      And("User clicks continue on C285 Scheduled Supporting Evidence Select Supporting Evidence Type Page v2")
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.waitForPageHeader
      C285_Scheduled_SupportingEvidenceSelectSupportingEvidenceTypePagev2.clickContinueButton()

      Then("User is presented with the UCDF Choose File Other Page - commercial invoice")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.checkURL
      UCDF_ChooseFileOtherPage.checkPageTitle("commercial invoice")

      When("User uploads a 1 document.pdf file on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.uploadDocument(1, "document.pdf")
      UCDF_ChooseFileOtherPage.waitForPageToLoad()

      And("User selects radio button No on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickRadioButton("No")

      // Note: feature uses 'click continue' (not 'click continue if I'm on') for this step
      And("User clicks continue on UCDF Choose File Other Page")
      UCDF_ChooseFileOtherPage.waitForPageHeader
      UCDF_ChooseFileOtherPage.clickContinueButton()

      Then("User is presented with the C285 Scheduled Claimant Details Change Claimant Details Page v2")
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.checkURL
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageHeader()
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.checkPageTitle()

      And("User enters empty string on C285 Scheduled Claimant Details Change Claimant Details Page v2")
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.enterDetails("")

      And("User clicks continue on C285 Scheduled Claimant Details Change Claimant Details Page v2")
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.waitForPageHeader
      C285_Scheduled_ClaimantDetailsChangeClaimantDetailsPagev2.clickContinueButton()

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

      And("User should see the following details and submit")
      checkAnswersAndSubmit("60AAAAAAAAAAAAAAA5", "Declarant", "document.pdf")
    }
  }
}
