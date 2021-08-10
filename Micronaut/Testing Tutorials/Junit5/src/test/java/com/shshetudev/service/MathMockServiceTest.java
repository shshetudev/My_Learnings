package com.shshetudev.service;

import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import javax.inject.Inject;

@MicronautTest
public class MathMockServiceTest {

  @Inject
  private MathService mathService;

  @ParameterizedTest
  @CsvSource({"2,4", "3,9"})
  void testComputeNumToSquare(Integer num, Integer square){
    Mockito.when(mathService.compute(10)).then(invocation -> Long.valueOf(Math.round(Math.pow(num,2))).intValue());
  }

  @MockBean(MathServiceImpl.class)
  MathService mathService(){
    return Mockito.mock(MathService.class);
  }
}
