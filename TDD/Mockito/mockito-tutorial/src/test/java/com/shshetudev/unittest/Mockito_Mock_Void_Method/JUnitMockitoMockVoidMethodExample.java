package com.shshetudev.unittest.Mockito_Mock_Void_Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class JUnitMockitoMockVoidMethodExample {

  @Test
  void testEmployee(){
    Employee emp = mock(Employee.class);
    doThrow(IllegalArgumentException.class).when(emp).setName(null);
    doAnswer(
      i -> {
        System.out.println("Employee setName Argument = " + i.getArgument(0));
      assertTrue("Shetu".equals(i.getArgument(0)));
      // return null is required since we are mocking void method
      return null;
      }).when(emp).setName(anyString());

    when(emp.getName()).thenReturn("Shetu");
    assertThrows(IllegalArgumentException.class, () -> emp.setName(null));

    emp.setName("Shetu");
    assertEquals("Shetu", emp.getName());
  }
}
