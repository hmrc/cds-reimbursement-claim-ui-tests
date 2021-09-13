#!/bin/bash

browserStackUsername="insert-Your-Username"
browserStackAutomateKey="insert-Your-Key"

#WindowsOS
sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="93" -Dbrowserstack.browser="Chrome" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="10" 'testOnly uk.gov.hmrc.cdsrc.cucumber.runner.BrowserStackRunner'
sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="91" -Dbrowserstack.browser="Firefox" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="10" 'testOnly uk.gov.hmrc.cdsrc.cucumber.runner.BrowserStackRunner'
sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="93.0" -Dbrowserstack.browser="EDGE" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="10" 'testOnly uk.gov.hmrc.cdsrc.cucumber.runner.BrowserStackRunner'
sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="11" -Dbrowserstack.browser="IE" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="10" 'testOnly uk.gov.hmrc.cdsrc.cucumber.runner.BrowserStackRunner'
#macOS
sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="91" -Dbrowserstack.browser="Firefox" -Dbrowserstack.os="OS X" -Dbrowserstack.os_version="Catalina" 'testOnly uk.gov.hmrc.cdsrc.cucumber.runner.BrowserStackRunner'
sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="93" -Dbrowserstack.browser="Chrome" -Dbrowserstack.os="OS X" -Dbrowserstack.os_version="Catalina" 'testOnly uk.gov.hmrc.cdsrc.cucumber.runner.BrowserStackRunner'


