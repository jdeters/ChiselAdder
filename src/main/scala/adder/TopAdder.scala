package adder
import chisel3._
class TopAdder(bitWidth: Int, numSubAdders: Int) extends MultiIOModule {
  val a = IO(Input(UInt(bitWidth.W)))
  val b = IO(Input(UInt(bitWidth.W)))
  val sum = IO(Output(UInt(bitWidth.W + 1)))

  val subAdderBits = bitWidth / numSubAdders
  val adders = for (i <- 0 until numSubAdders) yield {
    val unit = Module(new Adder(subAdderBits))
    val start = i * subAdderBits
    val stop = start + subAdderBits

    unit.a.zip(a.asBools.slice(start, stop)).foreach {
      case (x, y) => x := y
    }

    unit.b.zip(b.asBools.slice(start, stop)).foreach {
      case (x, y) => x := y
    }

    unit
  }

  adders(0).carryIn := false.B
  for (i <- 1 until numSubAdders) {
    adders(i).carryIn := adders(i - 1).carryOut
  }

  val sums = Wire(Vec(bitWidth + 1, Bool()))
  for (i <- 0 until numSubAdders) {
    for(j <- 0 until subAdderBits) {
      sums(i * subAdderBits + j) := adders(i).sum(j)
    }
  }
  sums.last := adders.last.carryOut
  sum := sums.asUInt
}
