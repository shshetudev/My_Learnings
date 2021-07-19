package com.shshetudev.unittest.Mockito_Mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MockitoSpyAnnotationExample {
   @Spy
  Utils mockUtils;

  @BeforeEach
   void setup(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
   void test(){
    Mockito.when(mockUtils.process(1,1)).thenReturn(5);

    // Mocked method
    assertEquals(5, mockUtils.process(1,1));

    // Real method called since it's not stubbed
    assertEquals(20, mockUtils.process(19,1));
  }

}
