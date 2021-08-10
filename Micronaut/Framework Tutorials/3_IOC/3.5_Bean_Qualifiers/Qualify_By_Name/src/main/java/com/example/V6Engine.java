package com.example;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
//@Named("v6")
public class V6Engine implements Engine{
  @Override
  public int getCylinders() {
    return 6;
  }

  @Override
  public String start() {
    return "Starting V6";
  }
}
