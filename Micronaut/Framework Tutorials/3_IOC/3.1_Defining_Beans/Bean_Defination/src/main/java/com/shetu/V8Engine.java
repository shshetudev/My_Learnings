package com.shetu;

import javax.inject.Singleton;

@Singleton
public class V8Engine implements Engine {
  private int cylinders = 8;

  @Override
  public int getCylinders() {
    return cylinders;
  }

  @Override
  public String start() {
    return "Starting V8";
  }

  public void setCylinders(int cylinders) {
    this.cylinders = cylinders;
  }
}
