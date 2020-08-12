package adder

import chisel3._

class CarryLookaheadGenerator (bitWidth: Int) extends MultiIOModule{
  val pIn = IO(Input(Vec(bitWidth, Bool())))
  val gIn = IO(Input(Vec(bitWidth, Bool())))
  val cOut = IO(Output(Vec(bitWidth, Bool())))

  for(stage <- 0 until bitWidth){
    //this is nonesene for now
    cOut(stage) := generateStage(stage)
  }

  def generateStage (stage: Int): Bool = {
    generateOR(stage, stage)
  }

  def generateOR(stage: Int, level: Int): Bool = {
    level match {
      //the last thing that need to be OR'd is the g of the stage
      case -1 => gIn(stage)
      //otherwise, OR with the level's AND, then generate another level
      case x if x == stage => (false.B & generateAND(stage, level)) |
        generateOR(stage, level-1)
      case _ => (gIn(stage-level-1) & generateAND(stage, level)) |
        generateOR(stage, level-1)
    }
  }

  def generateAND(stage: Int, level: Int) : Bool = {
    level match {
      case 0 => pIn(stage-level)
      case _ => pIn(stage-level) & generateAND(stage, level-1)
    }
  }
}
