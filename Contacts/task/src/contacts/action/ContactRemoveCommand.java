package contacts.action;

import contacts.menu.PhoneBookMenuOption;

public class ContactRemoveCommand implements Command {

    private final PhoneBookMenuOption menuOption;

    public ContactRemoveCommand(PhoneBookMenuOption menuOption) {
        this.menuOption = menuOption;
    }

    @Override
    public void execute() {
        menuOption.remove();
    }
}
