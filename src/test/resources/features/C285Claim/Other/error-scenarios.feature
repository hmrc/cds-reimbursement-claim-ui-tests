@Regression

Feature: C285 - Error Scenarios

  @test
  Scenario: User is a CDS Trader - Trigger error pages
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    And I click "Start now" on "Start Page"

    Then I am presented with the "Enter Movement Reference Number Page"
    When I enter "000000001A00000001e" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    Then I am presented with the "Enter Movement Reference Number Page" error page
    When I enter "000000001A00000001" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"

    Then I am presented with the "Enter Declaration Details Page"
    When I enter "" on "Enter Declaration Details Page"
    And I click continue on "Enter Declaration Details Page"

    Then I am presented with the "Who Is The Declarant Page"
    And I click continue on "Who Is The Declarant Page"
    Then I am presented with the "Who Is The Declarant Page" error page
    When I select radio button "0" on "Who Is The Declarant Page"
    And I click continue on "Who Is The Declarant Page"

    Then I am presented with the "Enter Your Details As Registered With CDS"
    When I enter "" on "Enter Your Details As Registered With CDS"
    And I select radio button "yes" on "Enter Your Details As Registered With CDS"
    And I click continue on "Enter Your Details As Registered With CDS"

    Then I am presented with the "Enter Your Contact Details Page"
    When I enter "" on "Enter Your Contact Details Page"
    And I click continue on "Enter Your Contact Details Page"

    Then I am presented with the "Enter Reason For Claim And Basis Page"
    When I select dropdown value "Duplicate Entry,Mail Order Goods – duties not due" on "Enter Reason For Claim And Basis Page"
    And I click continue on "Enter Reason For Claim And Basis Page"

    Then I am presented with the "Enter Duplicate Movement Reference Number Page"
    When I enter "000000002B00000002e" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    Then I am presented with the "Enter Duplicate Movement Reference Number Page" error page
    When I enter "000000002B00000002" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"

    Then I am presented with the "Enter Duplicate Declaration Details Page"
    When I enter "" on "Enter Duplicate Declaration Details Page"
    And I click continue on "Enter Duplicate Declaration Details Page"

    Then I am presented with the "Enter Commodity Details Page"
    When I enter "over 500 characters" on "Enter Commodity Details Page"
    And I click continue on "Enter Commodity Details Page"
    Then I am presented with the "Enter Commodity Details Page" error page
    When I enter "under 500 characters" on "Enter Commodity Details Page"
    And I click continue on "Enter Commodity Details Page"

    Then I am presented with the "Select Duties Page"
    And I click continue on "Select Duties Page"
    Then I am presented with the "Select Duties Page" error page
    When I select "0" on "Select Duties Page"
    And I click continue on "Select Duties Page"

    Then I am presented with the "Enter Claim Page" "Customs Duty - Code A00"
    When I enter "-2,-1" on "Enter Claim Page"
    And I click continue on "Enter Claim Page"
    Then I am presented with the "Enter Claim Page" "Customs Duty - Code A00" error page
    When I enter "2,1" on "Enter Claim Page"
    And I click continue on "Enter Claim Page"

    Then I am presented with the "Check Claim Page"
    When I click continue on "Check Claim Page"

    Then I am presented with the "Enter Bank Account Details Page"
    And I select checkbox on "Enter Bank Account Details Page"
    And I click continue on "Enter Bank Account Details Page"
    Then I am presented with the "Enter Bank Account Details Page" error page
    When I enter "" on "Enter Bank Account Details Page"
    And I select checkbox on "Enter Bank Account Details Page"
    And I click continue on "Enter Bank Account Details Page"

    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page" error page
    When I upload a "document.pdf" file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"

    And I click continue if I'm on "Supporting Evidence Scan Progress Page"

    Then I am presented with the "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "Supporting Evidence Select Supporting Evidence Type Page" error page
    When I select dropdown value "Commercial Invoice" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"

    Then I am presented with the "Supporting Evidence Check Your Answers Page"
    When I click continue on "Supporting Evidence Check Your Answers Page"

    Then I am presented with the "Check Answers Accept Send Page"
    And I click continue on "Check Answers Accept Send Page"

    Then I am presented with the "Claim Submitted Page"

