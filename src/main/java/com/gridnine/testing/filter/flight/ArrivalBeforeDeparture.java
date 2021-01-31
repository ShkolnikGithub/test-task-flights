package com.gridnine.testing.filter.flight;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDeparture extends FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> allFlights) {
//        List<Flight> result = new ArrayList<>(allFlights);
//
//        for (Flight flight : allFlights) {
//            List<Segment> listOfSegm = flight.getSegments();
//            for (Segment segm : listOfSegm) {
//                if (segm.getArrivalDate().isBefore(segm.getDepartureDate())) {
//                    result.remove(flight);
//                    break;
//                }
//            }
//        }
//
//        return result;

        return allFlights.stream().filter(flight -> flight.getSegments()
                .stream().anyMatch(segment -> !segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
