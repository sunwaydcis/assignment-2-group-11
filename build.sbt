enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "org.openjfx" % "javafx-controls" % "21",    
  "org.openjfx" % "javafx-fxml" % "21"
)

addCompilerPlugin("org.scala-js" % "scalajs-compiler" % "1.6.0")

scalaVersion := "3.3.4"
run / fork := true

// Add Maven Central repository to resolve dependencies
resolvers += "Maven Central" at "https://repo1.maven.org/maven2/"
