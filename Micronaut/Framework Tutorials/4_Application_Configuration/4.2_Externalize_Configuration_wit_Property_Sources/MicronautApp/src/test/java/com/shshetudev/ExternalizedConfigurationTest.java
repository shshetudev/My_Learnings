package com.shshetudev;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;
import io.micronaut.context.env.PropertySource;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class ExternalizedConfigurationTest {
  @Test
  void externalizeConfiguration() {
    ApplicationContext context = ApplicationContext.run(
      PropertySource.of("test",
        CollectionUtils.mapOf(
          "micronaut.server.host", "foo",
          "micronaut.server.port", 8080

        )
      ), "test", "android"
    );
    Environment environment = context.getEnvironment();
    Assertions.assertEquals("foo",environment.getProperty("micronaut.server.host",String.class).orElse("localhost"));
  }
}
