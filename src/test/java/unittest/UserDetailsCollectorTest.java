package unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import client.UserDetailsCollector;

public class UserDetailsCollectorTest {
   
    @Test
    public void testUserInfoCollection() {
        String simulatedInput = "Makhosazane\nDube";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        UserDetailsCollector collector = new UserDetailsCollector();

        assertEquals("Makhosazane", collector.getFirstName());
        assertEquals("Dube", collector.getLastName());
    }
}
