package com.shetu.conditional_bean_demo.named_requires_creation;

import io.micronaut.context.annotation.Value;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;

@MicronautTest
class VehicleTest {
  @Inject
  private Vehicle vehicle;

  @Value("${bucket:`rakizo-iac`}")
  public String bucketName;

  @Test
  void start(){
    Assertions.assertEquals("Starting V8",vehicle.start());
  }

  @Test
  void getBucketName(){
    Assertions.assertEquals("rakizo-iac",bucketName);
  }
}
