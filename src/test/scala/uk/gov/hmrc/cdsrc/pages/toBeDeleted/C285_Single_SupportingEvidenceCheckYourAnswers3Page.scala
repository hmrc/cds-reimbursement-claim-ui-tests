package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Single_SupportingEvidenceCheckYourAnswers3Page extends BasePage {

  override val url: String = TestConfiguration.url("cds-frontend") + "/single/supporting-evidence/check-your-answers"
  override val title       = "You have added 3 documents to your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "You have added 3 documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "You have added 3 documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("You have added 3 documents to your claim")

  override def clickRadioButton(choice: String): Unit =
    choice.toLowerCase() match {
      case "yes" => click on cssSelector("#supporting-evidence\\.check-your-answers")
      case "no"  => click on cssSelector("#supporting-evidence\\.check-your-answers-2")
    }

}
