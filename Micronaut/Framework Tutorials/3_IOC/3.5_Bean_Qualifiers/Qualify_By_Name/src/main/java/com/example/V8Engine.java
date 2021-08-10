package com.example;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
//@Named("v8")
public class V8Engine implements Engine{
  @Override
  public int getCylinders() {
    return 8;
  }

  @Override
  public String start() {
    return "Starting V8";
  }
}
