@Regression
Feature: C285 scheduled

  @test
  Scenario: test temp pages
    Given I "enable" the bulk feature
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    And I click "Start now" on "Start Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Number Of Claims Page"
    When I select radio button "schedule" on "Select Number Of Claims Page"
    And I click continue on "Select Number Of Claims Page"
    Then I am presented with the "Enter Mrn Schedule Page"