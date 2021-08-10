plugins {
  id("com.github.johnrengelman.shadow") version "7.0.0"
  id("io.micronaut.application") version "1.5.3"
}

version = "0.1"
group = "com.shshetudev"

repositories {
  mavenCentral()
}

micronaut {
  runtime("netty")
  testRuntime("junit5")
  processing {
    incremental(true)
    annotations("com.shshetudev.*")
  }
}

dependencies {
  implementation("io.micronaut:micronaut-http-client")
  implementation("io.micronaut:micronaut-runtime")
  implementation("javax.annotation:javax.annotation-api")
  runtimeOnly("ch.qos.logback:logback-classic")
  implementation("io.micronaut:micronaut-validation")
  testAnnotationProcessor("io.micronaut:micronaut-inject-java")
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testImplementation("io.micronaut.test:micronaut-test-junit5:2.3.7")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
  // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.0-M1")
// https://mvnrepository.com/artifact/org.mockito/mockito-all
  testImplementation("org.mockito:mockito-all:1.10.19")
// https://mvnrepository.com/artifact/org.hamcrest/hamcrest
  testImplementation("org.hamcrest:hamcrest:2.2")

}


application {
  mainClass.set("com.shshetudev.Application")
}
java {
  sourceCompatibility = JavaVersion.toVersion("11")
  targetCompatibility = JavaVersion.toVersion("11")
}



