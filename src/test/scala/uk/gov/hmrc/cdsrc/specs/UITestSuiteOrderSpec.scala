/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.cdsrc.specs

import org.scalatest.Suites
import uk.gov.hmrc.cdsrc.specs.CE1179.single.{CE1179SingleSpec, CE1179SingleXiEoriSpec}
import uk.gov.hmrc.cdsrc.specs.CE1179.scheduled.{CE1179ScheduledSpec, CE1179ScheduledXiEoriSpec}
import uk.gov.hmrc.cdsrc.specs.CE1179.multiple.{CE1179MultipleSpec, CE1179MultipleXiEoriSpec}
import uk.gov.hmrc.cdsrc.specs.CommonFeatures.CookiesBannerSpec
import uk.gov.hmrc.cdsrc.specs.Securities.{SingleSecuritySpec, SingleSecurityXiEoriSpec}
import uk.gov.hmrc.cdsrc.specs.Securities.other.{ChangeLinkTestsSpec, ExploratorySpec}
import uk.gov.hmrc.cdsrc.specs.C285.single_V2.{SingleClaimBasisV2Spec, SingleFileUploadV2Spec, SingleV2Spec, SingleV2XiEoriSpec}
import uk.gov.hmrc.cdsrc.specs.C285.scheduled_V2.{ScheduledV2Spec, ScheduledV2XiEoriSpec}
import uk.gov.hmrc.cdsrc.specs.C285.multiple_V2.{MultipleV2Spec, MultipleV2XiEoriSpec}
import uk.gov.hmrc.cdsrc.specs.WarmUpService.UploadFileServiceWarmUpSpec

class UITestSuiteOrderSpec
    extends Suites(
      new UploadFileServiceWarmUpSpec,
      new CE1179SingleSpec,
      new CE1179SingleXiEoriSpec,
      new CE1179ScheduledSpec,
      new CE1179ScheduledXiEoriSpec,
      new CE1179MultipleSpec,
      new CE1179MultipleXiEoriSpec,
      new CookiesBannerSpec,
      new SingleSecuritySpec,
      new SingleSecurityXiEoriSpec,
      new ChangeLinkTestsSpec,
      new ExploratorySpec,
      new SingleV2Spec,
      new SingleV2XiEoriSpec,
      new SingleClaimBasisV2Spec,
      new SingleFileUploadV2Spec,
      new ScheduledV2Spec,
      new ScheduledV2XiEoriSpec,
      new MultipleV2Spec,
      new MultipleV2XiEoriSpec
    )
