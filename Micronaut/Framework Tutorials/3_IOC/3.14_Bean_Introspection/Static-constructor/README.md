### Static Creator Methods
* The `@Creator` annotation can be applied to static methods that create class instances.
* The `@Creator` annotation is applied to the static method which instantiates the class.
* There can be multiple "creator" methods annotated.
    * __If there is one without arguments, it will be the default construction method.__
    * __The first method with arguments will be used as the primary construction method.__
* `@Immutable:`
    * The class to which this annotation is applied is immutable. This means that its state cannot be seen to change by callers. Of necessity this means that all public fields are final, and that all public final reference fields refer to other immutable objects, and that methods do not publish references to any internal state which is mutable by implementation even if not by design
    * Immutable objects are inherently thread-safe; they may be passed between threads or published without synchronization.
* __We can apply Bean introspection on Business class(Which does not have @Introspected anntation) using BusinessConfiguration class.__  
* __BusinessConfiguration introspection:__
  * The `BusinessConfiguration` class generates introspections from `Business` class.
  * We can also use the `packages` member of the `@Introspected` which package scans at compile time and generates introspections for all classes withing a package.
  * This feature is currently regarded as experimental.