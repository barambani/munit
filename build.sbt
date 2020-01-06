def scala213 = "2.13.1"
def scala212 = "2.12.10"
def scala211 = "2.11.12"
inThisBuild(
  List(
    organization := "com.geirsson",
    homepage := Some(url("https://github.com/olafurpg/funsuite")),
    licenses := List(
      "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
    ),
    developers := List(
      Developer(
        "olafurpg",
        "Ólafur Páll Geirsson",
        "olafurpg@gmail.com",
        url("https://geirsson.com")
      )
    ),
    scalaVersion := scala213,
    crossScalaVersions := List(scala213, scala212, scala211),
    fork := true,
    testFrameworks := List(
      new TestFramework("funsuite.Framework")
    ),
    resolvers += Resolver.sonatypeRepo("public")
  )
)

skip in publish := true

lazy val fansiVersion = Def.setting[String] {
  if (scalaVersion.value.startsWith("2.11")) "0.2.6"
  else "0.2.7"
}
lazy val pprintVersion = Def.setting[String] {
  if (scalaVersion.value.startsWith("2.11")) "0.5.4"
  else "0.5.7"
}

lazy val funsuite = project
  .settings(
    libraryDependencies ++= List(
      "junit" % "junit" % "4.13",
      "com.geirsson" % "junit-interface" % "0.11.4-SNAPSHOT",
      "com.lihaoyi" %% "sourcecode" % "0.1.9",
      "com.lihaoyi" %% "fansi" % fansiVersion.value,
      "com.googlecode.java-diff-utils" % "diffutils" % "1.3.0",
      "com.lihaoyi" %% "pprint" % pprintVersion.value
    )
  )
