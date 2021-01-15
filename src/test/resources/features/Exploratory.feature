@Exp

Feature: Exploratory file using Cucumber

  @test
  Scenario: CDSR-4 - User is a CDS Trader, has an EORI
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "asdf" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"
    Then I am presented with the "Start Page"

  @test
  Scenario: CDSR-4 - User is a CDS Trader, does not have an EORI
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "", ID Name "" and ID Value "" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"
    Then I am presented with the "Not Subscribed For CDS Page"