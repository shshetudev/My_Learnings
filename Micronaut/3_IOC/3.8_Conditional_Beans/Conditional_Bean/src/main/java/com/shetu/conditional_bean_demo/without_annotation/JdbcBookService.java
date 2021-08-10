package com.shetu.conditional_bean_demo.without_annotation;

import com.shetu.conditional_bean_demo.BookService;
import io.micronaut.context.annotation.Requires;

import javax.inject.Singleton;

@Singleton
@Requires(beans = DataSource.class)
@Requires(property = "datasource.url")
public class JdbcBookService implements BookService {
  DataSource dataSource;

  public JdbcBookService(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}
