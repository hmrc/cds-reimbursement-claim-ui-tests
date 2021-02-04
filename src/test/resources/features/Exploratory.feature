@Exp

Feature: Exploratory file using Cucumber

  @test
  Scenario: CDSR-36 - User is a CDS Trader, has an EORI, uploads 2 .jpg files
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB333186843345" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"
    #Then I am presented with the "Upload Supporting Evidence Page"
    When I upload a ".jpg" file on "Upload Supporting Evidence Page"
    And I click continue on "Upload Supporting Evidence Page"
    ###--- error happens here if/when wait for upload page shows
    When I select document type "C88/E2" on "Select Supporting Evidence Type Page"
    And I click continue on "Select Supporting Evidence Type Page"
    And I click "Add another file" on "Select Supporting Evidence Type Page"
    #Then I am presented with the "Upload Supporting Evidence Page"
    When I upload a ".jpg" file on "Upload Supporting Evidence Page"
    And I click continue on "Upload Supporting Evidence Page"
    When I select document type "Commercial Invoice" on "Select Supporting Evidence Type Page"
    And I click continue on "Select Supporting Evidence Type Page"
    #Then I am presented with the "Select Supporting Evidence Check Your Answers Page"
    When I click continue on "Select Supporting Evidence Check Your Answers Page"
    Then I am presented with the "Check Answers Accept Send Page"

  @testFail
  Scenario: CDSR-4 - User is a CDS Trader, does not have an EORI
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "", ID Name "" and ID Value "" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"
    Then I am presented with the "Start Page"
