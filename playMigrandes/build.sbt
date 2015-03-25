name := """playMigrandes"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

resolvers += "Typesafe Public Repo" at "http://repo.typesafe.com/typesafe/releases"

resolvers += "EclipseLink Repo" at "http://repo.maven.apache.org/maven2"


libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "3.6.10.Final",  
  "org.mindrot" % "jbcrypt" % "0.3m",
  "org.eclipse.persistence" % "eclipselink" % "2.5.0" % "compile",
  "org.mongodb" % "mongo-java-driver" % "2.8.0",
  "org.eclipse.persistence" % "org.eclipse.persistence.nosql" % "2.5.0",
  "org.apache.derby" % "derbyclient" % "10.8.3.0",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4"  
  )

fork in run := true
