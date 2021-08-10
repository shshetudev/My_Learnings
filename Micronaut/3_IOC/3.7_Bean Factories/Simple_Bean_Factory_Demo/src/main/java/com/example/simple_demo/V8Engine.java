package com.example.simple_demo;

class V8Engine implements Engine {
  private final int CYLINDERS = 8;
  private final CrankShaft CRANKSHAFT;

  V8Engine(CrankShaft crankshaft) {
    CRANKSHAFT = crankshaft;
  }


  @Override
  public String start() {
    return "Starting V8";
  }
}
