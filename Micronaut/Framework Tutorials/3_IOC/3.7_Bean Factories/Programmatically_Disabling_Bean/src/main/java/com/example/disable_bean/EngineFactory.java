package com.example.disable_bean;

import io.micronaut.context.annotation.EachBean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.exceptions.DisabledBeanException;

@Factory
class EngineFactory {
  @EachBean(EngineConfiguration.class)
  public Engine buildEngine(EngineConfiguration engineConfiguration){
    if(engineConfiguration.isEnabled()) return engineConfiguration::getCylinders;
    else throw new DisabledBeanException("Engine configuration disabled");
  }
}
