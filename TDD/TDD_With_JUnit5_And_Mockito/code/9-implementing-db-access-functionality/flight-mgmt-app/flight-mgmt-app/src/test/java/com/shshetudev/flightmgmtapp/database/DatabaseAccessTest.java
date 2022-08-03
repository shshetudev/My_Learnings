package com.shshetudev.flightmgmtapp.database;

import com.shshetudev.flightmgmtapp.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DatabaseAccessTest {
    // We use the mock object of the real database
    @Mock
    private Database database;

    private Credentials credentials = new Credentials("user", "password");

    // Initially it will fail
    // Each time a new object creation will create a unique object which can not be covered using mock
    // So we need to override the equals and hashcode method
    @Test
    void testUserSuccessfulLogin() {
        when(database.login(credentials)).thenReturn(true);
        // We want to make sure that login has been successful for the same user with same password
        Credentials sameCredentials = new Credentials("user", "password");
        assertTrue(database.login(sameCredentials));
    }

    @Test
    void testUserFailedLogin() {
        when(database.login(credentials)).thenReturn(true);
        Credentials otherCredentials = new Credentials("user", "password");
        otherCredentials.setUsername("otherUser");
        otherCredentials.setPassword("otherPassword");
        assertNotEquals(credentials.getUsername(), otherCredentials.getUsername());
        assertNotEquals(credentials.getPassword(), otherCredentials.getPassword());
        assertNotEquals(credentials.hashCode(), otherCredentials.hashCode());
        assertFalse(database.login(otherCredentials));
    }
}
