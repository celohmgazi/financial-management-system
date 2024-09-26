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

    /**
     * Validates if the email is in the correct format.
     *
     * @param email The email to validate
     * @return true if the email is in the correct format, otherwise false
     */
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}