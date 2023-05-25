package contacts.factory;

import contacts.builder.ContactBuilder;
import contacts.model.Contact;
import contacts.domain.ContactType;

import java.util.Optional;

public class ContactFactory {

    public static Optional<Contact> of(ContactType type) {
        ContactBuilder contactBuilder = ContactBuilderFactory.getContactBuilder(type);

        if (contactBuilder != null) {
            return Optional.of(contactBuilder.create());
        }

        return Optional.empty();
    }
}
