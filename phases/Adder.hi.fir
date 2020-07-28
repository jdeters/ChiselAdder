circuit Adder :
  module OneBitAdder :
    input clock : Clock
    input reset : UInt<1>
    output io : { flip a : UInt<1>, flip b : UInt<1>, flip carryIn : UInt<1>, sum : UInt<1>, carryOut : UInt<1>}
  
    node p = xor(io.a, io.b) @[OneBitAdder.scala 14:16]
    node _T = xor(p, io.carryIn) @[OneBitAdder.scala 15:15]
    io.sum <= _T @[OneBitAdder.scala 15:10]
    node g = and(io.a, io.b) @[OneBitAdder.scala 17:16]
    node p_c = and(io.carryIn, p) @[OneBitAdder.scala 18:24]
    node _T_1 = or(g, p_c) @[OneBitAdder.scala 19:20]
    io.carryOut <= _T_1 @[OneBitAdder.scala 19:15]

  module Adder :
    input clock : Clock
    input reset : UInt<1>
    output io : { flip a : UInt<4>, flip b : UInt<4>, sum : UInt<5>}
  
    inst adders_0 of OneBitAdder @[Adder.scala 17:22]
    adders_0.clock <= clock
    adders_0.reset <= reset
    node _T = bits(io.a, 0, 0) @[Adder.scala 19:22]
    adders_0.io.a <= _T @[Adder.scala 19:15]
    node _T_1 = bits(io.b, 0, 0) @[Adder.scala 20:22]
    adders_0.io.b <= _T_1 @[Adder.scala 20:15]
    inst adders_1 of OneBitAdder @[Adder.scala 17:22]
    adders_1.clock <= clock
    adders_1.reset <= reset
    node _T_2 = bits(io.a, 1, 1) @[Adder.scala 19:22]
    adders_1.io.a <= _T_2 @[Adder.scala 19:15]
    node _T_3 = bits(io.b, 1, 1) @[Adder.scala 20:22]
    adders_1.io.b <= _T_3 @[Adder.scala 20:15]
    inst adders_2 of OneBitAdder @[Adder.scala 17:22]
    adders_2.clock <= clock
    adders_2.reset <= reset
    node _T_4 = bits(io.a, 2, 2) @[Adder.scala 19:22]
    adders_2.io.a <= _T_4 @[Adder.scala 19:15]
    node _T_5 = bits(io.b, 2, 2) @[Adder.scala 20:22]
    adders_2.io.b <= _T_5 @[Adder.scala 20:15]
    inst adders_3 of OneBitAdder @[Adder.scala 17:22]
    adders_3.clock <= clock
    adders_3.reset <= reset
    node _T_6 = bits(io.a, 3, 3) @[Adder.scala 19:22]
    adders_3.io.a <= _T_6 @[Adder.scala 19:15]
    node _T_7 = bits(io.b, 3, 3) @[Adder.scala 20:22]
    adders_3.io.b <= _T_7 @[Adder.scala 20:15]
    adders_0.io.carryIn <= UInt<1>("h0") @[Adder.scala 26:24]
    adders_1.io.carryIn <= adders_0.io.carryOut @[Adder.scala 30:26]
    adders_2.io.carryIn <= adders_1.io.carryOut @[Adder.scala 30:26]
    adders_3.io.carryIn <= adders_2.io.carryOut @[Adder.scala 30:26]
    wire sums : UInt<1>[5] @[Adder.scala 34:18]
    sums[0] <= adders_0.io.sum @[Adder.scala 37:38]
    sums[1] <= adders_1.io.sum @[Adder.scala 37:38]
    sums[2] <= adders_2.io.sum @[Adder.scala 37:38]
    sums[3] <= adders_3.io.sum @[Adder.scala 37:38]
    sums[4] <= adders_3.io.carryOut @[Adder.scala 40:13]
    node _T_8 = cat(sums[1], sums[0]) @[Adder.scala 43:18]
    node _T_9 = cat(sums[4], sums[3]) @[Adder.scala 43:18]
    node _T_10 = cat(_T_9, sums[2]) @[Adder.scala 43:18]
    node _T_11 = cat(_T_10, _T_8) @[Adder.scala 43:18]
    io.sum <= _T_11 @[Adder.scala 43:10]
