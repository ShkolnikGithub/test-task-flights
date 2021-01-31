package com.gridnine.testing;

import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.filter.Filter;
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
        Filter<Flight> filter = new FlightFilter();

        System.out.println("All flights from test list without filters: ");
        testSet.forEach(System.out::println);

        System.out.println("\nAfter DepartureBeforeCurrentTime filter: ");
        filter.dynamicFilter(testSet, Arrays.asList(new DepartureBeforeCurrentTime())).forEach(System.out::println);

        System.out.println("\nAfter ArrivalBeforeDeparture filter: ");
        filter.dynamicFilter(testSet, Arrays.asList(new ArrivalBeforeDeparture())).forEach(System.out::println);

        System.out.println("\nAfter MoreThanTwoHoursOnGround filter: ");
        filter.dynamicFilter(testSet, Arrays.asList(new MoreThanTwoHoursOnGround())).forEach(System.out::println);

        //implement multiple filters on a single list
        System.out.println("\nAll filters together: ");
        filter.dynamicFilter(testSet, Arrays.asList(
                new DepartureBeforeCurrentTime(),
                new ArrivalBeforeDeparture(),
                new MoreThanTwoHoursOnGround()))
                .forEach(System.out::println);
    }
}
