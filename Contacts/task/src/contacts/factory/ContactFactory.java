package contacts.factory;

import contacts.builder.ContactBuilder;
import contacts.model.Contact;
import contacts.domain.ContactType;

public class ContactFactory {

    public static Contact createContact(ContactType type) {
        ContactBuilder contactBuilder = ContactBuilderFactory.getContactBuilder(type);
        return contactBuilder != null ? contactBuilder.create() : null;
    }
}
