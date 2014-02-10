package org.virtuslab.genesis.tasks

import sbt._
import sbt.Keys._

/**
 * Task for creating version report.
 *
 * @author Jerzy Müller
 */
object VersionReport {

  lazy val versionReport = taskKey[String]("Prints report with all dependencies and it's versions. Sorted by artifact name.")

  lazy val versionReportTask = versionReport := {
    val dependencies: Seq[Attributed[sbt.File]] = (externalDependencyClasspath in Compile).value

    val log = streams.value.log

    val artifactSort: (Attributed[sbt.File]) => String = attributed =>
      attributed.get(Keys.moduleID.key) match {
        case Some(moduleId) => moduleId.name
        case None           => attributed.data.getName
      }

    val nameExtractor: (Attributed[sbt.File]) => String = attributed =>
      attributed.get(Keys.moduleID.key) match {
        case Some(moduleId) => "%35s %20s %15s %15s".format(
          moduleId.organization,
          moduleId.name,
          moduleId.revision,
          moduleId.configurations.getOrElse("")
        )
        case None =>
          // unmanaged JAR, just
          attributed.data.getAbsolutePath
      }

    val report = dependencies.sortBy(artifactSort).map(nameExtractor).mkString("\n")
    log.info(report)
    report
  }

  lazy val settings: Seq[Setting[_]] = Seq(
    versionReportTask
  )
}