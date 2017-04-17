package org.redwine.sparkexamples

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, BeforeAndAfter, Matchers, OptionValues, Inside, Inspectors}

/**
  * Created by Christopher on 4/17/2017.
  */
@RunWith(classOf[JUnitRunner])
abstract class UnitBase extends FunSuite with BeforeAndAfter with Matchers with OptionValues with Inside with Inspectors