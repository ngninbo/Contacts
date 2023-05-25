package contacts.domain;

import java.util.List;
import java.util.stream.Stream;

import static contacts.domain.MenuAction.*;

public class ListMenu extends SearchMenu {

    public ListMenu() {
        super(List.of(VIEW_RECORD, BACK));
    }

    @Override
    public Stream<String> getItems() {
        return menuActions.stream()
                .filter(isKnown())
                .map(menuAction -> VIEW_RECORD.equals(menuAction) ? ACTION_NUMBER : menuAction.getLabel());
    }
}
