package contacts.domain;

import contacts.utils.PhoneBookUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ContactUpdateAction {

    EDIT,
    DELETE,
    MENU,
    NO_ACTION;

    public String toLowerCase() {
        return name().toLowerCase();
    }

    public String getLabel() {
        return "action.".concat(toLowerCase());
    }

    public static ContactUpdateAction from(String input) {
        return Arrays.stream(values())
                .filter(action -> filter().test(action, input))
                .findFirst().orElse(NO_ACTION);
    }

    public static Stream<String> getActions() {
        return Arrays.stream(values())
                .filter(isKnown())
                .map(ContactUpdateAction::getLabel);
    }

    private static BiPredicate<ContactUpdateAction, String> filter() {
        return (action, input) -> isKnown().test(action) && MenuAction.isEquals().test(action.toLowerCase(), input);
    }

    private static Predicate<ContactUpdateAction> isKnown() {
        return action -> !NO_ACTION.equals(action);
    }
}
