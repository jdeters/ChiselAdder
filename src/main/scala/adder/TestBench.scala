package adder
import chisel3._

class TestBench(bitWidth: Int) extends MultiIOModule {
  val sum = IO(Output(Bool()))

  val wholeAdder = Module(new Adder(bitWidth))

  when(reset.asBool & clock.asBool){
    wholeAdder.a := 1.U
    wholeAdder.b := 1.U
  } .otherwise {
    wholeAdder.a := 0.U
    wholeAdder.b := 0.U
  }

  sum := wholeAdder.sum
}
