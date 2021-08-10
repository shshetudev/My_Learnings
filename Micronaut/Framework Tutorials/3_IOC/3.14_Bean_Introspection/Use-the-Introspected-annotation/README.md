### Using the `@Introspected` Annotation
* The `@Introspected` annotation can be used on any class to make it available for introspection.
* We simply annotated the class with `@Introspcected`.
* Once introspection data has been produced at `compile time`, we can retrieve it via the `BeanIntrospection` API.
* We can retrieve a `BeanIntrospction` with the static `getIntrospection` method.
* Once we have a `BeanIntrospection`, we can __instantiate__ a bean with the `instantiate` method.
* A `BeanProperty` can be retrieved from the introspection.
* We can use the `set` method to set the __property value__.
* We can use the `get` method to retrieve the __property value__.
* If our `Person` class does not have any setters like `setAge`,`setName` methods in that case we won't be able to set any property value using bean introspection.