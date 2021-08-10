package com.shetu.injection_point;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.inject.InjectionPoint;

@Factory
public class EngineFactory {
  @Prototype
  Engine v8Engine(InjectionPoint<?> injectionPoint, CrankShaft crankShaft) {
    final int cylinders = injectionPoint.getAnnotationMetadata().intValue(Cylinders.class).orElse(8);
    switch (cylinders) {
      case 6:
        return new V6Engine(crankShaft);
      case 8:
        return new V8Engine(crankShaft);
      default:
        throw new IllegalArgumentException("Unsupported number of cylinders specified: " + cylinders);
    }
  }
}
