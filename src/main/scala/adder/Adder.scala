// See README.md for license details.

package adder

import chisel3._

class Adder (bitWidth: Int) extends Module {

  val io = IO(new Bundle{
    val a = Input(UInt(bitWidth.W))
    val b = Input(UInt(bitWidth.W))
    val sum = Output(UInt(bitWidth.W + 1))
  })

  //create each adder and wire them to their inputs
  val adders = for (i <- 0 until bitWidth) yield {
    val unit = Module(new OneBitAdder())
    //wire up the inputs
    unit.io.a := io.a(i)
    unit.io.b := io.b(i)

    unit
  }

  //the first adder needs to have a false input to carryIn
  adders(0).io.carryIn := false.B

  //wire the carryOut from n-1 to the carryIn of n
  for(i <- 1 until bitWidth) {
    adders(i).io.carryIn := adders(i-1).io.carryOut
  }

  //create a set of wires to collect the sums
  val sums = Wire(Vec(bitWidth + 1, Bool()))

  //collect the sums
  for(i <- 0 until bitWidth) sums(i) := adders(i).io.sum

  //get the carry out of the last adder to complete the sum
  sums.last := adders.last.io.carryOut

  //wire up the full sum to the output
  io.sum := sums.asUInt
}
