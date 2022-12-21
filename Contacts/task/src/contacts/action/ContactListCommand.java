package contacts.action;

import contacts.menu.PhoneBookMenuOption;

public class ContactListCommand implements Command {

    private final PhoneBookMenuOption menuOption;

    public ContactListCommand(PhoneBookMenuOption menuOption) {
        this.menuOption = menuOption;
    }

    @Override
    public void execute() {
        menuOption.list();
    }
}
