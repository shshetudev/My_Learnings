package com.shshetudev.flightmgmtapp.airport;

import com.shshetudev.flightmgmtapp.airport.flight.BusinessFlight;
import com.shshetudev.flightmgmtapp.airport.flight.EconomyFlight;
import com.shshetudev.flightmgmtapp.airport.flight.Flight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    // General test method
    @Test
    void testFlight() {
        Flight economy = new EconomyFlight("1");
        Flight business = new BusinessFlight("2");

        Passenger john = new Passenger("John", true);
        Passenger mike = new Passenger("Mike", false);

        // Testing vip passenger: john
        assertTrue(economy.addPassenger(john));
        assertFalse(economy.removePassenger(john));
        assertTrue(business.addPassenger(john));
        assertFalse(business.removePassenger(john));

        // Testing usual passenger: mike
        assertTrue(economy.addPassenger(mike));
        assertTrue(economy.removePassenger(mike));
        assertFalse(business.addPassenger(mike));
        assertFalse(business.removePassenger(mike));
    }

   /*
   * We have 4 scenarios here:
   *
   * For Economy flight:
   * -------------------
   * 1. A usual passenger can try to book for economy flight
   * 2. A vip passenger can try to book for economy flight
   *
   * For Business flight:
    * -------------------
    * 1. A usual passenger can try to book for business flight
    * 2. A vip passenger can try to book for business flight
   * */

    // todo: Uncomment to watch
    // Separating the test methods
    @Test
    void testEconomyFlightUsualPassenger() {
        Flight economy = new EconomyFlight("1");
        Passenger mike = new Passenger("Mike", false);
        // add
        assertEquals("1", economy.getId());
        assertTrue(economy.addPassenger(mike));

        // verify
        assertEquals(1, economy.getPassengers().size());
        assertEquals("Mike", economy.getPassengers().get(0).getName());

        // remove
        assertTrue(economy.removePassenger(mike));
        assertEquals(0, economy.getPassengers().size());
    }

    @Test
    void testEconomyFlightVipPassenger() {
        Flight economy = new EconomyFlight("1");
        Passenger john =     new Passenger("John", true);
        // add
        assertEquals("1", economy.getId());
        assertTrue(economy.addPassenger(john));

        // verify
        assertEquals(1, economy.getPassengers().size());
        assertEquals("John", economy.getPassengers().get(0).getName());

        // remove
        assertFalse(economy.removePassenger(john));
        assertEquals(1, economy.getPassengers().size());
    }

    @Test
    void testBusinessFlightUsualPassenger() {
        Flight business = new BusinessFlight("2");
        Passenger mike = new Passenger("Mike", false);
        // add
        assertEquals("2", business.getId());
        assertFalse(business.addPassenger(mike));

        // get
        assertEquals(0, business.getPassengers().size());

        // remove
        assertFalse(business.removePassenger(mike));
        assertEquals(0, business.getPassengers().size());
    }

    @Test
    void testBusinessFlightVipPassenger() {
        Flight business = new BusinessFlight("2");
        Passenger john = new Passenger("John", true);
        // add
        assertEquals("2", business.getId());
        assertTrue(business.addPassenger(john));

        // get
        assertEquals(1, business.getPassengers().size());
        assertEquals("John", business.getPassengers().get(0).getName());

        // remove
        assertFalse(business.removePassenger(john));
        assertEquals(1, business.getPassengers().size());
    }
}
