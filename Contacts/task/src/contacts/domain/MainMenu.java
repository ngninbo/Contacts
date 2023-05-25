package contacts.domain;

import java.util.List;

import static contacts.domain.MenuAction.*;
import static contacts.domain.MenuAction.NO_ACTION;

public class MainMenu extends Menu {

    public MainMenu() {
        super(List.of(ADD, LIST, SEARCH, COUNT, EXIT, NO_ACTION));
    }
}
