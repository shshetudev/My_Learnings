package com.shshetudev.unittest.Mockito_Verify;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.mock;

public class MockitoVerifyOrderOfInvocation {
  @Test
  void orderOfInvocation(){
    List<String> mockList = mock(List.class);
    mockList.add("Shetu");
    mockList.size();
    mockList.isEmpty();
    Map mockMap = mock(Map.class);
    mockMap.isEmpty();
    InOrder inOrder = Mockito.inOrder(mockList,mockMap);
    inOrder.verify(mockList).add("Shetu");
    inOrder.verify(mockList,calls(1)).size();
    inOrder.verify(mockList).isEmpty();
    inOrder.verify(mockMap).isEmpty();
  }
}
