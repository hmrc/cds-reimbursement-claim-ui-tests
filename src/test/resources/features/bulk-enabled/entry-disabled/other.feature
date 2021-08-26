@Regression

Feature: Bulk (bulk enabled, entry disabled)

  Background:
    Given the "Bulk Claim" feature is "enabled"
    Given the "Entry Number" feature is "disabled"
    Given the "Northern Ireland" feature is "disabled"

  @test @1
  Scenario: test Accessibility page link works
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page" and content "GB000000000000001,TestUser"
    When I click "Accessibility statement" on "Check Eori Details Page"
    Then I am presented with the "Accessibility Statement Page"
