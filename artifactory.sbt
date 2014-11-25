publishTo := {
  val artifactory = "https://artifactory.virtuslab.com/artifactory"
  if (version.value.endsWith("SNAPSHOT")) {
    Some("Artifactory Realm" at s"$artifactory/simple/plugins-snapshot-local/")
  } else {
    Some("Artifactory Realm" at s"$artifactory/simple/plugins-release-local/")
  }
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")