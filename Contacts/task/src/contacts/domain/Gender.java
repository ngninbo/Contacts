package contacts.domain;

import contacts.factory.MessageFactory;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Gender {

    FEMALE,
    MALE;

    public String toLowerCase() {
        return name().toLowerCase();
    }

    public String getLabel() {
        return "gender.".concat(toLowerCase());
    }

    public static Stream<String> getLabels() {
        return Arrays.stream(values()).map(Gender::getLabel);
    }

    public static String joinGender() {
        return getLabels()
                .map(MessageFactory::from)
                .map(s -> s.substring(0, 1))
                .collect(Collectors.joining(", "));
    }
}
