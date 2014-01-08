package org.virtuslab.genesis.plugins

import org.sbtidea.SbtIdeaPlugin

/**
 * Settings for sbt-idea plugin.
 *
 * @author Jerzy Müller
 */
object SbtIdea {

  private lazy val foldersToIgnore =  ".idea" :: ".idea_modules" :: ".settings" :: Nil

  lazy val settings = Seq(
    SbtIdeaPlugin.ideaExcludeFolders := foldersToIgnore
  )
}