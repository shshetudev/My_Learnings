package com.shshetudev;

import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.annotation.AnnotationValueBuilder;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.inject.annotation.NamedAnnotationMapper;
import io.micronaut.inject.visitor.VisitorContext;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

public class EntityIntrospectedAnnotationMapper implements NamedAnnotationMapper {
  @NonNull
  @Override
  public String getName() {
    return "javax.presistence.Entity";
  }

  @Override
  public List<AnnotationValue<?>> map(AnnotationValue<Annotation> annotation, VisitorContext visitorContext) {
    final AnnotationValueBuilder<Introspected> builder = AnnotationValue
      // don't bother with transient properties
      .builder(Introspected.class).member("excludedAnnotations", "javax.persistence.Transient");
    return Collections.singletonList(builder.build());
  }
}
