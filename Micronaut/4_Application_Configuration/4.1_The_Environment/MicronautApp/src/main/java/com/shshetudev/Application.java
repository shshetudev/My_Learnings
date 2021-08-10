package com.shshetudev;

import io.micronaut.runtime.Micronaut;

public class Application {

//  public static void main(String[] args) {
//    Micronaut.run(Application.class, args);
//  }

  // todo: To run by -> ./gradlew run
  public static void main(String[] args) {
    Micronaut.build(args)
      .mainClass(Application.class)
      .defaultEnvironments("dev")
      .start();
  }

  // todo: Uncomment to disable the banner
//  public static void main(String[] args) {
//    Micronaut.build(args)
//      .banner(false)
//      .start();
//  }
}
