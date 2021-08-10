package com.shshetudev;

import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

@MicronautTest
public class BusinessTest {

  @Test
  void introspect(){
    BeanIntrospection<Business> introspection = BeanIntrospection.getIntrospection(Business.class);
    Business business = introspection.instantiate("rakizo");
    System.out.println(business.getName());

    // Since this class has @Immutable no property can be set.
  }
}
