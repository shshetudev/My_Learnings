package com.shshetudev.flightmgmtapp.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Test
    void testFlight() {
        Flight economy = new Flight("1", "Economy");
        Flight business = new Flight("2", "Business");

        Passenger john = new Passenger("John", true);
        Passenger mike = new Passenger("Mike", false);
        // vip
        assertTrue(economy.addPassenger(john));
        assertFalse(economy.removePassenger(john));

        assertTrue(business.addPassenger(john));
        assertFalse(business.removePassenger(john));

        //non-vip
        assertTrue(economy.addPassenger(mike));
        assertTrue(economy.removePassenger(mike));

        assertFalse(business.addPassenger(mike));
        assertFalse(business.removePassenger(mike));
    }
}
