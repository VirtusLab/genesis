package org.virtuslab.genesis.tasks

import sbt._
import sbt.Keys._
import java.text.SimpleDateFormat
import java.util.Date

abstract class VersionFormatter extends ((String, Date, String) => String) {
  def apply(oldVersion: String, currentDate: Date, sha: String): String
}

object StandardVersionFormatter extends VersionFormatter {
  def apply(oldVersion: String, currentDate: Date, sha: String): String = {
    val date = new SimpleDateFormat("yyyyMMdd").format(currentDate)
    oldVersion.replaceAll("SNAPSHOT", s"$date-$sha-SNAPSHOT")
  }
}

trait Configuration {

  lazy val versionFormatter = settingKey[VersionFormatter]("Version formatter, function from 'old version' and 'currentDate")

  protected val defaults: Seq[Setting[_]] = Seq(
    versionFormatter := StandardVersionFormatter
  )
}

/**
 * Generates current commit SHA for git and mercurial (hg).
 *
 * @author Jerzy Müller
 */
object CommitNumber extends Configuration {

  lazy val gitHeadCommitSha = settingKey[String]("current git commit SHA")

  lazy val gitSettings: Seq[Setting[_]] = defaults ++ Seq(
    gitHeadCommitSha in ThisBuild := Process("git rev-parse HEAD").lines.head,
    version := {
      val old: String = version.value
      val sha: String = gitHeadCommitSha.value
      val formatter: VersionFormatter = versionFormatter.value
      val snapshot: Boolean = old endsWith "-SNAPSHOT"
      if (snapshot) formatter(old, new Date, sha) else old
    }
  )

  lazy val hgHeadCommitSha = settingKey[String]("current hg commit SHA")

  lazy val hgHeadCommitNum = settingKey[String]("current hg commit number (may vary from repo to repo)")

  val hgSettings: Seq[Setting[_]] = defaults ++ Seq(
    hgHeadCommitSha in ThisBuild := Process("hg id -i").lines.head.replaceAll( """(\n|\r|\+)""", ""),
    hgHeadCommitNum in ThisBuild := Process("hg id -n").lines.head.replaceAll( """(\n|\r|\+)""", ""),
    version := {
      val old: String = version.value
      val sha: String = hgHeadCommitSha.value
      val formatter: VersionFormatter = versionFormatter.value
      val snapshot: Boolean = old endsWith "-SNAPSHOT"
      if (snapshot) formatter(old, new Date, sha) else old
    }
  )

}