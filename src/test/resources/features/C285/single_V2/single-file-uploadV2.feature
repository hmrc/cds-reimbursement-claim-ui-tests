@C285 @Single
Feature: C285 Single file upload V2

  @test
  Scenario: happy path - upload 3 files
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    When the "overpayments v2" feature is "enabled"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "c285" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "C285_Choose How Many Mrns Page v2"
    When I select radio button "individual" on "C285_Choose How Many Mrns Page v2"
    And I click continue on "C285_Choose How Many Mrns Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "10AAAAAAAAAAAAAAA1" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    And I select radio button "yes" on "C285_Single_Check Declaration Details Page v2"
    And I click continue on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Claimant Details Page v2"
    And I click continue on "C285_Single_Claimant Details Page v2"
    Then I am presented with the "C285_Single_Claim Northern Ireland Page v2"
    And I select radio button "yes" on "C285_Single_Claim Northern Ireland Page v2"
    And I click continue on "C285_Single_Claim Northern Ireland Page v2"
    Then I am presented with the "C285_Single_Choose Basis For Claim Page v2"
    When I select radio button "Duty suspension" on "C285_Single_Choose Basis For Claim Page v2"
    And I click continue on "C285_Single_Choose Basis For Claim Page v2"
    Then I am presented with the "C285_Single_Enter Additional Details Page v2"
    When I enter "under 500 characters" on "C285_Single_Enter Additional Details Page v2"
    And I click continue on "C285_Single_Enter Additional Details Page v2"
    Then I am presented with the "C285_Single_Select Duties Page v2"
    When I select "A80,A95,A90,A85" on "C285_Single_Select Duties Page v2"
    And I click continue on "C285_Single_Select Duties Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A80 - Definitive Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A95 - Provisional Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A90 - Definitive Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A85 - Provisional Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Check Claim Page v2"
    And I select radio button "yes" on "C285_Single_Check Claim Page v2"
    When I click continue on "C285_Single_Check Claim Page v2"
    Then I am presented with the "C285_Single_Check These Bank Details Are Correct Page v2"
    When I click continue on "C285_Single_Check These Bank Details Are Correct Page v2"
    # upload file 1
    Then I am presented with the "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    When I select radio button "Commercial invoice" on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    And I click continue on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    Then I am presented with the "UCDF_Choose File Other Page" "commercial invoice"
    When I upload a 1 "image.jpg" file on "UCDF_Choose File Other Page"
    And I select radio button "Yes" on "UCDF_Choose File Other Page"
    And I click continue if I'm on "UCDF_Choose File Other Page"
    # upload file 2
    Then I am presented with the "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    When I select radio button "Bill of lading" on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    And I click continue on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    Then I am presented with the "UCDF_Choose File Other Page" "bill of landing"
    When I upload a 2 "document.pdf" file on "UCDF_Choose File Other Page"
    And I select radio button "Yes" on "UCDF_Choose File Other Page"
    And I click continue if I'm on "UCDF_Choose File Other Page"
    # upload file 3
    Then I am presented with the "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    When I select radio button "Packing list" on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    And I click continue on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    Then I am presented with the "UCDF_Choose File Other Page" "packing list"
    When I upload a 3 "image.png" file on "UCDF_Choose File Other Page"
    And I select radio button "NO" on "UCDF_Choose File Other Page"
    And I click continue if I'm on "UCDF_Choose File Other Page"
    # continue journey
    Then I am presented with the "C285_Single_Check Answers Accept Send Page v2"
    And I should see the following details
      | This is the basis behind the claim | VAT paid | Import date      | Contact details                                      | Importer email       | Uploaded                                                                        | Contact address                                  | Name on the account | Importer telephone | Importer name    | Account number   | Declarant name     | Were your goods imported into Northern Ireland? | Importer address                                 | This is the reason for the claim | Declarant address                                 | EU Duty | Total   | MRN                | Duties paid | Sort code      |
      | Duty suspension                    | £0.00    | 12 February 2021 | Online Sales LTD,automation@gmail.com,+4420723934397 | automation@gmail.com | image.jpg,Commercial invoice,document.pdf,Bill of lading,image.png,Packing list | 19 Bricks Road,Newcastle,NE12 5BT,United Kingdom | CDS E2E To E2E Bank | +4420723934397     | IT Solutions LTD | Ending with 5678 | Foxpro Central LTD | Yes                                             | 19 Bricks Road,Newcastle,NE12 5BT,United Kingdom | under 500 characters             | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | £788.00 | £788.00 | 10AAAAAAAAAAAAAAA1 | £828.00     | Ending with 44 |
    When I click continue on "C285_Single_Check Answers Accept Send Page v2"
    Then I am presented with the "C285_Single_Claim Submitted Page v2"