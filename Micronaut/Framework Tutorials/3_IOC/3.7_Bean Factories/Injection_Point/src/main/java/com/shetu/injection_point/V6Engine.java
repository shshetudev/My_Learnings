package com.shetu.injection_point;

import javax.inject.Singleton;

public class V6Engine implements Engine{
  private final int CYLINDERS = 6;
  private final CrankShaft CRANKSHAFT;

  V6Engine(CrankShaft crankshaft) {
    CRANKSHAFT = crankshaft;
  }
  @Override
  public String start() {
    return "Starting V6";
  }
}
