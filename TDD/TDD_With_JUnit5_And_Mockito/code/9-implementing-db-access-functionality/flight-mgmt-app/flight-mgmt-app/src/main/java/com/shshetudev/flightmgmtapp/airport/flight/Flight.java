package com.shshetudev.flightmgmtapp.airport.flight;

import java.util.*;

public abstract class Flight {
    private String id;
    private int distance;
    Set<Passenger> passengers = new HashSet<>();
    // protected -> same class, same package, outside the package only by subclass.
    // default -> same class, same package.
    protected Flight(String id) {
        this.id = id;
    }

    public abstract boolean addPassenger(Passenger passenger);
    public abstract boolean removePassenger(Passenger passenger);

    public String getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Set<Passenger> getPassengers() {
        return Collections.unmodifiableSet(passengers);
    }
}
