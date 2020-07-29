// See README.md for license details.

package adder

import chisel3._
import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}
import chisel3.aop.injecting.InjectingAspect

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

  val design = ChiselGeneratorAnnotation(() => new Adder(numBits))

  val testAspect = InjectingAspect(
    //this function has to point to the actual path of the objects
    //top.adders is the *actual* list of OneBitAdders in the Adder class
    {top: Adder => top.adders},
    {adder: OneBitAdder =>
      val g = adder.io.a & adder.io.b
      // p is actually defined in OneBitAdder
      // The way Chisel is supposed to be used, there are no private variables
      val p_c = adder.io.carryIn & adder.p
      adder.io.carryOut := g | p_c
    }
  )

  (new chisel3.stage.ChiselStage).execute(
    Array("-X", "high"),
    Seq(testAspect, design))
}
