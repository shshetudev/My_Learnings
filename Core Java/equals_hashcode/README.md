### Why to use `equals()` and `hashCode()`?
* These two methods make object comparisons efficient and easy in our Java programs.
* We simply put these methods work together to verify if two objects have the same values.
* __Without `equals()` and `hashCode()` we would have to create very large `if` comparisons, comparing every field from ona object.__
* __This would make code really confusing and hard to read.__
* Together, these two methods help use create more __flexible__ and __cohesive__ code.

### Overriding equals() and hashCode() in Java
* __Method overriding__ is a technique where the __behavior of the parent class or interface is written again (overriden)__ in the subclass in order to take advantage of `Polymorphism`.
* Every `Object` in Java includes an `equals()` and a `hashCode()` method, but they must be overriden to work properly.
* To understand how overriding works with `equals()` and `hashCode()`, we can study their implementation in the core Java classes.
* Below is the `equals()` method in the `Object` class. 
 >`public boolean equals(Object obj) {`<br/>
 >`return (this == obj);`<br/>
 > `}`
* __The method is checking whether the current instance is the same as the previously passed `Object`.__
* __When the hashCode() method is not overridden, the default method in the `Object` class will be invoked.__
* __This is a native method, which means it will be executed in another language like `C`, ane will return some code regarding the object's memory address.__
 >`@HotSpotIntrinsicCandidate`<br/>
 > `public native int hashCode();`
* __When the `equals()` and `hashCode()` methods are not overridden, we would see the above methods invoked instead.__
* In this case, the methods are not fulfilling the real purpose of `equals()` and `hashCode()`, which is to check whether two or more objects have the same values.
* __As a rule, when we override equals(), we must also override hashcode().__

### Comparing objects with equals()
* We use the `equals()` method to compare objects in Java.
* In order to determine if two objects are the same, `equals()` compares the values of the objects' attributes.
* Please see the illustration: [EqualsAndHashCodeExample](src/EqualsAndHashCodeExample.java)
 * In the first comparison, `equals()` compares the current object instance with the object that has been passed. 
   If the two objects have the same values, `equals()` will return `true`.
 * In the second comparison `equals()` checks to see whether the passed object is `null`, or if it's typed as a different class.
   If it's a different class then the objects are not equal.
 * Finally `equals()` compares the object's fields. If two objects have the same field values, then the objects are the same.

### Uniquely Identifying objects with hashCode()
* We use the `hashCode()` method to optimize performance when comparing objects.
* Executing `hashCode()` returns a unique ID for each object in our program, which makes the task of comparing the whole state of the object much 
easier.
* If an object's hashcode is not the same as another object's hashcode, there is no reason to execute the `equals()` method.
* We just know the two objects are not the same.
* __On the other hand, if the hashcode is the same, then we must execute the `equals()` method to determine whether the values and fields are same__.
* Please see the illustcration: [HashCodeConcept](src/HashCodeConcept.java)
* In the above illustration:
    * A `hashCode()` that always returns the same value is valid but not very effective.
    * In this case the comparison will always return `true`, so the `equals` method will always be executed.
    * There is no performance improvement in this case.
    