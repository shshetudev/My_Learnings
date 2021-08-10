#### Defining Beans
* __A bean is an object whose lifecylce is managed by the Micronaut IoC container.__
* That lifecycle may include creation, execution and destruction.
* Micronaut implements the __JSR-330 (javax.inject) - Dependency injection for Java__ specification, hence to use Micronaut we simply use the __annotation provided by javax.inject__.
* Micronaut supports the following types of dependency injection:
   * Constructor injection (must be one public constructor or a single constructor annotated with `@Inject`).
   * Field injection.
   * JavaBean property injection.
   * Method parameter injection.