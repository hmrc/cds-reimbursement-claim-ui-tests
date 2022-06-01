package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Multiple_SupportingEvidenceUploadProgressPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/multiple/scheduled-document-upload/progress"
  override val title       = "We are checking your document"

  override def expectedPageErrorTitle: Option[String] = Some(
    "We are checking your document - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "We are checking your document - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("We are checking your document")

}
