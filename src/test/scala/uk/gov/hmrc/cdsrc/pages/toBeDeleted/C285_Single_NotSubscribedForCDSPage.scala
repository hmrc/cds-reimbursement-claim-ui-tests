package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Single_NotSubscribedForCDSPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/not-subscribed-for-cds"
  override val title       = "Not registered with CDS"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Not registered with CDS - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Not registered with CDS - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some(
    "You need a valid EORI number to use the Customs Declaration Service (CDS)"
  )

}
