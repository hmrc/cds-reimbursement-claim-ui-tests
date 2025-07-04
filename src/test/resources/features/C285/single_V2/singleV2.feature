@C285 @Single
Feature: C285 Single V2

  @test
  Scenario: happy path with payee type and with only importer bank details
#  (MRN 60AAAAAAAAAAAAAAA5 => only importer bank details (user is importer))
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
#    When the "overpayments v2" feature is "enabled"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "c285" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "C285_Choose How Many Mrns Page v2"
    When I select radio button "individual" on "C285_Choose How Many Mrns Page v2"
    And I click continue on "C285_Choose How Many Mrns Page v2"
    Then I am presented with the "C285_Have Your Supporting Document Ready Page v2"
    When I clickContinue on "C285_Have Your Supporting Document Ready Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "60AAAAAAAAAAAAAAA5" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    #And I select radio button "yes" on "C285_Single_Check Declaration Details Page v2"
    And I click continue on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Choose Basis For Claim Page v2"
    When I select radio button "End use relief" on "C285_Single_Choose Basis For Claim Page v2"
    And I click continue on "C285_Single_Choose Basis For Claim Page v2"
    Then I am presented with the "C285_Single_Enter Additional Details Page v2"
    When I enter "under 500 characters" on "C285_Single_Enter Additional Details Page v2"
    And I click continue on "C285_Single_Enter Additional Details Page v2"
    Then I am presented with the "C285_Single_Select Duties Page v2"
    When I select "A80,A95,A90,A85" on "C285_Single_Select Duties Page v2"
    And I click continue on "C285_Single_Select Duties Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A80 - Definitive Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A95 - Provisional Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A90 - Definitive Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A85 - Provisional Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Check Claim Page v2"
    # And I select radio button "yes" on "C285_Single_Check Claim Page v2"
    When I clickContinue on "C285_Single_Check Claim Page v2"
    Then I am presented with the "C285_Single_Choose Payee Type v2"
    And I select radio button "Importer" on "C285_Single_Choose Payee Type v2"
    When I click continue on "C285_Single_Choose Payee Type v2"
