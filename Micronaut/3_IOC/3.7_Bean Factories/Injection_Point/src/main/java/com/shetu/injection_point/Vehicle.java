package com.shetu.injection_point;

import javax.inject.Singleton;

@Singleton
public class Vehicle {
  private final Engine engine;

  public Vehicle(@Cylinders(6) Engine engine) {
    this.engine = engine;
  }

  public String start() {
    return engine.start();
  }
}
