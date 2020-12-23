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
import chiseltest.internal.WriteVcdAnnotation


class AdderTester extends FlatSpec with ChiselScalatestTester with Matchers {
  private val numBits = 32
  private val maxNum = Math.pow(2, numBits).toInt
  private var minNum = 0
  if(maxNum > 256) minNum = maxNum - 256

  behavior of "RippleCarryAdder"
    it should "add all the numbers correctly" in {
      test(
        new RippleAdder(numBits)) {
          c =>
          for{
            i <- minNum until maxNum
            j <- minNum until maxNum
          }{
            val expected_sum = i + j
            c.a.poke(i.U)
            c.b.poke(j.U)
            c.clock.step()
            c.sum.expect(expected_sum.U)
          }
        }
      }

    behavior of "CarryLookaheadAdder"
      it should "add all the numbers correctly" in {
        test(
          new LookaheadAdder(numBits)) {
            c =>
            for{
              i <- minNum until maxNum
              j <- minNum until maxNum
            }{
              val expected_sum = i + j
              c.a.poke(i.U)
              c.b.poke(j.U)
              c.clock.step()
              c.sum.expect(expected_sum.U)
            }
          }
    }
}
