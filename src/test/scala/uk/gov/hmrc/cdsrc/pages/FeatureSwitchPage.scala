/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.pages

import org.openqa.selenium.By
import uk.gov.hmrc.cdsrc.conf.TestConfiguration

case class FeatureSwitchPage(featureName: String , featureState: String ) extends BasePage {

  override val url : String = TestConfiguration.url("cds-frontend") + s"/test-only/feature/$featureName/$featureState"

  def configure: Boolean = {
    go to url

    // this doesn't check if the above feature switching worked or not...
    val elements = driver.findElements(By.tagName("pre"))
    elements.size() == 1 && elements.get(0).getText.toLowerCase.startsWith(featureState.toLowerCase())
  }

}
