package com.shshetudev.unittest.Mockito_Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MockitoMockMethodExample {

  @SuppressWarnings("unchecked")
  @Test
  void test() {
    // Using Mockito.mock() method
    List<String> mockList = mock(List.class);
    when(mockList.size()).thenReturn(5);
    assertEquals(5, mockList.size());
  }
}
