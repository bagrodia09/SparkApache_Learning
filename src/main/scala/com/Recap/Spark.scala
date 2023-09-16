package com.Recap

import org.apache.spark.sql.SparkSession

object Spark extends App {
  val spark = SparkSession.builder()
    .appName("DataFrames Basics")
    .config("spark.master", "local")
    .getOrCreate()

  val firstDF = spark.read
    .format("json")
    .option("inferSchema", "true")
    .option("multiline", "true")
    .load("src/main/resources/sampleData/population_data.json")

  firstDF.show()
  firstDF.printSchema()
  firstDF.show(6)
}
