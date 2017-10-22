package com.yumiyama.spark_sample

import org.atilika.kuromoji.Tokenizer

import collection.JavaConversions._

case class Token(surfaceForm: String, baseForm: Option[String], normalizedForm: String, allFeatures: Array[String],
                 reading: String, primaryPartOfSpeech: String, partOfSpeeches: Array[String], known: Boolean, userDic: Boolean, position: Int)

object MyTokenizer {
  private val tokenizer: Tokenizer = Tokenizer.builder().mode(Tokenizer.Mode.SEARCH).build()

  def tokenize(sentence: String): List[Token] =  {
    tokenizer.tokenize(sentence).map(token =>
      Token(
        surfaceForm = token.getSurfaceForm,
        baseForm = Option(token.getBaseForm),
        normalizedForm = if (token.getBaseForm != null) {
          token.getBaseForm
        } else {
          token.getSurfaceForm
        },
        allFeatures = token.getAllFeaturesArray,
        reading = token.getReading,
        primaryPartOfSpeech = token.getPartOfSpeech.split(",")(0),
        partOfSpeeches = token.getPartOfSpeech.split(","),
        known = token.isKnown,
        userDic = token.isUser,
        position = token.getPosition
      )
    ).toList
  }
}
