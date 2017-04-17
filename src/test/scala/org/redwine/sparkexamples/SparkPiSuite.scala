package org.redwine.sparkexamples

/**
  * Created by Christopher on 4/17/2017.
  */
class SparkPiSuite extends UnitBase {
  test("Pi should be calculated approximately correctly") {
    SparkPi.CalculatePi() should be (3.14159 +- 0.01)
  }
}