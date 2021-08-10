#### Primary and Secondary Beans
* `Primary` is a qualifier that indicates that a bean is the primary bean to be selected in the case of multiple Interface implementations.
* `ColorPicker` is implemented by two classes: `Green` and `Blue`.
* The `Green` bean class implements `ColorPicker` and is annotated with `@Primary`.
* The `Blue` bean class also implements `ColorPicker` and hence we have two possible candidates when injecting the `ColorPicker` interface.
* Since `Green` is the primary, it will always be favoured.
* Run the application and run this command in command line: `curl http://localhost:8080/testPrimary`.