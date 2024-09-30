package communication;

import kong.unirest.json.JSONObject;

public class Response {
    
    public static String register() {
        JSONObject data = new JSONObject();
        JSONObject response = new JSONObject();

        String message = "Registeration successful!";
        data.put("message", message);

        response.put("status", "OK");
        response.put("data", data);

        return response.toString();
    }
}
