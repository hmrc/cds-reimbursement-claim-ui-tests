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
import uk.gov.hmrc.cdsrc.pages.AuthLoginStubPage

class ExampleStepDef extends BaseStepDef {

  Given("""a user is on test page""") { () =>
    driver.navigate().to("https://ps.uci.edu/~franklin/doc/file_upload.html")
  }

  When("""the user uploads file""") { () =>
    //click on choose file & select file to send
    driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("/home/jayen/Downloads/10.jpg")
    //click on send file
    driver.findElement(By.xpath("/html/body/form/input[2]")).click()
  }

  Given("""I am on login page""") { () =>
    driver.navigate().to("localhost:9949/auth-login-stub/gg-sign-in")
    println("dsfdfasdf")
  }

  When("""I enter Enrollment Name {string} and Enrollment ID {string} on {string}""") { (eName: String, eID: String, _: String) =>
    AuthLoginStubPage.login(eName, eID)
  }

  And("""I click submit on {string}""") { (_: String) =>
    click on xpath("//*[@id=\"inputForm\"]/p[1]/input")
  }

  And("""I enter redirectURL""") { () =>
    AuthLoginStubPage.enterRedirectURL("https://www.development.tax.service.gov.uk/claim-for-reimbursement-of-import-duties/start")
  }

}
