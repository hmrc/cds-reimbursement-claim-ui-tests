package uk.gov.hmrc.cdsrc.pages.CE1179.multiple.subsidy

import org.openqa.selenium.By
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object CE1179_Multiple_Subsidy_SelectDuties1DutyPage extends BasePage {
  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/multiple/enter-claim/1/..."
  override val title = ""

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("")

  override def expectedPageHeader: Option[String] = Some("")

  override def checkPageHeader(): Assertion = {
    true should equal(true)
  }

  override def enterDetails(data: String): Unit = {
    val amounts: Array[String] = data.split(",")
    enterText("enter-claim.rejected-goods.claim-amount", amounts(0))
  }

  override def checkPageTitle(duty: String): Unit = {
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(s"Claim details for $duty under first MRN")
  }

  override def checkPageErrorTitle(duty: String): Unit = {
    driver.findElement(By cssSelector "#main-content > div > div > h1").getText should equal(s"Claim details for $duty under first MRN")
  }

}