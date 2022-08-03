package com.shshetudev.flightmgmtapp.airport;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String id;
    private List<Passenger> passengers = new ArrayList<>();
    private String flightType;

    public Flight(String id , String flightType) {
        this.id = id;
        this.flightType = flightType;
    }

    public String getId() {
        return id;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public String getFlightType() {
        return flightType;
    }

    // SOLID ->
    // 1. SRP: Single responsibility principle
    // 2. OCP: Open closed principle
    // 3. LSP: Liskov's substitution principle
    // 4. ISP: Interface segregation principle
    // 5. DIP: Dependency Inversion principle

    public boolean addPassenger(Passenger passenger) {
        switch (flightType) {
            case "Economy":
                return passengers.add(passenger);
            case "Business":
                if(passenger.isVip()) {
                    return passengers.add(passenger);
                }
            return false;
            default:
                throw new RuntimeException("Unknown type: " + flightType);
        }
    }

    public boolean removePassenger(Passenger passenger) {
        switch (flightType) {
            case "Economy":
                // Wrong logic: Missing !
                if (!passenger.isVip()) { // Testing once again after adding !
                    return passengers.remove(passenger);
                }
                return false;
            case "Business":
                return false;
            default:
                throw new RuntimeException("Unknown type: " + flightType);
        }
    }
}
