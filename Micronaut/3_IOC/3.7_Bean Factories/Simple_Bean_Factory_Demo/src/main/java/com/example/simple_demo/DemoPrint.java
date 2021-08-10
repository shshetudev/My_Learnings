package com.example.simple_demo;

import javax.inject.Inject;

public class DemoPrint {

  private final DemoInterface demoInterface;

  @Inject
  public DemoPrint(DemoInterface demoInterface) {
    this.demoInterface = demoInterface;
  }

  void hello(){
    demoInterface.hello();
  }
}
