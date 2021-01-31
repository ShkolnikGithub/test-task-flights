package com.gridnine.testing.filter.flight;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightFilter implements Filter<Flight> {

    public List<Flight> dynamicFilter(List<Filter> listFilters, List<Flight> allFlights) {
        List<Flight> result = new ArrayList<>(allFlights);

        for (Filter filter : listFilters) {
            result = filter.filter(result);
        }

        return result;
    }

    @Override
    public List<Flight> filter(List<Flight> allFlights) {
        return null;
    }
}
