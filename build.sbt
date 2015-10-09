val ElementReleases  = "Element Releases"  at "http://repo.element.hr/nexus/content/repositories/releases/"
val ElementSnapshots = "Element Snapshots" at "http://repo.element.hr/nexus/content/repositories/snapshots/"

// ### BASIC SETTINGS ### //
organization := "io.jvm"
name := "scala-uuid"
version := "0.1.6"

unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value)
unmanagedSourceDirectories in Test := Seq((scalaSource in Test).value)

publishTo := Some(if (version.value endsWith "-SNAPSHOT") ElementSnapshots else ElementReleases)
publishArtifact in (Compile, packageDoc) := false

credentials ++= {
  val creds = Path.userHome / ".config" / "scala-uuid" / "nexus.config"
  if (creds.exists) Some(Credentials(creds)) else None
}.toSeq

// ### COMPILE SETTINGS ### //
crossScalaVersions := Seq("2.9.0", "2.9.0-1", "2.9.1", "2.9.1-1", "2.9.2", "2.9.3")
scalaVersion := crossScalaVersions.value.head
scalacOptions := Seq(
  "-deprecation"
, "-encoding", "UTF-8"
, "-optimise"
, "-unchecked"
, "-Xmax-classfile-name", "72"
, "-Xno-forwarders"
, "-Yclosure-elim"
, "-Ydead-code"
, "-Yinline"
, "-Ywarn-dead-code"
)
