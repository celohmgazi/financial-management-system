package actions.client;

import communication.Response;
import database.DataAccessInterface;
import database.DataManager;
import kong.unirest.json.JSONObject;

public class Register extends Actions{

    public Register() {
        super("register");
    }

    @Override
    public String execute(DataManager manager, DataAccessInterface dai, 
        String clientMessage, int userId) {
        
        JSONObject userData = new JSONObject(clientMessage).getJSONObject("data");
        String userFirstName = userData.getString("firstname");
        String userEmail = userData.getString("email");
        String userLastName = userData.getString("lastname");
        dai.createUSer(userFirstName, userLastName, userEmail);
        
        return Response.register();
    }
}