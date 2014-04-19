sbtPlugin := true

name := "genesis"

organization := "org.virtuslab"

version := "0.1.4-SNAPSHOT"

scalaVersion := "2.10.4"

exportJars := true

// plugin for dependency graphs
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

// scala code style
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")

// idea plugin
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

// scalariform plugin
addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.2.0")

// sbt-updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.3")

// self-dependency ;)
org.virtuslab.genesis.Genesis.common
