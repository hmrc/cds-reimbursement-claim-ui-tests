Feature: C285 Exploratory file

  @Exp
  Scenario: happy path - check importer/declarant eori pages
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "c285" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "C285_Choose How Many Mrns Page"
    When I select radio button "individual" on "C285_Choose How Many Mrns Page"
    And I click continue on "C285_Choose How Many Mrns Page"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page"
    When I enter "10AAAAAAAAAAAAAAA2" on "C285_Single_Enter Movement Reference Number Page"
    And I click continue on "C285_Single_Enter Movement Reference Number Page"
    Then I am presented with the "C285_Single_Enter Importer Eori Page"
    When I enter "GB000000000000002" on "C285_Single_Enter Importer Eori Page"
    And I click continue on "C285_Single_Enter Importer Eori Page"
    Then I am presented with the "C285_Single_Enter Declarant Eori Page"
    When I enter "GB000000000000002" on "C285_Single_Enter Declarant Eori Page"
    And I click continue on "C285_Single_Enter Declarant Eori Page"
    Then I am presented with the "C285_Single_Check Declaration Details Page"
    And I select radio button "yes" on "C285_Single_Check Declaration Details Page"
    And I click continue on "C285_Single_Check Declaration Details Page"
    Then I am presented with the "C285_Single_Claimant Details Page"
    And I click continue on "C285_Single_Claimant Details Page"
    Then I am presented with the "C285_Single_Claim Northern Ireland Page"
    And I select radio button "yes" on "C285_Single_Claim Northern Ireland Page"
    And I click continue on "C285_Single_Claim Northern Ireland Page"
    Then I am presented with the "C285_Single_Choose Basis For Claim Page"
    When I select radio button "Duplicate MRN" on "C285_Single_Choose Basis For Claim Page"
    And I click continue on "C285_Single_Choose Basis For Claim Page"
    Then I am presented with the "C285_Single_Enter Duplicate Movement Reference Number Page"
    When I enter "20AAAAAAAAAAAAAAA1" on "C285_Single_Enter Duplicate Movement Reference Number Page"
    And I click continue on "C285_Single_Enter Duplicate Movement Reference Number Page"
    Then I am presented with the "C285_Single_Check Duplicate Declaration Details Page"
    And I select radio button "yes" on "C285_Single_Check Duplicate Declaration Details Page"
    And I click continue on "C285_Single_Check Duplicate Declaration Details Page"
    Then I am presented with the "C285_Single_Enter Additional Details Page"
    When I enter "under 500 characters" on "C285_Single_Enter Additional Details Page"
    And I click continue on "C285_Single_Enter Additional Details Page"
    Then I am presented with the "C285_Single_Select Duties Page"
    When I select "A80,A95,A90,A85" on "C285_Single_Select Duties Page"
    And I click continue on "C285_Single_Select Duties Page"
    Then I am presented with the "C285_Single_Enter Claim Page" "A80 - Definitive Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page"
    And I click continue on "C285_Single_Enter Claim Page"
    Then I am presented with the "C285_Single_Enter Claim Page" "A95 - Provisional Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page"
    And I click continue on "C285_Single_Enter Claim Page"
    Then I am presented with the "C285_Single_Enter Claim Page" "A90 - Definitive Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page"
    And I click continue on "C285_Single_Enter Claim Page"
    Then I am presented with the "C285_Single_Enter Claim Page" "A85 - Provisional Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page"
    And I click continue on "C285_Single_Enter Claim Page"
    Then I am presented with the "C285_Single_Check Claim Page"
    And I select radio button "yes" on "C285_Single_Check Claim Page"
    When I click continue on "C285_Single_Check Claim Page"
    Then I am presented with the "C285_Single_Check These Bank Details Are Correct Page"
    When I click continue on "C285_Single_Check These Bank Details Are Correct Page"
    Then I am presented with the "C285_Single_Supporting Evidence Select Supporting Evidence Type Page"
    When I select radio button "Commercial invoice" on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "UDF_Choose File Other Page"
    When I upload a "document.pdf" file on "UDF_Choose File Other Page"
    And I click continue on "UDF_Choose File Other Page"
    And I click continue if I'm on "UDF_Progress Page"
    Then I am presented with the "UDF_Summary Page" "1"
    When I select radio button "No" on "UDF_Summary Page"
    And I click continue on "UDF_Summary Page"
    Then I am presented with the "C285_Single_Check Answers Accept Send Page"
    And I click continue on "C285_Single_Check Answers Accept Send Page"
    Then I am presented with the "C285_Single_Claim Submitted Page"