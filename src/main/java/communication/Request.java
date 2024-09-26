package communication;

import client.UserDetailsCollector;
import kong.unirest.json.JSONObject;

public class Request {
    
    public String register(UserDetailsCollector collector) {
        JSONObject personalDetails = new JSONObject();
        JSONObject registrationData = new JSONObject();

        personalDetails.put("firstname", collector.getFirstName());
        personalDetails.put("lastname", collector.getLastName());
        personalDetails.put("email", collector.getEmail());

        registrationData.put("action", "register");

        registrationData.put("data", personalDetails);

        return registrationData.toString();
    }
}
