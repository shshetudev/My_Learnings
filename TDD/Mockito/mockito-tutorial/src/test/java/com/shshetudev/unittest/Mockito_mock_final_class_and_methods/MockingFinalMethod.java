package com.shshetudev.unittest.Mockito_mock_final_class_and_methods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

public class MockingFinalMethod {
  @Test
  void whenMockFinalMethodMockWorks() {
    MyList myList = new MyList();
    MyList mock = Mockito.mock(MyList.class);
    when(mock.finalMethod()).thenReturn(1);
    assertNotEquals(mock.finalMethod(),myList.finalMethod());
  }
}
