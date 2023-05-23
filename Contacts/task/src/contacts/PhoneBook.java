package contacts;

import contacts.command.Command;
import contacts.domain.MenuAction;
import contacts.core.ContactList;
import contacts.core.ContactLoader;
import contacts.factory.CommandFactory;
import contacts.utils.MessageResourcesBundle;
import contacts.utils.PhoneBookUtils;

import java.text.MessageFormat;

public class PhoneBook {

    private String action;
    private ContactList contactList;

    public void processCommand() {
        while (!exit()) {
            action = PhoneBookUtils.requestMenuSelection();

            Command command = CommandFactory.commandOf(MenuAction.from(action));
            if (command != null) {
                command.setContactList(contactList);
                command.execute();
            }

            System.out.println();
        }
    }

    public PhoneBook load(String filename) {
        System.out.println(MessageFormat.format(MessageResourcesBundle.getInstance().get("file.open.msg"), filename));
        this.contactList = new ContactList(ContactLoader.getInstance().load(filename));
        return this;
    }

    private boolean exit() {
        return MenuAction.EXIT.toLowerCase().equals(action);
    }
}
