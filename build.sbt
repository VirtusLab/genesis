sbtPlugin := true

name := "genesis"

organization := "org.virtuslab"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.3"

// plugin for dependency graphs
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

// scala code style
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")

// idea plugin
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")

// scalariform plugin
addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.2.0")