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

package uk.gov.hmrc.cdsrc.pages.common

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.pages.BasePage

object AccessibilityStatementPage extends BasePage {

  override val url: String = "http://localhost:12346/accessibility-statement/cds-reimbursement-claim"
  override val title = "Accessibility statement for Claim for reimbursement of import duties service"

  override def expectedPageErrorTitle: Option[String] = Some("Accessibility statement for Claim for reimbursement of import duties service – GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Accessibility statement for Claim for reimbursement of import duties service – GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Accessibility statement for Claim for reimbursement of import duties service")

  override val pageShouldHaveBackButton: Boolean = false

  override def checkContent(content: String): Unit = {
    //only content checks for things that are likely to change at some point

    driver.findElement(By.cssSelector("#main-content > div > div > h3")).getText should equal("Non‐accessible content")

    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(29)")).getText should equal("The content listed below is non-accessible for the following reasons.")
    driver.findElement(By.cssSelector("#main-content > div > div > h4")).getText should equal("Non‐compliance with the accessibility regulations")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(31)")).getText should equal("missing error styles on fields that need to be corrected. This fails WCAG 2.1 success criterions 3.3.1 Error Identification. This will be fixed by 16 September 2021.")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(32)")).getText should equal("currency input does not have correct error styles. Validation prevents users from entering values with allowed characters. This fails WCAG 2.1 success criterions 3.3.2 Labels or Instructions and 3.3.1 Error Identification. This will be fixed by 16 September 2021.")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(33)")).getText should equal("error messages are general and non-specific to the actual error. They do not describe what action is required from the user. This fails WCAG 2.1 success criterions 3.3.1 Error Identification. This will be fixed by 16 September 2021.")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(34)")).getText should equal("account header layout and long strings of the text gets clipped and not visible on the screen when the user increases the font size. This fails WCAG 2.1 success criterions 1.4.4 Resize text and 1.4.10 Reflow. This will be fixed by 16 September 2021.")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(35)")).getText should equal("the correct language attribute to identify the copy in the main document’s language is missing. This fails WCAG 2.1 success criterions 3.1.2 Language of Parts. This will be fixed by 16 September 2021.")

    driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(36)")).getText should equal("How we tested this service")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(37)")).getText should equal("The service was last tested on 9 July 2021 and was checked for compliance with WCAG 2.1 AA.")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(38)")).getText should equal("The service was built using parts that were tested by the Digital Accessibility Centre. The full service was tested by HMRC and included disabled users.")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(39)")).getText should equal("This page was prepared on 18 March 2021. It was last updated on 16 July 2021.")
  }

}
