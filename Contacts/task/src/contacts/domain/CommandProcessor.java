package contacts.domain;

import contacts.command.Command;
import contacts.core.ContactList;

public abstract class CommandProcessor {

    protected ContactList contactList;

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }

    public void execute(Command command) {
        command.setContactList(contactList);
        command.execute();
    }
}
