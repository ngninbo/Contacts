package contacts.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Gender {

    F,
    M;

    public static String getValuesAsString() {
        return Arrays.stream(values()).map(Enum::name).collect(Collectors.joining(", "));
    }
}
