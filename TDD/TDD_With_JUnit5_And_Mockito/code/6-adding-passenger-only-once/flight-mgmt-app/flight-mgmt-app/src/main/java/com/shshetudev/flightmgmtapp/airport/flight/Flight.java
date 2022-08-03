package com.shshetudev.flightmgmtapp.airport.flight;

import com.shshetudev.flightmgmtapp.airport.Passenger;

import java.util.*;

public abstract class Flight {
    private String id;
    // Changing from List to Set to add unique passengers only
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

    public Set<Passenger> getPassengers() {
        return Collections.unmodifiableSet(passengers);
    }
}
