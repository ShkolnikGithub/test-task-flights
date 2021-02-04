package com.gridnine.testing.filter.flight;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDeparture extends FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> allFlights) {

        return allFlights.stream().filter(flight -> flight.getSegments()
                .stream().noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
