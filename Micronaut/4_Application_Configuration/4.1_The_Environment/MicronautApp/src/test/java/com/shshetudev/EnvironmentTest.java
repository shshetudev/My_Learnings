package com.shshetudev;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class EnvironmentTest {

  @Test
  void environmentTest() {
    ApplicationContext context = ApplicationContext.run("test", "android");
    Environment environment = context.getEnvironment();
    Assertions.assertTrue(environment.getActiveNames().contains("test"));
    Assertions.assertTrue(environment.getActiveNames().contains("android"));
  }
  // We can specify environment while running the jar: `java -Dmicronaut.environments=foo,bar -jar myapp.jar`
  // Disabling environment detection via system property: `java -Dmicronaut.env.deduction=false -jar myapp.jar`

  @Test
  void disableEnvironmentDeductionViaBuilder(){
    ApplicationContext context = ApplicationContext.builder().deduceEnvironment(false).start();
    Assertions.assertFalse(context.getEnvironment().getActiveNames().contains(Environment.TEST));
    context.close();
  }

}
