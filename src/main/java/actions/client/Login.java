package actions.client;

import communication.Response;
import database.DataAccessInterface;
import database.DataManager;

public class Login extends Actions{

    public Login() {
        super("login");
    }

    @Override
    public String execute(DataManager manager, DataAccessInterface dai, 
        String clientMessage, int userId) {
        String message = "Login in successful!";
        
        return Response.login("OK", message);
    }
}