@C285 @Single @Subsidy
Feature: C285 Single V2 with subsidy check

  @test @subsidy
  Scenario: happy path - Subsidy feature - v2 enabled
    Given I navigate to the "Auth Login Stub Page"
    And I enter redirectURL on "Auth Login Stub Page"
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
    When I enter "10DDDDDDDDDDDDDDD1" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2" error page
    And The error summary title is "There is a problem" and the error message is "Subsidy MRNs cannot be added to online claims at this time"
