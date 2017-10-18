name := "starships"

version := "0.1"

scalaVersion := "2.12.3"

mainClass in (Compile, run) := Some("edu.austral.GameController")

// https://mvnrepository.com/artifact/org.processing/core
libraryDependencies += "org.processing" % "core" % "3.2.3"
// https://mvnrepository.com/artifact/junit/junit
libraryDependencies += "junit" % "junit" % "4.12" % "test"
// https://mvnrepository.com/artifact/org.assertj/assertj-core
libraryDependencies += "org.assertj" % "assertj-core" % "3.8.0" % "test"
// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.2"
// https://mvnrepository.com/artifact/org.apache.commons/commons-math3
libraryDependencies += "org.apache.commons" % "commons-math3" % "3.2"

