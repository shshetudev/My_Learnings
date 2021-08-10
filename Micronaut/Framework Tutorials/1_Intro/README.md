## Introduction
* Micronaut is a modern, JVM-based, full stack Java framework designed for building modular, easily testable JVM applications with support for Java, Kotlin and Groovy.
* __Micronaut is developed by the creators of the Grails framework and takses Inspiration from lessons learnt over the years building real-world applications from monoliths to microservices using Spring, Spring Boot and Grails.__
* Micronaut aims to provide all the tools necessary to build JVM applications including:
  * Dependency Injection and Inversion of Control (IoC).
  * Aspect Oriented Programming (AOP).
  * Sensible Defaults and Auto-Configuration.
* With Micronaut we can build Message-driven Applications, Command line applications, HTTP servers and more whilst for Microservices in particular Micronaut also provides:
  * Distributed Configuration.
  * Service Discovery.
  * HTTP Routing.
  * Client-Side Load Balancing.
* At the same time Micronaut aims to avoid the downsides of frameworks like Spring, Spring Boot and Grails by providing:
  * Fast Startup time.
  * Reduced memory footprint.
  * Minimal use of reflection.
  * Minimal use of proxies.
  * No runtime bytecode generation.
  * Easy Unit Testing.
* __Historically, frameworks such as Spring ang Grails were not designed to run in scenarios such as serverless functions, Android apps or low memory footprint microservices.__ 
* In contrast, Micronaut is designed to be sutiable for all of these scenarios.
* This goal is achieved through the use of __Java's annotation processors__, which are usable on any JVM language that supports them, as well as an HTTP Servera and Client built on Netty.
* __To provide a similar programming model to Spring and Grails, these annotation processors precompile the necessary metadata to perform DI, define AOP proxies and configure our application to run in low-memory environment.__
* Many APIs in Micronaut are heavily inspired by Spring and Grails.
* This is by design, and helps bring developers up to speed quickly.