package uk.gov.hmrc.cdsrc.pages.common.ALF

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object ALF_LookupAddressLookupPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/lookup-address/.../lookup"
  override val title = "Find UK address"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Find UK address - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some("Find UK address - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Find UK address")

}
