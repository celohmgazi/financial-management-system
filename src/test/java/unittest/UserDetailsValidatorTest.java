package unittest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import client.UserDetailsValidator;

public class UserDetailsValidatorTest {
    
    @Test
    public void testValidName() {
        UserDetailsValidator validator = new UserDetailsValidator();

        assertTrue(validator.isValidName("Makhosazane"));
    }

    @Test
    public void testNumericName() {
        UserDetailsValidator validator = new UserDetailsValidator();

        assertFalse(validator.isValidName("123"));
    }

    @Test
    public void testAlphaNumericName() {
        UserDetailsValidator validator = new UserDetailsValidator();

        assertFalse(validator.isValidName("Sphe123"));
    }

    @Test
    public void testEmptyName() {
        UserDetailsValidator validator = new UserDetailsValidator();

        assertFalse(validator.isValidName(""));
    }

    @Test
    public void testNameWithSymbols() {
        UserDetailsValidator validator = new UserDetailsValidator();

        assertFalse(validator.isValidName("@nele"));
    }
}
