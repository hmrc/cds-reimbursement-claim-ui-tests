package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Single_EnterYourDetailsAsRegisteredWithCDSPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/enter-your-details-as-registered-with-cds"
  override val title       = "Enter your details as registered with CDS"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Enter your details as registered with CDS - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Enter your details as registered with CDS - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Enter your details as registered with CDS")

  override def enterDetails(data: String): Unit = {
    val fullName: String     = "Johnathon Smithson"
    val emailAddress: String = "johnathonsmithson@email.com"
    val addressLine1: String = "John Rd"
    val addressLine2: String = ""
    val addressLine3: String = ""
    val town: String         = "Johnstown"
    val postcode: String     = "JO0 0HN"
    val country: String      = "United Kingdom"

    enterText("enter-claimant-details-as-registered-with-cds.individual-full-name", fullName)
    enterText("enter-claimant-details-as-registered-with-cds.individual-email", emailAddress)
    enterText("nonUkAddress-line1", addressLine1)
    enterText("nonUkAddress-line2", addressLine2)
    enterText("nonUkAddress-line3", addressLine3)
    enterText("nonUkAddress-line4", town)
    enterText("postcode", postcode)
    selectFromAutocomplete("countryCode", country)
  }

  override def clickRadioButton(selection: String): Unit =
    click on cssSelector(s"""#enter-claimant-details-as-registered-with-cds\\.add-company-details${if (
      selection == "no"
    ) {
      "-no"
    } else {
      ""
    }}""")

}
