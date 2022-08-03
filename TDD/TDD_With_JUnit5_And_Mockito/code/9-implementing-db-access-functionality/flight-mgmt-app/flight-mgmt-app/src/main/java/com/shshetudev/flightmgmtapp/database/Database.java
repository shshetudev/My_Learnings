package com.shshetudev.flightmgmtapp.database;

import com.shshetudev.flightmgmtapp.airport.flight.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Map<String, String> registeredUsers = new HashMap<>();
    List<List<String>> queriedData = new ArrayList<>();

    public boolean login(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        return registeredUsers.containsKey(username) &&
                registeredUsers.get(username).equals(password);
    }

    public List<List<String>> queryFlightsDatabase() {
        return queriedData;
    }
    // Initially these three methods will be empty
    public double averageDistance(List<Flight> flights) {
        return flights.stream()
                .mapToDouble(Flight::getDistance)
                .average()
                .getAsDouble();
    }
    public int minimumDistance(List<Flight> flights) {
        return flights.stream()
                .mapToInt(Flight::getDistance)
                .min()
                .getAsInt();
    }

    public int maximumDistance(List<Flight> flights) {
        return flights.stream()
                .mapToInt(Flight::getDistance)
                .max()
                .getAsInt();
    }
}
