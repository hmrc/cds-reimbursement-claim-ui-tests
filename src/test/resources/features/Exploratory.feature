@Exp

Feature: Exploratory file using Cucumber

  @test
  Scenario: A logged in user is able to access payment details page
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL
    And I enter Enrollment Name "HMRC-CUS-ORG" and Enrollment ID "EORINumber" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    #Then I am presented with the "Sign In Using Government Gateway Page"