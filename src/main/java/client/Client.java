package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import communication.Request;

public class Client {



    public static void main(String[] args) {
        String host = "localhost";
        int portNumber = 5000;
        Scanner scanner = new Scanner(System.in);
        UserInputs inputs = new UserInputs();


        try (Socket socket = new Socket(host, portNumber)) {
            System.out.println("Connected to the server");

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));


            while (true) {
                System.out.println("What do you want to do?: ");
                String userInput = scanner.nextLine();
                String request = inputs.handleUserInputs(userInput);

                writer.println(request);
                String serverResponse = reader.readLine();
                System.out.println(serverResponse);
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
    public static void information(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Welcome to the Financial Management System !!!\n"+
                "\nThis is what we offer: \n"+
                "\t1. Savings planning\n"+
                "\t2. Budget planning\n");
        System.out.println("-------------------------------------------------------------");
    }
}
