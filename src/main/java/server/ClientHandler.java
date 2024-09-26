package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import communication.Response;

public class ClientHandler extends Thread{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //dai
        //dm
        try (
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true)
        ) {
            Response response = new Response();
            String clientMessage;

            while ((clientMessage = reader.readLine()) != null) {
                System.out.println(">>> Received: " + clientMessage);
                writer.println(response.register());
            }
        } catch (IOException e) {
            System.out.println("Client disconnected!");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
