package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Scheduled_SupportingEvidenceUploadSupportingEvidencePage extends BasePage {

  override val url: String =
    TestConfiguration.url("cds-frontend") + "/scheduled/supporting-evidence/upload-supporting-evidence"
  override val title       = "Add documents to support your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Error: Add documents to support your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Add documents to support your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Add documents to support your claim")

  override def clickContinueButton(): Unit =
    click on cssSelector("#main-content > div > div > form > div.govuk-\\!-margin-bottom-9 > button")

}
