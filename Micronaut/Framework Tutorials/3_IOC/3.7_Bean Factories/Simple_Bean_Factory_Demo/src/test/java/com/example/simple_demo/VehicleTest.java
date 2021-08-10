package com.example.simple_demo;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MicronautTest
public class VehicleTest {
  private static final Logger LOG = LoggerFactory.getLogger(VehicleTest.class);

 private Vehicle vehicle;

  public VehicleTest(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  @Test
  void start(){
    String vehicleStatus = vehicle.start();
    Assertions.assertEquals("Starting V8",vehicleStatus);
  }
}
