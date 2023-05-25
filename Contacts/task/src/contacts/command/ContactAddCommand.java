package contacts.command;

import contacts.factory.ContactFactory;
import contacts.model.Contact;
import contacts.domain.ContactType;

import static contacts.factory.RequestFactory.*;

public class ContactAddCommand extends Command {

    @Override
    public void execute() {
        add();
    }

    public void add() {
        String type = requestContactType();

        try {
            ContactFactory.of(ContactType.valueOf(type.toUpperCase())).ifPresent(this::add);
        } catch (IllegalArgumentException e) {
            print(CONTACT_TYPE_UNKNOWN, type);
        }
    }

    private void add(Contact contact) {
        contactList.add(contact);
        print(RECORD_ADD_SUCCESS_MSG);
    }
}
