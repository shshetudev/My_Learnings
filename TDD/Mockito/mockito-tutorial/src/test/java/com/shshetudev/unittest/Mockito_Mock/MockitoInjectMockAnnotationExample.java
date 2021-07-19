package com.shshetudev.unittest.Mockito_Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoInjectMockAnnotationExample {

  @Mock
  List<String> mockList;

  // @InjectMock creates an instance of the class and injects the mocks that are marked with the annotations @Mock into it.
  @InjectMocks
  Fruits mockFruits;

  @BeforeEach
  void setup(){
    MockitoAnnotations.initMocks(this);
  }

  @SuppressWarnings("unchecked")
  @Test
  void test(){
    when(mockList.get(0)).thenReturn("Apple");
    when(mockList.size()).thenReturn(1);
    assertEquals("Apple", mockList.get(0));
    assertEquals(1, mockList.size());

    // mockFruits names is using mockList, below asserts confirm it
    assertEquals("Apple",mockFruits.getNames().get(0));
    assertEquals(1,mockFruits.getNames().size());

    mockList.add(1,"Mango");
    // below will print null because mockList.get(1) is not stubbed.
    System.out.println(mockList.get(1));
  }

}
