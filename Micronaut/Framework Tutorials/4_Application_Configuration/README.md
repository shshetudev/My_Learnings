## Applcation Configuration

* Configuration in Micronaut takes inspiration from both __Spring and Grails,__ __integrating configuration properties from multiple sources directly into the core IoC container__.
* Configuration can by default be provided in Java properties: __YAML, JSON or Groovy files.__
* The convention is to search for a file named __application.yml, application.properties, application.json or application.groovy.__
* In addition, like Spring and Grails, __Micronaut allows overriding any property via system properties or environment variables.__
* Each source of configuration is modeled with __PropertySource__ interface and the mechanism is extensible, allowing the implementation of addtional __PropertySourceLoader__ implementations.

### The Environment

* The environment is modelled by the __Environment__ interface, which allows specifying one or many unique environment names when creating an __ApplicationContext.__
    >`ApplicationContext applicationContext = ApplicationContext.run("test","android");`
    `Environment environment = applicationContext.getEnvironment();`
    `assertTrue(environment.getActiveNames().contains("test"));`
    `assertTrue(environment.getActivenNames().contains("android"));`

* __The active environment names allow loading different configuration files depending on the environment__, and also using the `@Requires` annotation to conditionally load beans or bean `@Configuration` packages.
* __In addition, Micronaut attempts to detect the current environments.__
* For example, within a Spock or JUnit test the `TEST` environment is automatically active.
* Additional active environments can be specified using the `micronaut.environments` system property or the `MICRONAUT_ENVIRONMENTS` environment varaible.
* These are specified as a comma-seperated list. For example:
  > `java -Dmicronaut.environments=foo,bar -jar myapp.jar`
* Those above environments are called `foo` and `bar`.
* __Finally Cloud environments names are also detected.__

### Environment Priority

* Micronaut loads property sources based on the environments specified.
* __If the same property key exists in multiple property sources specific to an environment, the environemnt order determines which value to use.__
* Micronaut uses the following hierarchiy for __environment processing (lowest to highest priority):__
  * Deduced environments.
  * Environments from the `micronaut.environments` system property.
  * Environments from the `MICRONAUT_ENVIRONMENTS` environment variable.
  * __Environments specified explicitly through the applciation context builder.__
  * This also applies: `@MicronautTest(environments=...)`


### Disabling Environment Detection

* __Automatic detection of environments can be disabled by setting the `micronaut.env.deduction` system property or the `MICRONAUT_ENV_DEDUCTION` environment variable to false.__
* This prevents Micronaut from detecting current environments, while still using any environments that are specifically provided as show above:
  `java -Dmicronaut.env.deduction=false -jar myApp.jar`
  * Alternatively, we can disable environment deduction using the `ApplicationContextBuilder deduceEnvironment` method when setting up our application.
    > `​@Test`
    > `public void testDisableEnvironmentDeductionViaBuilder() {`
    > `ApplicationContext ctx = ApplicationContext.builder().deduceEnvironment(false).start();`
    > `assertFalse(ctx.getEnvironment().getActiveNames().contains(Environment.TEST));`
    > `ctx.close();`
    > `}`

### Default Environment

* __Micronaut supports the concept of one or may default environments.__
* A default environemnt is one that is only applied __if no other environemnts are explicitly specified or deduced.__
* __Environments can be explictily specified either through the application context builder `Micronaut.build().environments(...)`, through the `micronaut.environments` system property, or the `MICRONAUT_ENVIRONMENTS` environment variable.__
* Environments can be deduced to automatically apply the environment appropriate for cloud deployments.
* If an environment is found through any of the above means, the default enviromnet will not be applied.
* To set the default environments, we have to modify our application main method:
  > `public static void main(String[] args) {`
  `Micronaut.build(args)`
  `.mainClass(Application.class)`
  `.defaultEnvironments("dev")`
  `.defaultEnvironments("dev")`
  `}`

### Micronaut Banner

* __Since Micronaut 2.3 a banner is shown when the application starts.__
* It is enabled by default and it also shows the Micronaut version.
* We can get it by simply running: `./gradlew run`.
* __To customize the banner with our own ASCII art (just plain ASCII at this moment), we have to create the file `src/main/resources/micronaut-banner.txt` and it will be used instead.__
* To disable it, we have to modify our `Application` class:
  > `public class Application {` 
  `public static void main(String[] args) {`
  `Micronaut.build(args)`
  `.banner(false) `
  `.start();`
  `}`
  `}`

### Externalized Configuration with PropertySources

* Additional `PropertySource` instances can be applied to the environment prior to intializing the `ApplicationContext`.
    > `​ApplicationContext applicationContext = ApplicationContext.run(`
    > `PropertySource.of(`
    > `"test",`
    > `CollectionUtils.mapOf(`
    > `​"micronaut.server.host", "foo",`
    > `​"micronaut.server.port", 8080`
    > `​)`
    > `),`
    > `​"test", "android");`
    > `nvironment environment = applicationContext.getEnvironment();`
    > `assertEquals(`
    > `foo",`
    > `environment.getProperty("micronaut.server.host",`
    > `String.class).orElse("localhost")`
    > `​);`
