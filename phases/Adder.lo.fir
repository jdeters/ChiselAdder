circuit Adder :
  module OneBitAdder :
    input clock : Clock
    input reset : UInt<1>
    input io_a : UInt<1>
    input io_b : UInt<1>
    input io_carryIn : UInt<1>
    output io_sum : UInt<1>
    output io_carryOut : UInt<1>
  
    node p = xor(io_a, io_b) @[OneBitAdder.scala 14:16]
    node _T = xor(p, io_carryIn) @[OneBitAdder.scala 15:15]
    node g = and(io_a, io_b) @[OneBitAdder.scala 17:16]
    node p_c = and(io_carryIn, p) @[OneBitAdder.scala 18:24]
    node _T_1 = or(g, p_c) @[OneBitAdder.scala 19:20]
    io_sum <= _T @[OneBitAdder.scala 15:10]
    io_carryOut <= _T_1 @[OneBitAdder.scala 19:15]

  module Adder :
    input clock : Clock
    input reset : UInt<1>
    input io_a : UInt<4>
    input io_b : UInt<4>
    output io_sum : UInt<5>
  
    inst adders_0 of OneBitAdder @[Adder.scala 17:22]
    inst adders_1 of OneBitAdder @[Adder.scala 17:22]
    inst adders_2 of OneBitAdder @[Adder.scala 17:22]
    inst adders_3 of OneBitAdder @[Adder.scala 17:22]
    node _T = bits(io_a, 0, 0) @[Adder.scala 19:22]
    node _T_1 = bits(io_b, 0, 0) @[Adder.scala 20:22]
    node _T_2 = bits(io_a, 1, 1) @[Adder.scala 19:22]
    node _T_3 = bits(io_b, 1, 1) @[Adder.scala 20:22]
    node _T_4 = bits(io_a, 2, 2) @[Adder.scala 19:22]
    node _T_5 = bits(io_b, 2, 2) @[Adder.scala 20:22]
    node _T_6 = bits(io_a, 3, 3) @[Adder.scala 19:22]
    node _T_7 = bits(io_b, 3, 3) @[Adder.scala 20:22]
    node sums_1 = adders_1.io_sum @[Adder.scala 34:18 Adder.scala 37:38]
    node sums_0 = adders_0.io_sum @[Adder.scala 34:18 Adder.scala 37:38]
    node _T_8 = cat(sums_1, sums_0) @[Adder.scala 43:18]
    node sums_4 = adders_3.io_carryOut @[Adder.scala 34:18 Adder.scala 40:13]
    node sums_3 = adders_3.io_sum @[Adder.scala 34:18 Adder.scala 37:38]
    node _T_9 = cat(sums_4, sums_3) @[Adder.scala 43:18]
    node sums_2 = adders_2.io_sum @[Adder.scala 34:18 Adder.scala 37:38]
    node _T_10 = cat(_T_9, sums_2) @[Adder.scala 43:18]
    node _T_11 = cat(_T_10, _T_8) @[Adder.scala 43:18]
    io_sum <= _T_11 @[Adder.scala 43:10]
    adders_0.clock <= clock
    adders_0.reset <= reset
    adders_0.io_a <= _T @[Adder.scala 19:15]
    adders_0.io_b <= _T_1 @[Adder.scala 20:15]
    adders_0.io_carryIn <= UInt<1>("h0") @[Adder.scala 26:24]
    adders_1.clock <= clock
    adders_1.reset <= reset
    adders_1.io_a <= _T_2 @[Adder.scala 19:15]
    adders_1.io_b <= _T_3 @[Adder.scala 20:15]
    adders_1.io_carryIn <= adders_0.io_carryOut @[Adder.scala 30:26]
    adders_2.clock <= clock
    adders_2.reset <= reset
    adders_2.io_a <= _T_4 @[Adder.scala 19:15]
    adders_2.io_b <= _T_5 @[Adder.scala 20:15]
    adders_2.io_carryIn <= adders_1.io_carryOut @[Adder.scala 30:26]
    adders_3.clock <= clock
    adders_3.reset <= reset
    adders_3.io_a <= _T_6 @[Adder.scala 19:15]
    adders_3.io_b <= _T_7 @[Adder.scala 20:15]
    adders_3.io_carryIn <= adders_2.io_carryOut @[Adder.scala 30:26]
