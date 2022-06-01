package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Multiple_EnterDuplicateMovementReferenceNumberPage extends BasePage {

  override val url: String =
    TestConfiguration.url("cds-frontend") + "/multiple/enter-duplicate-movement-reference-number"
  override val title       = "Tell us your duplicate Movement Reference Number (MRN)"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Tell us your duplicate Movement Reference Number (MRN) - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Tell us your duplicate Movement Reference Number (MRN) - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Tell us your duplicate Movement Reference Number (MRN)")

  override def enterDetails(textToEnter: String) {
    enterText("enter-duplicate-movement-reference-number", textToEnter)
  }

}
