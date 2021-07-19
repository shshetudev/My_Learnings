package com.shshetudev.unittest.Overview;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Illustrates the usage of verify() method.
 *
 * @author shetu
 * @since July 10, 2021
 */
public class VerifyInteractionTest {

  @Test
  void testMethod() {
    // Adding functionalities
    @SuppressWarnings("unchecked")
    List<String> mockedList = mock(List.class);
    mockedList.add("first-element");
    mockedList.add("second-element");
    mockedList.add("third-element");
    mockedList.add("third-element");
    mockedList.clear();

    // Verifying functionalities
    verify(mockedList).add("first-element");
    verify(mockedList).add("second-element");
    verify(mockedList,VerificationModeFactory.times(2)).add("third-element");
    verify(mockedList).clear();
  }
}
