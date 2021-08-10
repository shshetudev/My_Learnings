package com.example;

import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.core.beans.BeanProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class PersonIntrospection {
  private static final Logger LOG = LoggerFactory.getLogger(PersonIntrospection.class);
  private static final String NAME = "Shetu";

  public void introspectName(String value) {
   getRequiredProperty(value);
  }

  public void introspectAge(Integer value){
    getProperty(value);
  }

  public Person getPerson(String name) {
    BeanIntrospection<Person> introspection = getIntrospection();
    return introspection.instantiate(name);
  }

  public Person getPerson() {
    BeanIntrospection<Person> introspection = getIntrospection();
    return introspection.instantiate();
  }

  public void getRequiredProperty(String value) {
    BeanProperty<Person, String> property = getIntrospection().getRequiredProperty("name", String.class);
    Person person = getPerson(NAME);
    property.set(person, value);
    LOG.info("Hello " + person.getName());
  }

  public void getProperty(Integer value) {
    Optional<BeanProperty<Person, Object>> age = getIntrospection().getProperty("age");
    if(age.isPresent()) {
      BeanProperty<Person, Object> property = age.get();
      Person person = getPerson();
      property.set(person, value);
      LOG.info("Your age is " + person.getAge());
    }

  }
  public BeanIntrospection<Person> getIntrospection() {
    return BeanIntrospection.getIntrospection(Person.class);
  }

}
