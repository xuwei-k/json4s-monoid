libraryDependencies ++= {
val json4sVersion = "3.2.4"
Seq(
  "org.typelevel" %% "scalaz-specs2" % "0.1.3" % "test",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.0.0-RC1" % "test",
  "org.json4s" %% "json4s-scalaz" % json4sVersion,
  "org.json4s" %% "json4s-native" % json4sVersion
)
}
