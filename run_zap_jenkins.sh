#!/usr/bin/env bash

sbt -Dbrowser=remote-chrome -Denvironment=local -Dzap.proxy=true "testOnly uk.gov.hmrc.cdsrc.cucumber.runner.ZapRunner"
sbt "testOnly uk.gov.hmrc.cdsrc.ZapSpec"
