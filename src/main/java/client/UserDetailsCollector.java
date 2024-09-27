package client;

import java.util.Scanner;

public class UserDetailsCollector {

    private String firstName;
    private String lastName;
    private String email;
    private final UserDetailsValidator validator;

    public UserDetailsCollector() {

        validator = new UserDetailsValidator();
        collectUserInformation();
    }

    public void collectUserInformation() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your first name: ");
            this.firstName = scanner.nextLine();
            if (validator.isValidName(firstName)) {
                break;
            } else {
                System.out.println("Invalid first name. Please enter a valid name");
            }
        }

        while (true) {
            System.out.println("Enter your last name: ");
            this.lastName = scanner.nextLine();
            if (validator.isValidName(lastName)) {
                break;
            } else {
                System.out.println("Invalid last name. Please enter a valid  last name");
            }
        }

        while (true) {
            System.out.println("Enter your email: ");
            this.email = scanner.nextLine();

            if (validator.isValidEmail(email)) {
                break;
            } else {
                System.out.println("Invalid email. Please enter a valid email");
            }

        }
    }

        public String getEmail () {
            return email;
        }

        public String getFirstName () {
            return firstName;
        }

        public String getLastName () {
            return lastName;
        }
    }
