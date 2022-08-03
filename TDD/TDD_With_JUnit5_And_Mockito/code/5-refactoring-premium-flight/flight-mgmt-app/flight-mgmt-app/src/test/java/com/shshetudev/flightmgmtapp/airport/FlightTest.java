package com.shshetudev.flightmgmtapp.airport;

import com.shshetudev.flightmgmtapp.airport.flight.BusinessFlight;
import com.shshetudev.flightmgmtapp.airport.flight.EconomyFlight;
import com.shshetudev.flightmgmtapp.airport.flight.Flight;
import com.shshetudev.flightmgmtapp.airport.flight.PremiumFlight;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    // todo: Grouping test classes based on context

    // Inner Economy flight class
    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {
        private Flight economy;
        private Passenger john;
        private Passenger mike;

        @BeforeEach
        void setup() {
            economy = new EconomyFlight("1");
            john = new Passenger("John", true);
            mike = new Passenger("Mike", false);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then we can add and remove him from an economy flight")
            void testEconomyFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and an economy flight",
                        // add
                        () -> assertEquals("1", economy.getId()),
                        () -> assertTrue(economy.addPassenger(mike)),
                        // verify
                        () -> assertEquals(1, economy.getPassengers().size()),
                        () -> assertEquals("Mike", economy.getPassengers().get(0).getName()),
                        // remove
                        () -> assertTrue(economy.removePassenger(mike)),
                        () -> assertEquals(0, economy.getPassengers().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then we can add and remove him from an economy flight")
            void testEconomyFlightVipPassenger() {
                assertAll(
                        "Verify all conditions for a vip passenger and an economy flight",
                        // add
                        () -> assertEquals("1", economy.getId()),
                        () -> assertTrue(economy.addPassenger(john)),
                        // verify
                        () -> assertEquals(1, economy.getPassengers().size()),
                        () -> assertEquals("John", economy.getPassengers().get(0).getName()),
                        // remove
                        () -> assertFalse(economy.removePassenger(john)),
                        () -> assertEquals(1, economy.getPassengers().size())
                );
            }
        }
    }

    // Inner Business flight class
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

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then we can add and remove him from an business flight")
            void testBusinessFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a business flight",
                        // add
                        () -> assertEquals("2", business.getId()),
                        () -> assertFalse(business.addPassenger(mike)),

                        // get
                        () -> assertEquals(0, business.getPassengers().size()),

                        // remove
                        () -> assertFalse(business.removePassenger(mike)),
                        () -> assertEquals(0, business.getPassengers().size())
                );

            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then we can add and remove him from an economy flight")
            void testBusinessFlightVipPassenger() {
                assertAll("Verify all conditions for a vip passenger and a business flight",
                        // add
                        () -> assertEquals("2", business.getId()),
                        () -> assertTrue(business.addPassenger(john)),

                        // get
                        () -> assertEquals(1, business.getPassengers().size()),
                        () -> assertEquals("John", business.getPassengers().get(0).getName()),

                        // remove
                        () -> assertFalse(business.removePassenger(john)),
                        () -> assertEquals(1, business.getPassengers().size())
                );

            }
        }
    }

    // Inner Business flight class
    @DisplayName("Given there is a premium flight")
    @Nested
    class PremiumFlightTest {
        private Flight premium;
        private Passenger john;
        private Passenger mike;

        @BeforeEach
        void setup() {
            premium = new PremiumFlight("3");
            john = new Passenger("John", true);
            mike = new Passenger("Mike", false);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then we can not add or remove him from a premium flight")
            void testPremiumFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a premium flight",
                        // add
                        () -> assertEquals("3", premium.getId()),
                        () -> assertFalse(premium.addPassenger(mike)),

                        // get
                        () -> assertEquals(0, premium.getPassengers().size()),

                        // remove
                        () -> assertFalse(premium.removePassenger(mike)),
                        () -> assertEquals(0, premium.getPassengers().size())
                );

            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            // todo: Uncomment @Disabled after failing the tests
            // @Disabled
            @DisplayName("Then we can add and remove him from a premium flight")
            void testPremiumFlightVipPassenger() {
                assertAll("Verify all conditions for a vip passenger and a premium flight",
                        // add
                        () -> assertEquals("3", premium.getId()),
                        () -> assertTrue(premium.addPassenger(john)),

                        // get
                        () -> assertEquals(1, premium.getPassengers().size()),
                        () -> assertEquals("John", premium.getPassengers().get(0).getName()),

                        // remove
                        () -> assertTrue(premium.removePassenger(john)),
                        () -> assertEquals(0, premium.getPassengers().size())
                );

            }
        }
    }
}

