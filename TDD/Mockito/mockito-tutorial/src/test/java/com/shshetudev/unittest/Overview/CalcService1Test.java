package com.shshetudev.unittest.Overview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Illustrates the usage of mock() method.
 * @author shetu
 * @since July 10, 2021
 */
class CalcService1Test {

 @Test
  void testCalc() {
//    System.out.println("**___  ___**");
    System.out.println("**___ Test testCalc executed ___**");
    AddService addService;
    CalcService calcService;
    // AddService is injected inside the CalcService. That's why we are mocking it.
    addService = mock(AddService.class);
    calcService = new CalcService(addService);

    int num1 = 11;
    int num2 = 12;
    int expected = 23;

    // We are willing to test the CalcService
    when(addService.add(num1, num2)).thenReturn(expected);
    int actual = calcService.calc(num1, num2);
    assertEquals(expected, actual);
  }
}
