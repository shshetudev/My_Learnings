package com.shshetudev.unittest.Mockito_mock_final_class_and_methods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockingFinalClassTest {

  @Test
  void whenFinalClassMockWorks(){
    FinalList finalList = new FinalList();
    FinalList mock = mock(FinalList.class);
    when(mock.size()).thenReturn(2);
    assertNotEquals(mock.size(),finalList.size());
  }
}
