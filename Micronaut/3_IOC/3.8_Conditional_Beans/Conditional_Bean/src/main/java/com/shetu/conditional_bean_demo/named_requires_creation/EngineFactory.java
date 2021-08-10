package com.shetu.conditional_bean_demo.named_requires_creation;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;

import javax.inject.Named;
import javax.inject.Singleton;

@Factory
public class EngineFactory {

  @Singleton
  @Named("V10Engine")
  Engine v10Engine(CrankShaft crankShaft) {
    return new V10Engine(crankShaft);
  }

  @Singleton
  @Named("V12Engine")
  Engine v12Engine(CrankShaft crankShaft) {
    return new V12Engine(crankShaft);
  }

  @Singleton
  @Requires(property = "name")
  String name(){
    return "shetu";
  }
}
