# ChiselAdder
An adder written in Chisel that can aspectually apply either ripple-carry or carry-lookahead for carry between bits. This repo also contains a hybrid design
where both ripple-carry and carry-lookahead are used. 

## Generating the Adders
To generate the adders execute `sbt run` in a terminal, assuming you have SBT installed.

## Configuring the Adders
The adders are configured in `AdderMain.scala`.
