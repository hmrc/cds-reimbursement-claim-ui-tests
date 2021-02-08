@Exp

Feature: Exploratory file using Cucumber

  @test
  Scenario Outline: CDSR-36 - User is a CDS Trader, has an EORI, uploads 2 .jpg files
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB333186843345" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"

    #Then I am presented with the "Enter Movement Reference Number Page"
    When I enter "19GB03I52858027017" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    #Then I am presented with the "Declarant Details Page"
    When I click continue on "Declarant Details Page"
    #Then I am presented with the "Who Is The Declarant Page"
    When I select radio button "0" on "Who Is The Declarant Page"
    When I click continue on "Who Is The Declarant Page"
    #Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    When I upload a ".jpg" file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    When I select document type "C88/E2" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click "Add another file" on "Supporting Evidence Select Supporting Evidence Type Page"
    #Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    When I upload a ".jpg" file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    When I select document type "Commercial Invoice" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    #Then I am presented with the "Supporting Evidence Select Supporting Evidence Check Your Answers Page"
    When I click continue on "Supporting Evidence Check Your Answers Page"
    Then I am presented with the "Check Answers Accept Send Page"

#    Examples:
#      | filetype |
#      | ".jpg"   |
#      | ".png"   |

  @testFail
  Scenario: CDSR-4 - User is a CDS Trader, does not have an EORI
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "", ID Name "" and ID Value "" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"
    Then I am presented with the "Start Page"
