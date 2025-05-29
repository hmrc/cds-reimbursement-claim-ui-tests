resolvers += "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/"
resolvers += Resolver.url("HMRC Sbt Plugin Releases", url("https://dl.bintray.com/hmrc/sbt-plugin-releases"))(
  Resolver.ivyStylePatterns
)
resolvers += MavenRepository("HMRC-open-artefacts-maven2", "https://open.artefacts.tax.service.gov.uk/maven2")
resolvers += Resolver.url("HMRC-open-artefacts-ivy", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(
  Resolver.ivyStylePatterns
)
resolvers += Resolver.typesafeRepo("releases")
addSbtPlugin("uk.gov.hmrc"   % "sbt-auto-build"  % "3.24.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt"    % "2.5.0")
addSbtPlugin("uk.gov.hmrc"   % "sbt-test-report" % "1.0.0")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.4")


