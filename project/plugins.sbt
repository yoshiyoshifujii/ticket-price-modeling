resolvers ++= Seq(
  "Seasar Repository" at "http://maven.seasar.org/maven2/",
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

addSbtPlugin("org.scalameta"          % "sbt-scalafmt"           % "2.0.2")
addSbtPlugin("net.virtual-void"       % "sbt-dependency-graph"   % "0.9.2")
