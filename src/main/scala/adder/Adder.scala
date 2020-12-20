package adder
import chisel3._
class Adder(bitWidth: Int) extends MultiIOModule {
  val a = IO(Input(UInt(bitWidth.W)))
  val b = IO(Input(UInt(bitWidth.W)))
  val sum = IO(Output(UInt(bitWidth.W + 1)))
  
  val adders = for (i <- 0 until bitWidth) yield {
    val unit = Module(new OneBitAdder() with CarryLookaheadIO)
    unit.a := a(i)
    unit.b := b(i)
    unit
  }

  adders(0).carryIn := false.B

  for (i <- 1 until bitWidth) {
    adders(i).carryIn := adders(i - 1).carryOut
  }

  val sums = Wire(Vec(bitWidth + 1, Bool()))
  for (i <- 0 until bitWidth) sums(i) := adders(i).sum

  sums.last := adders.last.carryOut

  sum := sums.asUInt
}
