package com.shshetudev.unittest.Mockito_Inliner;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mockStatic;

public class FooWithStaticsTest {

  // Test case is failing
  @Test
  void testStatic(){
    // before mock scope, usual behavior.
    assertNotEquals(0L,FooWithStatics.noParameters());
    assertNotEquals("yyy",FooWithStatics.oneParameter("xxx"));

    // Mock scope
    try(MockedStatic mocked = mockStatic(FooWithStatics.class)){
      // Mocking
      mocked.when(FooWithStatics::noParameters).thenReturn(0L);
      mocked.when(() -> FooWithStatics.oneParameter("xxx")).thenReturn("yyy");

      // Mocked behavior
      assertEquals(0L,FooWithStatics.noParameters());
      assertEquals("yyy",FooWithStatics.oneParameter("xxx"));

      // Verifying mocks
      mocked.verify(times(1), FooWithStatics::noParameters);
      mocked.verify(times(1), () -> FooWithStatics.oneParameter("xxx"));
    }

    // After mock scope returns to usual behavior.
    assertNotEquals(0L, FooWithStatics.noParameters());
    assertNotEquals("yyy", FooWithStatics.oneParameter("xxx"));
  }

  @Test
  void testStaticWithObjectConstruction(){
    // before mock scope, usual behavior.
    assertNotEquals(0L,FooWithStatics.noParameters());
    assertNotEquals("yyy",FooWithStatics.oneParameter("xxx"));

    // Mock scope
    try(MockedConstruction mocked = mockConstruction(FooWithStatics.class)){
      FooWithStatics foo = new FooWithStatics();
      // Mocking
     when(foo.noParameters()).thenReturn(0L);
     when(foo.oneParameter("xxx")).thenReturn("yyy");

      // Mocked behavior
      assertEquals(0L,foo.noParameters());
      assertEquals("yyy",foo.oneParameter("xxx"));

      // Verifying mocks
//      verify(times(1), foo.noParameters());
//      mocked.verify(times(1), () -> FooWithStatics.oneParameter("xxx"));
    }

    // After mock scope returns to usual behavior.
    assertNotEquals(0L, FooWithStatics.noParameters());
    assertNotEquals("yyy", FooWithStatics.oneParameter("xxx"));
  }
}
