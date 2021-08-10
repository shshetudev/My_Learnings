package com.shetu.conditional_bean_demo.named_requires_creation;

public class V12Engine implements Engine{
  private final int cylinders = 12;
  private final CrankShaft CRANKSHAFT;

  public V12Engine(CrankShaft crankshaft) {
    CRANKSHAFT = crankshaft;
  }

  @Override
  public int getCylinders() {
    return cylinders;
  }

  @Override
  public String start() {
    return "Starting V12";
  }
}
