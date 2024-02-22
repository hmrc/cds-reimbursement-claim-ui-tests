@test
Feature: Cookies Banner on Claim back import duty and VAT pages

  Background:
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"

  @test
  Scenario: Visibility of cookies banner on Claim back import duty and VAT page
    And I should see a cookie consent banner with the following details
      | Cookies on HMRC services                                                                                                                |
      | We use some essential cookies to make our services work.                                                                                |
      | We would like to set additional cookies so we can remember your settings, understand how people use our services and make improvements. |
      | Accept additional cookies                                                                                                               |
      | Reject additional cookies                                                                                                               |
      | View cookie preferences                                                                                                                           |
    And I should see the following "links" on the cookie banner
      | View cookies |
    And I should see the following "buttons" on the cookie banner
      | Accept additional cookies |
      | Reject additional cookies |

  @test
  Scenario: Cookies banner should not be displayed once accepted
  Scenario: Accept cookies on cookie consent banner
    And I click on "Accept additional cookies" button
    Then I should see a cookie consent banner with the following details
      | You have accepted additional cookies. You can change your cookie settings at any time. |
      | Hide cookies message                                                                   |
    And I should see the following "links" on the cookie banner
      | change your cookie settings |
    And I should see the following "buttons" on the cookie banner
      | Hide cookies message |
    When I click on "Hide cookies message" button
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Claim Type Page"
    Then I should not see cookie consent banner