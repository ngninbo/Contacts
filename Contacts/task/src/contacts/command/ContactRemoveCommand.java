package contacts.command;

import contacts.controller.ContactController;
import contacts.domain.Contact;

public class ContactRemoveCommand implements Command {

    private final Contact contact;

    public ContactRemoveCommand(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void execute() {
        remove();
    }

    public void remove() {
        boolean deletionSucceed = ContactController.contacts.remove(contact);
        if (deletionSucceed) {
            System.out.println("The record removed!");
        }
    }
}
