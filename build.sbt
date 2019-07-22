import Settings._

val baseName = "ticket-price-modeling"

lazy val `infrastructure` = (project in file("modules/infrastructure"))
  .settings(
    name := s"$baseName-infrastructure",
    libraryDependencies ++= Seq(
      Petitviolet.ulid
      )
  )
  .settings(coreSettings)

lazy val `domain` = (project in file("modules/domain"))
  .settings(
    name := s"$baseName-domain",
    libraryDependencies ++= Seq(
        ScalaDDDBase.core,
        Cats.core,
        Cats.free,
        Beachape.enumeratum
      )
  )
  .settings(coreSettings)
  .dependsOn(infrastructure)

lazy val `usecases` = (project in file("modules/usecases"))
  .settings(
    name := s"$baseName-usecases",
    libraryDependencies ++= Seq(
        ScalaDDDBase.memory % Test,
        Google.guava        % Test,
        ScalaTestPlus.db    % Test
      )
  )
  .settings(coreSettings)
  .dependsOn(`domain`)

lazy val `root` = (project in file("."))
  .settings(
    name := baseName
  )
  .settings(coreSettings)
  .aggregate(
    `infrastructure`,
    `domain`,
    `usecases`
  )
