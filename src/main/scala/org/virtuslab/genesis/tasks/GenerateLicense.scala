package org.virtuslab.genesis.tasks

import sbt._
import sbt.Keys._

object LicenseKeys {

  val license = settingKey[String]("LICENSE text to add to files")

  val licensedFiles = settingKey[Seq[String]]("Extensions of files to add license to")

  val generateLicense = taskKey[Seq[File]]("Adds licence to all *.scala files")

}

/**
 * Task for generating license in all your files.
 *
 * @author Jerzy Müller
 */
object GenerateLicense {

  import LicenseKeys._

  val generateLicenseTask = generateLicense := {
    val files: Seq[File] = (sources in Compile).value
    val licenseContent: String = license.value
    val extensions: Seq[String] = licensedFiles.value

    val correctType = (file: File) => extensions.exists(file.name.endsWith)

    for {
      file <- files
      if correctType(file)
      content = IO.read(file)
      if !content.startsWith(licenseContent)
    } yield {
      IO.write(file, licenseContent + content)
      file
    }
  }
}