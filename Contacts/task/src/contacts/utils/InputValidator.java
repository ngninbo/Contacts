package contacts.utils;

public class InputValidator {

    private static final String PHONE_NUMBER_REGEX = "^\\+?(\\(\\w+\\)|\\w+[ \\-]\\(\\w{2,}\\)|\\w+)([ \\-]\\w{2,})*$";
    public static boolean isValidNumber(String number) {
        return number.matches(PHONE_NUMBER_REGEX);
    }
}
