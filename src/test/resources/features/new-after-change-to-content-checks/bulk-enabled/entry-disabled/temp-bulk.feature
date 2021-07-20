@Regression @Bulk @new

Feature: C285 Bulk

  Background:
    Given the "Bulk Claim" feature is "enabled"
    Given the "Entry Number" feature is "disabled"
    Given the "Northern Ireland" feature is "disabled"

  @test @a11y @ZAP ### this journey fails due to 641. Enabling entry number fixes this
  Scenario: test temp pages - entry number disabled
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page" and content "GB000000000000001,TestUser"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Number Of Claims Page"
    When I select radio button "bulk" on "Select Number Of Claims Page"
    And I click continue on "Select Number Of Claims Page"
    Then I am presented with the "Bulk_Enter Movement Reference Number Page"

  @testFail @CDSR-650
  Scenario: test temp pages - wrong entry mrn - entry number disabled
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page" and content "GB000000000000001,TestUser"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Number Of Claims Page"
    When I select radio button "bulk" on "Select Number Of Claims Page"
    And I click continue on "Select Number Of Claims Page"
    Then I am presented with the "Bulk_Enter Movement Reference Number Page"
    When I enter "10AAAAAAAAAAAAAAA1" on "Bulk_Enter Movement Reference Number Page"
    And I click continue on "Bulk_Enter Movement Reference Number Page"
    Then I am presented with the "Bulk_Check Declaration Details Page" and content "10AAAAAAAAAAAAAAA1"
    And I select radio button "no" on "Bulk_Check Declaration Details Page"
    And I click continue on "Bulk_Check Declaration Details Page"
    Then I am presented with the "Bulk_Enter Movement Reference Number Page"
    When I enter "10AAAAAAAAAAAAAAA1" on "Bulk_Enter Movement Reference Number Page"
    And I click continue on "Bulk_Enter Movement Reference Number Page"
    Then I am presented with the "Bulk_Check Declaration Details Page" and content "10AAAAAAAAAAAAAAA1"
    And I select radio button "yes" on "Bulk_Check Declaration Details Page"
    And I click continue on "Bulk_Check Declaration Details Page"
    Then I am presented with the "Bulk_Who Is The Declarant Page"
