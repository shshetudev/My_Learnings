package com.shshetudev.property;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Requires;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import javax.inject.Singleton;

@MicronautTest(rebuildContext = true)
@Property(name="foo.bar", value = "stuff")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PropertyValueRequiresTest {
  @Inject
  private MyService myService;

  @Test
  @Order(1)
  void testInitialValue(){
    MatcherAssert.assertThat(myService, IsInstanceOf.instanceOf(MyServiceStuff.class));
  }

  @Property(name = "foo.bar", value = "changed")
  @Test
  @Order(2)
  void testValueChanged(){
    MatcherAssert.assertThat(myService,IsInstanceOf.instanceOf(MyServiceChanged.class));
  }

  @Test
  @Order(3)
  void testValueRestored(){
    MatcherAssert.assertThat(myService,IsInstanceOf.instanceOf(MyServiceStuff.class));
  }

}

interface MyService{}

@Singleton
@Requires(property = "foo.bar", value="stuff")
class MyServiceStuff implements MyService{}

@Singleton
@Requires(property = "foo.bar", value = "changed")
class MyServiceChanged implements MyService{}