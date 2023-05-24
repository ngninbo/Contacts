package contacts.utils;

import contacts.domain.ContactField;
import contacts.factory.MessageFactory;
import contacts.factory.PatternFactory;

import java.util.function.BiPredicate;
import java.util.regex.Pattern;

public class InputValidator {

    public static String validate(ContactField field, String value) {

        if (!match(value, field.getRegex())) {
            System.out.println(MessageFactory.from(String.format("%s.validation.error.msg", field.name().toLowerCase())));
            value = MessageFactory.from(String.format("missing.%s.msg", ContactField.NUMBER.equals(field) ? "number" : "value"));
        }

        return value;
    }

    public static boolean match(String input, String regex) {
        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(input).matches();
    }

    public static BiPredicate<String, Integer> isValidAction() {
        return (action, limit) -> match(action, PatternFactory.format("list.regex", limit));
    }
}
