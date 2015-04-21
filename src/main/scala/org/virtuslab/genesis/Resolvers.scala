package org.virtuslab.genesis

import sbt._

/**
 * Common resolvers.
 *
 * @author Jerzy Müller
 */
object Resolvers {

  val luminis = "Luminis Research Repo" at "http://lresearch.net/maven2"

  val scalaToolsReleases = "Scala-Tools Dependencies Repository for Releases" at "https://oss.sonatype.org/content/groups/scala-tools"

  val dukascopy = "Dukascopy public repository" at "https://www.dukascopy.com/client/jforexlib/publicrepo/"

  val sonatypeSnapshots = Resolver.sonatypeRepo("snapshots")

  val sonatypeReleases = Resolver.sonatypeRepo("releases")

  val julienrf = "julienrf.github.com" at "http://julienrf.github.com/repo/"
}
