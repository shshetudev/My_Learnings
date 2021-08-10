package com.shshetudev.controller;

import com.shshetudev.service.MathService;
import com.shshetudev.service.MathServiceImpl;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import javax.inject.Inject;

@MicronautTest
public class MathCollaboratorTest {
  @Inject
  private MathService mathService;

  @Inject
  @Client("/")
  RxHttpClient client;

  @ParameterizedTest
  @CsvSource({"2,4","3,9"})
  void testComputeNumToSquare(Integer num, Integer square){
    Mockito.when(mathService.compute(num))
      .then(invocation -> Long.valueOf(Math.round(Math.pow(num, 2))).intValue());
    final Integer result = client.toBlocking().retrieve(HttpRequest.GET("/math/compute/" + num), Integer.class);
    Assertions.assertEquals(square,result);
    Mockito.verify(mathService).compute(num);
  }

  @MockBean(MathServiceImpl.class)
  MathService mathService(){
    return Mockito.mock(MathService.class);
  }
}
