package org.virtuslab.genesis.test

import sbt.Keys._
import sbt._

/**
 * Settings for generating JUnit-compatible test reports.
 *
 * @author Jerzy Müller
 */
object JUnitReports {

  lazy val settings: Seq[Setting[_]] = Seq(
    testListeners <<= (target, streams).map((t, s) => Seq(new JUnitXmlTestsListener(t.getAbsolutePath, s.log)))
  )

}