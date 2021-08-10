#### Inversion of Contorll
* Unlike other frameworks which rely on runtime reflection and proxies, Micronuat uses compile time data to implement dependency injection.
* This is a similar ppoach taken by tools such as `Google Dagger(?)`, which is designed primarliy with Android in mind.
* Micronaut on the other hand, is desinged for building server-side microservices and provides many of the same tools and utilites as other frameworks but without usign reflection or caching excessive amount of relection metadata.

#### Goals of Micronaut IoC container
* Use reflection as a last resort.
* Avoid proxies.
* Optimize start-up time.
* Reduce memory footprint.
* Provide clear, understandale error handling.

#### Implementation
* __IoC part to Micronuat can be used completely independently of Micronuat for whatever application type we wish to build.__
* To do so, we configure our build to include the `micronaut-inject-java` dependency as an annotation processor.
* The easiest way to do this is with Micronaut's Gradle or Maven plugins. For example:
> `plugins {`
> `id 'io.micronaut.library' version '1.3.2'`
> `}`
> `version "0.1"`
> `group "com.example"`
> `micronaut {`
> `version = "2.5.7"`
> `}`      
* The entry point for IoC is then `ApplicationContext` interface, which includes a run method. The following example demonstrates using it:
> `try (ApplicationContext context = ApplicationContext.run()) {`
> `MyBean myBean = context.getBean(MyBean.class);`
> `// doing something with our bean`
> `}`








