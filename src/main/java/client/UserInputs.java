package client;

import communication.Request;

import java.util.Scanner;

public class UserInputs {

    private String firstName;
    private String lastName;
    private String email;
    private final UserDetailsValidator validator;
    private Request request;
    private Scanner scanner;

    public UserInputs() {
        validator = new UserDetailsValidator();
        request = new Request();
        scanner = new Scanner(System.in);
    }

    public String registrationInfo() {
        String firstName = getUserFirstName();
        String lastName = getUserLastName();
        String email = getUserEmail();

        return request.register(firstName, lastName, email);
    }

    public String loginInfo() {
        String email = getUserEmail();
        String password = getUserPassword();

        return request.login(email, "null");
    }

    public String userCommands() {
        return "";
    }

    public String getUserFirstName() {

        while (true) {
            System.out.println("Enter your first name: ");
            this.firstName = scanner.nextLine();
            if (validator.isValidName(firstName)) {
                return firstName;
            } else {
                System.out.println("Invalid first name. Please enter a valid name");
            }
        }
    }

    public String getUserLastName() {

        while (true) {
            System.out.println("Enter your last name: ");
            this.lastName = scanner.nextLine();
            if (validator.isValidName(lastName)) {
                return lastName;
            } else {
                System.out.println("Invalid last name. Please enter a valid  last name");
            }
        }
    }

    public String getUserEmail() {

        while (true) {
            System.out.println("Enter your email: ");
            this.email = scanner.nextLine();

            if (validator.isValidEmail(email)) {
                return email;
            } else {
                System.out.println("Invalid email. Please enter a valid email");
            }
        }
    }

    public String getUserPassword() {
        return null;
    }

    public String handleUserInputs(String userInput) {
        if (userInput.equals("register")) {
            return registrationInfo();
        } else if (userInput.equals("login")) {
            return loginInfo();
        } else {
            return userCommands();
        }
    }
}
