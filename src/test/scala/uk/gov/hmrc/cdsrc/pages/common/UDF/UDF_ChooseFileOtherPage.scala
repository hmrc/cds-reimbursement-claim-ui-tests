package uk.gov.hmrc.cdsrc.pages.common.UDF

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object UDF_ChooseFileOtherPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/upload-documents/choose-file"
  override val title = "Add documents to support your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Add documents to support your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Add documents to support your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Add documents to support your claim")

}
