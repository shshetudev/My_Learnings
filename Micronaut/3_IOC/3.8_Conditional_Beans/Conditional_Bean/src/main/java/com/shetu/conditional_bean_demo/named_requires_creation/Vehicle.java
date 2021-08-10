package com.shetu.conditional_bean_demo.named_requires_creation;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class Vehicle {
  private final Engine engine;

  @Inject
  public Vehicle( @Named("V12Engine") Engine engine) {
    this.engine = engine;
  }

  public String start() {
    return engine.start();
  }
}
