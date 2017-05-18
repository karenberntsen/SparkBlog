package org.rubigdata

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object RUBigDataApp {
  def main(args: Array[String]) {
    val fnm = "rubigdata-test.txt"
    val conf = new SparkConf().setAppName("RUBigDataApp")
    val sc = new SparkContext(conf)
    val data = sc.textFile(fnm, 2).cache()
    val numAs = data.filter(line => line.contains("a")).count()
    val numEs = data.filter(line => line.contains("e")).count()
    println("Lines with a: %s, Lines with e: %s".format(numAs, numEs))
  }
}
