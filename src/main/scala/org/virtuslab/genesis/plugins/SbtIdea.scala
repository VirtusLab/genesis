package org.virtuslab.genesis.plugins

import org.sbtidea.SbtIdeaPlugin
import sbt._
import sbt.Keys._

/**
 * Settings for sbt-idea plugin.
 *
 * @author Jerzy Müller
 */
object SbtIdea {

  private lazy val foldersToIgnore = ".idea" :: ".idea_modules" :: ".settings" :: Nil

  val fixingIdeaImport =
    sourceGenerators in Compile += task {
      val dir: File = (sourceManaged in Compile).value / "controllers"
      val dirs = Seq(dir / "ref", dir / "javascript")
      if (dir.exists()) dirs.foreach(_.mkdirs)
      Seq.empty[File]
    }

  lazy val settings: Seq[Setting[_]] = Seq(
    SbtIdeaPlugin.ideaExcludeFolders := foldersToIgnore,
    fixingIdeaImport
  )
}