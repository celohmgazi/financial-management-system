package communication;

import kong.unirest.json.JSONObject;

public class Response {
    
    public static String register(String status, String message) {
        JSONObject data = new JSONObject();
        JSONObject response = new JSONObject();

        data.put("message", message);

        response.put("status", status);
        response.put("data", data);

        return response.toString();
    }

    public static String login(String status, String message) {
        JSONObject data = new JSONObject();
        JSONObject response = new JSONObject();

        data.put("message", message);

        response.put("status", status);
        response.put("data", data);

        return response.toString();
    }
}
