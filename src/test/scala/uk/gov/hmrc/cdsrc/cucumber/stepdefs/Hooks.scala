/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.{JavascriptExecutor, OutputType, TakesScreenshot, WebDriver}
import uk.gov.hmrc.cdsrc.driver.BrowserDriver

import java.awt.image.BufferedImage
import java.io.File
import java.nio.file.{Files, Paths}
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.imageio.ImageIO

class Hooks extends ScalaDsl with EN with BrowserDriver {

  After { scenario: Scenario =>
    if (scenario.isFailed) {
      val screenshotName = scenario.getName.replaceAll(" ", "_")
      val screenshot = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.BYTES)
      scenario.attach(screenshot, "image/png", screenshotName)
    }
  }

  Before { _: Scenario =>
    val screenshotsFolderPath = "screenshots"  // Adjust the folder path accordingly
    clearScreenshotsFolder(screenshotsFolderPath)
  }
  def clearScreenshotsFolder(folderPath: String): Unit = {
    val screenshotsFolder = new File(folderPath)

    if (screenshotsFolder.exists() && screenshotsFolder.isDirectory) {
      val files = screenshotsFolder.listFiles()
      if (files != null) {
        files.foreach(_.delete())
      }
    }
  }
  AfterStep { step: Scenario =>
    val pageUrl = driver.getCurrentUrl()
    val screenshotName = generateScreenshotName(pageUrl, step.getName)

    // Capture full-screen screenshot
    captureFullScreenScreenshot(driver, screenshotName)

    // Read the screenshot as bytes
    val screenshotBytes = Files.readAllBytes(Paths.get(screenshotName))

    // Attach the screenshot to the step
    step.attach(screenshotBytes, "image/png", screenshotName)

    // Add debug logging
    println(s"Full-screen screenshot attached for step in scenario: ${step.getName}, URL: $pageUrl")
  }

  private def generateScreenshotName(pageIdentifier: String, stepName: String): String = {
    val sanitizedIdentifier = pageIdentifier.replaceAll("[^a-zA-Z0-9_-]", "_").substring(0, Math.min(pageIdentifier.length, 50))
    val sanitizedStepName = stepName.replaceAll("[^a-zA-Z0-9_-]", "_").substring(0, Math.min(stepName.length, 50))
    val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
    s"screenshots/$sanitizedIdentifier-$sanitizedStepName-$timestamp.png"
  }

  private def captureFullScreenScreenshot(driver: WebDriver, outputFilePath: String): Unit = {
    // Execute JavaScript to set the page zoom to 75%
    val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
    jsExecutor.executeScript("document.body.style.zoom = '75%'")

    // Capture screenshot as a file
    val screenshotFile: File = (driver.asInstanceOf[TakesScreenshot]).getScreenshotAs(OutputType.FILE)

    // Convert the screenshot file to a BufferedImage
    val bufferedImage: BufferedImage = ImageIO.read(screenshotFile)

    // Get the full height of the webpage
    val fullPageHeight: Int = bufferedImage.getHeight

    // Capture the full-page screenshot
    val fullPageScreenshot = new BufferedImage(bufferedImage.getWidth, fullPageHeight, BufferedImage.TYPE_INT_ARGB)
    val graphics = fullPageScreenshot.getGraphics
    graphics.drawImage(bufferedImage, 0, 0, null)
    graphics.dispose()

    // Save the full-page screenshot to the desired location
    ImageIO.write(fullPageScreenshot, "png", Paths.get(outputFilePath).toFile)

    // Reset the page zoom back to 100%
    jsExecutor.executeScript("document.body.style.zoom = '100%'")
  }
}
