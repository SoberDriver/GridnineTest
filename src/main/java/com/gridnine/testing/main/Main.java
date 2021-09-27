package com.gridnine.testing.main;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> defaultListOfFlights = FlightBuilder.createFlights();
        printTheList(defaultListOfFlights);
        printTheList(FlightFilter.departureBeforeTheCurrentTime(defaultListOfFlights));
        printTheList(FlightFilter.arrivalEarlierThanDeparture(defaultListOfFlights));
        printTheList(FlightFilter.moreThanTwoHoursOnTheGround(defaultListOfFlights));


    }
        private static void printTheList(List<Flight> flights)  {

        for (Flight flight : flights) {
            System.out.println(flight);
        }
            System.out.println("\n");

    }
}
