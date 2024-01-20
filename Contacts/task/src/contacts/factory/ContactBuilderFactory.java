package contacts.factory;

import contacts.builder.ContactBuilder;
import contacts.builder.OrganizationBuilder;
import contacts.builder.PersonBuilder;
import contacts.domain.ContactType;

public class ContactBuilderFactory {

    public static ContactBuilder getContactBuilder(ContactType type) {
        switch (type) {
            case PERSON:
                return new PersonBuilder();
            case ORGANIZATION:
                return new OrganizationBuilder();
            default:
                throw new IllegalArgumentException("Cannot create contact builder for type=" + type);
        }
    }
}
