import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "akka-lost-http-context-2_1-rc2"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
