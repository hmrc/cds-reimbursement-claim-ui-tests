Feature: multiple for C&E1179

  Background:
    Given the "Bulk Claim" feature is "enabled"
    Given the "Entry Number" feature is "disabled"
    Given the "Northern Ireland" feature is "enabled"
    Given the "Rejected Goods" feature is "enabled"

  @test @a11y @ZAP
  Scenario: happy path
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
    Then I am presented with the "RejectedGoods_Choose How Many Mrns Page"
    And I select radio button "Enter multiple MRNs" on "RejectedGoods_Choose How Many Mrns Page"
    And I click continue on "RejectedGoods_Choose How Many Mrns Page"
    Then I am presented with the "Rejected Goods_Multiple_Enter Movement Reference Number Page"
    When I enter "10AAAAAAAAAAAAAAA2" on "Rejected Goods_Multiple_Enter Movement Reference Number Page"
    And I click continue on "Rejected Goods_Multiple_Enter Movement Reference Number Page"
    Then I am presented with the "Rejected Goods_Multiple_Enter Importer Eori Page"
    When I enter "GB000000000000002" on "Rejected Goods_Multiple_Enter Importer Eori Page"
    And I click continue on "Rejected Goods_Multiple_Enter Importer Eori Page"
    Then I am presented with the "Rejected Goods_Multiple_Enter Declarant Eori Page"
    When I enter "GB000000000000002" on "Rejected Goods_Multiple_Enter Declarant Eori Page"
    And I click continue on "Rejected Goods_Multiple_Enter Declarant Eori Page"
    Then I am presented with the "Rejected Goods_Multiple_Check Declaration Details Page"