#    Then I am presented with the "C285_Single_Check These Bank Details Are Correct Page v2"
#    And I select radio button "yes" on "C285_Single_Check These Bank Details Are Correct Page v2"
#    When I click continue on "C285_Single_Check These Bank Details Are Correct Page v2"
    Then I am presented with the "C285_Single_Enter Bank Account Details Page v2"
    And I enter "" on "C285_Single_Enter Bank Account Details Page v2"
    When I click continue on "C285_Single_Enter Bank Account Details Page v2"
    Then I am presented with the "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    When I select radio button "Commercial invoice" on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    And I click continue on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    Then I am presented with the "UCDF_Choose File Other Page" "Commercial invoice"
    When I upload a 1 "document.pdf" file on "UCDF_Choose File Other Page"
    And I select radio button "No" on "UCDF_Choose File Other Page"
    And I click continue if I'm on "UCDF_Choose File Other Page"
    Then I am presented with the "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I enter "" on "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I click continue on "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I click "Enter the address manually" on "ALF_Lookup Address Lookup Page"
    And I enter "" on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Confirm Page"
    Then I am presented with the "C285_Single_Claimant Details Page v2"
    And I click continue on "C285_Single_Claimant Details Page v2"
    Then I am presented with the "C285_Single_Check Answers Accept Send Page v2"
    And I should see the following details
      | Reason for claim    | Personal details                              | Uploaded files                      | Address                                           | Bank details                     |Payee     | Additional claim information    | What do you want to claim?                                                                                                                       | A80 - Definitive Anti-Dumping Duty | A85 - Provisional Anti-Dumping Duty| A90 - Definitive Countervailing Duty|A95 - Provisional Countervailing Duty| Total   | Method  |Movement Reference Number (MRN)|
      |End use relief      | Mr John Smith,someemail@mail.com,01234567890  | Commercial invoice:,document.pdf    | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | Mr John Smith,123456,11001001    |Importer  | under 500 characters            | A80 - Definitive Anti-Dumping Duty,A95 - Provisional Countervailing Duty,A90 - Definitive Countervailing Duty,A85 - Provisional Anti-Dumping Duty| £10.00                             | £10.00                             | £10.00                              | £10.00                              | £40.00  | Bank account transfer  |60AAAAAAAAAAAAAAA5 |
    When I click continue on "C285_Single_Check Answers Accept Send Page v2"
    Then I am presented with the "C285_Single_Claim Submitted Page v2"

  @test
  Scenario: happy path with new payee type page - user selects CMA
    #  60AAAAAAAAAAAAAAA5 => only importer bank details (user is only importer ) - CMA eligible - displays payee indicator page and navigates to /check-bank-details page after /choose-repayment-method page
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
#    When the "overpayments v2" feature is "enabled"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "c285" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "C285_Choose How Many Mrns Page v2"
    When I select radio button "individual" on "C285_Choose How Many Mrns Page v2"
    And I click continue on "C285_Choose How Many Mrns Page v2"
    Then I am presented with the "C285_Have Your Supporting Document Ready Page v2"
    When I clickContinue on "C285_Have Your Supporting Document Ready Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "60AAAAAAAAAAAAAAA5" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    #And I select radio button "yes" on "C285_Single_Check Declaration Details Page v2"
    And I click continue on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Choose Basis For Claim Page v2"
    When I select radio button "Duplicate Movement Reference Number (MRN)" on "C285_Single_Choose Basis For Claim Page v2"
    And I click continue on "C285_Single_Choose Basis For Claim Page v2"
    Then I am presented with the "C285_Single_Enter Duplicate Movement Reference Number Page v2"
    When I enter "20AAAAAAAAAAAAAAA1" on "C285_Single_Enter Duplicate Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Duplicate Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Duplicate Declaration Details Page v2"
    #And I select radio button "yes" on "C285_Single_Check Duplicate Declaration Details Page v2"
    And I click continue on "C285_Single_Check Duplicate Declaration Details Page v2"
    Then I am presented with the "C285_Single_Enter Additional Details Page v2"
    When I enter "under 500 characters" on "C285_Single_Enter Additional Details Page v2"
    And I click continue on "C285_Single_Enter Additional Details Page v2"
    Then I am presented with the "C285_Single_Select Duties Page v2"
    When I select "A95,A90,A85" on "C285_Single_Select Duties Page v2"
    And I click continue on "C285_Single_Select Duties Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A95 - Provisional Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A90 - Definitive Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A85 - Provisional Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Check Claim Page v2"
    # And I select radio button "yes" on "C285_Single_Check Claim Page v2"
    When I clickContinue on "C285_Single_Check Claim Page v2"
    Then I am presented with the "C285_Single_Choose Payee Type v2"
    And I select radio button "Importer" on "C285_Single_Choose Payee Type v2"
    When I click continue on "C285_Single_Choose Payee Type v2"
    Then I am presented with the "C285_Single_Select Reimbursement Method Page v2"
    When I select radio button "Current Month Adjustment (CMA)" on "C285_Single_Select Reimbursement Method Page v2"
    And I click continue on "C285_Single_Select Reimbursement Method Page v2"
