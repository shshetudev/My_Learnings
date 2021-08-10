### Constructor methods
* For classes with multiple constructors, we can apply the `@Creator` annotation to the constructor to use.
* The `@Constructor' annotation denotes which constructor to use.
* Our considered `Vehicle` class has no default constructor, so if we call to instantiate without arguments, will throw an `InstantiationException`.