import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "ui-test-runner"    % "0.21.0"   % Test,
    "uk.gov.hmrc"         %% "webdriver-factory" % "0.46.0"   % Test,
    "org.scalatest"       %% "scalatest"         % "3.2.18"   % Test,
    "org.scalatestplus"   %% "selenium-4-12"     % "3.2.17.0" % Test,
    "com.vladsch.flexmark" % "flexmark-all"      % "0.64.8"   % Test,
    "io.cucumber"         %% "cucumber-scala"    % "8.20.0"   % Test,
    "io.cucumber"          % "cucumber-junit"    % "7.15.0"   % Test,
    "junit"                % "junit"             % "4.13.2"  % Test,
    "com.novocode"         % "junit-interface"   % "0.11"    % Test,
    "com.typesafe"         % "config"            % "1.4.3"   % Test,
    "ch.qos.logback"       % "logback-classic" % "1.5.1"  % Test,
    "commons-io"           % "commons-io"        % "2.15.1"
  )

}
