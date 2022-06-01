package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Single_SupportingEvidenceDocumentDidNotUploadPage extends BasePage {

  override val url: String =
    TestConfiguration.url("cds-frontend") + "/single/supporting-evidence/document-did-not-upload"
  override val title       = "There is a problem with the file you uploaded"

  override def expectedPageErrorTitle: Option[String] = Some(
    "There is a problem with the file you uploaded - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "There is a problem with the file you uploaded - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("There is a problem with the file you uploaded")

}
