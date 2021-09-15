@Regression @Scheduled @BrowserStack

Feature: Scheduled NI (bulk enabled, entry disabled)

  Background:
    Given the "Bulk Claim" feature is "enabled"
    Given the "Entry Number" feature is "disabled"
    Given the "Northern Ireland" feature is "enabled"

  @test
  Scenario: test temp NI pages - NI enabled
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000005" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page" and content "GB000000000000005,TestUser"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Number Of Claims Page"
    When I select radio button "schedule" on "Select Number Of Claims Page"
    And I click continue on "Select Number Of Claims Page"
    Then I am presented with the "Scheduled_Enter Movement Reference Number Page"
    When I enter "50AAAAAAAAAAAAAAA1" on "Scheduled_Enter Movement Reference Number Page"
    And I click continue on "Scheduled_Enter Movement Reference Number Page"
    Then I am presented with the "Scheduled_Check Declaration Details Page" and content "50AAAAAAAAAAAAAAA1"
    And I select radio button "yes" on "Scheduled_Check Declaration Details Page"
    And I click continue on "Scheduled_Check Declaration Details Page"
    Then I am presented with the "Scheduled_Scheduled Document Upload Upload Page"
    When I upload a "document.pdf" file on "Scheduled_Scheduled Document Upload Upload Page"
    And I click continue on "Scheduled_Scheduled Document Upload Upload Page"
