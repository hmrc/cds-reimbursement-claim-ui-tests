package uk.gov.hmrc.cdsrc.pages.CE1179.scheduled.subsidy

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object CE1179_Scheduled_Subsidy_SelectDutiesEuDutyPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/scheduled/select-duties/eu-duty"
  override val title = "Select the EU duties you want to claim for"

  override def expectedPageErrorTitle: Option[String] = Some("Select the EU duties you want to claim for - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Select the EU duties you want to claim for - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Select the EU duties you want to claim for")

}
