@Regression @Scheduled @new

Feature: C285 scheduled

  Background:
    Given the "Bulk Claim" feature is "enabled"
    Given the "Entry Number" feature is "disabled"
    Given the "Northern Ireland" feature is "disabled"

  @test @a11y @ZAP
  Scenario: test temp pages - entry number disabled
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page" and content "GB000000000000001,TestUser"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Number Of Claims Page"
    When I select radio button "schedule" on "Select Number Of Claims Page"
    And I click continue on "Select Number Of Claims Page"
    ###below line fails due to entry number, who knows why?, it should be fixed eventually
    Then I am presented with the "Enter Mrn Schedule Page"