package contacts.action;

import contacts.menu.PhoneBookMenuOption;

public class ContactAddCommand implements Command {

    private final PhoneBookMenuOption menuOption;

    public ContactAddCommand(PhoneBookMenuOption menuOption) {
        this.menuOption = menuOption;
    }

    @Override
    public void execute() {
        menuOption.add();
    }
}
