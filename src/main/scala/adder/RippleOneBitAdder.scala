package adder

import chisel3._
import chisel3.experimental._

class RippleOneBitAdder extends MultiIOModule {
  val a = IO(Input(Bool()))
  val b = IO(Input(Bool()))
  val carryIn = IO(Input(Bool()))
  val sum = IO(Output(Bool()))
  val carryOut = IO(Output(Bool()))

  val g = a & b
  val p = a ^ b
  val p_c = carryIn & p
  sum := p ^ carryIn
  carryOut := g | p_c
}
