plugins {
  id("com.github.johnrengelman.shadow") version "7.0.0"
  id("io.micronaut.application") version "1.5.3"
}

version = "0.1"
group = "com.shetu"

repositories {
  mavenCentral()
}

micronaut {
  runtime("netty")
  testRuntime("junit5")
  processing {
    incremental(true)
    annotations("com.shetu.*")
  }
}

dependencies {
  implementation("io.micronaut:micronaut-http-client")
  implementation("io.micronaut:micronaut-runtime")
  implementation("javax.annotation:javax.annotation-api")
  runtimeOnly("ch.qos.logback:logback-classic")
  implementation("io.micronaut:micronaut-validation")

}


application {
  mainClass.set("com.shetu.Application")
}
java {
  sourceCompatibility = JavaVersion.toVersion("11")
  targetCompatibility = JavaVersion.toVersion("11")
}



