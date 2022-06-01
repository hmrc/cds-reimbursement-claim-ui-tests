package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Scheduled_WhoIsTheDeclarantPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/who-is-the-declarant"
  override val title       = "Who is making this claim?"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Who is making this claim? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Who is making this claim? - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Who is making this claim?")

}
