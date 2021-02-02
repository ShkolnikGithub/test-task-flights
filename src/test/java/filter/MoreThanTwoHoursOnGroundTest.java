package filter;

import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.filter.flight.MoreThanTwoHoursOnGround;
import com.gridnine.testing.model.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MoreThanTwoHoursOnGroundTest {

    @Test
    public void filterTest() {
        List<Flight> testSet = FlightBuilder.createFlights();
        List<Flight> expected = new MoreThanTwoHoursOnGround().filter(testSet);
        List<Flight> result = Arrays.asList(testSet.get(0), testSet.get(1), testSet.get(2), testSet.get(3));
        Assert.assertEquals(expected, result);
    }
}
