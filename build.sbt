name := "atcoder"
version := "0.1.0"
organization := "com.github.kxbmap"

scalaVersion := "2.11.5"

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"

fork in Test := true
javaOptions in Test += "-Dline.separator=\n"
