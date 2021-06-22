@Regression

Feature: C285 - Error Scenarios

  @test
  Scenario: User is a CDS Trader - Trigger error pages
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"

    Then I am presented with the "Enter Movement Reference Number Page"
    When I enter "000000001A00000001e" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    Then I am presented with the "Enter Movement Reference Number Page" error page
    When I enter "000000001A00000001" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"

    Then I am presented with the "Entry_Enter Declaration Details Page"
    When I enter "" on "Entry_Enter Declaration Details Page"
    And I click continue on "Entry_Enter Declaration Details Page"

    Then I am presented with the "Entry_Who Is The Declarant Page"
    And I click continue on "Entry_Who Is The Declarant Page"
    Then I am presented with the "Entry_Who Is The Declarant Page" error page
    When I select radio button "0" on "Entry_Who Is The Declarant Page"
    And I click continue on "Entry_Who Is The Declarant Page"

    Then I am presented with the "Entry_Enter Your Details As Registered With CDS"
    When I enter "" on "Entry_Enter Your Details As Registered With CDS"
    And I select radio button "yes" on "Entry_Enter Your Details As Registered With CDS"
    And I click continue on "Entry_Enter Your Details As Registered With CDS"

    Then I am presented with the "Entry_Enter Your Contact Details Page"
    When I enter "" on "Entry_Enter Your Contact Details Page"
    And I click continue on "Entry_Enter Your Contact Details Page"

    Then I am presented with the "Entry_Enter Reason For Claim And Basis Page"
    When I select dropdown value "Duplicate Entry,Mail Order Goods – duties not due" on "Entry_Enter Reason For Claim And Basis Page"
    And I click continue on "Entry_Enter Reason For Claim And Basis Page"

    Then I am presented with the "Entry_Enter Duplicate Movement Reference Number Page"
    When I enter "000000002B00000002e" on "Entry_Enter Duplicate Movement Reference Number Page"
    And I click continue on "Entry_Enter Duplicate Movement Reference Number Page"
    Then I am presented with the "Entry_Enter Duplicate Movement Reference Number Page" error page
    When I enter "000000002B00000002" on "Entry_Enter Duplicate Movement Reference Number Page"
    And I click continue on "Entry_Enter Duplicate Movement Reference Number Page"

    Then I am presented with the "Entry_Enter Duplicate Declaration Details Page"
    When I enter "" on "Entry_Enter Duplicate Declaration Details Page"
    And I click continue on "Entry_Enter Duplicate Declaration Details Page"

    Then I am presented with the "Entry_Enter Commodity Details Page"
    When I enter "over 500 characters" on "Entry_Enter Commodity Details Page"
    And I click continue on "Entry_Enter Commodity Details Page"
    Then I am presented with the "Entry_Enter Commodity Details Page" error page
    When I enter "under 500 characters" on "Entry_Enter Commodity Details Page"
    And I click continue on "Entry_Enter Commodity Details Page"

    Then I am presented with the "Entry_Select Duties Page"
    And I click continue on "Entry_Select Duties Page"
    Then I am presented with the "Entry_Select Duties Page" error page
    When I select "A00" on "Entry_Select Duties Page"
    And I click continue on "Entry_Select Duties Page"

    Then I am presented with the "Entry_Enter Claim Page" "A00 - Customs Duty"
    When I enter "-2,-1" on "Entry_Enter Claim Page"
    And I click continue on "Entry_Enter Claim Page"
    Then I am presented with the "Entry_Enter Claim Page" "A00 - Customs Duty" error page
    When I enter "2,1" on "Entry_Enter Claim Page"
    And I click continue on "Entry_Enter Claim Page"

    Then I am presented with the "Entry_Check Claim Page"
    And I select radio button "yes" on "Entry_Check Claim Page"
    When I click continue on "Entry_Check Claim Page"

    Then I am presented with the "Entry_Enter Bank Account Details Page"
    And I select checkbox on "Entry_Enter Bank Account Details Page"
    And I click continue on "Entry_Enter Bank Account Details Page"
    Then I am presented with the "Entry_Enter Bank Account Details Page" error page
    When I enter "" on "Entry_Enter Bank Account Details Page"
    And I select checkbox on "Entry_Enter Bank Account Details Page"
    And I click continue on "Entry_Enter Bank Account Details Page"

    Then I am presented with the "Entry_Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Entry_Supporting Evidence Upload Supporting Evidence Page"
    Then I am presented with the "Entry_Supporting Evidence Upload Supporting Evidence Page" error page
    When I upload a "document.pdf" file on "Entry_Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Entry_Supporting Evidence Upload Supporting Evidence Page"

    And I click continue if I'm on "Entry_Supporting Evidence Scan Progress Page"

    Then I am presented with the "Entry_Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Entry_Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "Entry_Supporting Evidence Select Supporting Evidence Type Page" error page
    When I select dropdown value "Commercial Invoice" on "Entry_Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Entry_Supporting Evidence Select Supporting Evidence Type Page"

    Then I am presented with the "Entry_Supporting Evidence Check Your Answers Page"
    When I click continue on "Entry_Supporting Evidence Check Your Answers Page"

    Then I am presented with the "Entry_Check Answers Accept Send Page"
    And I click continue on "Entry_Check Answers Accept Send Page"

    Then I am presented with the "Entry_Claim Submitted Page"

