package com.shshetudev.flightmgmtapp.airconditioning;

import com.shshetudev.flightmgmtapp.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ThermometerTest {

    @InjectMocks
    Thermometer thermometer;

    @Mock
    Sensor sensor;

    // Initially both the methods will fail since functionality is not implemented.
    // After implementing the development code these test cases will be green.
    @Test
    void testWorkingSensor() {
        thermometer.setTemperature(25.0);
        when(sensor.isBlocked()).thenReturn(false);
        assertEquals(sensor, thermometer.getSensor());
        assertEquals(25.0, thermometer.getTemperature(), 0.001);
        verify(sensor, times(1)).isBlocked();
    }

    @Test
    void testBlockedSensor() {
        thermometer.setTemperature(25.0);
        when(sensor.isBlocked()).thenReturn(true);
        assertEquals(sensor, thermometer.getSensor());
        assertThrows(RuntimeException.class, () -> thermometer.getTemperature());
        verify(sensor, times(1)).isBlocked();
    }
}
