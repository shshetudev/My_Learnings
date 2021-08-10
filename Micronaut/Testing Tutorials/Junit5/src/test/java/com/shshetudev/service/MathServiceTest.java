package com.shshetudev.service;

import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import javax.inject.Inject;

@MicronautTest
public class MathServiceTest {
  @Inject
  private MathService mathService;

  @ParameterizedTest
  @CsvSource({"2,8", "3,12"})
  void testComputeNumToSquare(Integer num, Integer square){
  final Integer result = mathService.compute(num);
    Assertions.assertEquals(square,result);
  }
}
