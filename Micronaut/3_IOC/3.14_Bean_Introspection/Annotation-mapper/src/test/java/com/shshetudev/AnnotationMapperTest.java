package com.shshetudev;

import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
class AnnotationMapperTest {

  @Inject
  EmbeddedApplication<?> application;

  @Test
  void testItWorks() {
    Assertions.assertTrue(application.isRunning());
  }

  @Test
  void print(){
    System.out.println("Hello world");
  }

  @Test
  void introspectAnnotation(){
    BeanIntrospection<Consumed> introspection = BeanIntrospection.getIntrospection(Consumed.class);
    introspection.getPropertyNames();
  }

  @Test
  void introspect(){
    BeanIntrospection<Person> introspection = BeanIntrospection.getIntrospection(Person.class);
    String[] propertyNames = introspection.getPropertyNames();
    System.out.println("------------------ Introspected properties: --------------------");
    for (String propertyName : propertyNames) {
      System.out.println(propertyName);
    }
  }

}
