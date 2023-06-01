@C&E1179 @Single
Feature: C&E1179 Single Subsidy

  @test
  Scenario: Cannot submit a C&E1179 single MRN claim for Subsidy repayment online
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "ce1179" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    When the "block subsidies" feature is "enabled"
    Then I am presented with the "CE1179_Choose How Many Mrns Page"
    And I select radio button "Enter one MRN" on "CE1179_Choose How Many Mrns Page"
    And I click continue on "CE1179_Choose How Many Mrns Page"
    Then I am presented with the "CE1179_Single_Enter Movement Reference Number Page"
    When I enter "10DDDDDDDDDDDDDDD1" on "CE1179_Single_Enter Movement Reference Number Page"
    And I click continue on "CE1179_Single_Enter Movement Reference Number Page"
    And The error summary title is "There is a problem" and the error message is "Subsidy MRNs cannot be added to online claims at this time"