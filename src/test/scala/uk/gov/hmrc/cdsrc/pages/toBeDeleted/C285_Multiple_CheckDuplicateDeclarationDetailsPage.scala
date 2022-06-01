package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Multiple_CheckDuplicateDeclarationDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/multiple/check-duplicate-declaration-details"
  override val title       = "Check these details are correct"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Check these details are correct - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Check these details are correct - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Check these details are correct")

  override def clickRadioButton(text: String): Unit =
    text.toLowerCase() match {
      case "yes" => click on cssSelector("#check-declaration-details")
      case "no"  => click on cssSelector("#check-declaration-details-2")
    }

}
