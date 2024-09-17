package client;

public class UserDetailsValidator {

    /**
     * Validates if the name contains only alphabets.
     *
     * @param name The name to validate
     * @return true if the name is all alphabets, otherwise false
     */
    public boolean isValidName(String name) {
        return name.matches("^[a-zA-Z]+$");
    }
}
