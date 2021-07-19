package com.shshetudev.unittest.Mockito_Verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.mockito.Mockito.*;

public class MockitoVerifyOnlyOneMethodCall {
  @Test
  void verifyOnlyOnce(){
    Map mockMap = mock(Map.class);
    mockMap.isEmpty();
    verify(mockMap,only()).isEmpty();
  }
}
