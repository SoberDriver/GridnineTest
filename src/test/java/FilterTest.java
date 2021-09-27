import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.testClasses.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FilterTest {
   private List<Flight> testFlights;
   private List<Flight> expected;





    @BeforeEach
    public void createTestFlights(){
        testFlights = DataForTests.getList();
        expected = new ArrayList<>(testFlights);
    }

    @AfterEach
    public void refreshTestFlights(){
        testFlights = null;
        expected = null;
    }

    @Test
    public void departureBeforeTheCurrentTime(){
        List<Flight> actual = FlightFilter.departureBeforeTheCurrentTime(testFlights);
        expected.remove(0);
        expected.remove(0);
        expected.remove(0);
        expected.remove(0);
        Assertions.assertIterableEquals(expected,actual);
    }

    @Test
    public void arrivalEarlierThanDeparture(){
        List<Flight> actual = FlightFilter.arrivalEarlierThanDeparture(testFlights);
        expected.remove(2);
        Assertions.assertIterableEquals(expected,actual);
    }

    @Test
    public void moreThanTwoHoursOnTheGround(){
        List<Flight> actual = FlightFilter.arrivalEarlierThanDeparture(testFlights);
        expected.remove(2);
        Assertions.assertIterableEquals(expected,actual);

    }
}
