package adder

import chisel3._
import chisel3.experimental._

class LookaheadOneBitAdder extends MultiIOModule {
  val a = IO(Input(Bool()))
  val b = IO(Input(Bool()))
  val carryIn = IO(Input(Bool()))
  val pOut = IO(Output(Bool()))
  val gOut = IO(Output(Bool()))
  val sum = IO(Output(Bool()))

  val p = a ^ b
  val g = a & b
  pOut := p
  gOut := g
  sum := p ^ carryIn
}
