package adder

import chisel3._
import chisel3.aop.injecting.InjectingAspect
import chisel3.aop.Select
import chisel3.aop._


class AdderAspects(bitWidth: Int, numSubAdders: Int) {
  val subAdderBits = bitWidth / numSubAdders
  val hybridCarry = Seq(
    InjectingAspect(
      {top: TopAdder => {
          val adderList = collection.mutable.ArrayBuffer[OneBitAdder with CarryLookaheadIO]()
          top.adders.foreach { case (a) => adderList ++= a.adders }
          adderList
        }
      },
      {adder: OneBitAdder with CarryLookaheadIO =>
        val g = adder.a & adder.b
        adder.pOut := adder.p
        adder.gOut := g
      }
    ),
    InjectingAspect(
      {top: TopAdder => top.adders},
      {adder: Adder =>

        //pull the p and g out of each module and connect it to the carryLookahead module
        adder.carryLookaheadModule.cIn := adder.carryIn
        for(i <- 0 until subAdderBits){
          adder.carryLookaheadModule.pIn(i) := adder.adders(i).pOut
          adder.carryLookaheadModule.gIn(i) := adder.adders(i).gOut
        }
        //reassign the carry ins to be from the carryLookahead module instead
        for(i <- 1 until subAdderBits){
            adder.adders(i).carryIn := adder.carryLookaheadModule.cOut(i-1)
        }

        //reassign the last bit in sums to the carry out of the carryLookahead module
        adder.carryOut := adder.carryLookaheadModule.cOut.last
      }
    )
  )
}
