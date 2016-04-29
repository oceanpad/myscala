name := """myscala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "mysql" % "mysql-connector-java" % "5.1.21",
	"com.sksamuel.scrimage" %% "scrimage-core" % "2.1.5",
	"com.sksamuel.scrimage" %% "scrimage-io-extra" % "2.1.0",
	"com.sksamuel.scrimage" %% "scrimage-filters" % "2.1.0"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
