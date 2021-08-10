package com.shshetudev;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;

@MicronautTest
class EngineTest {
  @Inject
  private EngineImpl engine;
  @Test
  void getCylinders() {
   Assertions.assertEquals(6,engine.getCylinders());
  }

  @Test
  void start() {
    String expected = "Starting V6Engine";
    Assertions.assertEquals(expected,engine.start());
  }

  @Test
  void testNumber(){
    Assertions.assertEquals(10,engine.number);
  }

  @Test
  void url() throws MalformedURLException {
    Assertions.assertEquals(new URL("http://foo:8080"),engine.url);
  }

  @Test
  void myUrl() throws MalformedURLException {
    Assertions.assertEquals(new URL("http://myurl.com"),engine.myUrl);
  }
}
