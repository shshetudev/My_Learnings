package com.shshetudev;

import io.micronaut.context.annotation.Property;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class Engine {
  @Property(name = "my.engine.cylinders")
  protected int cylinders;
  protected String manufacturer;

  @Property(name = "jpa.default.properties.hibernate.hbm2ddl")
  Map<String,String> jpaProperties;

  public int getCylinders() {
    return cylinders;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  @Inject
  public void setManufacturer(@Property(name = "my.engine.cylinders") String manufacturer){
    this.manufacturer = manufacturer;
  }
}
