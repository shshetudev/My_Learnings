package com.shshetudev.flightmgmtapp.database;

import com.shshetudev.flightmgmtapp.MockitoExtension;
import com.shshetudev.flightmgmtapp.airport.flight.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shshetudev.flightmgmtapp.database.DatabaseUtil.buildFlightsList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatisticsTest {

    // Initially we used mock and by this we only mocked the behavior of queryFlightsDatabase() method
    // But we need other methods to be in working state. That's why we are using partial mock known as stubbing using the annotation @Spy.
//    @Mock
    @Spy
    private Database database;

    private List<List<String>> queriedData;
    private List<Flight> flights;

    @BeforeEach
    void before() {
        queriedData = new ArrayList<>();
        List<String> row1 = Arrays.asList("1", "e", "Mike", "false", "349");
        List<String> row2 = Arrays.asList("2", "b", "John", "true", "278");
        List<String> row3 = Arrays.asList("3", "e", "Mike", "false", "319");
        List<String> row4 = Arrays.asList("4", "p", "John", "true", "817");
        List<String> row5 = Arrays.asList("5", "e", "Mike", "false", "623");
        List<String> row6 = Arrays.asList("6", "e", "John", "true", "978");
        queriedData.add(row1);
        queriedData.add(row2);
        queriedData.add(row3);
        queriedData.add(row4);
        queriedData.add(row5);
        queriedData.add(row6);
    }

    // Initially this test will fail
    @Test
    void testQueriedData() {
        // Initially we have mocked queryFlightsDatabase() method only but other methods are not mocked.
        // So the tests will fail.
        when(database.queryFlightsDatabase()).thenReturn(queriedData);
        flights = buildFlightsList(queriedData);
        assertEquals(6, database.queryFlightsDatabase().size());
        assertEquals(6, flights.size());
        assertEquals(560.666, database.averageDistance(flights), 0.001);
        assertEquals(278, database.minimumDistance(flights));
        assertEquals(978, database.maximumDistance(flights));
    }
}
