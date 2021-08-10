package com.shetu;

import javax.inject.Singleton;

@Singleton
@V8
public class V8Engine implements Engine {
  @Override
  public String start() {
    return "Starting V8";
  }

  @Override
  public int getCylinders() {
    return 8;
  }
}
