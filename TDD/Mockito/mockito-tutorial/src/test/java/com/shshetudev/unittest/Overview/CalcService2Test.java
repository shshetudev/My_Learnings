package com.shshetudev.unittest.Overview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * Illustrates the usage of @Mock annotation.
 *
 * @author shetu
 * @since July 10, 2021
 */
public class CalcService2Test {

  private CalcService calcService;

  @Mock
  private AddService addService;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testCalc() {
    System.out.println("**--- Test testCalc executed ---**");
    calcService = new CalcService(addService);

    int num1 = 11;
    int num2 = 12;
    int expected = 23;

    when(addService.add(num1, num2)).thenReturn(expected);
    int actual = calcService.calc(num1, num2);
    Assertions.assertEquals(expected, actual);
  }
}
