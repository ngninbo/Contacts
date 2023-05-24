package contacts;

import contacts.command.Command;
import contacts.domain.MenuAction;
import contacts.core.ContactList;
import contacts.factory.CommandFactory;
import contacts.factory.RequestFactory;

public class PhoneBook {

    private String action;
    private final ContactList contactList;

    private PhoneBook(ContactList contactList) {
        this.contactList = contactList;
    }

    public static PhoneBook of(ContactList contactList) {
        return new PhoneBook(contactList);
    }

    public void processCommand() {
        while (!exit()) {
            action = RequestFactory.requestMenuSelection();

            Command command = CommandFactory.commandOf(MenuAction.from(action));
            if (command != null) {
                command.setContactList(contactList);
                command.execute();
            }

            System.out.println();
        }
    }

    private boolean exit() {
        return MenuAction.EXIT.toLowerCase().equals(action);
    }
}
