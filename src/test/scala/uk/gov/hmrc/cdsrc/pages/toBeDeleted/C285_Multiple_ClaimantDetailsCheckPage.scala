package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Multiple_ClaimantDetailsCheckPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/multiple/claimant-details/check"
  override val title       = "How we will contact you about this claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "How we will contact you about this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "How we will contact you about this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("How we will contact you about this claim")

  override def clickRadioButton(text: String): Unit =
    text match {
      case "yes" => click on cssSelector("#claimant-details-yes")
      case "no"  => click on cssSelector("#claimant-details-no")
    }

}
