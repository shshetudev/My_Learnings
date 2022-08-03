package com.shshetudev.flightmgmtapp.airconditioning;

public class Thermometer {
    private double temperature;
    private Sensor sensor;

    // initially it is not implemented and return temperature only.
    public double getTemperature() {
        if(sensor.isBlocked()) {
            throw new RuntimeException("Sensor is blocked");
        }
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
