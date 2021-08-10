### Injection point
* A common use case with factories is to take advantage of annotation metadata from the point at which an object is injected such that behaviour can be modified based on said metadata.
* The above annotation could be used to customize the type of engine we want to inject into a vehicle at the point at which the injection point is defined.
* The above `Vehicle` class specifies an annotation value of `@Cylinders(6)` indicating an `Engine` of six cylinders is required.
* To implement use case, we have to define a factory that accepts the `InjectionPoint` instance to analyze the defined annotation values.