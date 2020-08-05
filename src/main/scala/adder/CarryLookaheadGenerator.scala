package adder

import chisel3._

class CarryLookaheadGenerator (bitWidth: Int) extends Module{
  val io = IO(new Bundle{
    val pIn = Input(Vec(bitWidth, Bool()))
    val gIn = Input(Vec(bitWidth, Bool()))
    val cOut = Output(Vec(bitWidth, Bool()))
  })

  val test = Bool()
  for(stage <- 0 until bitWidth){
    //this is nonesene for now
    io.cOut(stage) := generateStage(stage)
  }

  def generateStage (stage: Int): Bool = {
    generateOR(stage, stage)
  }

  def generateOR(stage: Int, level: Int): Bool = {
    level match {
      //the last thing that need to be OR'd is the g of the stage
      case -1 => io.gIn(stage)
      //otherwise, OR with the level's AND, then generate another level
      case x if x == stage => (false.B & generateAND(stage, level)) |
        generateOR(stage, level-1)
      case _ => (io.gIn(stage-level-1) & generateAND(stage, level)) |
        generateOR(stage, level-1)
    }
  }

  def generateAND(stage: Int, level: Int) : Bool = {
    level match {
      case 0 => io.pIn(stage-level)
      case _ => io.pIn(stage-level) & generateAND(stage, level-1)
    }
  }
}
