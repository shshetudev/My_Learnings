### Programmatically disabling bean
* Factory methods can throw `DisabledBeanException` to conditionally disable beans.
* Using `@Requires` should always be the preferred method to conditionally create beans.
* Throwing an exception in a factory method should only be done if using `@Requires` is not possible.