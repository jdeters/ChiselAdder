package adder

import chisel3._
import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}
import chisel3.aop.injecting.InjectingAspect

object AdderMain extends App {
  private val numBits = 4

  val design = ChiselGeneratorAnnotation(() => new TestBench(numBits))
  val aspects = (new AdderAspects(numBits)).carryLookahead

  (new chisel3.stage.ChiselStage).execute(
    Array("-X", "verilog"),
    aspects ++ Seq(design))
}
