
enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "org.openjfx" % "javafx-controls" % "21",    
  "org.openjfx" % "javafx-fxml" % "21"         
)

addCompilerPlugin("org.scala-js" % "scalajs-compiler" % "1.5.0")
scalaVersion := "3.3.4"
run / fork := true  
