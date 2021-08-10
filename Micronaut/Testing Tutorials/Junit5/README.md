### Testing with Junit 5

### Setting up JUnit 5
* To get started using JUnit 5 we need the following dependencies in our build configuration:
> `dependencies {` <br/>
`testAnnotationProcessor "io.micronaut:micronaut-inject-java"`<br/>
`...`<br/>
`testImplementation("org.junit.jupiter:junit-jupiter-api")`<br/>
`testImplementation("io.micronaut.test:micronaut-test-junit5:2.3.7")`<br/>
`testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")`<br/>
`}`<br/>
// use JUnit 5 platform<br/>
`test {`<br/>
`useJUnitPlatform()`<br/>
`}`
* if we plan to define mock beans we will also need to `inject-groovy` on our `testCompile` classpath or `inject-java` for Java or Kotlin and `testAnnotationProcessor`.

### Writing a Micronaut Test with Junit5
Please see the illustration folder: [service](src/test/java/com/shshetudev/service)
* The test is declared as Micronaut test with `@MicronautTest`.
* The `@Inject` annotation is used to inject the bean.
* The test itself tests the injected bean.

### Environment, Classpath Scanning etc
* The `@MicronautTest` annotation support the environment names the test should run with.
`@MicronautTest(environments={"foo", "bar"})`
* In addition, although Micronaut itself doesn't scan the classpath, some integrations do (such as JPA or GORM).
* For these cases we may wish to specify either the application class:
`@MicronautTest(application=Application.class)`
* Or the packages, to ensure that entities can be found during classpath scanning:
`@MicronautTest(packages="foo.bar)`
  
### Transaction semantics
* By default,if `org.springframework:spring-tx` is in the test classpath (e.g. transitively via `io.micronaut.configuration:micronaut-hibernate-jpa-spring`),
when using `@MicronautTes` each `@Test` method will be wrapped in a transaction that will be rolled back when the test finishes.
* The behaviour can be changed by using the `transactional` and `rollback` properties.
* To avoid creating a transaction: `@MicronautTest(transactional = false)`.
* To not rollback the transaction: `@MicronautTest(rollback = false)`
* Additionally, the `transactionMode` property can be used to further customize the way that transactions are handled for each test:
`@MicronautTest(transactionMode = TransactionMode.SINGLE_TRANSACTION)`.
* The following transaction modes are supported:
    * __`SEPARATE_TRANSACTIONS` (default)__ :
        * __Each setup/cleanup method is wrapped in its own transaction, seperate from that of the test__.
        * The transaction is always committed.
    * __`SINGLE_TRANSACTION`__
        * All __setup methods__ are wrapped in the same transaction as the test.
        * Cleanup methods are wrapped in seperate transactions.

### Using Mockito Mocks
* Now let's say __we want to replace the implementation with a Mockito Mock__.
* We can do so by defining a method that returns a mock and is annotated with `@MockBean`.
* The `@MockBean` annotation is used to indicate the method returns a mock bean.
* The value to the method is the type being replaced.
* Mockito's `mock(...)` method creates the actual mock.
* The Mock is injected into the test.
* Mockito is used to verify the mock is called.
* __Because the bean is the inner class of the test, it will be active only for the scope of the test.__
* This approach allows us to define beans that are isolated per test class.

### Mocking Collaborators
* In most cases we won't define a `@MockBean` and then inject it only to verify interaction with the Mock directly, __instead the Mock will be a collaborator within our application__.
* For example say we have a `MathController`.
* This controller uses the `MathService` to expose a `/math/compute/{number}` endpoint.
* Let's see an example for a test that tests interaction with the mock collaborator.
* Like the previous example a Mock is defined using `@MockBean`.
* This time we inject an instance of `RxHttpClient` to test the controller.
* We invoke the controller and retrieve the result.
* The interaction with mock collaborator is verified.
* __The way this works is that `@MicronautTest` will inject the `Mock(..)` instance into the test, but the controller will have a proxy that points to the `Mock(..)` instance injected.__
* For each iteration of the test, the mock is refreshed (in fact it uses Micronaut's built in `RefreshScop`).
* For factory injected beans, we can use Factory Replacement to inject Mocks.

### Using `@Requires` on Tests
* Since `@MicronautTest` turns tests into bean themselves, it means we can use the `@Requires` annotation on the test to enable/disable tests. For example:
> `@MicronautTest`<br/>
`@Requires(env = "my-env")`<br/>
`class RequiresTest {`<br/>
`...`<br/>
`}`<br/>
* The above test will run if `my-env` is active (we can activate it by passing the system property `micronaut.environments`).

### Defining Additional Test Specific Properties
Please see the illustrations at: [property](src/test/java/com/shshetudev/property)
* We can define additional test specific properties using the `@Property` annotation.
* The following class illustrates:
* __When a `@Property` is defined at the test method level, it causes a `RefreshEvent` to be triggered which will update any `@ConfigurationProperties` related to the property.__
* Alternatively you can specify additional `propertySources` in any supported format (YAML, JSON, Java properties file etc.) using `@MicronautTest` annotation.
* The illustration of [PropertySourceTest](src/test/java/com/shshetudev/property/PropertySourceTest.java) expects a file located at `src/test/java/com/shshetudev/myprops.properties`.
* __We can however use a prefix to indicate where the file should be searched for.__
* The following are valid values:
    * `file:myprops.properties` - A relative path to a file somewhere on the file system.
    * `classpath:myprops.properties` - A file relative to the root of the classpath.
    * `myprops.properties` - A file relative on the classpath relative to the test being run.
* If we need more dynamic property definition or the property we want to define requires some setup then we can implement the `TestPropertyProvider` interface in our test and do whatever setup is necessary. 
* Then we return the properties we want to expose to the application.    

### Using the `TestPropertyProvider` interface
* When using `TestPropertyProvider`, our test must be declared with JUnit's `@TestInstance(TestInstance.Lifecycle.PER_CLASS)` annotation.

### Refreshing injected beans based on `@Requires` upon properties changes
Please see the illustration class: [PropertyValueRequiresTest](src/test/java/com/shshetudev/property/PropertyValueRequiresTest.java)
* __We can combine the use of `@Requires` and `@Property`, so that injected beans will be refreshed if there are configuration changes that affect their `@Requires` condition.__
* For That to work, __the test must be annotated with `@MicronautTest(rebuildContext = true)`__
* In that case, __if there are changes in any property for a given test, the application context will be rebuilt so that `@Requires` conditions are re-evaluated again.__

### Testing External Servers
* We can write integration tests that external servers in a couple of different ways.
* __One way__ is with the `micronaut.test.server.executable` property that allows us to specify the location of an executable JAR or native image of a server, that should be started and shutdown for the lifecycle of test.
* In this case Micronaut Test will replace the regular server with an instance of `TestExecutableEmbeddedServer` that executes the process to start the server and closes the process when the test ends.
> `@Property(`<br/>
`name = TestExecutableEmbeddedServer.PROPERTY,`<br/>
`value = "src/test/apps/test-app.jar"`<br/>
)
* Alternatively, if we have independently started an `EmbeddedServer` instance programmatically we can also specify the URL to the server with the `micronaut.test.server.url` property. 