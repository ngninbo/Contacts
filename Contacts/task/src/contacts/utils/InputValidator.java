package contacts.utils;

import contacts.domain.Gender;

import java.text.MessageFormat;
import java.util.function.BiPredicate;
import java.util.regex.Pattern;

public class InputValidator {

    private static final MessageResourcesBundle resourcesBundle = MessageResourcesBundle.getInstance("pattern");

    public static boolean isValidNumber(String number) {
        return number.matches(resourcesBundle.get("phone.number"));
    }

    public static boolean isValidBirthDate(String birthdate) {
        return birthdate.matches(resourcesBundle.get("birth.date"));
    }

    public static boolean match(String input, String query) {
        final String regex = format("search.query", query);
        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(input).matches();
    }

    public static BiPredicate<String, Integer> isValidAction() {
        return (action, limit) -> action.matches(format("list.regex", limit));
    }

    private static String format(String pattern, Object... args) {
        return MessageFormat.format(resourcesBundle.get(pattern), args);
    }

    public static boolean isValidGender(String gender) {
        return gender.matches(format("gender.regex", Gender.getValuesAsString().replace(", ", "")));
    }
}
