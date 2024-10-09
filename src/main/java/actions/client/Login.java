package actions.client;

import communication.Response;
import database.DataAccessInterface;
import database.DataManager;
import kong.unirest.json.JSONObject;

public class Login extends Actions{

    public Login() {
        super("login");
    }

    @Override
    public String execute(DataManager manager, DataAccessInterface dai, 
        String clientMessage, Integer userId) {

        JSONObject userData = new JSONObject(clientMessage).getJSONObject("data");
        String userEmail = userData.getString("email");

        Integer emailCount = dai.emailExists(userEmail);
        
        if (emailCount == 0 || emailCount == null) {
            return Response.login("ERROR", "Invalid email!");
        }
        
        return Response.login("OK", "Login in successful! " + emailCount);
    }
}