/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.cdsrc.pages.common.ALF

import uk.gov.hmrc.cdsrc.conf.TestConfiguration
import uk.gov.hmrc.cdsrc.pages.BasePage

object ALF_LookupAddressEditPage extends BasePage {

  override val url: String = TestConfiguration.url("lookup-address") + "/..."
  override val title       = "Enter your address"

  override def expectedPageErrorTitle: Option[String] = Some("Enter your address")

  override def expectedPageTitle: Option[String] = Some("Enter your address")

  override def expectedPageHeader: Option[String] = Some("Enter your address")

  override def enterDetails(data: String): Unit = {
    val address1: String = "12 Skybricks Road"
    val town: String     = "Coventry"
    val postcode: String = "CV3 6EA"

    enterText("line1", address1)
    enterText("town", town)
    enterText("postcode", postcode)
  }

}
