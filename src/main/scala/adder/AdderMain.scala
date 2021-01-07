package adder

import chisel3._
import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}
import chisel3.aop.injecting.InjectingAspect

object AdderMain extends App {
  val numBits = List(4, 8, 16, 32, 64, 128);

  for(a <- numBits){

    val design = ChiselGeneratorAnnotation(() => new Adder(a))
    val aspects = (new AdderAspects(a)).rippleCarry

    (new chisel3.stage.ChiselStage).execute(
      Array("-X", "verilog", "-o", "Adder_" + a),
      aspects ++ Seq(design))

  }
}
