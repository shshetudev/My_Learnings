package com.shshetudev;

import io.micronaut.context.annotation.Value;

import javax.inject.Singleton;
import java.net.URL;

@Singleton
public class EngineImpl implements Engine {
  @Value("10")
  int number;

  // To get the values see application.json
  @Value("http://${my.host}:${my.port}")
  URL url;

  // To get the values see application.yml
  // If my.url value is not found, then the value will be: http://foo.com
  @Value("${my.url:`http://foo.com`}")
  URL myUrl;

  // If no value is provided, 6 will be the default value
  @Value("${my.engine.cylinders:6}")
  protected int cylinders;

  @Override
  public int getCylinders() {
    return cylinders;
  }

  @Override
  public String start() {
    return "Starting V" + getCylinders() + "Engine";
  }
}
