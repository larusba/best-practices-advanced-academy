package exercises;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    public static final String PASSWORD_TOO_SHORT = "Password too short";
    public static final String AT_LEAST_ONE_NUMBER = "At least 1 number";
    public static final String AT_LEAST_ONE_UPPERCASE = "At least 1 uppercase";
    public static final String AT_LEAST_ONE_SPECIAL_CHAR = "At least 1 special char";
    public static final String EMPTY_PASSWORD = "Empty password";

    public boolean validate(String password) {
//        List<String> errors = new ArrayList<>();
        
        if (password == null || password.isEmpty()) {
            return false;
//            return List.of(EMPTY_PASSWORD);
        }
        
        if (password.length() < 8) {
            return false;
//            errors.add(PASSWORD_TOO_SHORT);
        }

        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasSpecialChar = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (c == '!') {
                hasSpecialChar = true;
            }
        }

        if (!hasDigit) {
            return false;
//            errors.add(AT_LEAST_ONE_NUMBER);
        }

        if (!hasUpper) {
            return false;
//            errors.add(AT_LEAST_ONE_UPPERCASE);
        }
        
        if (!hasSpecialChar) {
            return false;
//            errors.add(AT_LEAST_ONE_SPECIAL_CHAR);
        }
        
        return true;
    }
}
