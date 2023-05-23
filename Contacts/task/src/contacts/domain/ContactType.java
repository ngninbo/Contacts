package contacts.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ContactType {

    PERSON,
    ORGANIZATION;

    public static String getValuesAsString() {
        return Arrays.stream(values())
                .map(Enum::name)
                .map(String::toLowerCase)
                .collect(Collectors.joining(", "));
    }
}
