/*
 * This example has been adapted from:
 * https://github.com/apache/spark/tree/v1.6.2/examples/src/main/scala/org/apache/spark/examples/SparkPi.scala
 * The license has been copied here for reference.
 */

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package org.redwine.sparkexamples

import scala.math.random

/** Computes an approximation to pi */
object SparkPi extends SparkExample {
  def main(args: Array[String]): Unit = {
    val pi = CalculatePi(args)
    println("Pi is roughly " + pi)
  }

  def CalculatePi(args: Array[String] = Array("2")): Double = {
    init

    val slices = if (args.length > 0) args(0).toInt else 2
    val n = math.min(100000L * slices, Int.MaxValue).toInt // avoid overflow
    val count = sc.parallelize(1 until n, slices).map { i =>
      val x = random * 2 - 1
      val y = random * 2 - 1
      if (x*x + y*y < 1) 1 else 0
    }.reduce(_ + _)
    val pi = 4.0 * count / n

    stop
    pi
  }
}
// scalastyle:on println