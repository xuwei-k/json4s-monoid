val json4sVersion = "3.2.6"
val scalazV = "7.0.5"

libraryDependencies ++= Seq(
  "org.typelevel" %% "scalaz-specs2" % "0.1.5" % "test",
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazV % "test",
  "org.json4s" %% "json4s-scalaz" % json4sVersion,
  "org.json4s" %% "json4s-native" % json4sVersion
)
