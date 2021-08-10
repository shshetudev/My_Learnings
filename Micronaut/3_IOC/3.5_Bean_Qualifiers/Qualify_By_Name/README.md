### Qualifying by Name
* `javax.inject.Named` annotation indicates that `V8Engine` implementation is required.
* Micronaut is capable of injecting `V8Engine` in the previous example, because:
  * `@Named` qualifier value ( v8 ) + type being injected simple name (`Engine`) == (case-insensitive) == The simple name of a bean of type Engine (`V8Engine`).
* We can also declare `@Named` at the class level of a bean to explicitly define the name of the bean.