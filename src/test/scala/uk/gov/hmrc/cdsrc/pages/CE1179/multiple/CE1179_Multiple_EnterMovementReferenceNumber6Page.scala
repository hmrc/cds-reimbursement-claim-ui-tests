package uk.gov.hmrc.cdsrc.pages.CE1179.multiple

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object CE1179_Multiple_EnterMovementReferenceNumber6Page extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/rejected-goods/multiple/enter-movement-reference-number/2"
  override val title = "Enter the second Movement Reference Number (MRN)"

  override def expectedPageErrorTitle: Option[String] = Some("Error: Enter the second Movement Reference Number (MRN) - Claim back import duty and VAT - GOV.UK")

  override def expectedPageTitle: Option[String] = Some("Enter the second Movement Reference Number (MRN) - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Enter the second Movement Reference Number (MRN)")

  override def enterDetails(textToEnter: String) {
    enterText("enter-movement-reference-number.rejected-goods", textToEnter)
  }

}
