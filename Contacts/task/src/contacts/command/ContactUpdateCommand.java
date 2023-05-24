package contacts.command;

import contacts.domain.ContactUpdateAction;
import contacts.factory.CommandFactory;
import contacts.model.Contact;

import static contacts.factory.RequestFactory.requestContactUpdateAction;

public class ContactUpdateCommand extends Command {

    private final Contact contact;

    private ContactUpdateAction action = ContactUpdateAction.NO_ACTION;

    public ContactUpdateCommand(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void execute() {
        contact.info();

        while (process(action)) {
            action = ContactUpdateAction.from(requestContactUpdateAction());

            Command command = CommandFactory.commandOf(action);
            if (command != null) {
                command.setContactList(contactList);
                command.setContact(contact);
                command.execute();
            }
        }
    }

    private boolean process(ContactUpdateAction action) {
        return !ContactUpdateAction.MENU.equals(action);
    }
}
