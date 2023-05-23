package contacts.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum MenuAction {

    ADD,
    LIST,
    SEARCH,
    COUNT,
    EXIT,
    UNKNOWN;

    public String toLowerCase() {
        return name().toLowerCase();
    }

    public String getLabel() {
        return "action.".concat(toLowerCase());
    }

    public static MenuAction from(String action) {
        return Arrays.stream(values())
                .filter(menuAction -> filter().test(menuAction, action))
                .findFirst().orElse(UNKNOWN);
    }

    public static Stream<String> getActions() {
        return Arrays.stream(values())
                .filter(isKnown())
                .map(MenuAction::getLabel);
    }

    private static BiPredicate<MenuAction, String> filter() {
        return (menuAction, input) -> isKnown().test(menuAction) && isEquals().test(menuAction.toLowerCase(), input);
    }

    private static Predicate<MenuAction> isKnown() {
        return menuAction -> !UNKNOWN.equals(menuAction);
    }

    public static BiPredicate<String, String> isEquals() {
       return (actionName, input) -> input.equalsIgnoreCase(actionName);
    }
}
