package com.shshetudev;

import javax.inject.Singleton;

@Singleton
public class Vehicle {
  private final Engine engine;

  public Vehicle(Engine engine) {
    this.engine = engine;
  }

  String start() {
    return engine.start();
  }
}
