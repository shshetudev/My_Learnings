package com.shshetudev.flightmgmtapp.airport.flight;

import com.shshetudev.flightmgmtapp.airport.Passenger;

public class BusinessFlight extends Flight {
    public BusinessFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (!passenger.isVip()) return false;
        return passengers.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}
