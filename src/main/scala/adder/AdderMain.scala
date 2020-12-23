package adder

import chisel3._
import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}
import chisel3.aop.injecting.InjectingAspect

object AdderMain extends App {
  private val numBits = 128

  val design = ChiselGeneratorAnnotation(() => new LookaheadAdder(numBits))

  (new chisel3.stage.ChiselStage).execute(
    Array("-X", "verilog"), Seq(design))
}
