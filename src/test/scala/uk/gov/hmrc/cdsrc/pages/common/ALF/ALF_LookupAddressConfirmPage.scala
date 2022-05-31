package uk.gov.hmrc.cdsrc.pages.common.ALF

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object ALF_LookupAddressConfirmPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/lookup-address/.../confirm"
  override val title = "Review and confirm"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Review and confirm - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some("Review and confirm - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Review and confirm")

}
