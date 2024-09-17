package client;

import java.util.Scanner;

public class UserDetailsCollector {

    private String firstName;
    private String lastName;

    public UserDetailsCollector() {
        collectUserInformation();
    }
    
    public void collectUserInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        this.firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        this.lastName = scanner.nextLine();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
