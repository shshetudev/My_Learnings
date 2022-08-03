package com.shshetudev.flightmgmtapp.mileage;

import com.shshetudev.flightmgmtapp.airport.flight.*;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightArgumentConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        assertEquals(String.class, source.getClass(), "Can only convert from String");
        assertEquals(Flight.class, targetType, "Can only convert to Flight");

        String[] flightStr = source.toString().split(";");
        Flight flight = null;

        switch (flightStr[1].toLowerCase().trim()) {
            case "b":
                flight = new BusinessFlight(flightStr[0]);
                break;
            case "p":
                flight = new PremiumFlight(flightStr[0]);
                break;
            case "e":
                flight = new EconomyFlight(flightStr[0]);
                break;
        }

        flight.addPassenger(new Passenger(flightStr[2].trim(), Boolean.valueOf(flightStr[3].trim())));
        flight.setDistance(Integer.valueOf(flightStr[4].trim()));
        return flight;
    }
}
