package adder

import chisel3._
import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}
import chisel3.aop.injecting.InjectingAspect

object AdderMain extends App {
  private val numBits = 120
  private val numSubAdders = 2

  val design = ChiselGeneratorAnnotation(() => new TopAdder(numBits, numSubAdders))
  val aspects = (new AdderAspects(numBits,numSubAdders)).hybridCarry

  (new chisel3.stage.ChiselStage).execute(
    Array("-X", "verilog"),
    aspects ++ Seq(design))
}
