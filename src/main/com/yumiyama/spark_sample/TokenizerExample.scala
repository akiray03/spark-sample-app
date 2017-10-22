package com.yumiyama.spark_sample

import org.atilika.kuromoji.Token
import org.atilika.kuromoji.Tokenizer

object TokenizerExample {
  def main(args: Array[String]): Unit =  {
    val tokenizer: Nothing = Tokenizer.builder.build

    for (token <- tokenizer.tokenize("寿司が食べたい。"))  {
      printf(token.getSurfaceForm + "\t" + token.getAllFeatures)
    }
  }

}
