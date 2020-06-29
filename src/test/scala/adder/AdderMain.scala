// See README.md for license details.

package adder

import chisel3._

/**
  * This provides an alternate way to run tests, by executing then as a main
  * From sbt (Note: the test: prefix is because this main is under the test package hierarchy):
  * {{{
  * test:runMain Adder.AdderMain
  * }}}
  * To see all command line options use:
  * {{{
  * test:runMain Adder.AdderMain --help
  * }}}
  * To run with verilator:
  * {{{
  * test:runMain Adder.AdderMain --backend-name verilator
  * }}}
  * To run with verilator from your terminal shell use:
  * {{{
  * sbt 'test:runMain Adder.AdderMain --backend-name verilator
  * }}}
  */
object AdderMain extends App {
  private val numBits = 4
  private val maxNum = Math.pow(2, numBits)

  iotesters.Driver.execute(args, () => new Adder(numBits)) {
    c => new AdderUnitTester(c, maxNum.toInt)
  }
}
