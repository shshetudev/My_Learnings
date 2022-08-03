package com.shshetudev.flightmgmtapp.airport;

import com.shshetudev.flightmgmtapp.airport.flight.BusinessFlight;
import com.shshetudev.flightmgmtapp.airport.flight.EconomyFlight;
import com.shshetudev.flightmgmtapp.airport.flight.Flight;
import com.shshetudev.flightmgmtapp.airport.flight.PremiumFlight;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// We will try to add the same passenger 5 times to an economy flight
/*
 * Steps:
 * 1. Add the test case and run.
 * 2. It fails and mark as @Disabled.
 * 3. Fix the relevant code(Flight.java), run once again and make it green.
 *   i. Replacing List with Set data structure.
 *   ii. Changing the related test cases.
 * 4. After fixing economy flight we will do the same for business flight and premium flight.
 *
 * */
class FlightTest {

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
                        // applicable code for List data structure
                        // () -> assertEquals("Mike", economy.getPassengers().get(0).getName()),
                        // applicable code for Set data structure
                        () -> assertTrue(economy.getPassengers().contains(mike)),
                        // remove
                        () -> assertTrue(economy.removePassenger(mike)),
                        () -> assertEquals(0, economy.getPassengers().size())
                );
            }


            @DisplayName("Then we can not add him to an economy flight more than once")
            @RepeatedTest(5)
                // @Disabled
            void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economy.addPassenger(mike);
                }
                assertAll("Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economy.getPassengers().size()),
                        () -> assertTrue(economy.getPassengers().contains(mike)),
                        // applicable code for List data structure
                        // () -> assertEquals("Mike", economy.getPassengers().get(0).getName())
                        // applicable code for Set data structure
                        () -> assertTrue(economy.getPassengers().contains(mike))
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then we can add but can not remove him from an economy flight")
            void testEconomyFlightVipPassenger() {
                assertAll(
                        "Verify all conditions for a vip passenger and an economy flight",
                        // add
                        () -> assertEquals("1", economy.getId()),
                        () -> assertTrue(economy.addPassenger(john)),
                        // verify
                        () -> assertEquals(1, economy.getPassengers().size()),
                        // applicable code for List data structure
                        //  () -> assertEquals("John", economy.getPassengers().get(0).getName()),
                        // applicable code for Set data structure
                        () -> assertTrue(economy.getPassengers().contains(john)),
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
                        // applicable code for List data structure
                        // () -> assertEquals("John", business.getPassengers().get(0).getName()),
                        // applicable code for Set data structure
                        () -> assertTrue(business.getPassengers().contains(john)),

                        // remove
                        () -> assertFalse(business.removePassenger(john)),
                        () -> assertEquals(1, business.getPassengers().size())
                );

            }

            @DisplayName("Then we can not add him to a business flight more than once")
            @RepeatedTest(5)
            void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    business.addPassenger(john);
                }
                assertAll("Verify a VIP passenger can be added to a business flight only once",
                        () -> assertEquals(1, business.getPassengers().size()),
                        () -> assertTrue(business.getPassengers().contains(john)),
                        () -> assertEquals("John", new ArrayList<>(business.getPassengers()).get(0).getName())
                );
            }
        }
    }

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
            @DisplayName("Then we can add and remove him from a premium flight")
            void testPremiumFlightVipPassenger() {
                assertAll("Verify all conditions for a vip passenger and a premium flight",
                        // add
                        () -> assertEquals("3", premium.getId()),
                        () -> assertTrue(premium.addPassenger(john)),

                        // get
                        () -> assertEquals(1, premium.getPassengers().size()),
                        // applicable code for List data structure
                        // () -> assertEquals("John", premium.getPassengers().get(0).getName()),
                        // applicable code for Set data structure
                        () -> assertTrue(premium.getPassengers().contains(john)),

                        // remove
                        () -> assertTrue(premium.removePassenger(john)),
                        () -> assertEquals(0, premium.getPassengers().size())
                );

            }
        }

        @DisplayName("Then we can not add him to a premium flight more than once")
        @RepeatedTest(5)
        void testPremiumFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
            for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                premium.addPassenger(john);
            }
            assertAll("Verify a VIP passenger can be added to a premium flight only once",
                    () -> assertEquals(1, premium.getPassengers().size()),
                    () -> assertTrue(premium.getPassengers().contains(john)),
                    () -> assertEquals("John", new ArrayList<>(premium.getPassengers()).get(0).getName())
            );
        }
    }
}

