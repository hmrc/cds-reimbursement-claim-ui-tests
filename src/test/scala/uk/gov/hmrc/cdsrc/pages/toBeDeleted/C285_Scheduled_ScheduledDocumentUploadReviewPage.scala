package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Scheduled_ScheduledDocumentUploadReviewPage extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/scheduled/scheduled-document-upload/review"
  override val title       = "You have successfully uploaded a document showing all the MRNs in this claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "You have successfully uploaded a document showing all the MRNs in this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "You have successfully uploaded a document showing all the MRNs in this claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some(
    "You have successfully uploaded a document showing all the MRNs in this claim"
  )

  override def clickContinueButton(): Unit =
    click on cssSelector("#main-content > div > div > form > button")

}
