package com.shshetudev.unittest.Mockito_Verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

 class MockitoVerifyNumberOfTimes {

  @Test
  void test(){
    List<String> mockList = mock(List.class);
    mockList.add("Shetu");
    mockList.size();
    verify(mockList, times(1)).size(); // same as normal verify
    verify(mockList, atLeastOnce()).size(); // must be called at least once
    verify(mockList, atMost(2)).size(); // must be called at most 2 times
    verify(mockList, never()).clear(); // must never be called
  }
}
