package communication;

import kong.unirest.json.JSONObject;

public class Response {
    
    public String register() {
        JSONObject data = new JSONObject();
        JSONObject response = new JSONObject();

        data.put("message", "Registration Successful!");

        response.put("status", "OK");
        response.put("data", data);

        return response.toString();
    }
}
