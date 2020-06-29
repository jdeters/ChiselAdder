// See README.md for license details.

package adder

import java.io.File

import scala.math._
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class AdderUnitTester(c: Adder) extends PeekPokeTester(c) {

  def computeSum(a: Int, b: Int): (Int) = {
    a + b
  }

  private val Adder = c

  private val numBits = 4
  private val maxNum = Math.pow(2, numBits)

  for(i <- 0 to numBits) {
    for (j <- 0 to numBits) {
      poke(Adder.io.a, i)
      poke(Adder.io.b, j)

      val expected_sum  = computeSum(i, j)

      expect(Adder.io.sum, expected_sum)
    }
  }
}

class AdderTester extends ChiselFlatSpec {
  "Basic test using Driver.execute" should "be used as an alternative way to run specification" in {
    iotesters.Driver.execute(Array(), () => new Adder) {
      c => new AdderUnitTester(c)
    } should be (true)
  }
}
