/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.pages.individual.mrn

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

import scala.jdk.CollectionConverters.asScalaBufferConverter

object Mrn_ChooseBasisForClaimPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/choose-basis-for-claim"
  override val title = "Select the basis for claim"

  override def expectedPageErrorTitle: Option[String] = Some("Select the basis for claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the basis for claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the basis for claim")

  override def dropdownSelect(selection: String): Unit = {
    val dropdown = new Select(driver.findElement(By.id("select-basis-for-claim")))
    dropdown.selectByVisibleText(selection)
  }

  override def clickRadioButton(selection: String): Unit = {
    driver.findElements(By.tagName("label")).asScala.filter(_.getText.trim == selection).head.click()
  }

  override def clickContinueButton(): Unit = {
    click on cssSelector("#main-content > div > div > form > button")
  }

}
