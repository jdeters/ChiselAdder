// See README.md for license details.

package adder

import java.io.File

import scala.math._
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class AdderUnitTester(c: Adder, maxNum: Int) extends PeekPokeTester(c) {

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
}
