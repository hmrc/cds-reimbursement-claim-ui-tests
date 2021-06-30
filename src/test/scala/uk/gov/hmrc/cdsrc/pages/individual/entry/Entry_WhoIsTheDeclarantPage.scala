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

package uk.gov.hmrc.cdsrc.pages.individual.entry

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object Entry_WhoIsTheDeclarantPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/who-is-the-declarant"
  override val title = "Who is making this claim?"

  override def expectedPageErrorTitle: Option[String] = Some("Who is making this claim? - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Who is making this claim? - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Who is making this claim?")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p")).getText should equal("This person is responsible for the claim. They are the point of contact if we have a query about the claim.")

    driver.findElement(By.cssSelector("#main-content > div > div > details > summary > span")).getText should equal("What is an importer and a representative?")
    driver.findElement(By.cssSelector("#main-content > div > div > details > summary > span")).click
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(1)")).getText should equal("A private individual importer can be a private individual or company bringing goods into the country.")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(2)")).getText should equal("An importer company is one that solely imports (not agents, private individuals or sole traders).")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(3)")).getText should equal("A representative company can be a person or a company acting on behalf of an importer. This could be an agent or a broker or a freight forwarder.")

    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(1) > label")).getText should equal("I am a private individual importer")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(2) > label")).getText should equal("I work for an importer company")
    driver.findElement(By.cssSelector("#main-content > div > div > form > div > fieldset > div > div:nth-child(3) > label")).getText should equal("I work for a representative company on behalf of the importer")

    driver.findElement(By.cssSelector("#main-content > div > div > form > button")).getText should equal("Continue")
  }
}
