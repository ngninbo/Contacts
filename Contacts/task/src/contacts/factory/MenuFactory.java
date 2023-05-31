package contacts.factory;

import contacts.domain.*;

import java.util.Optional;

public class MenuFactory {

    public static Optional<Menu> of(MenuAction menuAction) {
        return Optional.ofNullable(from(menuAction));

    }

    public static Menu from(MenuAction menuAction) {
        switch (menuAction) {
            case LIST:
                return new ListMenu();
            case SEARCH:
                return new SearchMenu();
            case VIEW_RECORD:
                return new UpdateMenu();
            case MENU:
                return new MainMenu();
            default:
                return null;
        }

    }
}
