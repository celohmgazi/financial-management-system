package communication;

import client.UserDetailsCollector;
import kong.unirest.json.JSONObject;

public class Request {
    
    public String register(String firstName, String lastName, String email) {
        JSONObject personalDetails = new JSONObject();
        JSONObject registrationData = new JSONObject();

        personalDetails.put("firstname", firstName);
        personalDetails.put("lastname", lastName);
        personalDetails.put("email", email);

        registrationData.put("action", "register");

        registrationData.put("data", personalDetails);

        return registrationData.toString();
    }

    public String login(String email, String password) {
        JSONObject loginDetails = new JSONObject();
        JSONObject loginData = new JSONObject();

        loginDetails.put("email", email);
        loginDetails.put("password", password);


        loginData.put("action", "login");

        loginData.put("data", loginDetails);

        return loginData.toString();
    }

    public String handleRequests(String request) {
        if (request.contains("register")) {
            return register("","","");
        }
        return null;
    }
}
