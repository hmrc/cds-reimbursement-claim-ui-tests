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

  When("""I enter {string} on {string}""") { (data: String, page: String) =>
    page match {
      case "Enter Movement Reference Number Page" => enterText("enter-movement-reference-number", data)
      case "Enter Declaration Details Page" =>
        data match {
          case "" => EnterDeclarationDetailsPage.enterDetails()
        }
      case "Enter Claimant Details As Individual Page" =>
        data match {
          case "" => EnterClaimantDetailsAsIndividualPage.enterDetails()
        }
      case "Enter Claimant Details As Company Page" =>
        data match {
          case "" => EnterClaimantDetailsAsCompanyPage.enterDetails()
        }
      case "Enter Duplicate Declaration Details Page" =>
        data match {
          case "" => EnterDuplicateDeclarationDetailsPage.enterDetails()
        }
      case "Enter Commodity Details Page" =>
        data match {
          case _ => EnterCommodityDetailsPage.enterDetails(data)
        }
      case "Enter UK Duty Amounts Page" =>
        data match {
          case _ => EnterUKDutyAmountsPage.enterDetails()
        }
      case "Enter EU Duty Amounts Page" =>
        data match {
          case _ => EnterEUDutyAmountsPage.enterDetails()
        }
      case "Enter Bank Account Details Page" =>
        data match {
          case _ => EnterBankAccountDetailsPage.enterDetails()
        }
    }
  }

  When("""I click continue if I'm on {string}""") { (page: String) =>
    page match {
      case "Supporting Evidence Scan Progress Page" => SupportingEvidenceScanProgressPage.continuouslyClickContinue()
    }
  }

  When("""I select dropdown value {string} on {string}""") { (selection: String, page: String) =>
    page match {
      case "Supporting Evidence Select Supporting Evidence Type Page" => SupportingEvidenceSelectSupportingEvidenceTypePage.dropdownSelect(selection)
      case "Enter Reason For Claim Page" => EnterReasonForClaimPage.dropdownSelect(selection)
      case "Enter Reason For Claim And Basis Page" => EnterReasonForClaimAndBasisPage.dropdownSelect(selection)
    }
  }

  When("""I upload a {string} file on {string}""") { (file: String, page: String) =>
    //click on choose file & select file to send
    page match {
      case "Supporting Evidence Upload Supporting Evidence Page" => SupportingEvidenceUploadSupportingEvidencePage.uploadDocument(file)
    }
  }

  And("""I click submit on {string}""") { (page: String) =>
    page match {
      case "Auth Login Stub Page" => click on xpath("//*[@id=\"inputForm\"]/p[1]/input")
    }
  }

  When("""I enter Enrollment Key {string}, ID Name {string} and ID Value {string} on {string}""") { (eKey: String, IDName: String, IDValue: String, _: String) =>
    AuthLoginStubPage.enrolments(eKey, IDName, IDValue)
  }

  When("""I enter redirectURL on {string}""") { (page: String) =>
    page match {
      case "Auth Login Stub Page" =>
        AuthLoginStubPage.enterRedirectURL("/claim-for-reimbursement-of-import-duties/start/claim-for-reimbursement")
    }
  }

}
