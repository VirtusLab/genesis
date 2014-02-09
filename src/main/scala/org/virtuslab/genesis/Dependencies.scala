package org.virtuslab.genesis

import sbt._

/**
 * Common dependencies.
 *
 * SORTED ALPHABETICALLY.
 *
 * @author Jerzy Müller
 */
object Dependencies {

  // A

  def akkaActor(version: String) = "com.typesafe.akka" %% "akka-actor" % version

  def akkaTestKit(version: String) = "com.typesafe.akka" %% "akka-testkit" % version

  def apachePoi(version: String) = "org.apache.poi" % "poi" % version

  // C

  def commonsIo(version: String) = "commons-io" % "commons-io" % version

  // F

  def flyingSaucer(version: String) = Seq(flyingSaucerCore _, flyingSaucerPdf _).map(_.apply(version))

  def flyingSaucerCore(version: String) = "org.xhtmlrenderer" % "flying-saucer-core" % version

  def flyingSaucerPdf(version: String) = "org.xhtmlrenderer" % "flying-saucer-pdf" % version

  // H

  def h2DbDriver(version: String) = "com.h2database" % "h2" % version

  // I

  val itext = "com.lowagie" % "itext" % "2.0.8"

  // J

  def jbcrypt(version: String) = "org.mindrot" % "jbcrypt" % version

  def jodaTime(version: String) = "joda-time" % "joda-time" % version

  def jodaConvert(version: String) = "joda-time" % "joda-convert" % version

  def jsMessages(version: String) = "com.github.julienrf" %% "play-jsmessages" % version

  def junit(version: String) = "junit" % "junit" % version

  // L

  def liftJson(version: String) = "net.liftweb" %% "lift-json" % version

  def liftMapper(version: String) = "net.liftweb" %% "lift-mapper" % version

  def liftTestKit(version: String) = "net.liftweb" %% "lift-testkit" % version

  def log4j(version: String) = "log4j" % "log4j" % version

  // M

  def mockitoCore(version: String) = "org.mockito" % "mockito-core" % version

  def mySqlDriver(version: String) = "mysql" % "mysql-connector-java" % version

  // P

  def playTest(version: String) = "com.typesafe.play" %% "play-test" % version

  def postgresDriver(version: String) = "postgresql" % "postgresql" % version

  // S

  def scalaTest(version: String) = "org.scalatest" %% "scalatest" % version

  def slick(version: String) = "com.typesafe.slick" %% "slick" % version

  def slickTestKit(version: String) = "com.typesafe.slick" %% "slick-testkit" % version

  def slf4jLog4j12(version: String) = "org.slf4j" % "slf4j-log4j12" % version

  def specs2(version: String) = "org.specs2" %% "specs2" % version

  def specs(version: String) = "org.scala-tools.testing" %% "specs" % version

  // T

  def twitter4j(version: String) = "org.twitter4j" % "twitter4j-core" % version

  // V

  def vlc(version: String) = Seq(vlcUtil _, vlcPm _, vlcUm _, vlcUi _).map(_.apply(version))

  def vlcUtil(version: String) = "com.virtuslab.commons" % "commons-util" % version

  def vlcPm(version: String) = "com.virtuslab.commons" % "commons-pm" % version

  def vlcUm(version: String) = "com.virtuslab.commons" % "commons-um" % version

  def vlcUi(version: String) = "com.virtuslab.commons" % "commons-ui" % version

}