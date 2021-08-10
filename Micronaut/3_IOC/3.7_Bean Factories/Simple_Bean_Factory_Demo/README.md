### Bean Factories
* In many cases, we may want to make available a class as a bean, that is not part of our codebase.
* Such as those provided by third party libraries.
* In this case we can not annotate the compiled class.
* Instead we can implement a `@Factory`.

### Factory
* A factory is a class annotated with the Factory annotation that provides one or more methods annotated with a bean scope annotation.
* Which annotation we use dependes on what scope we want the bean to be in.
* The return types of methods annotated with a bean scope annotation are the bean types.

#### 1. Simple Bean Factory Demo Application:
