// See README.md for license details.

package adder

import java.io.File

import scala.math._
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.aop.injecting.InjectingAspect
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class AdderTester extends FlatSpec with ChiselScalatestTester with Matchers {
  private val numBits = 4
  private val maxNum = Math.pow(2, numBits)

  val testAspect = InjectingAspect(
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

  behavior of "MyModule"
    it should "do something" in {
      test(
        new Adder(numBits)).withAnnotations(Seq(testAspect)) { c =>
          for{
            i <- 0 until maxNum.toInt
            j <- 0 until maxNum.toInt
          }{
            val expected_sum = i + j
            c.io.a.poke(i.U)
            c.io.b.poke(j.U)
            c.io.sum.expect(expected_sum.U)
          }
      }
    }
}

/*class AdderUnitTester(c: Adder, maxNum: Int) extends PeekPokeTester(c) {

  for{
    i <- 0 until maxNum
    j <- 0 until maxNum
  }{
      val expected_sum = i + j
      poke(c.io.a, i)
      poke(c.io.b, j)
      expect(c.io.sum, expected_sum)
  }
}

class AdderTester extends ChiselFlatSpec {
  private val numBits = 4
  private val maxNum = Math.pow(2, numBits)

  "Basic test using Driver.execute" should "be used as an alternative way to run specification" in {
    iotesters.Driver.execute(Array(), () => new Adder(numBits)) {
      c => new AdderUnitTester(c, maxNum.toInt)
    } should be (true)
  }
}*/
