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
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object StartPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend")
  override val title = "Claim for reimbursement of import duties"

  override def expectedPageErrorTitle: Option[String] = Some("Claim for reimbursement of import duties - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Claim for reimbursement of import duties - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Claim for reimbursement of import duties")

  override def checkContent(content: String): Unit = {
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(2)")).getText should equal("You can use this service to apply to claim reimbursements on overpayments for import charges. These include Customs Duties, Excise Duties, Countervailing Duties and specific other customs duties.")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(3)")).getText should equal("You can use this service for multiple claims (bulk), and be reimbursed via either Current Month Adjustment (CMA) or by bank account transfer.")

    driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(4)")).getText should equal("Who can claim")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(5)")).getText should equal("You can claim if you have a valid EORI number associated with your Government Gateway login, and one or more Movement Reference Number(s) (MRN) or an entry number.")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(6)")).getText should equal("Find out more about an EORI number (opens in new tab) and an MRN (opens in new tab).")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(7)")).getText should equal("As a claim declarant you can be an:")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(8) > li:nth-child(1)")).getText should equal("importer or a representative of the importer")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(8) > li:nth-child(2)")).getText should equal("agent, freight forwarder or accountant")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(8) > li:nth-child(3)")).getText should equal("private individual")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(9)")).getText should equal("You must apply within 3 years of when the goods are cleared to enter the UK.")

    driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(10)")).getText should equal("Why claim")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(11)")).getText should equal("You should claim if:")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(12) > li:nth-child(1)")).getText should equal("the amount you already paid in the import declaration is inaccurate")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(12) > li:nth-child(2)")).getText should equal("your import declaration was rejected so you need to claim back all or some of the amount you already paid")

    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(13) > a")).getText should equal("Start now")

    driver.findElement(By.cssSelector("#main-content > div > div > h2:nth-child(14)")).getText should equal("Before you start")
    driver.findElement(By.cssSelector("#main-content > div > div > p:nth-child(15)")).getText should equal("To use this service, you will need:")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(16) > li:nth-child(1)")).getText should equal("Government Gateway credentials")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(16) > li:nth-child(2)")).getText should equal("to have your EORI number associated with your CDS enrolment")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(16) > li:nth-child(3)")).getText should equal("a MRN or entry number")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(16) > li:nth-child(4)")).getText should equal("to know the type of duty you want to claim reimbursement for")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(16) > li:nth-child(5)")).getText should equal("the reason for overpayment")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(16) > li:nth-child(6)")).getText should equal("details of the goods")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(16) > li:nth-child(7)")).getText should equal("your bank details")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(16) > li:nth-child(8)")).getText should equal("name and address details of the declarant")
    driver.findElement(By.cssSelector("#main-content > div > div > ul:nth-child(16) > li:nth-child(9)")).getText should equal("duty or VAT amount due and paid to HMRC")

    driver.findElement(By.cssSelector("#main-content > div > div > details > summary > span")).getText should equal("Examples of supporting documents")
    click on cssSelector("#main-content > div > div > details > summary > span")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > p")).getText should equal("You will need supporting evidence you have received relating to goods you have imported. You can scan copies in advance to make it easier to upload in this service. They can be any of these documents:")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(1)")).getText should equal("C88/E2 (proof to authorise imports from the country of origin)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(2)")).getText should equal("commercial invoice (shows the value of the goods)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(3)")).getText should equal("packing list (document that states packaging details in each shipment)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(4)")).getText should equal("air waybill (in your cargo documents)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(5)")).getText should equal("bill of lading (this is a receipt of shipped goods)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(6)")).getText should equal("substitute entry (a form to declare a substitute when goods have been incorrectly declared)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(7)")).getText should equal("schedule of MRNs (a list of previous MRN numbers)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(8)")).getText should equal("proof of authority (from importer for duty to be repaid)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(9)")).getText should equal("correspondence trader or internal (an email chain or letters between you and the trader)")
    driver.findElement(By.cssSelector("#main-content > div > div > details > div > ul > li:nth-child(10)")).getText should equal("additional supporting documents (for example an import licence, insurance certificate, purchase order or letter of credit)")
  }

}
