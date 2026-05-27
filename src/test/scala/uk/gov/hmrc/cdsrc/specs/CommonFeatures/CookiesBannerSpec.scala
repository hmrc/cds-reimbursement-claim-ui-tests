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

package uk.gov.hmrc.cdsrc.specs.CommonFeatures

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.auth.AuthLoginStubPage
import uk.gov.hmrc.cdsrc.pages.common.{CheckEoriDetailsPage, SelectClaimTypePage}
import uk.gov.hmrc.cdsrc.pages.generic.PageObjectFinder
import uk.gov.hmrc.cdsrc.specs.BaseSpec

class CookiesBannerSpec extends BaseSpec {

  Feature("Cookies Banner on Claim back import duty and VAT pages") {

    def loginBackground(): Unit = {
      go to AuthLoginStubPage
      AuthLoginStubPage.enterRedirectURL(TestConfiguration.url("cds-frontend") + "/start")
      AuthLoginStubPage.enrolments("HMRC-CUS-ORG", "EORINumber", "GB000000000000001")
      AuthLoginStubPage.waitForPageHeader
      AuthLoginStubPage.clickContinueButton()
      CheckEoriDetailsPage.waitForPageHeader
      CheckEoriDetailsPage.checkURL
      CheckEoriDetailsPage.checkPageHeader()
      CheckEoriDetailsPage.checkPageTitle()
    }

    Scenario("Visibility of cookies banner on Claim back import duty and VAT page") {

      Given("User has navigated to the service")
      loginBackground()

      Then("User should see a cookie consent banner with the following details")
      val bannerText = PageObjectFinder.cookieBannerText()
      bannerText.foreach(item => info(s"- $item"))
      bannerText should be(List(
        "Cookies on HMRC services",
        "We use some essential cookies to make our services work.",
        "We would like to set additional cookies so we can remember your settings, understand how people use our services and make improvements.",
        "Accept additional cookies",
        "Reject additional cookies",
        "View cookie preferences"
      ))

      And("User should see the following links on the cookie banner")
      PageObjectFinder.cookieBannerLinkUrl("View cookie preferences") should include("/tracking-consent/cookie-settings")
      val linksText = PageObjectFinder.cookieBannerLinksButtonsText("a")
      linksText.foreach(item => info(s"- $item"))
      linksText should be(List("View cookie preferences"))

      And("User should see the following buttons on the cookie banner")
      val buttonsText = PageObjectFinder.cookieBannerLinksButtonsText("button")
      buttonsText.foreach(item => info(s"- $item"))
      buttonsText should be(List("Accept additional cookies", "Reject additional cookies"))
    }

    Scenario("Cookies banner should not be displayed once accepted") {
    }

    Scenario("Accept cookies on cookie consent banner") {

      Given("User has navigated to the service")
      loginBackground()

      And("User clicks on Accept additional cookies button")
      PageObjectFinder.button("Accept additional cookies").click()

      Then("User should see a cookie consent banner with the following details")
      val acceptedBannerText = PageObjectFinder.cookieBannerText()
      acceptedBannerText.foreach(item => info(s"- $item"))
      acceptedBannerText should be(List(
        "You have accepted additional cookies. You can change your cookie settings at any time.",
        "Hide cookies message"
      ))

      And("User should see the following links on the cookie banner")
      PageObjectFinder.cookieBannerLinkUrl("change your cookie settings") should include("/tracking-consent/cookie-settings")
      val acceptedLinksText = PageObjectFinder.cookieBannerLinksButtonsText("a")
      acceptedLinksText.foreach(item => info(s"- $item"))
      acceptedLinksText should be(List("change your cookie settings"))

      And("User should see the following buttons on the cookie banner")
      val acceptedButtonsText = PageObjectFinder.cookieBannerLinksButtonsText("button")
      acceptedButtonsText.foreach(item => info(s"- $item"))
      acceptedButtonsText should be(List("Hide cookies message"))

      When("User clicks on Hide cookies message button")
      PageObjectFinder.button("Hide cookies message").click()

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

      Then("User should not see cookie consent banner")
      PageObjectFinder.cookieBannerPresence() should be(false)
    }
  }
}
