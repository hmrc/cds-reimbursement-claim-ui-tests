/*
 * Copyright 2021 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.cdsrc.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.{OutputType, TakesScreenshot}
import uk.gov.hmrc.cdsrc.driver.BrowserDriver

class Hooks extends ScalaDsl with EN with BrowserDriver {
  After {
    scenario: Scenario =>
      if (scenario.isFailed) {
        val screenshotName = scenario.getName.replaceAll(" ", "_")
        val screenshot = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.BYTES)
        scenario.attach(screenshot, "image/png", screenshotName)
      }
  }
}

