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

package uk.gov.hmrc.cdsrc.pages.scheduled

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Scheduled_SupportingEvidenceCheckYourAnswersPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/supporting-evidence/check-your-answers"
  override val title = "You have added 1 document to your claim"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("You have added 1 document to your claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("You have added 1 document to your claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("You have added 1 document to your claim")

  override def checkContent(content: String): Unit = {
    content match {
      case _ =>
        driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("These are the documents you have added so far to support this claim. So we can process your claim efficiently, add the commercial invoice used in the import declaration.")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("document.pdf\nCommercial Invoice")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > a")).getText should equal("Remove")

        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > legend")).getText should equal("Do you want to add another document?")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("Yes")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("No")

        driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
    }
  }


  override def clickRadioButton(choice: String): Unit = {
    choice.toLowerCase() match {
      case "yes" => click on cssSelector("#supporting-evidence\\.check-your-answers")
      case "no" => click on cssSelector("#supporting-evidence\\.check-your-answers-2")
    }
  }

}
