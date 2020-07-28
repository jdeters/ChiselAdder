Circuit(
  Adder,ArrayBuffer(
    DefModule(adder.OneBitAdder@2591ee73,OneBitAdder,ArrayBuffer(
      Port(Clock(IO clock in OneBitAdder),Input),
        Port(Reset(IO reset in OneBitAdder),Input),
        Port(AnonymousBundle(IO io in OneBitAdder),Unspecified)),
        List(
          DefPrim(SourceLine(OneBitAdder.scala,14,16),
            Bool(OpResult in OneBitAdder),xor,WrappedArray(Node(Bool(IO io_a in OneBitAdder)), Node(Bool(IO io_b in OneBitAdder)))),
          DefPrim(SourceLine(OneBitAdder.scala,15,15),Bool(OpResult in
            OneBitAdder),xor,WrappedArray(Node(Bool(OpResult in OneBitAdder)), Node(Bool(IO io_carryIn in OneBitAdder)))), Connect(SourceLine(OneBitAdder.scala,15,10),Node(Bool(IO io_sum in OneBitAdder)),Node(Bool(OpResult in OneBitAdder))),
          DefPrim(SourceLine(OneBitAdder.scala,17,16),Bool(OpResult in
            OneBitAdder),and,WrappedArray(Node(Bool(IO io_a in OneBitAdder)), Node(Bool(IO io_b in OneBitAdder)))),
          DefPrim(SourceLine(OneBitAdder.scala,18,24),Bool(OpResult in
            OneBitAdder),and,WrappedArray(Node(Bool(IO io_carryIn in OneBitAdder)), Node(Bool(OpResult in OneBitAdder)))),
          DefPrim(SourceLine(OneBitAdder.scala,19,20),Bool(OpResult in
            OneBitAdder),or,WrappedArray(Node(Bool(OpResult in OneBitAdder)), Node(Bool(OpResult in OneBitAdder)))), Connect(SourceLine(OneBitAdder.scala,19,15),Node(Bool(IO io_carryOut in OneBitAdder)),Node(Bool(OpResult in OneBitAdder))))),
    DefModule(adder.OneBitAdder@370c9a6,OneBitAdder_1,ArrayBuffer(Port(Clock(IO clock in OneBitAdder),Input),
      Port(Reset(IO reset in OneBitAdder),Input),
      Port(AnonymousBundle(IO io in OneBitAdder),Unspecified)),
        List(
          DefPrim(SourceLine(OneBitAdder.scala,14,16),Bool(OpResult in
            OneBitAdder),xor,WrappedArray(Node(Bool(IO io_a in OneBitAdder)), Node(Bool(IO io_b in OneBitAdder)))),
          DefPrim(SourceLine(OneBitAdder.scala,15,15),Bool(OpResult in
            OneBitAdder),xor,WrappedArray(Node(Bool(OpResult in OneBitAdder)), Node(Bool(IO io_carryIn in OneBitAdder)))), Connect(SourceLine(OneBitAdder.scala,15,10),Node(Bool(IO io_sum in OneBitAdder)),Node(Bool(OpResult in OneBitAdder))),
          DefPrim(SourceLine(OneBitAdder.scala,17,16),Bool(OpResult in
            OneBitAdder),and,WrappedArray(Node(Bool(IO io_a in OneBitAdder)), Node(Bool(IO io_b in OneBitAdder)))),
          DefPrim(SourceLine(OneBitAdder.scala,18,24),Bool(OpResult in
            OneBitAdder),and,WrappedArray(Node(Bool(IO io_carryIn in OneBitAdder)), Node(Bool(OpResult in OneBitAdder)))),
          DefPrim(SourceLine(OneBitAdder.scala,19,20),Bool(OpResult in
            OneBitAdder),or,WrappedArray(Node(Bool(OpResult in OneBitAdder)), Node(Bool(OpResult in OneBitAdder)))), Connect(SourceLine(OneBitAdder.scala,19,15),Node(Bool(IO io_carryOut in OneBitAdder)),Node(Bool(OpResult in OneBitAdder))))),
    DefModule(adder.OneBitAdder@30e50098,OneBitAdder_2,ArrayBuffer(Port(Clock(IO clock in OneBitAdder),Input),
      Port(Reset(IO reset in OneBitAdder),Input),
      Port(AnonymousBundle(IO io in OneBitAdder),Unspecified)),
        List(
          DefPrim(SourceLine(OneBitAdder.scala,14,16),Bool(OpResult in
            OneBitAdder),xor,WrappedArray(Node(Bool(IO io_a in OneBitAdder)), Node(Bool(IO io_b in OneBitAdder)))),
          DefPrim(SourceLine(OneBitAdder.scala,15,15),Bool(OpResult in
            OneBitAdder),xor,WrappedArray(Node(Bool(OpResult in OneBitAdder)), Node(Bool(IO io_carryIn in OneBitAdder)))), Connect(SourceLine(OneBitAdder.scala,15,10),Node(Bool(IO io_sum in OneBitAdder)),Node(Bool(OpResult in OneBitAdder))),
          DefPrim(SourceLine(OneBitAdder.scala,17,16),Bool(OpResult in
            OneBitAdder),and,WrappedArray(Node(Bool(IO io_a in OneBitAdder)), Node(Bool(IO io_b in OneBitAdder)))),
          DefPrim(SourceLine(OneBitAdder.scala,18,24),Bool(OpResult in
            OneBitAdder),and,WrappedArray(Node(Bool(IO io_carryIn in OneBitAdder)), Node(Bool(OpResult in OneBitAdder)))),
          DefPrim(SourceLine(OneBitAdder.scala,19,20),Bool(OpResult in
            OneBitAdder),or,WrappedArray(Node(Bool(OpResult in OneBitAdder)), Node(Bool(OpResult in OneBitAdder)))), Connect(SourceLine(OneBitAdder.scala,19,15),Node(Bool(IO io_carryOut in OneBitAdder)),Node(Bool(OpResult in OneBitAdder))))),
    DefModule(adder.OneBitAdder@239f3443,OneBitAdder_3,ArrayBuffer(Port(Clock(IO clock in OneBitAdder),Input),
      Port(Reset(IO reset in OneBitAdder),Input),
      Port(AnonymousBundle(IO io in OneBitAdder),Unspecified)),
      List(
        DefPrim(SourceLine(OneBitAdder.scala,14,16),Bool(OpResult in
          OneBitAdder),xor,WrappedArray(Node(Bool(IO io_a in OneBitAdder)), Node(Bool(IO io_b in OneBitAdder)))),
        DefPrim(SourceLine(OneBitAdder.scala,15,15),Bool(OpResult in
          OneBitAdder),xor,WrappedArray(Node(Bool(OpResult in OneBitAdder)), Node(Bool(IO io_carryIn in OneBitAdder)))), Connect(SourceLine(OneBitAdder.scala,15,10),Node(Bool(IO io_sum in OneBitAdder)),Node(Bool(OpResult in OneBitAdder))),
        DefPrim(SourceLine(OneBitAdder.scala,17,16),Bool(OpResult in
          OneBitAdder),and,WrappedArray(Node(Bool(IO io_a in OneBitAdder)), Node(Bool(IO io_b in OneBitAdder)))),
        DefPrim(SourceLine(OneBitAdder.scala,18,24),Bool(OpResult in
          OneBitAdder),and,WrappedArray(Node(Bool(IO io_carryIn in OneBitAdder)), Node(Bool(OpResult in OneBitAdder)))),
        DefPrim(SourceLine(OneBitAdder.scala,19,20),Bool(OpResult in
          OneBitAdder),or,WrappedArray(Node(Bool(OpResult in OneBitAdder)), Node(Bool(OpResult in OneBitAdder)))), Connect(SourceLine(OneBitAdder.scala,19,15),Node(Bool(IO io_carryOut in OneBitAdder)),Node(Bool(OpResult in OneBitAdder))))),
    DefModule(adder.Adder@7053e92c,Adder,ArrayBuffer(Port(Clock(IO clock in Adder),Input),
      Port(Bool(IO reset in Adder),Input),
      Port(AnonymousBundle(IO io in Adder),Unspecified)),
      List(
        DefInstance(SourceLine(Adder.scala,17,22),adder.OneBitAdder@2591ee73,ArrayBuffer(Port(Clock(IO clock in OneBitAdder),Input), Port(Reset(IO reset in OneBitAdder),Input), Port(AnonymousBundle(IO io in OneBitAdder),Unspecified))), Connect(UnlocatableSourceInfo,Node(Clock(IO clock in OneBitAdder)),Node(Clock(IO clock in Adder))), Connect(UnlocatableSourceInfo,Node(Reset(IO reset in OneBitAdder)),Node(Bool(IO reset in Adder))),
        DefPrim(SourceLine(Adder.scala,19,22),Bool(OpResult in
          Adder),bits,WrappedArray(Node(UInt<4>(IO io_a in Adder)), ILit(0), ILit(0))), Connect(SourceLine(Adder.scala,19,15),Node(Bool(IO io_a in OneBitAdder)),Node(Bool(OpResult in Adder))),
        DefPrim(SourceLine(Adder.scala,20,22),Bool(OpResult in
          Adder),bits,WrappedArray(Node(UInt<4>(IO io_b in Adder)), ILit(0), ILit(0))), Connect(SourceLine(Adder.scala,20,15),Node(Bool(IO io_b in OneBitAdder)),Node(Bool(OpResult in Adder))),
          DefInstance(SourceLine(Adder.scala,17,22),adder.OneBitAdder@370c9a6,ArrayBuffer(Port(Clock(IO clock in OneBitAdder),Input), Port(Reset(IO reset in OneBitAdder),Input), Port(AnonymousBundle(IO io in OneBitAdder),Unspecified))), Connect(UnlocatableSourceInfo,Node(Clock(IO clock in OneBitAdder)),Node(Clock(IO clock in Adder))), Connect(UnlocatableSourceInfo,Node(Reset(IO reset in OneBitAdder)),Node(Bool(IO reset in Adder))),
        DefPrim(SourceLine(Adder.scala,19,22),Bool(OpResult in
          Adder),bits,WrappedArray(Node(UInt<4>(IO io_a in Adder)), ILit(1), ILit(1))), Connect(SourceLine(Adder.scala,19,15),Node(Bool(IO io_a in OneBitAdder)),Node(Bool(OpResult in Adder))),
        DefPrim(SourceLine(Adder.scala,20,22),Bool(OpResult in
          Adder),bits,WrappedArray(Node(UInt<4>(IO io_b in Adder)), ILit(1), ILit(1))), Connect(SourceLine(Adder.scala,20,15),Node(Bool(IO io_b in OneBitAdder)),Node(Bool(OpResult in Adder))), DefInstance(SourceLine(Adder.scala,17,22),adder.OneBitAdder@30e50098,ArrayBuffer(Port(Clock(IO clock in OneBitAdder),Input), Port(Reset(IO reset in OneBitAdder),Input), Port(AnonymousBundle(IO io in OneBitAdder),Unspecified))), Connect(UnlocatableSourceInfo,Node(Clock(IO clock in OneBitAdder)),Node(Clock(IO clock in Adder))), Connect(UnlocatableSourceInfo,Node(Reset(IO reset in OneBitAdder)),Node(Bool(IO reset in Adder))),
        DefPrim(SourceLine(Adder.scala,19,22),Bool(OpResult in
          Adder),bits,WrappedArray(Node(UInt<4>(IO io_a in Adder)), ILit(2), ILit(2))), Connect(SourceLine(Adder.scala,19,15),Node(Bool(IO io_a in OneBitAdder)),Node(Bool(OpResult in Adder))),
        DefPrim(SourceLine(Adder.scala,20,22),Bool(OpResult in
          Adder),bits,WrappedArray(Node(UInt<4>(IO io_b in Adder)), ILit(2), ILit(2))), Connect(SourceLine(Adder.scala,20,15),Node(Bool(IO io_b in OneBitAdder)),Node(Bool(OpResult in Adder))), DefInstance(SourceLine(Adder.scala,17,22),adder.OneBitAdder@239f3443,ArrayBuffer(Port(Clock(IO clock in OneBitAdder),Input), Port(Reset(IO reset in OneBitAdder),Input), Port(AnonymousBundle(IO io in OneBitAdder),Unspecified))), Connect(UnlocatableSourceInfo,Node(Clock(IO clock in OneBitAdder)),Node(Clock(IO clock in Adder))), Connect(UnlocatableSourceInfo,Node(Reset(IO reset in OneBitAdder)),Node(Bool(IO reset in Adder))),
        DefPrim(SourceLine(Adder.scala,19,22),Bool(OpResult in
          Adder),bits,WrappedArray(Node(UInt<4>(IO io_a in Adder)), ILit(3), ILit(3))), Connect(SourceLine(Adder.scala,19,15),Node(Bool(IO io_a in OneBitAdder)),Node(Bool(OpResult in Adder))),
        DefPrim(SourceLine(Adder.scala,20,22),Bool(OpResult in
          Adder),bits,WrappedArray(Node(UInt<4>(IO io_b in Adder)), ILit(3), ILit(3))), Connect(SourceLine(Adder.scala,20,15),Node(Bool(IO io_b in OneBitAdder)),Node(Bool(OpResult in Adder))), Connect(SourceLine(Adder.scala,26,24),Node(Bool(IO io_carryIn in OneBitAdder)),ULit(0,<1>)), Connect(SourceLine(Adder.scala,30,26),Node(Bool(IO io_carryIn in OneBitAdder)),Node(Bool(IO io_carryOut in OneBitAdder))), Connect(SourceLine(Adder.scala,30,26),Node(Bool(IO io_carryIn in OneBitAdder)),Node(Bool(IO io_carryOut in OneBitAdder))), Connect(SourceLine(Adder.scala,30,26),Node(Bool(IO io_carryIn in OneBitAdder)),Node(Bool(IO io_carryOut in OneBitAdder))), DefWire(SourceLine(Adder.scala,34,18),Bool[5](Wire in Adder)), Connect(SourceLine(Adder.scala,37,38),Node(Bool(Wire in Adder)),Node(Bool(IO io_sum in OneBitAdder))), Connect(SourceLine(Adder.scala,37,38),Node(Bool(Wire in Adder)),Node(Bool(IO io_sum in OneBitAdder))), Connect(SourceLine(Adder.scala,37,38),Node(Bool(Wire in Adder)),Node(Bool(IO io_sum in OneBitAdder))), Connect(SourceLine(Adder.scala,37,38),Node(Bool(Wire in Adder)),Node(Bool(IO io_sum in OneBitAdder))), Connect(SourceLine(Adder.scala,40,13),Node(Bool(Wire in Adder)),Node(Bool(IO io_carryOut in OneBitAdder))),
        DefPrim(SourceLine(Adder.scala,43,18),UInt<2>(OpResult in
          Adder),cat,WrappedArray(Node(Bool(Wire in Adder)), Node(Bool(Wire in Adder)))),
        DefPrim(SourceLine(Adder.scala,43,18),UInt<2>(OpResult in
          Adder),cat,WrappedArray(Node(Bool(Wire in Adder)), Node(Bool(Wire in Adder)))),
        DefPrim(SourceLine(Adder.scala,43,18),UInt<3>(OpResult in
          Adder),cat,WrappedArray(Node(UInt<2>(OpResult in Adder)), Node(Bool(Wire in Adder)))),
        DefPrim(SourceLine(Adder.scala,43,18),UInt<5>(OpResult in
          Adder),cat,WrappedArray(Node(UInt<3>(OpResult in Adder)), Node(UInt<2>(OpResult in Adder)))), Connect(SourceLine(Adder.scala,43,10),Node(UInt<5>(IO io_sum in Adder)),Node(UInt<5>(OpResult in Adder)))))),ArrayBuffer())
