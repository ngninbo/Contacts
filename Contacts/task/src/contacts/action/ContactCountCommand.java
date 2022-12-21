package contacts.action;

import contacts.menu.PhoneBookMenuOption;

public class ContactCountCommand implements Command {

    private final PhoneBookMenuOption menuOption;

    public ContactCountCommand(PhoneBookMenuOption menuOption) {
        this.menuOption = menuOption;
    }

    @Override
    public void execute() {
        menuOption.count();
    }
}
