@C&E1179 @Multiple
Feature: C&E1179 Multiple Subsidy

  @test
  Scenario: Cannot submit a C&E1179 Multiple MRN claim when first MRN is subsidy
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "ce1179" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "CE1179_Choose How Many Mrns Page"
    When I select radio button "Enter multiple MRNs" on "CE1179_Choose How Many Mrns Page"
    And I click continue on "CE1179_Choose How Many Mrns Page"
    Then I am presented with the "CE1179_Multiple_Enter Movement Reference Number Page"
    When I enter "10DDDDDDDDDDDDDDD1" on "CE1179_Multiple_Enter Movement Reference Number Page"
    And I click continue on "CE1179_Multiple_Enter Movement Reference Number Page"
    And The error summary title is "There is a problem" and the error message is "Subsidy MRNs cannot be added to online claims at this time"


    @test
    Scenario: Cannot submit a C&E1179 Multiple MRN claim when second MRN is subsidy
      Given I navigate to the "Auth Login Stub Page"
      When I enter redirectURL on "Auth Login Stub Page"
      And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
      And I click continue on "Auth Login Stub Page"
      Then I am presented with the "Check Eori Details Page"
      When I select radio button "yes" on "Check Eori Details Page"
      And I click continue on "Check Eori Details Page"
      Then I am presented with the "Select Claim Type Page"
      When I select radio button "ce1179" on "Select Claim Type Page"
      And I click continue on "Select Claim Type Page"
      Then I am presented with the "CE1179_Choose How Many Mrns Page"
      And I select radio button "Enter multiple MRNs" on "CE1179_Choose How Many Mrns Page"
      And I click continue on "CE1179_Choose How Many Mrns Page"
      Then I am presented with the "CE1179_Multiple_Enter Movement Reference Number Page"
      When I enter "10AAAAAAAAAAAAAAA1" on "CE1179_Multiple_Enter Movement Reference Number Page"
      And I click continue on "CE1179_Multiple_Enter Movement Reference Number Page"
      Then I am presented with the "CE1179_Multiple_Check Declaration Details Page"
      And I select radio button "yes" on "CE1179_Multiple_Check Declaration Details Page"
      And I click continue on "CE1179_Multiple_Check Declaration Details Page"
      Then I am presented with the "CE1179_Multiple_Enter Movement Reference Number 2 Page"
      When I enter "10DDDDDDDDDDDDDDD1" on "CE1179_Multiple_Enter Movement Reference Number 2 Page"
      And I click continue on "CE1179_Multiple_Enter Movement Reference Number 2 Page"
      And The error summary title is "There is a problem" and the error message is "Subsidy MRNs cannot be added to online claims at this time"