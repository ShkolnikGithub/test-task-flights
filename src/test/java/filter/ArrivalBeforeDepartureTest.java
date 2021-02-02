package filter;

import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.filter.flight.ArrivalBeforeDeparture;
import com.gridnine.testing.model.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArrivalBeforeDepartureTest {

    @Test
    public void filterTest() {
        List<Flight> testSet = FlightBuilder.createFlights();
        List<Flight> expected = new ArrivalBeforeDeparture().filter(testSet);
        List<Flight> result = Arrays.asList(testSet.get(0), testSet.get(1), testSet.get(2), testSet.get(4), testSet.get(5));
        Assert.assertEquals(expected, result);
    }
}
