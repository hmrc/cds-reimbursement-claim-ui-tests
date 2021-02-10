@Regression

Feature: Exploratory file using Cucumber

  @test
  Scenario Outline: User is a CDS Trader, has an EORI, uploads different types of valid files
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "AA12345678901234Z" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"
    Then I am presented with the "Enter Movement Reference Number Page"
    When I enter "10ABCDEFGHIJKLMNO0" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    Then I am presented with the "Declarant Details Page"
    When I click continue on "Declarant Details Page"
    Then I am presented with the "Who Is The Declarant Page"
    When I select radio button "0" on "Who Is The Declarant Page"
    And I click continue on "Who Is The Declarant Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    When I upload a <filetype> file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    Then I am presented with the "Supporting Evidence Select Supporting Evidence Type Page"
    When I select document type "Bill of Lading" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "Supporting Evidence Check Your Answers Page"
    When I click continue on "Supporting Evidence Check Your Answers Page"
    Then I am presented with the "Check Answers Accept Send Page"

    Examples:
      | filetype       |
      | "image.jpg"    |
      | "image.png"    |
      | "document.pdf" |
      | "document.doc" |
      | "document.xls" |

  @test
  Scenario: User is a CDS Trader, has an EORI, uploads 3 valid files
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "AA12345678901234Z" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"
    Then I am presented with the "Enter Movement Reference Number Page"
    When I enter "10ABCDEFGHIJKLMNO0" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    Then I am presented with the "Declarant Details Page"
    When I click continue on "Declarant Details Page"
    Then I am presented with the "Who Is The Declarant Page"
    When I select radio button "0" on "Who Is The Declarant Page"
    And I click continue on "Who Is The Declarant Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    # upload file 1
    When I upload a "image.jpg" file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    When I select document type "C88/E2" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click "Add another file" on "Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    # ---
    # upload file 2
    When I upload a "image.jpg" file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    When I select document type "Packing List" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click "Add another file" on "Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    # ---
    #upload file 3
    When I upload a "document.pdf" file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    When I select document type "Commercial Invoice" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "Supporting Evidence Check Your Answers Page"
    # ---
    When I click continue on "Supporting Evidence Check Your Answers Page"
    Then I am presented with the "Check Answers Accept Send Page"

  @test
  Scenario: User fails file upload process
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "AA12345678901234Z" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"
    Then I am presented with the "Enter Movement Reference Number Page"
    When I enter "10ABCDEFGHIJKLMNO0" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    Then I am presented with the "Declarant Details Page"
    When I click continue on "Declarant Details Page"
    Then I am presented with the "Who Is The Declarant Page"
    When I select radio button "0" on "Who Is The Declarant Page"
    And I click continue on "Who Is The Declarant Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    # I don't upload a file, but I click continue
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    Then I am presented with the "Supporting Evidence Document Did Not Upload Page"
    And I click continue on "Supporting Evidence Document Did Not Upload Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    # ---
    # I upload a file that is too big
    When I upload a "image-big.jpg" file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    Then I am presented with the "Supporting Evidence Document Did Not Upload Page"
    And I click continue on "Supporting Evidence Document Did Not Upload Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    # ---
    # I upload a file that isn't allowed
#    When I upload a "other.dmg" file on "Supporting Evidence Upload Supporting Evidence Page"
#    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
#    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
#    Then I am presented with the "Supporting Evidence Problem With Document Page"
#    And I click continue on "Supporting Evidence Problem With Document Page"
#    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    # ---
    # I upload a file that isn't allowed and is too big
#    When I upload a "other-big.dmg" file on "Supporting Evidence Upload Supporting Evidence Page"
#    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
#    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
#    Then I am presented with the "Supporting Evidence Document Did Not Upload Page"
#    And I click continue on "Supporting Evidence Problem With Document Page"
#    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    # ---
    # I upload a good file but don't select a description
    When I upload a "image.jpg" file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    Then I am presented with the "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "Supporting Evidence Select Supporting Evidence Type Page" error page
    # ---
    # I select a description
    When I select document type "Air Waybill" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    Then I am presented with the "Supporting Evidence Check Your Answers Page"
    # ---
    # I remove all uploaded documents
    When I click "Remove" on "Supporting Evidence Check Your Answers Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    # ---
    # I upload a file successfully
    When I upload a "image.jpg" file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    Then I am presented with the "Supporting Evidence Select Supporting Evidence Type Page"
    When I select document type "Bill of Lading" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "Supporting Evidence Check Your Answers Page"
    # ---
    When I click continue on "Supporting Evidence Check Your Answers Page"
    Then I am presented with the "Check Answers Accept Send Page"

  @testFail
  Scenario Outline: User is a CDS Trader, has an EORI, uploads different types of invalid files
    Given I navigate to the "Auth Login Stub Page"
    When I enter redirectURL on "Auth Login Stub Page"
    And I enter Enrollment Key "HMRC-CUS-ORG", ID Name "EORINumber" and ID Value "AA12345678901234Z" on "Auth Login Stub Page"
    And I click submit on "Auth Login Stub Page"
    Given I navigate to the "Start Page"
    Then I am presented with the "Enter Movement Reference Number Page"
    When I enter "10ABCDEFGHIJKLMNO0" on "Enter Movement Reference Number Page"
    And I click continue on "Enter Movement Reference Number Page"
    Then I am presented with the "Declarant Details Page"
    When I click continue on "Declarant Details Page"
    Then I am presented with the "Who Is The Declarant Page"
    When I select radio button "0" on "Who Is The Declarant Page"
    And I click continue on "Who Is The Declarant Page"
    Then I am presented with the "Supporting Evidence Upload Supporting Evidence Page"
    When I upload a <filetype> file on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue on "Supporting Evidence Upload Supporting Evidence Page"
    And I click continue if I'm on "Supporting Evidence Scan Progress Page"
    Then I am presented with the "Supporting Evidence Select Supporting Evidence Type Page"
    When I select document type "Bill of Lading" on "Supporting Evidence Select Supporting Evidence Type Page"
    And I click continue on "Supporting Evidence Select Supporting Evidence Type Page"
    Then I am presented with the "Supporting Evidence Check Your Answers Page"
    When I click continue on "Supporting Evidence Check Your Answers Page"
    Then I am presented with the "Check Answers Accept Send Page"

    Examples:
      | filetype       |
      | "document.odt" |
      | "document.ods" |
      | "document.odp" |
      | "document.rtf" |
      | "image.gif"    |
      | "image.tiff"   |
      | "image.ico"    |
      | "image.svg"    |
      | "image.webp"   |
      | "audio.mp3"    |
      | "audio.wav"    |
      | "audio.ogg"    |
      | "video.avi"    |
      | "video.mov"    |
      | "video.mp4"    |
      | "video.ogg"    |
      | "video.wmv"    |
      | "video.webm"   |
      | "other.csv"    |
      | "other.json"   |
      | "other.xml"    |
      | "other.html"   |
      | "other.zip"    |
