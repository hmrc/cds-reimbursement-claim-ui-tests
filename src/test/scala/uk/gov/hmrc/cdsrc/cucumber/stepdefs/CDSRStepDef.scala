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

package uk.gov.hmrc.cdsrc.cucumber.stepdefs

import uk.gov.hmrc.cdsrc.pages._

class CDSRStepDef extends BaseStepDef {

  When("""I click continue if I'm on {string}""") { (page: String) =>
    page match {
      case "Supporting Evidence Scan Progress Page" => SupportingEvidenceScanProgressPage.continuouslyClickContinue()
    }
  }

  When("""I upload a {string} file on {string}""") { (file: String, page: String) =>
    //click on choose file & select file to send
    page match {
      case "Supporting Evidence Upload Supporting Evidence Page" => SupportingEvidenceUploadSupportingEvidencePage.uploadDocument(file)
    }
  }

  When("""I enter Enrollment Key {string}, ID Name {string} and ID Value {string} on {string}""") { (eKey: String, IDName: String, IDValue: String, _: String) =>
    AuthLoginStubPage.enrolments(eKey, IDName, IDValue)
  }

  When("""I enter redirectURL on {string}""") { (page: String) =>
    page match {
      case "Auth Login Stub Page" =>
        AuthLoginStubPage.enterRedirectURL("http://localhost:7500/claim-for-reimbursement-of-import-duties/start/claim-for-reimbursement")
    }
  }

}
