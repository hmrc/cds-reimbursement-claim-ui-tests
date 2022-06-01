package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import org.scalatest.Assertion
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Scheduled_SupportingEvidenceScanProgressPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/supporting-evidence/scan-progress"
  override val title       = "Wait a few seconds and then select ‘continue’"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Wait a few seconds and then select ‘continue’ - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Wait a few seconds and then select ‘continue’ - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Wait a few seconds and then select ‘continue’")

  override def checkURL: Assertion =
    driver.getCurrentUrl should fullyMatch regex (url + ".*?").r

}
