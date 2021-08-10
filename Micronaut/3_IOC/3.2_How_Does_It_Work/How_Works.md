#### How Does it work?
* Micronuat performs dependency injection without requiring reflection.
* __The key is a set of AST transformations (for Groovy) and annotation processors (for Java) that generated classes that implements the `BeanDefinition` interface.__
* Micronaut uses the `ASM bytecode library` to generate classes, and becuase __Micronuat knows ahead of time the injection points, there is no need to scan all of the methods, fields, constructors, etc. at rutime like other frameworks such as Spring do.__
* Also since __reflection is not used when constructing the bean, the JVM can inline and optimize the code far better, resulting in better runtime performance and reduced memory consumption.__
* This is particulary important for non-singleton scopes where application performance depends on bean creation performance.
* In addition, __with Micronaut our application startup time and memory consumption are not affected by the size of our codebase in the same way as with a framework that uses reflection.__
* __Reflection based IoC frameworks load and cache reflection datga for every single field, method, and constructor in our code.__
* Thus as our code grows in size so do our memory requirements, whilst with Micronaut this is not the case. 