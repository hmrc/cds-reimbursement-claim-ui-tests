package uk.gov.hmrc.cdsrc.pages.common.UDF

import org.openqa.selenium.By
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object UDF_ChooseFilessPage extends BasePage {

  override val url: String = TestConfiguration.url("upload-customs-frontend") + "/choose-files"
  override val title = "Add a document which shows all the subsidy MRNs in this claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Add a document which shows all the subsidy MRNs in this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Add a document which shows all the subsidy MRNs in this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Add a document which shows all the subsidy MRNs in this claim")

  override def clickContinueButton(): Unit = click on cssSelector("#upload-documents-submit")

  override def continuouslyClickContinue(): Unit = {
    waitForPageToLoad()
    while (driver.getCurrentUrl.equals(url)) {
      clickContinueButton()
    }
  }

}

