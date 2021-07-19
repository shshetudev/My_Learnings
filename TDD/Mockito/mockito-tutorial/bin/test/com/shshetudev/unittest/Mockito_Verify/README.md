### Mockito Verify
* Mockito Verify methods are used to check that certain behavior happened.
* __We can use Mockito verify methods at the end of the testing method code to make sure that specified methods are called.__
* __verify():__
    * Mockito `verfiy()` method can be used to test number of method invocations too.
    * We can test exact number of times, at least once, at least, at most number of invocation times for a mocked method.
* __verifyNoMoreInteractions():__
    * We can use `verifyNoMoreInteraactions()` after all the `verify()` method calls to make sure everything is verified.
    * If any method verification is still left, it will fail and provide proper message.
* __verifyZeroInteractions():__ `verifyZeroInteractions()` behavior is same as `verifyNoMoreInteractions()` method.
* __inOrder():
    * __ We can use `inOrder()` method to verify the order of method invocation.
    * We can skip a method invocation but the methods being verified must be in the smae order.


### Mockito verify() simple example
Please see the implementation at: [MockitoVerifySimpleExample](../Mockito_Verify/MockitoVerifySimpleExample.java)
* In the following example, `verify()` method will pass if `add("Shetu")` is called only once on the mocked list object.
* It's the same as calling with `times(1)` argument with `verify()` method.
* If we want to make sure a method is called but we don't care about the argument, then we can use `ArgumentMatchers` with `verify()` method.
* `org.mockito.Mockito` class provides for most of the useful methods in the Mockito framework.
* This helps us in writing fluent code by importing them using `import static`.

### Mockito verify with number of times
Please see the implementation at: [MockitoVerifyNumberOfTimes](../Mockito_Verify/MockitoVerifyNumberOfTimes.java)
* Mockito `verify()` method is overloaded, the second one is `verify(T mock, VerificationMode mode)`.
* We can use it to verify for the invocation count.

### Mockito verifyNoMoreInteractions()
Please see the implementation at: [MockitoVerifyNoMoreInteractions](../Mockito_Verify/MockitoVerifyNoMoreInteractions.java)
* `verifyNoMoreInteractions()` can be used after all the verify methods to makes sure that all the interactions are verified.
* It will fail the test if there are any unverified interactions on the mocked object.

### Mockito verifyZeroInteractions()
Please see the implementation at: [MockitoVerifyZeroInteractions](../Mockito_Verify/MockitoVerifyZeroInteractions.java)
* `verifyZeroInteractions()` method behavior is same as `verifyNoMoreInteractions()` method.

### Mockito verify only one method call
Please see the implementation at: [MockitoVerifyOnlyOneMethodCall](../Mockito_Verify/MockitoVerifyOnlyOneMethodCall.java)
* If we want to verify that only one method is being called, then we can use `only()` with verify method.

### Mockito Verify Order of Invocation
Please see the implementation at: [MockitoVerifyOrderOfInvocation](../Mockito_Verify/MockitoVerifyOrderOfInvocation.java)
* We can use `InOrder` to verify the order of invocation.
* We can skip any method to verify, but the methods being verified must be invoked in the same order.

