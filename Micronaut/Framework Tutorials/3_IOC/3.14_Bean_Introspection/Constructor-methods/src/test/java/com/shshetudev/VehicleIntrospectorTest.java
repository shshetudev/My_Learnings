package com.shshetudev;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class VehicleIntrospectorTest {

  @Inject
  private VehicleIntrospector vehicleIntrospector;

  @Test
  void introspect(){
    vehicleIntrospector.introspect();
  }
}
