package com.shshetudev.unittest.Mockito_Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class MockitoSpyMethodExample {

 @Test
  void test(){
   List<String> list = new ArrayList<>();
   List<String> spyOnList = spy(list);

   when(spyOnList.size()).thenReturn(10);
   assertEquals(10, spyOnList.size());

   // Calling real methods since below methods are not stubbed
   spyOnList.add("Shetu");
   spyOnList.add("Shanta");
   assertEquals("Shetu",spyOnList.get(0));
   assertEquals("Shanta",spyOnList.get(1));
 }

}
