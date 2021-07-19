### Mockito Mock Static Method Using PowerMock
* Mockito allows us to create mock objects.
* Since static method belongs to the class, there is no way in Mockito to mock static methods.
* However, we can use PowerMock along with Mockito framework to mock static methods.
* We need to annotate class with `@PrepareForTest` and provide class to be mocked using PowerMock.
* We use `PowerMockito.mockStatic()` for mocking class with static methods.
* We use `PowerMockito.verifyStatic()` for verifying mocked methods using Mockito.

### Mockito Verify Order of Invocation
Please see the implementation at: [PowerMockitoStaticExample](../Mockito_Mock_Static_Method/PowerMockitoStaticExample.java)
