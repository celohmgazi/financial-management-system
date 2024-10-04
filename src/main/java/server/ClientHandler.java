package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


import actions.client.Actions;
import communication.Response;
import database.DataAccessInterface;
import database.DataManager;
import kong.unirest.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

public class ClientHandler extends Thread{
    private static Set<String> loggedInUsers = new HashSet<>();

    private Socket socket;
    private DataManager manager;
    private DataAccessInterface dai;
    private Actions action;
    private String userEmail;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true)
        ) {
            manager = new DataManager();
            dai = manager.getDAI();

            String clientMessage;
            boolean loggedIn = false;
            userEmail = null;

            while ((clientMessage = reader.readLine()) != null) {
                System.out.println(">>> Received: " + clientMessage);

                userEmail = extractUserEmail(clientMessage);
                
                if (isUserLoggedIn(userEmail)) {
                    writer.println(Response.login("ERROR", "You're already logged in!"));
                    continue;
                }

                int userId = setUserId(clientMessage, dai);
                if (userId != 0) {
                    loggedIn = true;
                    loggedInUsers.add(userEmail);
                }
                
                action = Actions.create(clientMessage);
                String response = handleResponse(manager, dai, clientMessage, userId);
                writer.println(response);
            }
        } catch (IOException e) {
            System.out.println("Client disconnected!");
        } finally {
            try {
                socket.close();
                if (userEmail != null) {
                    loggedInUsers.remove(userEmail);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int setUserId(String clientMessage, DataAccessInterface dai) {
        String action = new JSONObject(clientMessage).getString("action");
        int userId = 0;
        String userEmail = null;

        if (action.equals("login")) {
            userEmail = new JSONObject(clientMessage).getJSONObject("data").getString("email");
            userId = dai.getUserId(userEmail);
        }

        return userId;
    }

    private boolean isUserLoggedIn(String userEmail) {
        return loggedInUsers.contains(userEmail);
    }

    private String handleResponse(DataManager manager, DataAccessInterface dai,
                                  String clientMessage, int userId) {
        return action.execute(manager, dai, clientMessage, userId);
    }

    private String extractUserEmail(String clientMessage) {
        String action = new JSONObject(clientMessage).getString("action");

        if (action.equals("login")) {
            return new JSONObject(clientMessage).getJSONObject("data").getString("email");
        }
        return null;
    }
}
