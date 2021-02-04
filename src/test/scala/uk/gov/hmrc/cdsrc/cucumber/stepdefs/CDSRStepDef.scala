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

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.cdsrc.pages.{AuthLoginStubPage, UploadSupportingEvidencePage}

class CDSRStepDef extends BaseStepDef {

  When("""I select document type {string} on {string}""") { (documentType: String, page: String) =>
    page match {
      case "Select Supporting Evidence Type Page" =>
          val dropdown = new Select(driver.findElement(By.id("supporting-evidence.choose-document-type")))
          dropdown.selectByVisibleText(documentType)
    }
  }

  When("""I upload a {string} file on {string}""") { (file: String, page: String) =>
    //click on choose file & select file to send
    page match {
      case "Upload Supporting Evidence Page" => UploadSupportingEvidencePage.uploadDocument(file)
    }
  }

  When("""I enter Enrollment Key {string}, ID Name {string} and ID Value {string} on {string}""") { (eKey: String, IDName: String, IDValue: String, _: String) =>
    AuthLoginStubPage.login(eKey, IDName, IDValue)
  }

  And("""I click submit on {string}""") { (page: String) =>
    page match {
      case "Auth Login Stub Page" => click on xpath("//*[@id=\"inputForm\"]/p[1]/input")
    }
  }

  And("""I enter redirectURL on {string}""") { (page: String) =>
    page match {
      case "Auth Login Stub Page" =>
        AuthLoginStubPage.enterRedirectURL("/claim-for-reimbursement-of-import-duties/start")
    }
  }

}
