package client;

import java.util.Scanner;

public class UserDetailsCollector {

    private String firstName;
    private String lastName;
    private String email;
    private UserDetailsValidator validator;

    public UserDetailsCollector() {

        validator = new UserDetailsValidator();
        collectUserInformation();
    }

    public void collectUserInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        this.firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        this.lastName = scanner.nextLine();

        while(true){
        System.out.println("Enter your email: ");
        this.email = scanner.nextLine();

        if(validator.isValidEmail(email)){
            break;
        }else {
            System.out.println("Invalid email. Please enter a valid email");
        }

    }

    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}