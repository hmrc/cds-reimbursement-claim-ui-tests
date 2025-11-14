# cds-reimbursement-claim-ui-tests

UI test suite for the CDS Reimbursement service cds-reimbursement-claim-frontend for  (`cds-reimbursement-claim-ui-tests`) -
UI test suite using WebDriver and `cucumber`for BDD Testing and Service Manager for managing dependencies locally.

## Nomenclature

A list of definitions for unusual terms in the code.

## Technical documentation

Link to the journey's :- https://confluence.tools.tax.service.gov.uk/display/CDSR/Entire+User+Journeys+-+June+2025

##  Pre-requisites

### Services

Prior to executing the tests ensure you have:
- Docker - to run mongo and browser (Chrome or Firefox) inside a container
  docker run --rm -d --name mongo -d -p 27017:27017 mongo:4.0
- Java (JDK 11 or 21) - Required to compile and run Scala-based projects
  CDSR is mainly compatible with JDK 21
- sbt(Scala Build Tool) - Required to compile & run the application. Ensure the version matches what's in build.sbt
- Git - To clone the repository and manage branches
    1) https://github.com/hmrc/cds-reimbursement-claim-ui-tests
    2) https://github.com/hmrc/cds-reimbursement-claim-frontend
    3) https://github.com/hmrc/cds-reimbursement-claim-stubs
- Appropriate [drivers installed](#installing-local-driver-binaries) - to run tests against locally installed Browser
- Installed/configured [service manager](https://github.com/hmrc/service-manager).

Run the following command to start the services locally:

```
   sm2 -start CDSRC_ALL
```

To stop the services:

```
    sm2 --stop-all
```

To check the status of services:

```
sm2 --status
```

## Running the Tests

Run Acceptance test using SM2 Locally

1. Navigate to the directory where the project has been cloned.
2. To run all acceptance tests on your local machine, use: ```./run_tests.sh```
3. To run all tests that are tagged as "@wip", use: ```./run_tests_wip.sh```
4. By default, the scripts execute in headless mode. To run them with the browser ui visible, set the below-mentioned property in run_tests_wip.sh script - Argument -Dbrowser.option.headless=false

## Security and Accessibility tests
The accessibility and ZAP tests are run as part of Jenkins job. 
We can get the latest reports from the corresponding acceptance-tests CDS Reimbursement Claim UI Tests job.

## Test the application manually

1. Local
   auth-login-stub  (Link 'http://localhost:9949/auth-login-stub/gg-sign-in')

   Details to give in Authority wizard page
   Redirect url      = http://localhost:7500/claim-back-import-duty-vat/start
   Enrolment Key     ='HMRC-CUS-ORG'
   Identifier Name   ='EORINumber'
   Identifier Value  ='GB000000000000001'

2. Development
   auth-login-stub  (Link 'https://www.development.tax.service.gov.uk/auth-login-stub/gg-sign-in?continue=%2Fclaim-back-import-duty-vat%2Fstart')

   Details to give in Authority wizard page
   Redirect url      = /claim-back-import-duty-vat/start
   Enrolment Key     ='HMRC-CUS-ORG'
   Identifier Name   ='EORINumber'
   Identifier Value  ='GB000000000000001'


3. Staging
   auth-login-stub (Link 'https://www.staging.tax.service.gov.uk/auth-login-stub/gg-sign-in?continue=%2Fclaim-back-import-duty-vat%2Fstart')

   Details to give in Authority wizard page
   Redirect url      = /claim-back-import-duty-vat/start
   Enrolment Key     ='HMRC-CUS-ORG'
   Identifier Name   ='EORINumber'
   Identifier Value  ='GB000000000000001'


## Useful links

All the useful link for the CDSR space is listed in confluence page https://confluence.tools.tax.service.gov.uk/display/CDSR/Useful+URL%27S+%2CUI+Automation+%2CPerformance+Test+Repos+and+Requirement

1. Link to the Stub data used in local and staging environment(git hub)   =https://github.com/hmrc/cds-reimbursement-claim-stubs/blob/main/README.md
2. Link to the Stub data used in local and staging environment Confluence = https://confluence.tools.tax.service.gov.uk/display/CDSR/Simulation+Data


### Scalafmt
This repository uses [Scalafmt](https://scalameta.org/scalafmt/), a code formatter for Scala. The formatting rules configured for this repository are defined within [.scalafmt.conf](.scalafmt.conf).

To apply formatting to this repository using the configured rules in [.scalafmt.conf](.scalafmt.conf) execute:

 ```
 sbt scalafmtAll
 ```
    
To check files have been formatted as expected execute:

 ```
 sbt scalafmtCheckAll scalafmtSbtCheck
 ```

[Visit the official Scalafmt documentation to view a complete list of tasks which can be run.](https://scalameta.org/scalafmt/docs/installation.html#task-keys)
