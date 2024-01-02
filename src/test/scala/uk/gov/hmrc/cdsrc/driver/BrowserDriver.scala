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

package uk.gov.hmrc.cdsrc.driver

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.WebDriver
import uk.gov.hmrc.webdriver.SingletonDriver

import scala.util.Try
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.MutableCapabilities

trait BrowserDriver extends LazyLogging {
  logger.info(
    s"Instantiating Browser: ${sys.props.getOrElse("browser", "'browser' System property not set. This is required")}"
  )

  val browserProperty = Option(System.getProperty("browser"))
    .flatMap(v => if (v.length > 0) Some(v) else None)

  if (browserProperty.isEmpty) {
    System.setProperty("browser", "chrome")
  }

  val options: Option[MutableCapabilities] =
    if (browserProperty.contains("chrome") || browserProperty.isEmpty) {
      val o = new ChromeOptions()
      o.addArguments("--headless")
      o.addArguments("--remote-allow-origins=*")
      o.addArguments("--ignore-ssl-errors=yes")
      o.addArguments("--ignore-certificate-errors");
      Some(o)
    } else None

  implicit lazy val driver: WebDriver = SingletonDriver.getInstance(options)

  val debug: Boolean = sys.props.getOrElse("drivernotquit", "false").toBoolean
  if (!debug)
    sys.addShutdownHook {
      Try(driver.quit())
    }

}
