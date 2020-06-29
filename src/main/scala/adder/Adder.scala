// See README.md for license details.

package adder

import chisel3._

class Adder (bitWidth: Int) extends Module {

  val io = IO(new Bundle{
    val a = Input(UInt(bitWidth.W))
    val b = Input(UInt(bitWidth.W))
    val sum = Output(UInt(bitWidth.W+1))
  })

  io.sum := io.a +& io.b
}
