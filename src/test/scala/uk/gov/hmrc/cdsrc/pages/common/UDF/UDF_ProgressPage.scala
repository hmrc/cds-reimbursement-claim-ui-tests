package uk.gov.hmrc.cdsrc.pages.common.UDF

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object UDF_ProgressPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/upload-documents/progress/..."
  override val title = "We are checking your document"

  override def expectedPageErrorTitle: Option[String] = Some(
    "We are checking your document - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "We are checking your document - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("We are checking your document")

}
