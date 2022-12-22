package contacts.utils;

import java.util.List;

public class InputValidator {

    private static final String PHONE_NUMBER_REGEX = "^\\+?(\\(\\w+\\)|\\w+[ \\-]\\(\\w{2,}\\)|\\w+)([ \\-]\\w{2,})*$";
    public static boolean isValidNumber(String number) {
        return number.matches(PHONE_NUMBER_REGEX);
    }

    public static boolean isValidPersonField(String field) {
        return field != null && List.of("name", "surname", "birth", "gender", "number").contains(field);
    }

    public static boolean isOrganizationField(String field) {
        return field != null && List.of("address", "number").contains(field);
    }
}
