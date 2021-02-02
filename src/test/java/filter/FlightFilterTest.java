package filter;

import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.filter.flight.ArrivalBeforeDeparture;
import com.gridnine.testing.filter.flight.DepartureBeforeCurrentTime;
import com.gridnine.testing.filter.flight.FlightFilter;
import com.gridnine.testing.filter.flight.MoreThanTwoHoursOnGround;
import com.gridnine.testing.model.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FlightFilterTest {

    @Test
    public void filterTest() {
        List<Flight> testSet = FlightBuilder.createFlights();
        List<Flight> expected = Arrays.asList(testSet.get(0), testSet.get(1));
        List<Flight> result = new FlightFilter().dynamicFilter(testSet, Arrays.asList(
                new DepartureBeforeCurrentTime(),
                new ArrivalBeforeDeparture(),
                new MoreThanTwoHoursOnGround()));
        Assert.assertEquals(expected, result);
    }
}
