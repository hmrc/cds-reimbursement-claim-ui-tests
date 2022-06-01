package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Scheduled_ScheduledDocumentUploadUploadPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/scheduled-document-upload/upload"
  override val title       = "Add a document which shows all the MRNs in this claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Add a document which shows all the MRNs in this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Add a document which shows all the MRNs in this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Add a document which shows all the MRNs in this claim")

  override def clickContinueButton(): Unit =
    click on cssSelector("#main-content > div > div > form > div.govuk-\\!-margin-bottom-9 > button")

}
