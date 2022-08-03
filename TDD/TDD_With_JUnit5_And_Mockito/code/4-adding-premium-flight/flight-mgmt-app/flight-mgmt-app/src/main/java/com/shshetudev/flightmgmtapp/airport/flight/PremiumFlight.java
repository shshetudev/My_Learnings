package com.shshetudev.flightmgmtapp.airport.flight;

import com.shshetudev.flightmgmtapp.airport.Passenger;
/*
* Steps to follow:
* 1. Creating the new PremiumFlight subclass.
* 2. We will create test methods and expect them to be red.
*   i. And from the failed test case we have a good indication that we should focus only on vip passenger(code isolation).
*   ii. We are driven by the test.
* 3.
*   i. We presume that, we would like not to break the test until we fix the addPassenger and removePassenger methods.
*   ii. We mark the non-working test as disabled, and we go to work. So we add @Disabled on the VipPassenger inner class, the one that is failing.
* */
public class PremiumFlight extends Flight{
    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (!passenger.isVip()) return false;
        return passengers.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return passenger.isVip() && passengers.remove(passenger);
    }
}
