package actions.client;

import database.DataAccessInterface;
import database.DataManager;

public abstract class Actions {
    private String action;

    public Actions(String action) {
        this.action = action;
    }

    public static Actions create() {

        return new Register();
    };

    public abstract String execute(DataManager manager, DataAccessInterface dai, String clientMessage);
}
