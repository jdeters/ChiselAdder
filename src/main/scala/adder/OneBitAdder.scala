package adder

import chisel3._

class OneBitAdder extends Module {
  val io = IO(new Bundle{
    val a = Input(Bool())
    val b = Input(Bool())
    val carryIn = Input(Bool())
    val sum = Output(Bool())
    val carryOut = Output(Bool())
  })

  val p = io.a ^ io.b
  io.sum := p ^ io.carryIn
  
  val g = io.a & io.b
  val p_c = io.carryIn & p
  io.carryOut := g | p_c
}
