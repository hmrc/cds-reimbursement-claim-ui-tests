Feature: Scheduled journey for C&E1179

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
    And I select radio button "Upload multiple MRNs" on "RejectedGoods_Choose How Many Mrns Page"
    And I click continue on "RejectedGoods_Choose How Many Mrns Page"
    Then I am presented with the "Rejected Goods_Scheduled_Enter Movement Reference Number Page"
    When I enter "10AAAAAAAAAAAAAAA1" on "Rejected Goods_Scheduled_Enter Movement Reference Number Page"