## Build/ Install the CLI
* The best way to install Micronaut on Unix systems is with SDKMAN which greatly simplifies installing and managing multiple versions.

## Creating a Server Application
* Although not required to use Micronaut, the Micronaut CLI is the quickest way to create a new server application.
* Using the CLI we can create a new Micronaut application in either Groovy, Java, or Kotlin (the default is Java).
* The following command creates a new "Hello World" server application in Java with a Gradle build:
    > `mn create-app hello-world`

* By default the Micronaut HTTP server is configured to run on port 8080.
* Please see the illustration:
  [HomeController](../2_Quick_Start/server-hello-world/hello-world/bin/main/hello/world/HelloController.class)

## Creating a Client
* As mentioned previously, Micronaut includes both an __HTTP server__ and an __HTTP client__.
* A __low level HTTP client__ is provided which we can use to test the __HelloController__ created in the previous section.
* Please see the illustration:
    [HelloControllerSpec](server-hello-world/hello-world/src/test/java/hello/world/HelloControllerSpec.java)
* The __EmbeddedServer__ is configured as a shared test field.
* A __HttpClient__ instance shared field is also defined.
* The test used the __toBlocking()__ method to make a blocking call.
* The __retrieve__ method returns the controller response as a __String__.
* In addition to a low-level client, Micronaut features a __declarative, compile-time HTTP client__, powered by the __Client__ annotation.
* To create a client, we need to create an interface annotated with `@Client`.
* Please see the illustration:
    [HelloClientSpec](server-hello-world/hello-world/src/test/java/hello/world/HelloClientSpec.java)
* The `@Client` annotation is used with a value that is a relative path to the current server.
* The same `@Get` annotation used on the server is used to define the client mapping.
* An __RxJava `Single` is returned with the value read from the server.__
* To test the `HelloClient`, retrieve it from the `ApplicationContext` associated with the Server.
* The `@MicronautTest` annonation defines the test.
* The `HelloClient` is injected from the `ApplicationContext`.
* The client is invoked using the RxJava `blockingGet` method.
* The `Client` annotation produces an implementation automatically for you at compile time without the using proxies or runtime reflection.
* The `Client` annotation is very flexible.

## Deploying the Application
* To deploy a Micronaut application we create an executable JAR file by running `./gradlew assemble` or `./mvnw package`.
* The constructed Jar file can then be executed with `java -jar`. for example:
`java -jar build/libs/hello-world-all.jar`
* To publish a layered application to a Docker container registry, we configure our Docker image name in `build.gradle` for Gradle:
  > `dockerBuild { images = ["[REPO_URL]/[NAMESPACE]/my-image:$project.version"]}`
* Then we use `dockerPush` to push a built image of the application:
  `./gradlew dockerPush`