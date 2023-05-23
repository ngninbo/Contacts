package contacts.command;

import contacts.factory.ContactFactory;
import contacts.model.Contact;
import contacts.domain.ContactType;

import static contacts.utils.PhoneBookUtils.requestInput;

public class ContactAddCommand extends Command {

    @Override
    public void execute() {
        add();
    }

    public void add() {
        String type = requestInput(format("field.enter.multiple.msg",
                format("contact.type"), ContactType.getValuesAsString()));

        try {
            Contact contact = ContactFactory.createContact(ContactType.valueOf(type.toUpperCase()));
            if (contact != null) {
                contactList.add(contact);
                print("record.add.success.msg");
            }
        } catch (IllegalArgumentException e) {
            print("contact.type.unknown", type);
        }
    }
}
