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

  behavior of "MyModule"
    it should "do something" in {
      test(
        new Adder(numBits)).withAnnotations(Seq(AdderAspects.rippleCarry)) {
          c =>
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
