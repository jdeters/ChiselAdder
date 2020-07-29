package adder

import chisel3._
import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}
import chisel3.aop.injecting.InjectingAspect

object AdderMain extends App {
  private val numBits = 4

  val design = ChiselGeneratorAnnotation(() => new Adder(numBits))

  (new chisel3.stage.ChiselStage).execute(
    Array("-X", "high"),
    Seq(AdderAspects.rippleCarry, design))
}
