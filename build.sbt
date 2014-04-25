val json4sVersion = "3.2.9"
val scalazV = "7.0.6"

def scalazSpecs2version(v: String) = (
  if(v.startsWith("2.10")) "0.1.5"
  else "0.2"
)

libraryDependencies ++= Seq(
  "org.typelevel" %% "scalaz-specs2" % scalazSpecs2version(scalaVersion.value) % "test",
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazV % "test",
  "org.json4s" %% "json4s-scalaz" % json4sVersion,
  "org.json4s" %% "json4s-native" % json4sVersion
)

licenses += ("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php"))

