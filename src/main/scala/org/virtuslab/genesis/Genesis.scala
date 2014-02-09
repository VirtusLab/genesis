package org.virtuslab.genesis

import sbt._
import org.virtuslab.genesis.plugins.{ SbtIdea, Scalariform }
import org.virtuslab.genesis.tasks.VersionReport
import net.virtualvoid.sbt.graph
import sbt.Keys._

object Genesis extends Plugin {

  lazy val prompt = shellPrompt := (_ => s"${moduleName.value}-${version.value}> ")

  lazy val aliases = addCommandAlias("pluginUpdates", "; reload plugins; dependencyUpdates; reload return")

  lazy val common: Seq[Setting[_]] =
    BuildSettings.settings ++
      Scalariform.settings ++
      SbtIdea.settings ++
      VersionReport.settings ++
      graph.Plugin.graphSettings ++
      aliases ++ Seq(
        prompt
      )
}
