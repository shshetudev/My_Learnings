package com.shshetudev.flightmgmtapp.airport.flight;

public class EconomyFlight extends Flight{
    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengers.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return !passenger.isVip() && passengers.remove(passenger);
    }
}