#    Then I am presented with the "C285_Single_Check These Bank Details Are Correct Page v2"
#    And I select radio button "yes" on "C285_Single_Check These Bank Details Are Correct Page v2"
#    When I click continue on "C285_Single_Check These Bank Details Are Correct Page v2"
    Then I am presented with the "C285_Single_Enter Bank Account Details Page v2"
    And I enter "" on "C285_Single_Enter Bank Account Details Page v2"
    When I click continue on "C285_Single_Enter Bank Account Details Page v2"
    Then I am presented with the "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    When I select radio button "Commercial invoice" on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    And I click continue on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    Then I am presented with the "UCDF_Choose File Other Page" "Commercial invoice"
    When I upload a 1 "document.pdf" file on "UCDF_Choose File Other Page"
    And I select radio button "No" on "UCDF_Choose File Other Page"
    And I click continue if I'm on "UCDF_Choose File Other Page"
    Then I am presented with the "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I enter "" on "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I click continue on "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I click "Enter the address manually" on "ALF_Lookup Address Lookup Page"
    And I enter "" on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Confirm Page"
    Then I am presented with the "C285_Single_Claimant Details Page v2"
    And I click continue on "C285_Single_Claimant Details Page v2"
    Then I am presented with the "C285_Single_Check Answers Accept Send Page v2"
    And I should see the following details
      | Reason for claim           | Personal details                                       | Bank details       | Uploaded files     | Address                                   |Duplicate MRN|Payee                          | Additional claim information                                   | What do you want to claim? |A85 - Provisional Anti-Dumping Duty |A90 - Definitive Countervailing Duty|A95 - Provisional Countervailing Duty| Total   | Movement Reference Number (MRN)               | Method                         |
      | Duplicate Movement Reference Number (MRN)  | Mr John Smith,someemail@mail.com,01234567890 | Mr John Smith,123456,11001001  | Commercial invoice:,document.pdf | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom  |20AAAAAAAAAAAAAAA1|Importer| under 500 characters                  | A95 - Provisional Countervailing Duty,A90 - Definitive Countervailing Duty,A85 - Provisional Anti-Dumping Duty|£10.00 | £10.00                          |£10.00                              | £30.00 | 60AAAAAAAAAAAAAAA5   | Current Month Adjustment (CMA) |
    When I click continue on "C285_Single_Check Answers Accept Send Page v2"
    Then I am presented with the "C285_Single_Claim Submitted Page v2"


  @ALF
  Scenario: happy path - confirm ALF data works in journey, no contact details (not regression tested since this is out of our team's scope)
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000006" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "c285" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "C285_Choose How Many Mrns Page"
    When I select radio button "individual" on "C285_Choose How Many Mrns Page"
    And I click continue on "C285_Choose How Many Mrns Page"
    Then I am presented with the "C285_Have Your Supporting Document Ready Page v2"
    When I clickContinue on "C285_Have Your Supporting Document Ready Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page"
    When I enter "10AAAAAAAAAAAAAAA6" on "C285_Single_Enter Movement Reference Number Page"
    And I click continue on "C285_Single_Enter Movement Reference Number Page"
    Then I am presented with the "C285_Single_Check Declaration Details Page"
    And I select radio button "yes" on "C285_Single_Check Declaration Details Page"
    And I click continue on "C285_Single_Check Declaration Details Page"
    Then I am presented with the "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I enter "" on "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I click continue on "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I click "Enter the address manually" on "ALF_Lookup Address Lookup Page"
    And I enter "" on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Confirm Page"
    Then I am presented with the "C285_Single_Claimant Details Page"
    And I click continue on "C285_Single_Claimant Details Page"
    Then I am presented with the "C285_Single_Claimant Details Enter Contact Details Page"
    And I enter "" on "C285_Single_Claimant Details Enter Contact Details Page"
    And I click continue on "C285_Single_Claimant Details Enter Contact Details Page"
    And I click "Enter the address manually" on "ALF_Lookup Address Lookup Page"
    And I enter "" on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Confirm Page"
    Then I am presented with the "C285_Single_Claimant Details Page"
    And I click continue on "C285_Single_Claimant Details Page"
    Then I am presented with the "C285_Single_Choose Basis For Claim Page"
    When I select radio button "Outward processing relief" on "C285_Single_Choose Basis For Claim Page"
    And I click continue on "C285_Single_Choose Basis For Claim Page"
    Then I am presented with the "C285_Single_Enter Additional Details Page"
    When I enter "under 500 characters" on "C285_Single_Enter Additional Details Page"
    And I click continue on "C285_Single_Enter Additional Details Page"
    Then I am presented with the "C285_Single_Select Duties Page"
    When I select "A80,A95,A90,A85" on "C285_Single_Select Duties Page"
    And I click continue on "C285_Single_Select Duties Page"
    Then I am presented with the "C285_Single_Enter Claim Page" "A80 - Definitive Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page"
    And I click continue on "C285_Single_Enter Claim Page"
    Then I am presented with the "C285_Single_Enter Claim Page" "A95 - Provisional Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page"
    And I click continue on "C285_Single_Enter Claim Page"
    Then I am presented with the "C285_Single_Enter Claim Page" "A90 - Definitive Countervailing Duty"
    When I enter "10" on "C285_Single_Enter Claim Page"
    And I click continue on "C285_Single_Enter Claim Page"
    Then I am presented with the "C285_Single_Enter Claim Page" "A85 - Provisional Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page"
    And I click continue on "C285_Single_Enter Claim Page"
    Then I am presented with the "C285_Single_Check Claim Page"
    # And I select radio button "yes" on "C285_Single_Check Claim Page"
    When I clickContinue on "C285_Single_Check Claim Page"
    Then I am presented with the "C285_Single_Check These Bank Details Are Correct Page"
    Then I am presented with the "C285_Single_Choose Payee Type v2"
    And I select radio button "Importer" on "C285_Single_Choose Payee Type v2"
    When I click continue on "C285_Single_Choose Payee Type v2"
    When I click continue on "C285_Single_Check These Bank Details Are Correct Page"
    Then I am presented with the "C285_Single_Supporting Evidence Select Supporting Evidence Type Page"
    When I select radio button "Commercial invoice" on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "UCDF_Choose File Other Page"
    When I upload a 1 "document.pdf" file on "UCDF_Choose File Other Page"
    And I select radio button "No" on "UCDF_Choose File Other Page"
    And I click continue if I'm on "UCDF_Choose File Other Page"
#    Then I am presented with the "UDF_Summary Page" "1"
#    When I select radio button "No" on "UDF_Summary Page"
#    And I click continue on "UDF_Summary Page"
    Then I am presented with the "C285_Single_Check Answers Accept Send Page"
    And I click continue on "C285_Single_Check Answers Accept Send Page"
    Then I am presented with the "C285_Single_Claim Submitted Page"


  @test
  Scenario: happy path with no bank details (user is both importer and declarant)- CMA not eligible - choose Bank account transfer
#  60AAAAAAAAAAAAAAA1 => No bank details (user is both importer and declarant),CMA eligible - skips payee indicator page and navigates to /enter-bank-account-details page after /choose-repayment-method page
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
#    When the "overpayments v2" feature is "enabled"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "c285" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "C285_Choose How Many Mrns Page v2"
    When I select radio button "individual" on "C285_Choose How Many Mrns Page v2"
    And I click continue on "C285_Choose How Many Mrns Page v2"
    Then I am presented with the "C285_Have Your Supporting Document Ready Page v2"
    When I clickContinue on "C285_Have Your Supporting Document Ready Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "60AAAAAAAAAAAAAAA1" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    #And I select radio button "yes" on "C285_Single_Check Declaration Details Page v2"
    And I click continue on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Choose Basis For Claim Page v2"
    When I select radio button "End use relief" on "C285_Single_Choose Basis For Claim Page v2"
    And I click continue on "C285_Single_Choose Basis For Claim Page v2"
    Then I am presented with the "C285_Single_Enter Additional Details Page v2"
    When I enter "under 500 characters" on "C285_Single_Enter Additional Details Page v2"
    And I click continue on "C285_Single_Enter Additional Details Page v2"
    Then I am presented with the "C285_Single_Select Duties Page v2"
    When I select "A80" on "C285_Single_Select Duties Page v2"
    And I click continue on "C285_Single_Select Duties Page v2"
    Then I am presented with the "C285_Single_Enter Claim Page v2" "A80 - Definitive Anti-Dumping Duty"
    When I enter "10" on "C285_Single_Enter Claim Page v2"
    And I click continue on "C285_Single_Enter Claim Page v2"
    Then I am presented with the "C285_Single_Check Claim Page v2"
    # And I select radio button "yes" on "C285_Single_Check Claim Page v2"
    When I clickContinue on "C285_Single_Check Claim Page v2"
    Then I am presented with the "C285_Single_Choose Payee Type v2"
    And I select radio button "Importer" on "C285_Single_Choose Payee Type v2"
    When I click continue on "C285_Single_Choose Payee Type v2"
#    Then I am presented with the "C285_Single_Check These Bank Details Are Correct Page v2"
#    And I select radio button "yes" on "C285_Single_Check These Bank Details Are Correct Page v2"
#    When I click continue on "C285_Single_Check These Bank Details Are Correct Page v2"
    Then I am presented with the "C285_Single_Enter Bank Account Details Page v2"
    And I enter "" on "C285_Single_Enter Bank Account Details Page v2"
    When I click continue on "C285_Single_Enter Bank Account Details Page v2"
    Then I am presented with the "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    When I select radio button "Commercial invoice" on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    And I click continue on "C285_Single_Supporting Evidence Select Supporting Evidence Type Page v2"
    Then I am presented with the "UCDF_Choose File Other Page" "Commercial invoice"
    When I upload a 1 "document.pdf" file on "UCDF_Choose File Other Page"
    And I select radio button "No" on "UCDF_Choose File Other Page"
    And I click continue if I'm on "UCDF_Choose File Other Page"
    Then I am presented with the "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I enter "" on "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I click continue on "C285_Single_Claimant Details Change Claimant Details Page v2"
    And I click "Enter the address manually" on "ALF_Lookup Address Lookup Page"
    And I enter "" on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Edit Page"
    And I click continue on "ALF_Lookup Address Confirm Page"
    Then I am presented with the "C285_Single_Claimant Details Page v2"
    And I click continue on "C285_Single_Claimant Details Page v2"
    Then I am presented with the "C285_Single_Check Answers Accept Send Page v2"
    And I should see the following details
      | Reason for claim    | Personal details                                                | Uploaded files                        | Address                             | Bank details        |Payee     | Additional claim information  |What do you want to claim? | A80 - Definitive Anti-Dumping Duty | Total   | Method                 |Movement Reference Number (MRN)               |
      | End use relief                      | Mr John Smith,someemail@mail.com,01234567890 | Commercial invoice:,document.pdf | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | Mr John Smith,123456,11001001      |Importer  | under 500 characters            |A80 - Definitive Anti-Dumping Duty| £10.00 | £10.00 | Bank account transfer |60AAAAAAAAAAAAAAA1 |
    When I click continue on "C285_Single_Check Answers Accept Send Page v2"
    Then I am presented with the "C285_Single_Claim Submitted Page v2"

  @test
  Scenario: happy path - Method of payment displays specified value in declaration details page
#  MRN: 00AA001AAAAAAAAA01, Payment Method/s:001; MRN: 00AA002AAAAAAAAA01, Payment Method/s:002; MRN: 00AA003AAAAAAAAA01, Payment Method/s:003; MRN: 00AA006AAAAAAAAA01, Payment Method/s:006; MRN: 00AA001002AAAAAA01, Payment Method/s:001, 002; MRN: 00AA001003AAAAAA01, Payment Method/s:001, 003; MRN: 00AA001006AAAAAA01,  Payment Method/s:001, 006; MRN: 00AA002003AAAAAA01, Payment Method/s:002, 003;
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "c285" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "C285_Choose How Many Mrns Page v2"
    When I select radio button "individual" on "C285_Choose How Many Mrns Page v2"
    And I click continue on "C285_Choose How Many Mrns Page v2"
    Then I am presented with the "C285_Have Your Supporting Document Ready Page v2"
    When I clickContinue on "C285_Have Your Supporting Document Ready Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "00AA001AAAAAAAAA01" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    And I should see the following details
      |MRN                  | Date of import      | Method of payment | Total       | Email                     |  Name              | Address                                           | A85 - Provisional Anti-Dumping Duty | A80 - Definitive Anti-Dumping Duty | A95 - Provisional Countervailing Duty |A90 - Definitive Countervailing Duty |
      | 00AA001AAAAAAAAA01  | 12 February 2021    | Immediate payment | £828.00     | automation@gmail.com      | Foxpro Central LTD | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | £171.00                             |£218.00                             | £211.00                               | £228.00                             |
    Then I go back on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "00AA002AAAAAAAAA01" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    And I should see the following details
      |MRN                 | Date of import   | Method of payment | Total       |    Email                 | Name               | Address                                           | A85 - Provisional Anti-Dumping Duty | A80 - Definitive Anti-Dumping Duty | A95 - Provisional Countervailing Duty    |A90 - Definitive Countervailing Duty |
      | 00AA002AAAAAAAAA01 | 12 February 2021 | Deferment account | £828.00     | automation@gmail.com     | Foxpro Central LTD | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | £171.00                             |                    £218.00         | £211.00                                  | £228.00                             |
    Then I go back on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "00AA003AAAAAAAAA01" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    And I should see the following details
      |MRN                  | Date of import      | Method of payment | Total        | Email                    | Name               | Address                                           | A85 - Provisional Anti-Dumping Duty | A80 - Definitive Anti-Dumping Duty | A95 - Provisional Countervailing Duty |A90 - Definitive Countervailing Duty |
      | 00AA003AAAAAAAAA01  | 12 February 2021    | Cash account      | £828.00      | automation@gmail.com     | Foxpro Central LTD | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | £171.00                             | £218.00                            | £211.00                               | £228.00                             |
    Then I go back on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "00AA001002AAAAAA01" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    And I should see the following details
      |MRN                  | Date of import      | Method of payment                       | Total         | Email                      |  Name              |  Address                                          | A85 - Provisional Anti-Dumping Duty | A80 - Definitive Anti-Dumping Duty | A95 - Provisional Countervailing Duty |A90 - Definitive Countervailing Duty |
      | 00AA001002AAAAAA01  | 12 February 2021    | Immediate payment and Deferment account | £828.00       | automation@gmail.com       | Foxpro Central LTD | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | £171.00                             | £218.00                            |  £211.00                              | £228.00                             |
    Then I go back on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "00AA001003AAAAAA01" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    And I should see the following details
      |MRN                  | Date of import      | Method of payment                  | Total        | Email                    | Name               | Address                                           | A85 - Provisional Anti-Dumping Duty | A80 - Definitive Anti-Dumping Duty | A95 - Provisional Countervailing Duty |A90 - Definitive Countervailing Duty |
      | 00AA001003AAAAAA01  | 12 February 2021    | Immediate payment and Cash account | £828.00      | automation@gmail.com     | Foxpro Central LTD | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | £171.00                             |  £218.00                           | £211.00                               | £228.00                             |
    Then I go back on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "00AA002003AAAAAA01" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    And I should see the following details
      |MRN                  | Date of import      | Method of payment                  | Total        | Email                     | Name               | Address                                           | A85 - Provisional Anti-Dumping Duty | A80 - Definitive Anti-Dumping Duty | A95 - Provisional Countervailing Duty |A90 - Definitive Countervailing Duty |
      | 00AA002003AAAAAA01  | 12 February 2021    | Deferment account and Cash account | £828.00      | automation@gmail.com      | Foxpro Central LTD | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | £171.00                             | £218.00                            | £211.00                               | £228.00                             |
    Then I go back on "C285_Single_Check Declaration Details Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "00AA006AAAAAAAAA01" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
    And I should see the following details
      |MRN                  | Date of import      | Method of payment | Total         | Email                      | Name               | Address                                           | A85 - Provisional Anti-Dumping Duty | A80 - Definitive Anti-Dumping Duty | A95 - Provisional Countervailing Duty |A90 - Definitive Countervailing Duty |
      | 00AA006AAAAAAAAA01  | 12 February 2021    | Subsidy           | £828.00       | automation@gmail.com       | Foxpro Central LTD | 12 Skybricks Road,Coventry,CV3 6EA,United Kingdom | £171.00                             | £218.00                            | £211.00                               | £228.00                             |

  @test
  Scenario: Error page when the MRN contains only new tax type codes
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
    And I click continue on "Auth Login Stub Page"
    Then I am presented with the "Check Eori Details Page"
    When I select radio button "yes" on "Check Eori Details Page"
    And I click continue on "Check Eori Details Page"
    Then I am presented with the "Select Claim Type Page"
    When I select radio button "c285" on "Select Claim Type Page"
    And I click continue on "Select Claim Type Page"
    Then I am presented with the "C285_Choose How Many Mrns Page v2"
    When I select radio button "individual" on "C285_Choose How Many Mrns Page v2"
    And I click continue on "C285_Choose How Many Mrns Page v2"
    Then I am presented with the "C285_Have Your Supporting Document Ready Page v2"
    When I clickContinue on "C285_Have Your Supporting Document Ready Page v2"
    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
    When I enter "10AAAAAAAAAAAAA301" on "C285_Single_Enter Movement Reference Number Page v2"
    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
    Then I am presented with the "C285_Single_Check Declaration Details Page v2"

#    @test
#    Scenario: Happy path page when the MRN contains both old and new tax type codes and user continues the journey
#    Given I navigate to the "Auth Login Stub Page"
#    When I enter redirectURL on "Auth Login Stub Page"
#    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "GB000000000000001" on "Auth Login Stub Page"
#    And I click continue on "Auth Login Stub Page"
#    Then I am presented with the "Check Eori Details Page"
#    When I select radio button "yes" on "Check Eori Details Page"
#    And I click continue on "Check Eori Details Page"
#    Then I am presented with the "Select Claim Type Page"
#    When I select radio button "c285" on "Select Claim Type Page"
#    And I click continue on "Select Claim Type Page"
#    Then I am presented with the "C285_Choose How Many Mrns Page v2"
#    When I select radio button "individual" on "C285_Choose How Many Mrns Page v2"
#    And I click continue on "C285_Choose How Many Mrns Page v2"
#    Then I am presented with the "C285_Single_Enter Movement Reference Number Page v2"
#    When I enter "10AAAAAAAAAAA00301" on "C285_Single_Enter Movement Reference Number Page v2"
#    And I click continue on "C285_Single_Enter Movement Reference Number Page v2"
#    Then I am presented with the "C285_Single_New Tax Type Code Validation Page v2"
#    And I select radio button "yes" on "C285_Single_New Tax Type Code Validation Page v2"
#    And I click continue on "C285_Single_New Tax Type Code Validation Page v2"
#    Then I am presented with the "C285_Single_Check Declaration Details Page v2"
