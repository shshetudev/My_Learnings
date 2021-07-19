package com.shshetudev.unittest.Mockito_Verify;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoVerifySimpleExample {
  @Test
  void test(){
    List<String> mockList = mock(List.class);
    mockList.add("Shetu");
    mockList.size();

    verify(mockList).add("Shetu");
    // We could also use times(1) argument with verify method
    verify(mockList,times(1)).size();
  }

  @Test
  void testAnyArgument(){
    List<String> mockList = mock(List.class);
    mockList.add("Shetu");
//    mockList.size();
    // Verify with any arguments
    verify(mockList).add(anyString());
    verify(mockList).add(any(String.class));
    verify(mockList).add(ArgumentMatchers.any(String.class));
//    verify(mockList,times(4)).size();
  }
}
