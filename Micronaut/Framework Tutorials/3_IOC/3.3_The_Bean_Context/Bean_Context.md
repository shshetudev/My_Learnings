#### The BeanContext
* The `BeanContext` is a container object for all our bean definitions (it also implements `BeanDefintionRegistry`).
* __It is also the point of initialization for Micronaut.__
* Generally speaking however, we don't interact directly with the `BeanContext` API and can simply use `javax.inject` annotations and the annotations in the `io.micronaut.context.annotation` package for our dependency injection needs.