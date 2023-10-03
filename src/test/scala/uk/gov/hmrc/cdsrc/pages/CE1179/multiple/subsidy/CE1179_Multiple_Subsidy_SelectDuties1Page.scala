package uk.gov.hmrc.cdsrc.pages.CE1179.multiple.subsidy

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object CE1179_Multiple_Subsidy_SelectDuties1Page  extends BasePage{
  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/multiple/select-duties"
  override val title = "Duties shown are all covered by subsidy"

  override def expectedPageErrorTitle: Option[String] = Some("Duties shown are all covered by subsidy - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Duties shown are all covered by subsidy - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Duties shown are all covered by subsidy")


}
