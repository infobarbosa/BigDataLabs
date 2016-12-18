name := "spark-streaming-demo"

organization := "com.infobarbosa"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.8"

val sparkVersion = "2.0.1"

resolvers += "Spark Packages Repo" at "https://dl.bintray.com/spark-packages/maven"

lazy val root = (project in file(".")).
  settings(
    name := "spark-streaming-demo",
    version := "1.0",
    scalaVersion := "2.11.8",
    mainClass in Compile := Some("com.infobarbosa.spark.streaming.Demo")        
  )

libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % sparkVersion % "provided",
	"org.apache.spark" % "spark-sql_2.11" % sparkVersion % "provided",
	"org.apache.spark" % "spark-streaming_2.11" % sparkVersion % "provided",
        "org.apache.spark" % "spark-streaming-kafka-0-10_2.11" % sparkVersion,
        "datastax" % "spark-cassandra-connector" % "2.0.0-M2-s_2.11",
	"org.scala-lang" % "scala-compiler" % scalaVersion.value,
	"org.apache.kafka" % "kafka-clients" % "0.10.1.0"
)

// META-INF discarding
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
   {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
   }
}
