package com.shshetudev.flightmgmtapp.airconditioning;

import com.shshetudev.flightmgmtapp.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AirConditioningSystemTest {

    @InjectMocks
    AirConditioningSystem airConditioningSystem;

    @Mock
    Thermometer thermometer;

    @Test
    void testAirConditionedSystemStarted() {
        when(thermometer.getTemperature()).thenReturn(25.0);
        airConditioningSystem.setTemperatureThreshold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        assertTrue(airConditioningSystem.isOpen());
        Mockito.verify(thermometer, times(1)).getTemperature();
    }

    @Test
    void testAirConditionSystemStopped() {
        when(thermometer.getTemperature()).thenReturn(23.0);
        airConditioningSystem.setTemperatureThreshold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        assertFalse(airConditioningSystem.isOpen());
        verify(thermometer, times(1)).getTemperature();
    }
}
