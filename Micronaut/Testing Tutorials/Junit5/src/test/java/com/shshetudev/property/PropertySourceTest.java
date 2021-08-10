package com.shshetudev.property;

import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@MicronautTest(propertySources = "file:resources/myprops.properties")
//@MicronautTest(propertySources = "myprops.properties")
@MicronautTest(propertySources = "classpath:myprops.properties")
public class PropertySourceTest {
  @Property(name = "foo.bar")
  String val;

  @Test
  void testPropertySource(){
    assertEquals("foo", val);
  }
}
