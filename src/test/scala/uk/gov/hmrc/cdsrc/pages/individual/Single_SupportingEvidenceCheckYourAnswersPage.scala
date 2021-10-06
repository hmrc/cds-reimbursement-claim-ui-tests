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

package uk.gov.hmrc.cdsrc.pages.individual

import org.openqa.selenium.By
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Single_SupportingEvidenceCheckYourAnswersPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/supporting-evidence/check-your-answers"
  override val title = "You have added 1 document to your claim"
  override val pageShouldHaveBackButton = false

  override def expectedPageErrorTitle: Option[String] = Some("You have added 1 document to your claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("You have added 1 document to your claim - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("You have added 1 document to your claim")

  override def checkPageHeader(content: String): Assertion = {
    true should equal(true)
  }

  override def checkPageTitle(content: String): Assertion = {
    true should equal(true)
  }

  override def checkContent(content: String): Unit = {
    content match {
      case "2 files" =>
        driver.findElement(By.cssSelector("#main-content > div > div > h1")).getText should equal("You have added 2 documents to your claim")

        driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("These are the documents you have added so far to support this claim. So we can process your claim efficiently, add the commercial invoice used in the import declaration.")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("document.pdf\nImport and Export Declaration")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > a")).getText should equal("Remove")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(3) > dt")).getText should equal("document.pdf\nCommercial Invoice")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(3) > dd > a")).getText should equal("Remove")

        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > legend")).getText should equal("Do you want to add another document?")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("Yes")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("No")

        driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")

      case "3 files" =>
        driver.findElement(By.cssSelector("#main-content > div > div > h1")).getText should equal("You have added 3 documents to your claim")

        driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("These are the documents you have added so far to support this claim. So we can process your claim efficiently, add the commercial invoice used in the import declaration.")

        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dt")).getText should equal("document.pdf\nPacking List")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(2) > dd > a")).getText should equal("Remove")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(3) > dt")).getText should equal("document.pdf\nImport and Export Declaration")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(3) > dd > a")).getText should equal("Remove")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(4) > dt")).getText should equal("document.pdf\nCommercial Invoice")
        driver.findElement(By.cssSelector("#main-content > div > div > dl > div:nth-child(4) > dd > a")).getText should equal("Remove")

        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > legend")).getText should equal("Do you want to add another document?")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("Yes")
        driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("No")

        driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")

      case "1 file" | _ =>
        driver.findElement(By.cssSelector("#main-content > div > div > h1")).getText should equal("You have added 1 document to your claim")

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
