@Regression

Feature: Exploratory file using Cucumber

  @test1
  Scenario: User is a CDS Trader - happy path
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "AA12345678901234Z" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Then I navigate to the "Start Page"
    And I click "Start now" on "Start Page"
    Then I am presented with the "Enter Movement Reference Number Page"
    When I enter "666541198B49856762" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    Then I am presented with the "Enter Declaration Details Page"
    When I enter "" on "Enter Declaration Details Page"
    And I click continue on "Enter Declaration Details Page"
    Then I am presented with the "Who Is The Declarant Page"
    When I select radio button "0" on "Who Is The Declarant Page"
    And I click continue on "Who Is The Declarant Page"
    Then I am presented with the "Enter Claimant Details As Individual Page"
    When I enter "" on "Enter Claimant Details As Individual Page"
    And I select radio button "1" on "Enter Claimant Details As Individual Page"
    And I click continue on "Enter Claimant Details As Individual Page"
    Then I am presented with the "Enter Claimant Details As Company Page"
    When I enter "" on "Enter Claimant Details As Company Page"
    And I click continue on "Enter Claimant Details As Company Page"
    And I click continue on "Enter Claimant Details As Company Page"
    ### duplicate should be removed after CDSR-210 is fixed
    Then I am presented with the "Enter Reason For Claim And Basis Page"
    When I select dropdown value "Duplicate MRN or Entry,Mail order goods" on "Enter Reason For Claim And Basis Page"
    And I click continue on "Enter Reason For Claim And Basis Page"
    Then I am presented with the "Enter Duplicate Movement Reference Number Page"
    When I enter "666541198B49856762" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    Then I am presented with the "Enter Duplicate Declaration Details Page"
    When I enter "" on "Enter Duplicate Declaration Details Page"
    And I click continue on "Enter Duplicate Declaration Details Page"
    Then I am presented with the "Enter Commodity Details Page"
    When I enter "under 500 characters" on "Enter Commodity Details Page"
    And I click continue on "Enter Commodity Details Page"




