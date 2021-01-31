package com.gridnine.testing.filter.flight;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeCurrentTime extends FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> allFlights) {

//        List<Flight> result = new ArrayList<>(allFlights);
//
//        for (Flight flight : allFlights) {
//            List<Segment> listOfSegm = flight.getSegments();
//            for (Segment segm : listOfSegm) {
//                if (segm.getDepartureDate().isBefore(LocalDateTime.now())) {
//                    result.remove(flight);
//                    break;
//                }
//            }
//        }
//
//        return result;

        return allFlights.stream().filter(flight -> flight.getSegments()
                .stream().anyMatch(segment -> !segment.getDepartureDate().isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());
    }
}
