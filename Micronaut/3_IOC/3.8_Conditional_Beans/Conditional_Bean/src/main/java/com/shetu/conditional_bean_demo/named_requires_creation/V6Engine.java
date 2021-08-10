package com.shetu.conditional_bean_demo.named_requires_creation;

import javax.inject.Named;
import javax.inject.Singleton;

@Named("V6Engine")
@Singleton
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
