package contacts.domain;

import java.util.List;
import java.util.stream.Stream;

import static contacts.domain.MenuAction.*;

public class SearchMenu extends Menu {

    public SearchMenu() {
        super(List.of(VIEW_RECORD, BACK, AGAIN));
    }

    public SearchMenu(List<MenuAction> menuActions) {
        super(menuActions);
    }

    @Override
    public Stream<String> getItems() {
        return menuActions.stream()
                .filter(isKnown())
                .map(menuAction -> VIEW_RECORD.equals(menuAction) ? ACTION_NUMBER : menuAction.getLabel());
    }
}
