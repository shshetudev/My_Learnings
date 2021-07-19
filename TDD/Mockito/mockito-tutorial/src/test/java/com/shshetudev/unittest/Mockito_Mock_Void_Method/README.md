### Mockito Mock Void Method
* Most of the times Mockito `when()` method is good enough to mock an object's behavior.
* But when we have to mock a void method, we can't use `when()`.
* Mockito provides following methods that can be used to mock void methods:
    * __`doAnswer():`__ We can use this to perform some operations when a mocked object method is called that is returning void.
    * __`doThrow():`__ We can use `doThrow()` when we want to stub a void method that throws exception.

### Mockito Verify Order of Invocation
Please see the implementation at: [MockitoMockVoidMethodExample](../Mockito_Mock_Void_Method/MockitoMockVoidMethodExample.java)
* Mockito `doAnswer()` method takes `Answer` as argument.
* It's a `functional Interface` so we can use `lambda expression` for its implementation.
* `return null` statement is required since we are mocking void method.