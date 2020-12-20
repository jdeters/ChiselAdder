package adder

import chisel3._
import chisel3.aop.injecting.InjectingAspect
import chisel3.aop.Select
import chisel3.aop._

class AdderAspects(bitWidth: Int) {
  val rippleCarry = Seq(
    InjectingAspect(
      //this function has to point to the actual path of the objects
      //top.adders is the *actual* list of OneBitAdders in the Adder class
      {top: TestBench => top.wholeAdder.adders},
      {adder: OneBitAdder =>
        val g = adder.a & adder.b
        // p is actually defined in OneBitAdder
        // The way Chisel is supposed to be used, there are no private variables
        val p_c = adder.carryIn & adder.p
        adder.carryOut := g | p_c
      }
    )
  )

  val carryLookahead = Seq(
    InjectingAspect(
      {top: TestBench => top.wholeAdder.adders},
      {adder: OneBitAdder with CarryLookaheadIO =>
        val g = adder.a & adder.b
        adder.pOut := adder.p
        adder.gOut := g
      }
    ),
    InjectingAspect(
      {top: TestBench => Seq(top.wholeAdder)},
      {adder: Adder =>
        val carryLookaheadModule = Module(new CarryLookaheadGenerator(bitWidth))

        //pull the p and g out of each module and connect it to the carryLookahead module
        for(i <- 0 until bitWidth){
          carryLookaheadModule.pIn(i) := adder.adders(i).pOut
          carryLookaheadModule.gIn(i) := adder.adders(i).gOut
        }
        //reassign the carry ins to be from the carryLookahead module instead
        for(i <- 1 until bitWidth){
            adder.adders(i).carryIn := carryLookaheadModule.cOut(i-1)
        }

        //reassign the last bit in sums to the carry out of the carryLookahead module
        adder.sums.last := carryLookaheadModule.cOut.last
      }
    )
  )
}
