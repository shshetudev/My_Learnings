package com.shshetudev.flightmgmtapp.mileage;

import com.shshetudev.flightmgmtapp.airport.flight.Flight;
import com.shshetudev.flightmgmtapp.airport.flight.Passenger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MileageTest {
    private Mileage mileage;

    @BeforeAll
    void beforeAll() {
        mileage = new Mileage();
    }

    // Denoting this test as parameterized test
    // Adding @ValueSource to provide data record in CSV format as a string
    // Each record contains in order - flight number,it's type, name of the passenger, vip or not, mileage of the flight
    // todo: Uncomment the @Disabled annotation
    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "1; e; Mike; false; 349",
            "2; b; John; true; 278",
            "3; e; Mike; false; 319",
            "4; p; John; true; 817"})
    void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for (Passenger passenger : flight.getPassengers()) {
            mileage.addMileage(passenger, flight.getDistance());
        }
    }

    // Doing the parameterized test using external csv file
    @ParameterizedTest
    @CsvFileSource(resources = "/flights_information.csv")
    void checkGivenPointsWithCsvInput(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for (Passenger passenger : flight.getPassengers()) {
            mileage.addMileage(passenger, flight.getDistance());
        }
    }

    //todo: fix the execution error
    @AfterAll
    void afterAll() {
        mileage.calculateGivenPoints();
        assertEquals(64, mileage.getPoints().get(new Passenger("Mike", false)).intValue());
        assertEquals(207, mileage.getPoints().get(new Passenger("John", true)).intValue());
        System.out.println(mileage.getPoints());
    }
}
