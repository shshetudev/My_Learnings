package com.shetu.conditional_bean_demo;

import com.shetu.conditional_bean_demo.with_annotation.JdbcBookServiceWithAnnotation;
import com.shetu.conditional_bean_demo.without_annotation.JdbcBookService;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MicronautTest
public class JdbcBookServiceTest {
  private static final Logger LOG = LoggerFactory.getLogger(JdbcBookServiceTest.class);

  private JdbcBookService jdbcBookService;
  private JdbcBookServiceWithAnnotation jdbcBookServiceWithAnnotation;
  @Property(name = "datasource.url")
  private String dataSource;
  @Value("rakizo-iac")
  private String bucketName;
  public JdbcBookServiceTest(JdbcBookService jdbcBookService, JdbcBookServiceWithAnnotation jdbcBookServiceWithAnnotation) {
    this.jdbcBookService = jdbcBookService;
    this.jdbcBookServiceWithAnnotation = jdbcBookServiceWithAnnotation;
  }

  @Test
  void hello() {
    LOG.info("Hello World");
  }

  @Test
  void jdbcBookServiceBeanCreation() {
    String className = jdbcBookService.getClass().getSimpleName();
    LOG.info("className:[{}]", className);
  }

  @Test
  void jdbcBookServiceWithoutAnnotationBeanCreation() {
    String className = jdbcBookServiceWithAnnotation.getClass().getSimpleName();
    LOG.info("className:[{}]", className);
  }

  @Test
  void dataSourceAndBucketName(){
    String dataSourceStr = dataSource;
    Assertions.assertEquals("localhost:3000",dataSourceStr);
    Assertions.assertEquals("rakizo-iac",bucketName);
  }

  @Test
  void testName(){

  }
}
