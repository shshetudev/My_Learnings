package com.shshetudev.flightmgmtapp.airport;

import com.shshetudev.flightmgmtapp.airport.flight.BusinessFlight;
import com.shshetudev.flightmgmtapp.airport.flight.EconomyFlight;
import com.shshetudev.flightmgmtapp.airport.flight.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    // todo: Grouping test classes based on context
    // inner economy flight class
    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {
        private Flight economy;
        private Passenger mike;
        Passenger john;

        @BeforeEach
        void setup() {
            economy = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Test
        void testEconomyFlightUsualPassenger() {
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
    }

    // inner business flight class
    @DisplayName("Given there is an business flight")
    @Nested
    class BusinessFlightTest {
        private Flight business;
        private Passenger john;
        private Passenger mike;

        @BeforeEach
        void setup() {
            business = new BusinessFlight("2");
            john = new Passenger("John", true);
            mike = new Passenger("Mike", false);
        }

        @Test
        void testBusinessFlightUsualPassenger() {
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
}

