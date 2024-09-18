package acceptance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.fasterxml.jackson.databind.JsonNode;

import resources.RegisteringClient;
import resources.RegisteringJsonClient;

public class RegistrationTests {
    private final static int DEFAULT_PORT = 5000;
    private final static String DEFAULT_IP = "localhost";
    private final RegisteringClient serverClient = new RegisteringJsonClient();

    @BeforeEach
    public void connectToServer() {
        serverClient.connect(DEFAULT_IP, DEFAULT_PORT);
    }

    @AfterEach
    public void disconnectFromServer() {
        serverClient.disconnect();
    }

    @Test
    public void testSuccessfulRegistration() {

        String requestJson = "{" +
            "\"action\": \"register\"," +
            "\"data\": {" +
                "\"firstname\": \"Kusasalakhe\"," +
                "\"lastname\": \"Hlongwa\"" +
            "}" +
        "}";

        JsonNode response = serverClient.sendRequest(requestJson);

        assertEquals("OK", response.get("status").asText());
    }
}