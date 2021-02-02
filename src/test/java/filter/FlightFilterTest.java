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
        List<Flight> expected = new FlightFilter().dynamicFilter(testSet, Arrays.asList(
                new DepartureBeforeCurrentTime(),
                new ArrivalBeforeDeparture(),
                new MoreThanTwoHoursOnGround()));
        List<Flight> result = Arrays.asList(testSet.get(0), testSet.get(1));
        Assert.assertEquals(expected, result);
    }
}
