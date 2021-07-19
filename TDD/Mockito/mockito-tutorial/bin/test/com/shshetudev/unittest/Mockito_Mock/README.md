### Mockito mock method
Please see the implementation at: [MockitoMockMethodExample](../Mockito_Mock/MockitoMockMethodExample.java)
* We can use `Mockito` class `mock()` method to create a mock object of a given class or interface.
* This is the simplest way to mock an object.
* We can use `JUnit5` to write test cases in conjunction with `Mockito` to mock objects.

### Mockito @Mock Annotation
Please see the implementation at: [MockitoMockAnnotationExample](../Mockito_Mock/MockitoMockAnnotationExample.java)
* We can mock an object using `@Mock` annotation too.
* __It is useful when we want to use the mocked object at multiple places because we avoid calling `mock()` method multiple times.__
* __The code becomes more readable and we can specify mock object name that will be useful in case of errors.__
* When using `@Mock` annotation, __we have to make sure that we call `MockitoAnnotations.initMocks(this)` to initialize the mocked object__.
* __We can do this in testing framework `setup()` methods that are executed before the tests.__

### Mockito @InjectMocks Annotation
Please see the implementation at: [MockitoInjectMockAnnotationExample](../Mockito_Mock/MockitoInjectMockAnnotationExample.java)
* When we want to inject a mocked object into another mocked object, we can use `@InjectMocks` annotation.
* __`@InjectMocks` create the mock object of the class and injects the mocks that are marked with the annotations `@Mock` into it.__

### Mockito spy() for partial mocking
Please see the implementation at: [MockitoSpyMethodExample](../Mockito_Mock/MockitoSpyMethodExample.java)
* If we want only specific behaviors and call the real methods for unstubbed behaviors, then we create a spy object using Mockito `spy()` method.

### Mockito @Spy Annotation 
Please see the implementation at: [MockitoSpyAnnotationExample](../Mockito_Mock/MockitoSpyAnnotationExample.java)
* We can use `@Spy` annotation to spy on an object.
* __`@Spy` annotations tries to call the no-args constructor to initialized the mocked object.__
* if our class doesn't have it then we will such exception `org.mockito.exceptions.base.MockitoException: Unable to initialize @Spy annotated field 'mockUtils'.`.
* Mockito __can not instantiate inner classes, local classes, abstract classes, and interfaces.__
* So it's always a good idea to provide an instance to spy on.
* Otherwise, real methods might not get called and silently ignored.
* For example:
    * If we specify a spy object as below:
  > `@Spy` <br/>
  > `List<String>` spyList;
    * We will get notice that, when we call `add()` or `get()` methods, real methods are not getting called.
    * If we specify the spy object like below, then everything will work fine.
  > `@Spy` <br/>
  > `List<String>` spyList = new ArrayList<>();