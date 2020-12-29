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
  private val numBits = 8
  private val numSubAdders = 4
  private val maxNum = Math.pow(2, numBits)

  behavior of "HybridAdder"
    it should "add all the numbers correctly" in {
      test(
        new TopAdder(numBits, numSubAdders)).withAnnotations(new AdderAspects(numBits, numSubAdders).hybridCarry) {
          c =>
          for{
            i <- 0 until maxNum.toInt
            j <- 0 until maxNum.toInt
          }{
            val expected_sum = i + j
            c.a.poke(i.U)
            c.b.poke(j.U)
            c.sum.expect(expected_sum.U)
            //println(c.a.peek() + " + " + c.b.peek() + " = " + c.sum.peek() + "\n" + c.sum.peek().asBools)
          }
        }
  }
}
