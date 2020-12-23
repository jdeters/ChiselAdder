package adder
import chisel3._
class LookaheadAdder(bitWidth: Int) extends MultiIOModule {
  val a = IO(Input(UInt(bitWidth.W)))
  val b = IO(Input(UInt(bitWidth.W)))
  val sum = IO(Output(UInt(bitWidth.W + 1)))
  val adders = for (i <- 0 until bitWidth) yield {
    val unit = Module(new LookaheadOneBitAdder())
    unit.a := a(i)
    unit.b := b(i)
    unit
  }
  val carryLookaheadModule = Module(new CarryLookaheadGenerator(bitWidth))
  for(i <- 0 until bitWidth){
    carryLookaheadModule.pIn(i) := adders(i).pOut
    carryLookaheadModule.gIn(i) := adders(i).gOut
  }

  adders(0).carryIn := false.B
  for(i <- 1 until bitWidth){
      adders(i).carryIn := carryLookaheadModule.cOut(i-1)
  }

  val sums = Wire(Vec(bitWidth + 1, Bool()))
  for (i <- 0 until bitWidth) sums(i) := adders(i).sum
  sums.last := carryLookaheadModule.cOut.last
  sum := sums.asUInt
}
