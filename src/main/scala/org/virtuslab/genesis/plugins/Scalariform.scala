package org.virtuslab.genesis.plugins

import com.typesafe.sbt.SbtScalariform._
import sbt._
import scalariform.formatter.preferences._

/**
 * Settings for Scalariform - scala auto-formatter
 *
 * @author Jerzy Müller
 */
object Scalariform {

  private lazy val commonScalariformPreferences = FormattingPreferences()
    // so you can write "a should equals (b)" or "def * = a ~ b <> (A.apply, A.unapply)"
    .setPreference(PreserveSpaceBeforeArguments, true)
    // so you can write:
    // Seq(
    //  alaMaKotaAKotJestWPaski
    // )
    .setPreference(PreserveDanglingCloseParenthesis, true)
    // aligning multi-line parameters to first one (like intellij does)
    .setPreference(AlignParameters, true)
    // aligning => in case statements vertically
    .setPreference(AlignSingleLineCaseStatements, true)

  lazy val settings : Seq[Setting[_]]= scalariformSettings ++ Seq(
    ScalariformKeys.preferences := commonScalariformPreferences
  )
}