package contacts.controller;

import contacts.command.Command;
import contacts.command.ContactEditCommand;
import contacts.command.ContactRemoveCommand;
import contacts.domain.Contact;

import java.util.List;

import static contacts.utils.PhoneBookUtils.requestInput;

public class ContactModificationAction implements Command {

    private final List<Contact> contacts;

    private String action;

    public ContactModificationAction(List<Contact> contactItems) {
        this.contacts = contactItems;
    }

    public ContactModificationAction setAction(String action) {
        this.action = action;

        return this;
    }

    @Override
    public void execute() {
        if (action.matches("\\d")) {
            int number = Integer.parseInt(action) - 1;

            if (number < 0 || number > contacts.size()) {
                return;
            }

            final Contact contact = contacts.get(number);
            contact.info();

            while (!"menu".equals(action)) {
                action = requestInput("\n[record] Enter action (edit, delete, menu): ");

                Command command = null;

                if ("edit".equals(action)) {
                    command = new ContactEditCommand(contact);
                } else if ("delete".equals(action)) {
                    command = new ContactRemoveCommand(contact);
                }

                if (command != null) {
                    command.execute();
                }
            }
        }
    }
}
