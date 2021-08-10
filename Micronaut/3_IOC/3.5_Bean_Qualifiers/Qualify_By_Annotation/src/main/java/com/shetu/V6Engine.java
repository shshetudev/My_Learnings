package com.shetu;

import javax.inject.Singleton;

@Singleton
@V6
public class V6Engine implements Engine {
  @Override
  public String start() {
    return "Starting V6";
  }

  @Override
  public int getCylinders() {
    return 6;
  }
}
