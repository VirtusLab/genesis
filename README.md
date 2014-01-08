Genesis
=======

Contains some common definitions for SbtIdea, Scalariform, XML Reports and more.

Usefull for setting up sbt-based projects.

Made in [VirtusLab](http://virtuslab.com).

Contributors
============

* [Jerzy Müller](https://github.com/Kwestor)

Feel free to use it, test it and to contribute!

Usage
=====

Common
------

Common settings, contains:

* Several compiler flags for warnings: `-deprecation -unchecked -Xlint -Ywarn-all` and, if Scala version >= 2.10 `-feature`
* [Scalariform](https://github.com/sbt/sbt-scalariform) settings - basic, plus:
 * `PreserveSpaceBeforeArguments = true`
 * `PreserveDanglingCloseParenthesis = true`
 * `AlignParameters = true`
 * `AlignSingleLineCaseStatements = true`
* SbtIdea settings for [sbt-idea](https://github.com/mpeltonen/sbt-idea) - excluding `.idea`, `.idea_modules` and `.settings`
* `versionReport` - prints all dependencies for current module (sorted by artifact name)
* Dependency graph settings from [sbt-dependency-graph](https://github.com/jrudolph/sbt-dependency-graph)

```scala
import org.virtuslab.genesis.Genesis

val settings = yourSettings ++ Genesis.common
```

Test
----

Generates JUnit XML test reports, usefull if your CI needs them. Code copied from [junit_xml_listener](https://github.com/hydrasi/junit_xml_listener) via Play! framework.

```scala
import org.virtuslab.genesis

val settings = yourSettings ++ genesis.test.JUnitReports.settings
```

Lift logger initializer
-----------------------

Lift have issues with initializing logger in tests, to overcome them you can use `LoggerInitializer`.

*WARNING* - this will blow up if you include it and do not have Lift on classpath.

```scala
import org.virtuslab.genesis

val settings = yourSettings ++ genesis.lift.LoggerInitializer.settings
```
