package uk.gov.hmrc.cdsrc.pages.common.ALF

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object ALF_LookupAddressEditPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/lookup-address/.../edit"
  override val title = "Find UK address"

  override def expectedPageErrorTitle: Option[String] = Some("Enter address - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter address - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter address")

  override def enterDetails(data: String): Unit = {
    val address1: String = "123 Fake Street"
    val town: String     = "123 Fake Town"
    val postcode: String = "SW1A 1AA"

    enterText("line1", address1)
    enterText("town", town)
    enterText("postcode", postcode)
  }

}
