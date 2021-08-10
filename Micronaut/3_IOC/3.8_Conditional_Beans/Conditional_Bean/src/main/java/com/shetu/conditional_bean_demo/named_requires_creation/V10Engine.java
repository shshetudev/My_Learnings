package com.shetu.conditional_bean_demo.named_requires_creation;

import javax.inject.Named;

public class V10Engine implements Engine{
  private final int cylinders = 10;
  private final CrankShaft CRANKSHAFT;

  public V10Engine(CrankShaft crankshaft) {
    CRANKSHAFT = crankshaft;
  }

  @Override
  public int getCylinders() {
    return cylinders;
  }

  @Override
  public String start() {
    return "Starting V10";
  }
}
