package com.shetu.injection_point;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Cylinders {
  int value() default 8;
}
