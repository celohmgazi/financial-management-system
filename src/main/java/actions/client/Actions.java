package actions.client;

import database.DataAccessInterface;
import database.DataManager;
import kong.unirest.json.JSONObject;

public abstract class Actions {
    

    public Actions(String action) {
        
    }

    public static Actions create(String clientMessage) {
        JSONObject msgObject = new JSONObject(clientMessage);
        String action = msgObject.getString("action");

        switch (action) {

            case "register":
                return new Register();
            case "login":
                return new Login();
            default:
                throw new IllegalArgumentException("Unsupported command: " + action);
        }
    }

    public abstract String execute(DataManager manager, DataAccessInterface dai, String clientMessage, Integer userId);
}
