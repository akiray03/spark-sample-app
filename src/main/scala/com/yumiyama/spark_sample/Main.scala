package com.yumiyama.spark_sample

object Main {
  def main(args: Array[String]): Unit = {
    val mode = if(args.length == 0) "word-count" else args(0)
    val arguments = args.slice(1, args.length)

    mode match {
      case "word-count" => SparkWordCount.main(arguments)
      case _ =>
        System.out.printf("unknown parameter=%s\n", mode)
        System.exit(1)
    }
  }
}
