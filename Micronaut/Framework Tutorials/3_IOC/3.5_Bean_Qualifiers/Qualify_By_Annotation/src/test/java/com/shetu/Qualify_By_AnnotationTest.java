package com.shetu;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class Qualify_By_AnnotationTest {
  private final Vehicle vehicle;
  @Inject
  EmbeddedApplication<?> application;

  Qualify_By_AnnotationTest(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  @Test
  void testItWorks() {
    Assertions.assertTrue(application.isRunning());
  }

  @Test
  void getVehicle(){
    assertEquals("Starting V6",vehicle.start());
  }
}
