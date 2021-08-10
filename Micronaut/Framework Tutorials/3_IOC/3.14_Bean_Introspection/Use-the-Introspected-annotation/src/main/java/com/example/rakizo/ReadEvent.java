package com.example.rakizo;

import com.example.annotation.Consumed;
import io.micronaut.core.annotation.Introspected;

import java.time.LocalDate;
import java.util.Locale;

@Introspected
@Consumed
public class ReadEvent {
  private Foo foo;
  private String field1;
  private Integer intObject;
  private boolean boolField;
  private int intField;
  private char charField;
  private Boolean boolObject;
  private LocalDate date;
  private Locale locale;

  protected ReadEvent() {
  }

  /**
   * Creates a fully initialized instance of this class.
   *
   * @param builder builder
   */
  public ReadEvent(Builder builder) {
    this.field1 = "field1";
    this.intObject = 1000;
    this.boolField = true;
    this.intField = 222;
    this.charField = 'a';
    this.boolObject = true;
    this.date = LocalDate.now();
    this.locale = Locale.US;
  }
  public static class Builder extends Event.Builder<ReadEvent.Builder> {
    public Builder(String aggregateId, String entityId, String trigger) {
      super(aggregateId, entityId, trigger);
    }

    public ReadEvent build() {
      return new ReadEvent(this);
    }
  }

  public String getField1() {
    return field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }

  public Integer getIntObject() {
    return intObject;
  }

  public void setIntObject(Integer intObject) {
    this.intObject = intObject;
  }

  public boolean isBoolField() {
    return boolField;
  }

  public void setBoolField(boolean boolField) {
    this.boolField = boolField;
  }

  public int getIntField() {
    return intField;
  }

  public void setIntField(int intField) {
    this.intField = intField;
  }

  public char getCharField() {
    return charField;
  }

  public void setCharField(char charField) {
    this.charField = charField;
  }

  public Boolean getBoolObject() {
    return boolObject;
  }

  public void setBoolObject(Boolean boolObject) {
    this.boolObject = boolObject;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }
}
