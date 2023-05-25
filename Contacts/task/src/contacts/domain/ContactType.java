package contacts.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum ContactType {

    PERSON,
    ORGANIZATION;

    public String toLowerCase() {
        return name().toLowerCase();
    }

    public String getLabel() {
        return "contact.type.".concat(toLowerCase());
    }

    public static Stream<String> getValues() {
        return Arrays.stream(values())
                .map(ContactType::getLabel);
    }
}
