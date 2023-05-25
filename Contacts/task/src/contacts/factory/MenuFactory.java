package contacts.factory;

import contacts.domain.*;

import java.util.stream.Stream;

public class MenuFactory {

    public static Stream<String> from(MenuAction menuAction) {
        switch (menuAction) {
            case LIST:
                return new ListMenu().getItems();
            case SEARCH:
                return new SearchMenu().getItems();
            case VIEW_RECORD:
                return new UpdateMenu().getItems();
            case MENU:
                return new MainMenu().getItems();
            default:
                return Stream.of();
        }

    }
}
