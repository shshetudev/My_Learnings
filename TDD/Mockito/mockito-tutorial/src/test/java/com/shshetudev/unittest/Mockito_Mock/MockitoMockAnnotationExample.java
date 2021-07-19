package com.shshetudev.unittest.Mockito_Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MockitoMockAnnotationExample {
@Mock
List<String> mockList;

@BeforeEach
  void setup(){
  // If we don't call below, we will get NullPointerException
  MockitoAnnotations.initMocks(this);
}

@SuppressWarnings("unchecked")
@Test
void test(){
  when(mockList.get(0)).thenReturn("JournalDev");
  assertEquals("JournalDev",mockList.get(0));
}
}
