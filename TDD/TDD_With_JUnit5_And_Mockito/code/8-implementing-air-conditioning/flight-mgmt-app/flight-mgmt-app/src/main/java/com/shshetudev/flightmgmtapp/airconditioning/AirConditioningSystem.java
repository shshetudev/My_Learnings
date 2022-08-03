package com.shshetudev.flightmgmtapp.airconditioning;

import org.junit.jupiter.api.extension.ExtendWith;

public class AirConditioningSystem {
    private Thermometer thermometer;
    private double temperatureThreshold;
    private boolean open;

    public AirConditioningSystem() {
        open = false;
    }

    // Initially it was empty
    public void checkAirConditioningSystem() {
        this.open = thermometer.getTemperature() >= temperatureThreshold;
    }

    public boolean isOpen() {
        return open;
    }

    public void setThermometer(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public void setTemperatureThreshold(double temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
    }
}
