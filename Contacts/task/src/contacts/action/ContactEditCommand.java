package contacts.action;

import contacts.menu.PhoneBookMenuOption;

public class ContactEditCommand implements Command {

    private final PhoneBookMenuOption menuOption;

    public ContactEditCommand(PhoneBookMenuOption menuOption) {
        this.menuOption = menuOption;
    }

    @Override
    public void execute() {
        menuOption.edit();
    }
}
