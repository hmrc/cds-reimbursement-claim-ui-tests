@Security @Single
Feature: Security Single

  @test
  Scenario: happy path - check importer/declarant eori pages
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "securities" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "Securities_Enter Movement Reference Number Page"
    When I enter "01AAAAAAAAAAAAAAA2" on "Securities_Enter Movement Reference Number Page"
    And I click continue on "Securities_Enter Movement Reference Number Page"
    Then I am presented with the "Securities_Choose Reason For Security Page"
    When I select radio button "End-use Relief" on "Securities_Choose Reason For Security Page"
    And I click continue on "Securities_Choose Reason For Security Page"
    Then I am presented with the "Securities_Enter Importer Eori Page"
    When I enter "GB000000000000002" on "C285_Single_Enter Importer Eori Page"
    And I click continue on "Securities_Enter Importer Eori Page"
    Then I am presented with the "Securities_Enter Declarant Eori Page"
    When I enter "GB000000000000002" on "Securities_Enter Declarant Eori Page"
    And I click continue on "Securities_Enter Declarant Eori Page"
