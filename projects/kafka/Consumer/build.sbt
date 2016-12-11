name := "kafka-labs"

organization := "com.infobarbosa.kafka"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.8"

val sparkVersion = "2.0.1"

scalacOptions ++= Seq("-deprecation", "-feature")

lazy val root = (project in file(".")).
  settings(
    name := "kafka-labs",
    version := "1.0",
    scalaVersion := "2.11.8",
    mainClass in Compile := Some("com.infobarbosa.kafka.TestConsumer")        
  )

libraryDependencies ++= Seq(
    "org.apache.kafka" % "kafka_2.11" % "0.10.1.0",
    "org.scala-lang" % "scala-compiler" % scalaVersion.value
)

// META-INF discarding
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
   {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
   }
}
