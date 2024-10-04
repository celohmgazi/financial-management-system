package actions.client;

import communication.Response;
import database.DataAccessInterface;
import database.DataManager;
import kong.unirest.json.JSONObject;

import java.util.List;

public class Register extends Actions{

    public Register() {
        super("register");
    }


    @Override
    public String execute(DataManager manager, DataAccessInterface dai, 
        String clientMessage, int userId) {
        
        JSONObject userData = new JSONObject(clientMessage).getJSONObject("data");
        String userEmail = userData.getString("email");

        int emailCount = dai.emailExists(userEmail);
        
        if (emailCount > 0) {
            return Response.register("ERROR", "An account with that email already exists!");
        }

        String userFirstName = userData.getString("firstname");
        String userLastName = userData.getString("lastname");

        dai.createUser(userFirstName, userLastName, userEmail);
        
        return Response.register("OK", "Registration successful!");
    }
}