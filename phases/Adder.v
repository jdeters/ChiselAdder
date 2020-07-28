module OneBitAdder(
  input   io_a,
  input   io_b,
  input   io_carryIn,
  output  io_sum,
  output  io_carryOut
);
  wire  p = io_a ^ io_b; // @[OneBitAdder.scala 14:16]
  wire  g = io_a & io_b; // @[OneBitAdder.scala 17:16]
  wire  p_c = io_carryIn & p; // @[OneBitAdder.scala 18:24]
  assign io_sum = p ^ io_carryIn; // @[OneBitAdder.scala 15:10]
  assign io_carryOut = g | p_c; // @[OneBitAdder.scala 19:15]
endmodule
module Adder(
  input        clock,
  input        reset,
  input  [3:0] io_a,
  input  [3:0] io_b,
  output [4:0] io_sum
);
  wire  adders_0_io_a; // @[Adder.scala 17:22]
  wire  adders_0_io_b; // @[Adder.scala 17:22]
  wire  adders_0_io_carryIn; // @[Adder.scala 17:22]
  wire  adders_0_io_sum; // @[Adder.scala 17:22]
  wire  adders_0_io_carryOut; // @[Adder.scala 17:22]
  wire  adders_1_io_a; // @[Adder.scala 17:22]
  wire  adders_1_io_b; // @[Adder.scala 17:22]
  wire  adders_1_io_carryIn; // @[Adder.scala 17:22]
  wire  adders_1_io_sum; // @[Adder.scala 17:22]
  wire  adders_1_io_carryOut; // @[Adder.scala 17:22]
  wire  adders_2_io_a; // @[Adder.scala 17:22]
  wire  adders_2_io_b; // @[Adder.scala 17:22]
  wire  adders_2_io_carryIn; // @[Adder.scala 17:22]
  wire  adders_2_io_sum; // @[Adder.scala 17:22]
  wire  adders_2_io_carryOut; // @[Adder.scala 17:22]
  wire  adders_3_io_a; // @[Adder.scala 17:22]
  wire  adders_3_io_b; // @[Adder.scala 17:22]
  wire  adders_3_io_carryIn; // @[Adder.scala 17:22]
  wire  adders_3_io_sum; // @[Adder.scala 17:22]
  wire  adders_3_io_carryOut; // @[Adder.scala 17:22]
  wire  sums_1 = adders_1_io_sum; // @[Adder.scala 34:18 Adder.scala 37:38]
  wire  sums_0 = adders_0_io_sum; // @[Adder.scala 34:18 Adder.scala 37:38]
  wire [1:0] _T_8 = {sums_1,sums_0}; // @[Adder.scala 43:18]
  wire  sums_4 = adders_3_io_carryOut; // @[Adder.scala 34:18 Adder.scala 40:13]
  wire  sums_3 = adders_3_io_sum; // @[Adder.scala 34:18 Adder.scala 37:38]
  wire  sums_2 = adders_2_io_sum; // @[Adder.scala 34:18 Adder.scala 37:38]
  wire [2:0] _T_10 = {sums_4,sums_3,sums_2}; // @[Adder.scala 43:18]
  OneBitAdder adders_0 ( // @[Adder.scala 17:22]
    .io_a(adders_0_io_a),
    .io_b(adders_0_io_b),
    .io_carryIn(adders_0_io_carryIn),
    .io_sum(adders_0_io_sum),
    .io_carryOut(adders_0_io_carryOut)
  );
  OneBitAdder adders_1 ( // @[Adder.scala 17:22]
    .io_a(adders_1_io_a),
    .io_b(adders_1_io_b),
    .io_carryIn(adders_1_io_carryIn),
    .io_sum(adders_1_io_sum),
    .io_carryOut(adders_1_io_carryOut)
  );
  OneBitAdder adders_2 ( // @[Adder.scala 17:22]
    .io_a(adders_2_io_a),
    .io_b(adders_2_io_b),
    .io_carryIn(adders_2_io_carryIn),
    .io_sum(adders_2_io_sum),
    .io_carryOut(adders_2_io_carryOut)
  );
  OneBitAdder adders_3 ( // @[Adder.scala 17:22]
    .io_a(adders_3_io_a),
    .io_b(adders_3_io_b),
    .io_carryIn(adders_3_io_carryIn),
    .io_sum(adders_3_io_sum),
    .io_carryOut(adders_3_io_carryOut)
  );
  assign io_sum = {_T_10,_T_8}; // @[Adder.scala 43:10]
  assign adders_0_io_a = io_a[0]; // @[Adder.scala 19:15]
  assign adders_0_io_b = io_b[0]; // @[Adder.scala 20:15]
  assign adders_0_io_carryIn = 1'h0; // @[Adder.scala 26:24]
  assign adders_1_io_a = io_a[1]; // @[Adder.scala 19:15]
  assign adders_1_io_b = io_b[1]; // @[Adder.scala 20:15]
  assign adders_1_io_carryIn = adders_0_io_carryOut; // @[Adder.scala 30:26]
  assign adders_2_io_a = io_a[2]; // @[Adder.scala 19:15]
  assign adders_2_io_b = io_b[2]; // @[Adder.scala 20:15]
  assign adders_2_io_carryIn = adders_1_io_carryOut; // @[Adder.scala 30:26]
  assign adders_3_io_a = io_a[3]; // @[Adder.scala 19:15]
  assign adders_3_io_b = io_b[3]; // @[Adder.scala 20:15]
  assign adders_3_io_carryIn = adders_2_io_carryOut; // @[Adder.scala 30:26]
endmodule
