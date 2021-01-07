package adder

import chisel3._
import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}
import chisel3.aop.injecting.InjectingAspect

object AdderMain extends App {
  val numBits = 120

  val subAdderList = List(1,2,3,4,5,6,8,10,12,15,20,24,30);

  for(a <- subAdderList){

    val design = ChiselGeneratorAnnotation(() => new TopAdder(numBits, a))
    val aspects = (new AdderAspects(numBits, a)).hybridCarry

    (new chisel3.stage.ChiselStage).execute(
      Array("-X", "verilog", "-o", "Adder_" + numBits + "_" + a),
      aspects ++ Seq(design))

  }
}
