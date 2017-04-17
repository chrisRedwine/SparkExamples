package org.redwine.sparkexamples

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Christopher on 4/17/2017.
  */
trait SparkExample {
  val master = "local[*]"
  val appName = "Spark example"

  var sc: SparkContext = _

  def init: Unit = {
    val conf = new SparkConf()
      .setMaster(master)
      .setAppName(appName)
    sc = new SparkContext(conf)
  }

  def stop: Unit = {
    if (sc != null) {
      sc.stop()
    }
  }
}