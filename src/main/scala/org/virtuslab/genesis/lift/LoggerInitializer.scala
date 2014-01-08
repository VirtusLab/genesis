package org.virtuslab.genesis.lift

import sbt.Keys._
import sbt.Tests


/**
 * Logger initializer for Lift projects.
 *
 * @author Jerzy Müller
 */
object LoggerInitializer {

  lazy val fuckedUpLiftTestLoggerSettings =
    testOptions += Tests.Setup.apply {
      loader: ClassLoader =>
      // Get Logger.setup
        val boxClass = loader.loadClass("net.liftweb.common.Box")
        val loggerClass = loader.loadClass("net.liftweb.common.Logger$")
        val logger = loggerClass.getField("MODULE$").get(null)
        val loggerSetupEq = loggerClass.getMethod("setup_$eq", boxClass)

        // Get function from LoggingAutoConfigurer.apply()
        val configurerClass = loader.loadClass("net.liftweb.util.LoggingAutoConfigurer$")
        val configurer = configurerClass.getField("MODULE$").get(null)
        val configFunc = configurerClass.getMethod("apply").invoke(configurer)

        // Put it in a Box
        val fullClass = loader.loadClass("net.liftweb.common.Full")
        val fullConstructor = fullClass.getConstructor(classOf[Object])
        val configFuncBox = fullConstructor.newInstance(configFunc)

        // Call Logger.setup on the Box
        loggerSetupEq.invoke(logger, configFuncBox.asInstanceOf[Object])
    }

  lazy val settings = Seq(
    fuckedUpLiftTestLoggerSettings
  )

}