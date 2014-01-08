package org.virtuslab.genesis

import sbt._
import sbt.Keys._
import org.virtuslab.genesis.plugins.{ SbtIdea, Scalariform }
import org.virtuslab.genesis.tasks.VersionReport
import net.virtualvoid.sbt.graph

object Genesis extends Plugin {

  lazy val common =
    BuildSettings.settings ++
    Scalariform.settings ++
    SbtIdea.settings ++
    VersionReport.settings ++
    graph.Plugin.graphSettings
}



