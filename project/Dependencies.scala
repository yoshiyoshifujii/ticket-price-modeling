import sbt._

object ScalaTest {
  val version = "3.0.5"
  val core    = "org.scalatest" %% "scalatest" % version
}

object ScalaTestPlus {
  val version = "1.0.8"
  val db      = "com.github.j5ik2o" %% "scalatestplus-db" % version
}

object Logback {
  val version = "1.2.3"
  val classic = "ch.qos.logback" % "logback-classic" % version
}

object ScalaDDDBase {
  val version = "1.0.27"
  val core    = "com.github.j5ik2o" %% "scala-ddd-base-core" % version
  val memory  = "com.github.j5ik2o" %% "scala-ddd-base-memory" % version
}

object Cats {
  val version = "1.6.0"
  val core    = "org.typelevel" %% "cats-core" % version
  val free    = "org.typelevel" %% "cats-free" % version
}

object Beachape {
  val version    = "1.5.13"
  val enumeratum = "com.beachape" %% "enumeratum" % version
}

object Google {
  val version = "27.1-jre"
  val guava   = "com.google.guava" % "guava" % version
}

object Petitviolet {
  val version = "0.4.0"
  val ulid    = "net.petitviolet" %% "ulid4s" % version
}
