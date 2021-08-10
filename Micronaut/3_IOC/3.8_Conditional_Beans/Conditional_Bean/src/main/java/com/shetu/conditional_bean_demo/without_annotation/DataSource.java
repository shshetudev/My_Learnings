package com.shetu.conditional_bean_demo.without_annotation;

import javax.inject.Singleton;

@Singleton
public class DataSource {
  private javax.sql.DataSource dataSource;

  public DataSource(javax.sql.DataSource dataSource) {
    this.dataSource = dataSource;
  }
}
