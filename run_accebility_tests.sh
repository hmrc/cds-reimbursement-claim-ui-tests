#!/bin/bash
set -e
ENV=${1:-local}
BROWSER=${2:-chrome}
DRIVER=

if [ "$BROWSER" = "chrome" ]; then
    DRIVER="-Dwebdriver.chrome.driver=/usr/local/bin/chromedriver"
elif [ "$BROWSER" = "firefox" ]; then
    DRIVER="-Dwebdriver.gecko.driver=/usr/local/bin/geckodriver"
fi

sbt -Dbrowser=$BROWSER -Denvironment=$ENV $DRIVER -Ddrivernotquit=true "testOnly uk.gov.hmrc.cdsrc.cucumber.runner.AccessibilityRunner"