* The `PropertySources.of` method can be used to create a `PropertySource` form a map of values.
* Alternatively one can register a `PropertySouceLoader` by creating a `META-INF/services/io.micronaut.context.env.PropertySourceLoader` file containing a reference to the class name of the `PropertySourceLoader`.

### Included PropertySource Loaders

* Micronaut by default contains `PropertySourceLoader` implmentations that load properties from the given locations and priority.
  * Command line arguments.
  * Properties from `SPRING_APPLICATION_JSON`__(for Spring compatibility)__
* Properties from `MICRONAUT_APPLICATION_JSON`
* Java System Properties
* OS environment variables.
* Configuration file loaded in order from the system property `micronau.config.files` or the environmnet variable `MICRONAUT_CONFIG_FILES`.
* The value can be a comma seperated list of paths with the last file having precedence.
* These files can be referenced from the file system as a path, or the classpath with a `classpath:` prefix.
* Environment-specific properties from `application-{environment}.{extension}`
* Application-specific properties from `application.{extension}`
* ___.properties, .json, .yml are supported out of the box. For Groovy users .groovy is supported as well.__

### Supplying Configuration via Command line

Configuration can be supplied at the command line using Gradle or our Maven plugin:
> `./gradlew run --args="-endpoints.health.enabled=true -config.property=test"`
> `./mvnw mn:run -Dmn.appArgs="-endpoints.health.enabled=true -config.property=test"`

### Property Value placeholders

* Micronaut indicates a property placeholder syntax to reference configuration properties both within configuration values and with any Micronaut annotation.
* Programmatic usage is also possible via the `PropertyPlaceholderResolver` interface.
* the basic syntax is to wrap a reference to a property in `${...}`.
* For example in `application.yml`:
  > `myapp:`
  > `endpoint: http://${micronaut.server.host}:${micronaut.server.port}/foo`
* The above example embeds references to the `micronuat.server.host` and `micronuat.server.port` properties.
* We can specify default values by defining a value after the `:` character. For example:
  > `myapp:`
  > `endpoint: http://${micronaut.server.host:localhost}:${micronaut.server.port:8080}/foo`
* The above example defaults to `localhost`and port `8080` if no value is found (rather than throwing an exception).
* Note that if the default value contains a `:` character, we must excapt it using backticks:
  > `myapp:`
  > `endpoint: ${server.address:`\`http://localhost:8080\`}/`foo`
* The above example looks for a `server.address` property and defaults to `http://localhost:8080`. This default values is escaped with backticks since it has `:` character.

### Property Value Binding

* Note that these property references should be in kebab case (lowercase and hyphen-seperated), when placing references in code or in placeholder values.
* For example, we can use `micronaut.server.default-charset` and not `micronaut.server.defaultCharset`.
* __Micronuat still allows specifying the latter in configuration, but normalizes the properties into kebab case form to optimize memory consumption and reduce complexity when resolving properties.__
* The following summarizes how properties are normalized from different sources:
Property Value Normalization:

| Configuration Value        | Resulting Properties           | Property Source  |
| ------------- |-------------| -----|
| myApp.myStuff      | my-app.my-stuff | Properties, YAML etc. |
| MYAPP_MYSTUFF     | myapp.mystuff, myapp-mystuff      |   Environment Variable |
| MY_APP_MY_STUFF | my.app.my.stuff, my.app.my-stuff, my.app-my.stuff, my.app-my-stuff, my-app.my.stuff, my-app.my-stuff, my-app-my.stuff, my-app-my-stuff      |    Environment Variable |

* Environment variables are treated specially to allow more flexibility. There is no way to reference an environment variable with camel-case.
* To control how environment properties participate in configuration, we have to call the respective methods on the `Micronaut` builder.

### Using Random Properties

* We can use random values by using the following properties. These can be used in configuration files as varaibles like the following:
  > `micronaut:`
  > ` application:`
  > `   name: myapplication`
  > `   instance:`
  > `     id: ${random.shortuuid}`

* Random values:

| Property  | Vlaue |
|---------  |-----  |
| random.port | An available random port number |
| random.int  | Random int  |
| random.integer  | Random int  |
| random.long | Random long |
| random.float  | Random float  |
| random.shortuuid  | Random UUID of only 10 chars in length (Note: As this isn’t full UUID, collision COULD occur) |
| random.uuid | Random UUID with dashes |
| random.uuid2  | Random UUID without dashes  |

* `(max)` where max is an exclusive value.
* `[min,max]` where min being inclusive and max being excluesive values.
  > `instance:`
  > ` id: ${random.int[5,10]}`
  > ` count: ${random.int(5)}`

### Fail Fast Property Injection

