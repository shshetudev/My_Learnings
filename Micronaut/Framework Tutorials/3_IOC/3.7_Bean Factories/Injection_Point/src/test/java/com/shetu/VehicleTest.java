package com.shetu;

import com.shetu.injection_point.Vehicle;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MicronautTest
public class VehicleTest {
  private static final Logger LOG = LoggerFactory.getLogger(VehicleTest.class);

  Vehicle vehicle;

  public VehicleTest(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  @Test
  void createVehicleBean() {
    String vehicleStatus = vehicle.start();
    LOG.info("Vehicle Status:[{}]", vehicleStatus);
  }
}
