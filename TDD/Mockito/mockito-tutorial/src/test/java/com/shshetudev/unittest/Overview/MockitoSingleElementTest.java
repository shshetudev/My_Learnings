package com.shshetudev.unittest.Overview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MockitoSingleElementTest {

  @SuppressWarnings("unchecked")
  @Test
  void testMethod(){
    ArrayList mockedList = mock(ArrayList.class);
    // Here ArrayList is stubbed
    when(mockedList.get(0)).thenReturn("first-element");
    System.out.println(mockedList.get(0));
    assertEquals("first-element",mockedList.get(0));
    // null gets printed as get(1) is not stubbed
    System.out.println(mockedList.get(1));
  }
}
