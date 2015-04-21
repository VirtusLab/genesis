// VirtusLab sonatype repo

val artifactory = "https://artifactory.virtuslab.com/artifactory"

resolvers += "Local Plugins Snapshots" at s"$artifactory/simple/plugins-snapshot-local/"

resolvers += "Local Plugins Releases" at s"$artifactory/simple/plugins-release-local/"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

addSbtPlugin("org.virtuslab" %% "genesis" % "0.1.4")
