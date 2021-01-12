@Example

Feature: Example Feature file using Cucumber

  @ZAP
  Scenario: A logged in user is able to access payment details page
    Given a user logs in to access payments page
    When the user chooses to pay VAT tax
    Then payment details page is displayed
    When I click continue

  Scenario: Test file upload
    Given a user is on test page
    When the user uploads file
