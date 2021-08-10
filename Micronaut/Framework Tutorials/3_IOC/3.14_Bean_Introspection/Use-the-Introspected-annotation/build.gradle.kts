plugins {
  id("com.github.johnrengelman.shadow") version "7.0.0"
  id("io.micronaut.application") version "1.5.3"
}

version = "0.1"
group = "com.example"

repositories {
  mavenCentral()
}

micronaut {
  runtime("netty")
  testRuntime("junit5")
  processing {
    incremental(true)
    annotations("com.example.*")
  }
}

dependencies {
  implementation("io.micronaut:micronaut-http-client")
  implementation("io.micronaut:micronaut-runtime")
  implementation("javax.annotation:javax.annotation-api")
  runtimeOnly("ch.qos.logback:logback-classic")
  implementation("io.micronaut:micronaut-validation")
  implementation("org.apache.commons:commons-lang3:3.0")
// https://mvnrepository.com/artifact/org.assertj/assertj-core
  testImplementation("org.assertj:assertj-core:3.19.0")


}


application {
  mainClass.set("com.example.Application")
}
java {
  sourceCompatibility = JavaVersion.toVersion("11")
  targetCompatibility = JavaVersion.toVersion("11")
}



