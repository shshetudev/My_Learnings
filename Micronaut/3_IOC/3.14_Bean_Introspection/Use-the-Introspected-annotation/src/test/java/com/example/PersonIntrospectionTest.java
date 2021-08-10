package com.example;

import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.core.beans.BeanWrapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Optional;

@MicronautTest
public class PersonIntrospectionTest {
@Inject
private PersonIntrospection introspection;
  @Test
  void introspect(){
//    introspection.introspectName("Shahariar");
    introspection.introspectAge(28);
  }

  @Test
  void beanWrapping(){
    BeanIntrospection<Person> introspection = BeanIntrospection.getIntrospection(Person.class);
    BeanWrapper<Person> wrapper = BeanWrapper.getWrapper(introspection.instantiate());
    String[] propertyNames = wrapper.getPropertyNames();
    System.out.println(propertyNames);
    Optional<Integer> age = wrapper.getProperty("age", int.class);
    if(age.isPresent()){
      int newAge = age.get();
      System.out.println("Age: " + newAge);
    }
  }

  @Test
  void getIntrospectedProperties(){
    BeanIntrospection<Person> introspection = BeanIntrospection.getIntrospection(Person.class);
    String[] propertyNames = introspection.getPropertyNames();
    Arrays.stream(propertyNames).forEach(System.out::println);
  }
}
