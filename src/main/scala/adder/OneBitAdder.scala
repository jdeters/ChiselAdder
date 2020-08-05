package adder

import chisel3._

class OneBitAdder extends Module {
  val io = IO(new Bundle{
    val a = Input(Bool())
    val b = Input(Bool())
    val carryIn = Input(Bool())
    val sum = Output(Bool())
    //these may or may not be used by aspects
    val carryOut = Output(Bool())
    val pOut = Output(Bool())
    val gOut = Output(Bool())
  })

  //need to make sure that these are initialized so that we don't get any errors
  io.carryOut := false.B
  io.pOut := false.B
  io.gOut := false.B

  val p = io.a ^ io.b
  io.sum := p ^ io.carryIn
}
