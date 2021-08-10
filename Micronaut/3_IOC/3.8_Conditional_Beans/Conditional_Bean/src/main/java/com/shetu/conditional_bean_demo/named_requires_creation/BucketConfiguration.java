package com.shetu.conditional_bean_demo.named_requires_creation;

import io.micronaut.context.annotation.Factory;

import javax.inject.Named;
import javax.inject.Singleton;

@Factory
public class BucketConfiguration {

  @Singleton
  @Named("bucketName")
  public String getBucketName(){
    return "rakizo-iac";
  }
}
