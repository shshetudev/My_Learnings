package com.shshetudev.flightmgmtapp.airport;


import com.shshetudev.flightmgmtapp.configuration.Generated;

//todo: Remove it after testing
@Generated
public class Airport {
    public static void main(String[] args) {
        Flight economy = new Flight("1", "Economy");
        Flight business = new Flight("2", "Business");

        Passenger john = new Passenger("John", true);
        Passenger mike = new Passenger("Mike", false);

        business.addPassenger(john);
        business.removePassenger(john);
        business.addPassenger(mike);
        economy.addPassenger(mike);

        System.out.println("Business flight passengers list:");
        for (Passenger passenger : business.getPassengers()) {
            System.out.println(passenger.getName());
        }

        System.out.println("Economy flight passengers list:");
        for (Passenger passenger : economy.getPassengers()) {
            System.out.println(passenger.getName());
        }
    }
}
