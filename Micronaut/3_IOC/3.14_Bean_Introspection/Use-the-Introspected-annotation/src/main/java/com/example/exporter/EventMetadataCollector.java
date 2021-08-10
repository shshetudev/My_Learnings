package com.example.exporter;

import com.example.annotation.Consumed;
import io.micronaut.context.BeanContext;
import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.qualifiers.Qualifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
public class EventMetadataCollector {

  private static final Logger LOG = LoggerFactory.getLogger(EventMetadataCollector.class);

  private final BeanContext context;

  /**
   * Creates a fully initialized instance of this class.
   *
   * @param context context
   */
  public EventMetadataCollector(BeanContext context) {
    this.context = context;
  }

  /**
   * Converts the Event into EventMetadata.
   *
   * @return EventMetadata
   */
  public Set<EventMetadata> getConsumedEventsMetadata() {
    LOG.info("Getting consumed events metadata");
    return collectConsumedAnnotatedClasses()
      .stream()
      .map(event -> generateMetadata(event, 1.0F)) //todo: Change the hardcoded version
      .collect(Collectors.toSet());
  }

  /**
   * Collecting the Annotated classes having @Consumed Annotation.
   *
   * @return Set of @Consumed annotated classes
   */
  private Set<Class<?>> collectConsumedAnnotatedClasses() {
    LOG.debug("Collecting annotated consumer classes");
    return context.getBeanDefinitions(Qualifiers.byStereotype(Consumed.class))
      .stream()
      .map(BeanDefinition::getBeanType)
      .collect(Collectors.toSet());
  }

  /**
   * Generates EventMetadata from the provided Event.
   *
   * @param event   event
   * @param version version
   * @return new instance of EventMetadata
   */
  private EventMetadata generateMetadata(Class<?> event, Float version) {
    return new EventMetadata(event.getSimpleName(), version, getIntrospectedProperties(event));
  }

  /**
   * Generates properties of an Event Class.
   *
   * @param event event
   * @return {@code Set} of properties
   */
  private Set<String> getIntrospectedProperties(Class<?> event) {
    return Arrays.stream(BeanIntrospection.getIntrospection(event).getPropertyNames()).collect(Collectors.toSet());
  }
}
