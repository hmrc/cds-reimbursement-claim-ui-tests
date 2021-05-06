package uk.gov.hmrc.cdsrc.pages

import uk.gov.hmrc.cdsrc.conf.TestConfiguration

object ClaimNorthernIrelandPage extends BasePage {

  override val url : String = TestConfiguration.url("cds-frontend") + "/claim-northern-ireland"
  override val title: String = "Were your commodities (goods) moved or imported into Northern Ireland?"

  override def expectedPageErrorTitle: Option[String] = Some("Were your commodities (goods) moved or imported into Northern Ireland? - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageTitle : Option[String] = Some("Were your commodities (goods) moved or imported into Northern Ireland? - Claim for reimbursement of import duties - GOV.UK")

  override def expectedPageHeader: Option[String] = Some("Were your commodities (goods) moved or imported into Northern Ireland?")

  override def clickRadioButton(text : String): Unit = {
    text.toLowerCase() match {
      case "yes" => click on cssSelector("#claim-northern-ireland-yes")
      case "no"  => click on cssSelector("#claim-northern-ireland-no")
    }
  }
}
