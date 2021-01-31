package com.gridnine.testing.filter.flight;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MoreThanTwoHoursOnGround extends FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> allFlights) {
        List<Flight> result = new ArrayList<>(allFlights);

        for (Flight flight : allFlights) {
            List<Segment> listOfSegm = flight.getSegments();
            double timeOnGround = 0;

            for (int i = 0; i < listOfSegm.size() - 1; i++) {
                timeOnGround += Duration.between(
                        listOfSegm.get(i).getArrivalDate(), listOfSegm.get(i + 1).getDepartureDate()).toHours();
            }

            if (timeOnGround > 2.0) {
                result.remove(flight);
            }
        }

        return result;
    }
}
