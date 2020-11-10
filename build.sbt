scalaVersion := "2.13.3"

name := "SampleTest"
version := "1.0"


libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
libraryDependencies += "io.cucumber" %% "cucumber-scala" % "6.8.2"
libraryDependencies += "io.cucumber" % "cucumber-junit" % "6.8.2" 
libraryDependencies += "junit" % "junit" % "4.12" % Test
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "3.141.59"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.3.0-SNAP2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP2"
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" 
libraryDependencies += "com.github.javafaker" % "javafaker" % "1.0.2"