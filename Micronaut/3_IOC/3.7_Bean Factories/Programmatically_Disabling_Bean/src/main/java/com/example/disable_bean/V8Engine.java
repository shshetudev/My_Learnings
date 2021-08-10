package com.example.disable_bean;

class V8Engine implements Engine {
  private final int CYLINDERS = 8;
  private final CrankShaft CRANKSHAFT;

  V8Engine(CrankShaft crankshaft) {
    CRANKSHAFT = crankshaft;
  }

  @Override
  public Integer getCylinder() {
    return null;
  }
}
