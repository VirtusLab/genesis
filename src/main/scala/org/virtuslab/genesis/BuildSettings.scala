package org.virtuslab.genesis

import sbt._
import sbt.Keys._

/**
 * Common settings for build.
 *
 * @author Jerzy Müller
 */
object BuildSettings {

  lazy val compilerFlags = scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-Xlint",
    "-Ywarn-all"
  ) ++ {
      if (scalaVersion.value.startsWith("2.1")) Seq("-feature") else Seq.empty
    }

  val settings: Seq[Setting[_]] = Seq(
    compilerFlags
  )
}