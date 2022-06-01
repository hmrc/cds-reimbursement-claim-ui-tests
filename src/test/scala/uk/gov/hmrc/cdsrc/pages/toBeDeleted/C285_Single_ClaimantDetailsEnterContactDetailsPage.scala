package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Single_ClaimantDetailsEnterContactDetailsPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/claimant-details/enter-contact-details"
  override val title       = "Add contact details"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Add contact details - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some("Add contact details - Claim back import duty and VAT - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Add contact details")

  override def enterDetails(data: String): Unit = {
    val fullName: String     = "John Smith"
    val emailAddress: String = "john@smith.com"
    val telephone: String    = "01234567890"

    enterText("enter-contact-details.contact-name", fullName)
    enterText("enter-contact-details.contact-email", emailAddress)
    enterText("enter-contact-details.contact-phone-number", telephone)
  }

}
