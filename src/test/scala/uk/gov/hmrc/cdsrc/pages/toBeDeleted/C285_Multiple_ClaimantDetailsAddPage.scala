package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Multiple_ClaimantDetailsAddPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/multiple/claimant-details/add"
  override val title       = "Check your details as registered with CDS"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Check your details as registered with CDS - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Check your details as registered with CDS - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Check your details as registered with CDS")

  override def clickRadioButton(text: String): Unit =
    text match {
      case "yes" => click on cssSelector("#claimant-details-yes")
      case "no"  => click on cssSelector("#claimant-details-no")
    }

}
