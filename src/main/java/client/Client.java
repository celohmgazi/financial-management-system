package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int portNumber = 5000;

        try (Socket socket = new Socket(host, portNumber)) {
            System.out.println("Connected to the server");

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            writer.println("Hello, Server!");

            String serverResponse = reader.readLine();
            System.out.println("Server: " + serverResponse);
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
