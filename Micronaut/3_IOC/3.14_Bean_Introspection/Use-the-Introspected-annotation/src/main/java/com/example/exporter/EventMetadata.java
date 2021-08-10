package com.example.exporter;

import java.util.Set;

public class EventMetadata {

  private String type;
  private float version;
  private Set<String> fields;

  /**
   * Constructor for EventMetadata.
   *
   * @param type    type
   * @param version version
   * @param fields  fields
   */
  public EventMetadata(String type, float version, Set<String> fields) {
    this.type = type;
    this.version = version;
    this.fields = fields;
  }

  /**
   * Returns the event type.
   *
   * @return {@code String} of event type.
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the event version.
   *
   * @return {@code String} of event version.
   */
  public float getVersion() {
    return version;
  }

  /**
   * Returns the event properties.
   *
   * @return {@code Set} of event properties.
   */
  public Set<String> getFields() {
    return fields;
  }
}
