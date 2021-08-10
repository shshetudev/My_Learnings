package com.shshetudev.property;

import io.micronaut.context.annotation.Property;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.validation.constraints.NotNull;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PropertySourceMapTest implements TestPropertyProvider {
  @Property(name = "foo.bar")
  private String val;

  @Test
  void testPropertySource() {
    assertEquals("one", val);
  }

  @NotNull
  @Override
  public Map<String, String> getProperties() {
    return CollectionUtils.mapOf(
      "foo.bar", "one",
      "foo.baz", "two"
    );
  }
}
