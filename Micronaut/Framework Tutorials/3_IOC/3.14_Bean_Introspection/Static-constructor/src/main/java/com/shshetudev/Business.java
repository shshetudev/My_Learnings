package com.shshetudev;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.concurrent.Immutable;

@Introspected
@Immutable
public class Business {
  private final String name;

  private Business(String name) {
    this.name = name;
  }

  @Creator
  public static Business forName(String name){
    return new Business(name);
  }

  public String getName(){
    return name;
  }
}
