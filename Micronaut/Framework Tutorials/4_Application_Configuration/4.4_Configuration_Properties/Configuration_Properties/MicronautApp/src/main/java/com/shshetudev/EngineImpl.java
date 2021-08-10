package com.shshetudev;

import javax.inject.Singleton;

@Singleton
public class EngineImpl implements Engine {
  private final EngineConfig config;

  public EngineImpl(EngineConfig config) {
    this.config = config;
  }

  @Override
  public int getCylinders() {
    return config.getCylinders();
  }

  @Override
  public String start() {
    return getConfig().getManufacturer()
    + " Engine Starting V" + getConfig().getCylinders()
    + " [rodLength=" + getConfig().getCrankShaft().getRodLength().orElse(6d) + "]";
  }

  public final EngineConfig getConfig() {
    return config;
  }
}
