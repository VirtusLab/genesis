sbtPlugin := true

name := "genesis"

organization := "org.virtuslab"

version := "0.1.6-SNAPSHOT"

scalaVersion := "2.10.4"

exportJars := true

// plugin for dependency graphs
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.5")

// scala code style
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")

// idea plugin
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

// scalariform plugin
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.5.1")

// sbt-updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.9")

// self-dependency ;)
org.virtuslab.genesis.Genesis.common
