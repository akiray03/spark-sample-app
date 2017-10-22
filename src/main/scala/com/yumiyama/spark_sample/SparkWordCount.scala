package com.yumiyama.spark_sample

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark._

object SparkWordCount {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("WordCountApp").setMaster("local")

    val sc = new SparkContext(conf)

    /* local = master URL; Word Count = application name; */
    /* /usr/local/spark = Spark Home; Nil = jars; Map = environment */
    /* Map = variables to work nodes */
    /*creating an inputRDD to read text file (in.txt) through Spark context*/
    val input = sc.textFile("input.txt")
    /* Transform the inputRDD into countRDD */

    val selectionPartOfSpeeches = Array("名詞", "動詞", "形容詞", "形容動詞", "副詞")

    val preprocessed = input.flatMap(line =>
      MyTokenizer.tokenize(line)
    ).filter(token =>
      selectionPartOfSpeeches.indexOf(token.primaryPartOfSpeech) >= 0
    )

    val count = preprocessed
      .map(token => ((token.primaryPartOfSpeech, token.normalizedForm), 1))
      .reduceByKey(_ + _)

    /* saveAsTextFile method is an action that effects on the RDD */
    count.saveAsTextFile("outfile")
    System.out.println("OK")
  }
}
