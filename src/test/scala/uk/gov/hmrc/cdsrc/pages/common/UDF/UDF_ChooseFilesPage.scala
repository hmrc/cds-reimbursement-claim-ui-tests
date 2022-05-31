package uk.gov.hmrc.cdsrc.pages.common.UDF

import org.openqa.selenium.By
import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object UDF_ChooseFilesPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/upload-documents/choose-file"
  override val title = "Upload supporting documents"

  override def expectedPageErrorTitle: Option[String] = Some("")

  override def expectedPageTitle: Option[String] = Some("")

  override def expectedPageHeader: Option[String] = Some("")

  override def checkPageHeader(): Assertion =
    true should equal(true)

  override def checkPageTitle(page: String): Unit = {
    waitForPageToLoad()
    driver.findElement(By tagName "h1").getText should equal("Upload " + page)
  }

}
