package com.shshetudev.unittest.Mockito_Verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class MockitoVerifyZeroInteractions {
  @Test
  void test(){
    List<String> mockList = mock(List.class);
    mockList.isEmpty();
    Map mockMap = mock(Map.class);
    Set mockSet = mock(Set.class);
    verify(mockList).isEmpty();
    verifyZeroInteractions(mockList,mockMap,mockSet);
  }
}
