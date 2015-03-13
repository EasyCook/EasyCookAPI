name := """EasyCook"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaCore,
  javaJpa,
  "org.springframework" % "spring-context" % "4.1.4.RELEASE",
  "javax.inject" % "javax.inject" % "1",
  "org.springframework.data" % "spring-data-jpa" % "1.7.2.RELEASE",
  "org.springframework" % "spring-expression" % "4.1.4.RELEASE",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
  "org.mockito" % "mockito-core" % "1.10.8" % "test",
  "mysql" % "mysql-connector-java" % "5.1.33",
  "net.jodah" % "typetools" % "0.4.0"
)
