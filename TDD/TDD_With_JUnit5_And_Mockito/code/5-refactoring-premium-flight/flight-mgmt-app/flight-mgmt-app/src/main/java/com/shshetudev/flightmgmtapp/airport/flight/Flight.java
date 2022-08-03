package com.shshetudev.flightmgmtapp.airport.flight;

import com.shshetudev.flightmgmtapp.airport.Passenger;

import java.util.ArrayList;
import java.util.List;

public abstract class Flight {
    private String id;
    List<Passenger> passengers = new ArrayList<>();
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

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
