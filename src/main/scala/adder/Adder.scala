// See README.md for license details.

package adder

import chisel3._

class Adder extends Module {

  val io = IO(new Bundle{
    val a = Input(UInt(4.W))
    val b = Input(UInt(4.W))
    val sum = Output(UInt(4.W))
  })

  io.sum := io.a + io.b
}
