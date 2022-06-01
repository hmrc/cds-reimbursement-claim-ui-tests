package uk.gov.hmrc.cdsrc.pages.toBeDeleted

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object C285_Multiple_SupportingEvidenceSelectSupportingEvidenceTypePage extends BasePage {

  override val url: String =
    TestConfiguration.url("cds-frontend") + "/multiple/supporting-evidence/select-supporting-evidence-type"
  override val title       = "Add supporting documents to your claim"

  override def expectedPageErrorTitle: Option[String] = Some(
    "Add supporting documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageTitle: Option[String] = Some(
    "Add supporting documents to your claim - Claim back import duty and VAT - GOV.UK"
  )

  override def expectedPageHeader: Option[String] = Some("Add supporting documents to your claim")

  override def clickRadioButton(selection: String): Unit =
    driver.findElements(By.tagName("label")).asScala.filter(_.getText.trim == selection).head.click()

}
