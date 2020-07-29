package adder

import chisel3._
import chisel3.aop.injecting.InjectingAspect

object AdderAspects {
  val rippleCarry = InjectingAspect(
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
}
