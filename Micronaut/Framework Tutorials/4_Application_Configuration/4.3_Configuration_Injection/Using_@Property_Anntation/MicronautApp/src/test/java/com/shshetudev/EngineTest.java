package com.shshetudev;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Map;

@MicronautTest
public class EngineTest {

  @Inject
  private Engine engine;

  @Test
  void getCylinders(){
    Assertions.assertEquals(6,engine.getCylinders());
  }

  @Test
  void getManufacturer(){
    String manufacturer = "bmw";
    engine.setManufacturer(manufacturer);
    Assertions.assertEquals(manufacturer,engine.getManufacturer());
  }

  @Test
  void jpaProperties(){
    final Map<String, String> jpaProperties = engine.jpaProperties;
    System.out.println(jpaProperties);
  }

}
