package adder

import chisel3._
import chisel3.experimental._

trait CarryLookaheadIO {
  val pOut = IO(Output(Bool()))
  val gOut = IO(Output(Bool()))

  pOut := false.B
  gOut := false.B
}

class OneBitAdder extends MultiIOModule {
  val a = IO(Input(Bool()))
  val b = IO(Input(Bool()))
  val carryIn = IO(Input(Bool()))
  val sum = IO(Output(Bool()))
  val carryOut = IO(Output(Bool()))

  carryOut := false.B

  val p = a ^ b
  sum := p ^ carryIn
}
