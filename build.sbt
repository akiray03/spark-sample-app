name := "WordCountApp"
version := "1.0.0"
scalaVersion := "2.11.9"

/*
 * 日本語の形態素解析を行うために kuromoji を入れる
 */
resolvers += "Atilika Open Source repository" at "http://www.atilika.org/nexus/content/repositories/atilika"
libraryDependencies += "org.atilika.kuromoji" % "kuromoji" % "0.7.7"


val sparkVersion = "2.2.0"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion
)

mainClass in Compile := Some("com.yumiyama.spark_sample.Main")
