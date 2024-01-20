package contacts.factory;

import contacts.model.Contact;
import contacts.domain.ContactType;

import java.util.Optional;

public class ContactFactory {

    public static Optional<Contact> of(ContactType type) {
        return Optional.ofNullable(ContactBuilderFactory.getContactBuilder(type).create());
    }
}
