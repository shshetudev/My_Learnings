package com.shshetudev;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class Application {

  public static void main(String[] args) {
    Micronaut
    .run(Application.class, args);

//    ApplicationContext context = ApplicationContext.run();
  }
}
