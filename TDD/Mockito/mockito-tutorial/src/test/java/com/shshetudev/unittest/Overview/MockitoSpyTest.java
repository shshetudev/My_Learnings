package com.shshetudev.unittest.Overview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoSpyTest {

  @Test
   void testMethod(){
    List<String> list = new ArrayList<>();
    // Calling the real methods
    List<String> listSpy = spy(list);

    listSpy.add("first-element");
    System.out.println(listSpy.get(0));
    assertEquals("first-element",listSpy.get(0));
    when(listSpy.get(0)).thenReturn("second-element");
    System.out.println(listSpy.get(0));
    assertEquals("second-element", listSpy.get(0));
  }
}
