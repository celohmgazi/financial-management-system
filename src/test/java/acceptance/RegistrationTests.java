package acceptance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(serverClient.isConnected());

         String requestJson = "{" +
             "\"action\": \"register\"," +
             "\"data\": {" +
                 "\"firstname\": \"Kusasalakhe\"," +
                 "\"lastname\": \"Hlongwa\"," +
                 "\"email\": \"kusasalakhe.hlongwa@example.com\"" +
             "}" +
         "}";

         JsonNode response = serverClient.sendRequest(requestJson);

         assertEquals("OK", response.get("status").asText());
    }

    // @Test
    // public void testRegistrationWithEmailAlreadyTaken() {

    //     assertTrue(serverClient.isConnected());

    //      String requestJson = "{" +
    //          "\"action\": \"register\"," +
    //          "\"data\": {" +
    //              "\"firstname\": \"suguru\"," +
    //              "\"lastname\": \"geto\"," +
    //              "\"email\": \"sgeto@example.com\"" +
    //          "}" +
    //      "}";

    //      String requestJson2 = "{" +
    //          "\"action\": \"register\"," +
    //          "\"data\": {" +
    //              "\"firstname\": \"suguru\"," +
    //              "\"lastname\": \"geto\"," +
    //              "\"email\": \"sgeto@example.com\"" +
    //          "}" +
    //      "}";

    //      serverClient.sendRequest(requestJson);

    //      JsonNode response = serverClient.sendRequest(requestJson2);

    //      assertEquals("ERROR", response.get("status").asText());
    // }
}
