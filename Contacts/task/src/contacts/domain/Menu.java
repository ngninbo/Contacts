package contacts.domain;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static contacts.domain.MenuAction.NO_ACTION;

public abstract class Menu {

    protected final List<MenuAction> menuActions;

    public Menu(List<MenuAction> menuActions) {
        this.menuActions = menuActions;
    }

    public MenuAction getAction(String input) {
        return menuActions.stream()
                .filter(action -> filter().test(action, input))
                .findFirst().orElse(NO_ACTION);
    }

    private static BiPredicate<MenuAction, String> filter() {
        return (action, input) -> isKnown().test(action) && isEquals().test(action.toLowerCase(), input);
    }

    protected static Predicate<MenuAction> isKnown() {
        return menuAction -> !NO_ACTION.equals(menuAction);
    }

    public static BiPredicate<String, String> isEquals() {
        return (actionName, input) -> input.equalsIgnoreCase(actionName);
    }

    public Stream<String> getItems() {
        return menuActions.stream()
                .filter(isKnown())
                .map(MenuAction::getLabel);
    }
}
