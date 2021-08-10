package com.shshetudev;

import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class EngineTest {

  @Test
  void vehicle() {
    Map<String, Object> map = new LinkedHashMap<>(1);
    // To get the default behaviors we can comment out the below 3 lines
    map.put("my.engine.cylinders", "8");
    map.put("my.engine.manufacturer","BMW");
    map.put("my.engine.crank-shaft.rodLength",8.0d);
    ApplicationContext context = ApplicationContext.run(map, "test");
    Vehicle vehicle = context.getBean(Vehicle.class);
    System.out.println(vehicle.start());
  }
}
