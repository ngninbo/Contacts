package contacts.domain;

import java.util.List;

import static contacts.domain.MenuAction.*;
import static contacts.domain.MenuAction.NO_ACTION;

public class UpdateMenu extends Menu {

    public UpdateMenu() {
        super(List.of(EDIT, DELETE, MENU, NO_ACTION));
    }
}
