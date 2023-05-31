package contacts;

import contacts.domain.CommandProcessor;
import contacts.domain.MainMenu;
import contacts.domain.MenuAction;
import contacts.core.ContactList;
import contacts.factory.CommandFactory;

import static contacts.factory.RequestFactory.requestInput;

public class PhoneBook extends CommandProcessor {

    private MenuAction action;

    private PhoneBook(ContactList contactList) {
        setContactList(contactList);
    }

    public static PhoneBook of(ContactList contactList) {
        return new PhoneBook(contactList);
    }

    public void processCommand() {
        while (!exit()) {
            action = new MainMenu().getAction(requestInput(MenuAction.MENU));
            CommandFactory.of(action).ifPresent(this::execute);
        }
    }

    private boolean exit() {
        return MenuAction.EXIT.equals(action);
    }
}
