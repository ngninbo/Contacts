package contacts.action;

import contacts.menu.PhoneBookMenuOption;

public class ContactInfoCommand implements Command {

    private final PhoneBookMenuOption menuOption;

    public ContactInfoCommand(PhoneBookMenuOption menuOption) {
        this.menuOption = menuOption;
    }

    @Override
    public void execute() {
        menuOption.info();
    }
}
