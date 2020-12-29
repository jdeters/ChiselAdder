package adder
import chisel3._
class Adder(bitWidth: Int) extends MultiIOModule {
  val a = IO(Input(Vec(bitWidth, Bool())))
  val b = IO(Input(Vec(bitWidth, Bool())))
  val carryIn = IO(Input(Bool()))
  val sum = IO(Output(Vec(bitWidth, Bool())))
  val carryOut = IO(Output(Bool()))

  //this is here because chisel aspects doesn't like it
  val carryLookaheadModule = Module(new CarryLookaheadGenerator(bitWidth))

  val adders = for (i <- 0 until bitWidth) yield {
    val unit = Module(new OneBitAdder() with CarryLookaheadIO)
    unit.a := a(i)
    unit.b := b(i)
    unit
  }

  adders(0).carryIn := carryIn
  for (i <- 1 until bitWidth) {
    adders(i).carryIn := adders(i - 1).carryOut
  }

  for (i <- 0 until bitWidth) sum(i) := adders(i).sum
  carryOut := adders.last.carryOut
}
