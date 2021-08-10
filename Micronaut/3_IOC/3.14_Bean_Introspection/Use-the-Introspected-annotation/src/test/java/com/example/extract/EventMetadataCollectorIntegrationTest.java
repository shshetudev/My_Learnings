package com.example.extract;

import com.example.exporter.EventMetadata;
import com.example.exporter.EventMetadataCollector;
import com.example.support.EventUtils;
import io.micronaut.context.BeanContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@MicronautTest
public class EventMetadataCollectorIntegrationTest {

  @Inject
  private EventMetadataCollector collector;

  @Inject
  private BeanContext context;
  private Set<EventMetadata> metadata;

  @BeforeEach
  void setup() {
    metadata = collector.getConsumedEventsMetadata();
  }

  @Test
  void getAllConsumedEventsMetadata() {
    Set<Class<?>> classes = EventUtils.collectConsumedAnnotatedClasses(context);
    assertThat(classes.size()).isEqualTo(metadata.size());
    metadata.forEach(
      data -> {
        assertThat(data).isNotNull();
        assertThat(data.getType()).isNotNull();
        assertThat(data.getFields()).isNotNull();
        assertThat(data.getVersion()).isGreaterThan(0.0F);
        assertThat(classes.stream().anyMatch(clazz -> clazz.getSimpleName().equals(data.getType()))).isTrue();
      }
    );
  }
}
