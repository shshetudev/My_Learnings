package com.shetu.conditional_bean_demo.with_annotation;

import com.shetu.conditional_bean_demo.BookService;

import javax.inject.Singleton;

@RequiresJdbc
@Singleton
public class JdbcBookServiceWithAnnotation implements BookService {
}
