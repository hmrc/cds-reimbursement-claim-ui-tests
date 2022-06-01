package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Single_SupportingEvidenceProblemWithDocumentPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/supporting-evidence/problem-with-document"
  override val title       = "There is a problem with your file"

  override def expectedPageErrorTitle: Option[String] = Some(
    "There is a problem with your file - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "There is a problem with your file - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("There is a problem with your file")

}
