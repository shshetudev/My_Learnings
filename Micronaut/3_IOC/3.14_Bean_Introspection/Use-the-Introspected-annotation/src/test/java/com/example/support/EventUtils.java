package com.example.support;

import com.example.annotation.Consumed;
import com.example.exporter.EventMetadata;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.BeanContext;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.qualifiers.Qualifiers;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EventUtils {


  /**
   * Creates event meta data.
   *
   * @param numberOfEvents number of events
   * @return {@code} Set of event metadata
   */
  public static Set<EventMetadata> getGeneratedEventsMetadata(int numberOfEvents) {
    Set<EventMetadata> events = new HashSet<>();
    for (int i = 1; i <= numberOfEvents; i++) {
      events.add(createAndGetEventMetadata(i));
    }
    return events;
  }

  private static EventMetadata createAndGetEventMetadata(int version) {
    return new EventMetadata("Event" + version, (float) version, getIntrospectedFields());
  }

  private static Set<String> getIntrospectedFields() {
    Set<String> fields = new HashSet<>();
    fields.add("id");
    fields.add("aggregateId");
    fields.add("entityId");
    fields.add("entityType");
    fields.add("trigger");
    fields.add("triggeredBy");
    fields.add("generatedAt");
    fields.add("companyId");
    fields.add("sessionId");
    fields.add("application");
    return fields;
  }

  /**
   * Collects the @Consumed annotated classes.
   *
   * @param beanContext beanContext
   * @return returns {@code} Set of collected Annotated classes
   */
  public static Set<Class<?>> collectConsumedAnnotatedClasses(BeanContext beanContext) {
    return beanContext.getBeanDefinitions(Qualifiers.byStereotype(Consumed.class))
      .stream()
      .map(BeanDefinition::getBeanType)
      .collect(Collectors.toSet());
  }
}
