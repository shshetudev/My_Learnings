package com.shshetudev;

import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.core.beans.BeanProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class VehicleIntrospector {
  private final Logger LOG = LoggerFactory.getLogger(VehicleIntrospector.class);

  public void introspect() {
    BeanIntrospection<Vehicle> introspection = BeanIntrospection.getIntrospection(Vehicle.class);
    Vehicle vehicle = introspection.instantiate("German", "BMW",6);
    LOG.info("Vehicle is made in [{}], model [{}]",vehicle.getModel(),vehicle.getModel());

    // Setting required properties
    // We can not set in a final variable without constructor
//    BeanProperty<Vehicle, String> property = introspection.getRequiredProperty("model", String.class);
//    property.set(vehicle,"Ford");
//    LOG.info("Vehicle model [{}]",vehicle.getModel());
  }
}
