package com.shshetudev.flightmgmtapp.mileage;

import com.shshetudev.flightmgmtapp.airport.flight.Passenger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mileage {
    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    // coherence -> max, coupling -> low
    private Map<Passenger, Integer> mileages = new HashMap<>();
    private Map<Passenger, Integer> points = new HashMap<>();

    // getters

    public Map<Passenger, Integer> getPoints() {
        return Collections.unmodifiableMap(points);
    }

    // Initially these 2 methods will be empty
    public void addMileage(Passenger passenger, int miles) {
        if (mileages.containsKey(passenger)) {
            mileages.put(passenger, mileages.get(passenger) + miles);
        } else {
            mileages.put(passenger, miles);
        }
    }

    public void calculateGivenPoints() {
        for (Passenger passenger : mileages.keySet()) {
            if (passenger.isVip()) {
                points.put(passenger, mileages.get(passenger) / VIP_FACTOR);
            } else {
                points.put(passenger, mileages.get(passenger) / USUAL_FACTOR);
            }
        }
    }
}
