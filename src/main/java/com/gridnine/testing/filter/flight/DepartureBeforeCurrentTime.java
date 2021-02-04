package com.gridnine.testing.filter.flight;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeCurrentTime extends FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> allFlights) {

        return allFlights.stream().filter(flight -> flight.getSegments()
                .stream().noneMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());
    }
}
