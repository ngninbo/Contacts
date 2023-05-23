package contacts.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ContactUpdateAction {

    EDIT,
    DELETE,
    MENU,
    NO_ACTION;

    public static ContactUpdateAction from(String input) {
        return Arrays.stream(values())
                .filter(action -> !NO_ACTION.equals(action))
                .filter(action -> input.equalsIgnoreCase(action.name()))
                .findFirst().orElse(NO_ACTION);
    }

    public static String getActions() {
        return Arrays.stream(values())
                .filter(action -> !NO_ACTION.equals(action))
                .map(Enum::name)
                .map(String::toLowerCase)
                .collect(Collectors.joining(", "));
    }
}
