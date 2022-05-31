package uk.gov.hmrc.cdsrc.pages.common.UDF

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object UDF_SummaryPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/upload-documents/summary"
  override val title = "You have successfully uploaded a document showing all the MRNs in this claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "You have successfully uploaded a document showing all the MRNs in this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "You have successfully uploaded a document showing all the MRNs in this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some(
    "You have successfully uploaded a document showing all the MRNs in this claim"
  )

  override def checkPageTitle(page: String): Unit = { //triggers on supporting evidence upload
    waitForPageToLoad()
    page match {
      case "1" =>
        driver.findElement(By tagName "h1").getText should equal(s"""You have added $page document to your claim""")
      case _   =>
        driver.findElement(By tagName "h1").getText should equal(s"""You have added $page documents to your claim""")
    }
  }

}
