package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import database.DataManager;

public class Server {
    public static void main(String[] args) {
        int portNumber = 5000;
        DataManager dm = new DataManager();

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
