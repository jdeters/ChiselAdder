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
      {top: Adder => top.adders},
      {adder: OneBitAdder =>
        val g = adder.io.a & adder.io.b
        // p is actually defined in OneBitAdder
        // The way Chisel is supposed to be used, there are no private variables
        val p_c = adder.io.carryIn & adder.p
        adder.io.carryOut := g | p_c
      }
    )
  )

  val carryLookahead = Seq(
    InjectingAspect(
      {top: Adder => top.adders},
      {adder: OneBitAdder =>
        val g = adder.io.a & adder.io.b
        adder.io.pOut := adder.p
        adder.io.gOut := g
      }
    ),
    InjectingAspect(
      {top: Adder => Seq(top)},
      {adder: Adder =>
        val carryLookaheadModule = Module(new CarryLookaheadGenerator(bitWidth))

        //pull the p and g out of each module and connect it to the carryLookahead module
        for(i <- 0 until bitWidth){
          carryLookaheadModule.io.pIn(i) := adder.adders(i).io.pOut
          carryLookaheadModule.io.gIn(i) := adder.adders(i).io.gOut
        }
        //reassign the carry ins to be from the carryLookahead module instead
        for(i <- 1 until bitWidth){
            adder.adders(i).io.carryIn := carryLookaheadModule.io.cOut(i-1)
        }

        //reassign the last bit in sums to the carry out of the carryLookahead module
        adder.sums.last := carryLookaheadModule.io.cOut.last
      }
    )
  )
}
