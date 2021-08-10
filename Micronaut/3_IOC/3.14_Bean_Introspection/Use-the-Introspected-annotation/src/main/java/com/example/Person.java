package com.example;

import com.example.annotation.Consumed;
import io.micronaut.core.annotation.Introspected;

@Consumed
@Introspected
public class Person {
  private String name;
  private int age = 20;

  public Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
