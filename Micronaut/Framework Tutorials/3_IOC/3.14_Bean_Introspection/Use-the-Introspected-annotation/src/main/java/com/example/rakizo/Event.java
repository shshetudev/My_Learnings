package com.example.rakizo;

import com.example.Application;
import io.micronaut.core.annotation.Introspected;
import org.apache.commons.lang3.Validate;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

public class Event {

  private static final float VERSION_1 = 1.0f;
  private static final long serialVersionUID = -7813679737189123760L;

  private String id;
  private String type;
  private String aggregateId;
  private String entityId;
  private String entityType;
  private String trigger;
  private String triggeredBy;
  private Float version;
  private ZonedDateTime generatedAt;

  private Application application;
  private String companyId;
  private String sessionId;

  //--------------------------------------------------------------------------------------------------------------------
  // CONSTRUCTOR
  //--------------------------------------------------------------------------------------------------------------------

  /**
   * Creates a fully initialized instance of this class.
   */
  protected Event() {
  }

  /**
   * Creates a fully initialized instance of this class.
   */
  public Event(Builder builder) {
    id = IdGenerator.uuid();
    type = this.getClass().getSimpleName();
    aggregateId = Validate.notBlank(builder.aggregateId, Constant.Msg.NOT_NULL_OR_EMPTY, "aggregateId");
    entityId = Optional.ofNullable(builder.entityId).orElse(builder.aggregateId);
    entityType = Validate.notBlank(builder.entityType, Constant.Msg.NOT_NULL_OR_EMPTY, "entityType");
    trigger = Validate.notBlank(builder.trigger, Constant.Msg.NOT_NULL_OR_EMPTY, "trigger");
    triggeredBy = builder.triggeredBy;
    version = Optional.ofNullable(version).orElse(VERSION_1);
    generatedAt = builder.generatedAt;
    application = builder.application;
    companyId = builder.companyId;
    sessionId = builder.sessionId;
    generatedAt = Optional.ofNullable(builder.generatedAt).orElse(ZonedDateTime.now(Clock.systemUTC()));
  }

  //--------------------------------------------------------------------------------------------------------------------
  // ACCESSOR METHODS
  //--------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the event identifier associated with this event.
   *
   * @return event identifier
   */
  public String getId() {
    return id;
  }

  /**
   * Returns the aggregate identifier.
   *
   * @return {@code String} aggregate identifier
   */
  public String getAggregateId() {
    return aggregateId;
  }

  /**
   * Returns the entity identifier.
   *
   * @return {@code String} entity identifier, if not found aggregate id
   */
  public String getEntityId() {
    return entityId;
  }

  /**
   * Returns the entity type.
   *
   * @return {@code String} entity type
   */
  public String getEntityType() {
    return entityType;
  }

  /**
   * Returns the trigger reason.
   *
   * @return {@code String } trigger
   */
  public String getTrigger() {
    return trigger;
  }

  /**
   * Represents the event version.
   *
   * @return {@code Float} version, if none provided defaults to 1.0f
   */
  public float getVersion() {
    return version;
  }

  /**
   * Returns the user that triggered the change.
   *
   * @return {@code String} the user that triggered the action
   */
  public String getTriggeredBy() {
    return triggeredBy;
  }

  /**
   * Returns the application object associated with this event.
   *
   * @return application
   */
  public Application getApplication() {
    return application;
  }

  /**
   * Returns the company identifier associated with this event.
   *
   * @return company identifier
   */
  public String getCompanyId() {
    return companyId;
  }

  /**
   * Returns the session identifier associated with this event.
   *
   * @return {@code String} session identifier
   */
  public String getSessionId() {
    return sessionId;
  }

  /**
   * Returns the event type.
   *
   * @return event type
   */
  public final String getType() {
    return type;
  }

  /**
   * Returns the generated at date.
   *
   * @return generated at
   */
  public ZonedDateTime getGeneratedAt() {
    return generatedAt;
  }

  //====================================================================================================================
  // BUILDER
  //====================================================================================================================
  @Introspected
  public static class Builder<T extends Builder> {
    private final String aggregateId;
    private final String entityId;
    private final String entityType;
    private final String trigger;
    private String triggeredBy;
    private ZonedDateTime generatedAt;
    private Application application;
    private String companyId;
    private String sessionId;

    /**
     * Builder constructor.
     *
     * @param aggregateId aggregate identifier
     * @param entityId entity identifier
     * @param entityType entity type
     * @param trigger trigger
     */
    public Builder(String aggregateId, String entityId, String entityType, String trigger) {
      this.aggregateId = aggregateId;
      this.entityId = entityId;
      this.entityType = entityType;
      this.trigger = trigger;
    }

    public Builder(String aggregateId, String entityType, String trigger) {
      this(aggregateId, aggregateId, entityType, trigger);
    }

    public T generatedAt(ZonedDateTime val) {
      generatedAt = val;
      return getInstance();
    }

    public T triggeredBy(String val) {
      triggeredBy = val;
      return getInstance();
    }

    public T application(Application val) {
      application = val;
      return getInstance();
    }

    public T companyId(String val) {
      companyId = val;
      return getInstance();
    }

    public T sessionId(String val) {
      sessionId = val;
      return getInstance();
    }

    public T getInstance() {
      return (T) this;
    }
  }

  //====================================================================================================================
  // UTILITY METHODS
  //====================================================================================================================

  @Override
  public int hashCode() {
    return Objects.hash(aggregateId, getType(), trigger, getEntityId(), getEntityType(), getVersion());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Event)) {
      return false;
    }

    Event that = (Event) obj;
    return that.canEqual(this)
      && Objects.equals(aggregateId, that.aggregateId)
      && Objects.equals(getType(), that.getType())
      && Objects.equals(trigger, that.trigger)
      && Objects.equals(getEntityId(), that.getEntityId())
      && Objects.equals(getEntityType(), that.getEntityType())
      && Objects.equals(getVersion(), that.getVersion());
  }

  /**
   * Reflexive equality check for equals.
   *
   * @param obj the object to verify
   *
   * @return true if the object can possible equal this, false otherwise
   */
  public boolean canEqual(Object obj) {
    return obj instanceof Event;
  }
}

