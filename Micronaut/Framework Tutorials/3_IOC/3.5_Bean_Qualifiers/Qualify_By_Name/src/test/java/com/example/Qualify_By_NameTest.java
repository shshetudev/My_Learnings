package com.example;

import io.micronaut.context.BeanContext;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
class Qualify_By_NameTest {

  @Inject
  EmbeddedApplication<?> application;
  @Inject
  private Vehicle vehicle;

  @Test
  void testItWorks() {
    Assertions.assertTrue(application.isRunning());
  }

  @Test
  void getVehicle(){
    final BeanContext context = BeanContext.run();
    Vehicle vehicle = context.getBean(Vehicle.class);
    assertNotNull(vehicle);
    assertEquals("Starting V6",vehicle.start());
  }

  @Test
  void getVehicleByDI(){
    assertNotNull(vehicle);
    assertEquals("Starting V6",vehicle.start());
  }

}
