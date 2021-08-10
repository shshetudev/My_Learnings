package com.example;

import com.example.simple_demo.DemoInterface;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
class Simple_Bean_Factory_DemoTest {
  @Inject
  DemoInterface demoInterface;

  @Inject
  EmbeddedApplication<?> application;

  @Test
  void testItWorks() {
    Assertions.assertTrue(application.isRunning());
  }

  @Test
  void hello(){
    demoInterface.hello();
  }
}