* __For beans that inject required properties, the injection and potential failure will not occur untill the bean is requested.__
* To verify at startup that the properties exist and can be injected, the bean can be annotated with `@Context`.
* Context-scoped beans are injected at startup, and startup fails if any required properties are missing or cannot be converted to the required type.
* It is recommended to use this feature sparingly to ensure fast startup.

### Controlling log levels with Properties

* Log levels can be configured via properties defined in `application.yml` (and environment variables) with the `logger.levels` prefix:
  > `logger:`
  > `levels:`
  > `foo.bar: ERROR`

* __The same configuration can be achieved by setting the environment variable `LOGGER_LEVELS_FOO_BAR`.__

* Note that there is currently no way to set log levels for unconventional prefixes such as `foo.barBz`.

### Disabling a Logger with Properties

* To disable a logger, we need to set the logger level to `OFF`:
  >`logger:`
  >`levels:`
  >`io.verbose.logger.who.CriedWolf: OFF`
* This will disable `ALL` logging for the class `io.verbose.logger.who.CriedWolf`.
* Note that the ability to control log levels via config is controlled via the `LoggingSystem` interface.
* Currently, Micronaut includes a single implementation that allows setting log levels for the Logback library.
* If we use another libarary, we should provide a bean that implements this interface.

## Configuration Injection

We can inject configuration values info beans using the `@Value` annotation.

### Using the `@Value` Annotation

* Please see the illustration: Using_@Value_Anntation>EngineImpl.java
* The `@Value` annotation accepts a string that can have embedded placeholder values (teh default value can be provided by specifying a value after the `:` character).
* The injected value can then be used withing code.
* __Static @Value Example:__ 
  * Note that, `@Value` can also be used  to inject a static value. For example the following injects the number 10:
    >`@Value("10")`
    >`int number;`

  * This is even more useful when used to compose injected values combining static content and placeholders.

* __Placeholders with @Value:__ 
   >`@Value("http://${my.host}:${my.port}")`
   >`URL url;`

  * In the above example the URL is constructed from two placeholder properties that must be present in configuration: `my.host` and `my.port`.
  * We remember that to specify a default value in a placeholder expression, we use the colon `:` character.
  * If the default we specify includes a colon, we must escape the value with backticks. For example:
  > `@Value("${my.url:`http://foo.com`}")`
  > `URL url;`

  * Note that there is nothing special about `@Value` itself regarding the resolution of property value placeholders.
  * Due to Micronaut's extensive support for annotation metadata we can use property placeholder expressions on any annotation.
  * For example, to make the path of a `@Controller` configurable we can do:
  > `@Controller("${hello.controller.path:/hello}")`
  > `class HelloController {`
  > `...`
  > `}`
  
  * In the above case, if `hello.controller.path` is specified in configuration the controller will be mapped to the specified path, otherwise it will be mapped to `/hello`
  * We can also make the tart server fo r `@Client` configurable (although service discovery approaches are often better), for example:
    > `@Client("${my.server.url:`<http://localhost:8080>`}")`
    > `interface HelloClient {`
    > `...`
    > `}`

  * In the above example, the property `my.server.url` can be used to configure the client, otherwise the client falls back to a localhost address.

## Using the `@Property` Annoation

Please see the illustration:

* To inject a specific property name, we may be better off using `@Property`.
* __The `my.engine.cylinders` property is resolved from configuration and injected into the field.__
* __Fields subject to injection should not be private because expensive reflection must be used__
* ___The `@Property` annotation is used to inject through the setter.__
* __It is not possible to define a default value with `@Property, if the value doesn't exist or can not be converted to the required type, bean instantiation will fail.__
* The denoted illustration, injects the value of the `my.url` property resolved from application configuration.
* If the property can not be found in configuration, an exception is thrown.
* __As with other types of injection, the injection point can also be annoatated with @Nullable to make injection optional.__
* The `@MapFormat` annotation can be used to customize the injected map depending on whether you want nested keys or flat keys, and it allows customization of the key style via the `StringConvention` enum.

### Configuration Properties

Please see the illustration: 

* We can create type-safe configuration by creating classes that are annotated with `@ConfigurationProperties`.
* Micronaut will produce a reflection-free `@ConfigurationProeprties` bean and will also at compile time calculate the property paths to evaluate, greatly improving the speed and efficiency of loading `@ConfigurationProperties`.
* The `@ConfigurationProperties` annotation takes the configuration prefix.
* We can use `javax.validation` annotations to validate the configuration.
* Static inner classes can provide nested configuration.
* Optional configuration values can be wrapped in `java.util.Optional`.
* Configuration values can then be supplied from one of the `PropertySource` instances.
* For more complex configurations we can strcture `@ConfigurationProperties` beans through inheritence.
* __For example, creating a subclass of `EngineConfig` with `@ConfigurationProperties('bar') will resolve all properties under the path`my.eninge.bar`__
