package com.shetu.conditional_bean_demo.named_requires_creation;

import javax.inject.Named;
import javax.inject.Singleton;

@Named("V8Engine")
@Singleton
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
