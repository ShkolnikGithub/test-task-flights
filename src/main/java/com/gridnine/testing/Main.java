package com.gridnine.testing;

import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.filter.flight.ArrivalBeforeDeparture;
import com.gridnine.testing.filter.flight.DepartureBeforeCurrentTime;
import com.gridnine.testing.filter.flight.FlightFilter;
import com.gridnine.testing.filter.flight.MoreThanTwoHoursOnGround;
import com.gridnine.testing.model.Flight;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> testSet = FlightBuilder.createFlights();

        System.out.println("All flights from test list without filters: ");
        testSet.forEach(System.out::println);

        System.out.println("\nAfter DepartureBeforeCurrentTime filter: ");
        FlightFilter departureBeforeCurrentTime = new DepartureBeforeCurrentTime();
        departureBeforeCurrentTime.filter(testSet).forEach(System.out::println);

        System.out.println("\nAfter ArrivalBeforeDeparture filter: ");
        FlightFilter arrivalBeforeDeparture = new ArrivalBeforeDeparture();
        arrivalBeforeDeparture.filter(testSet).forEach(System.out::println);

        System.out.println("\nAfter MoreThanTwoHoursOnEarth filter: ");
        FlightFilter moreThanTwoHoursOnEarth = new MoreThanTwoHoursOnGround();
        moreThanTwoHoursOnEarth.filter(testSet).forEach(System.out::println);


        //implement multiple filters on a single list
        System.out.println("\nAll filters together: ");
        FlightFilter flightFilter = new FlightFilter();
        flightFilter.dynamicFilter(Arrays.asList(
                departureBeforeCurrentTime,
                arrivalBeforeDeparture,
                moreThanTwoHoursOnEarth),
                testSet)
                .forEach(System.out::println);
    }
}
