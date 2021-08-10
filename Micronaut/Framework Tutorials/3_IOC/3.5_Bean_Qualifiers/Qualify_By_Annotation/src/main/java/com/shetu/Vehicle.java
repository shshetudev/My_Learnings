package com.shetu;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Vehicle {
  private final Engine engine;

  @Inject
  public Vehicle(@V6 Engine engine) {
    this.engine = engine;
  }
  public String start(){
    return engine.start();
  }
}
