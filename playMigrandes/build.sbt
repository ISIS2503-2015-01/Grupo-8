name := """playMigrandes"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

resolvers += "EclipseLink Repo" at "http://repo.maven.apache.org/maven2"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
  "org.mindrot" % "jbcrypt" % "0.3m",
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
  "org.eclipse.persistence" % "eclipselink" % "2.5.0" % "compile",
  "org.mongodb" % "mongo-java-driver" % "2.8.0",
  "org.eclipse.persistence" % "org.eclipse.persistence.nosql" % "2.5.0"  
  )

fork in run := true