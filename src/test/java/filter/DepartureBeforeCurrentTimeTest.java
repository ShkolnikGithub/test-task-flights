package filter;

import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.filter.flight.DepartureBeforeCurrentTime;
import com.gridnine.testing.model.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DepartureBeforeCurrentTimeTest {

    @Test
    public void filterTest() {
        List<Flight> testSet = FlightBuilder.createFlights();
        List<Flight> expected = Arrays.asList(testSet.get(0), testSet.get(1), testSet.get(3), testSet.get(4), testSet.get(5));
        List<Flight> result = new DepartureBeforeCurrentTime().filter(testSet);
        Assert.assertEquals(expected, result);
    }
}
