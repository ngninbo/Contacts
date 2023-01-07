package contacts.factory;

import contacts.builder.ContactBuilder;
import contacts.builder.OrganizationBuilder;
import contacts.builder.PersonBuilder;
import contacts.model.Contact;

public class ContactCreator {

    private ContactBuilder contactBuilder;

    private ContactCreator(String type) {

        switch (type) {
            case "person":
                contactBuilder = new PersonBuilder();
                break;
            case "organization":
                contactBuilder = new OrganizationBuilder();
                break;
        }
    }

    public static Contact of(String type) {
        return createContact(type);
    }

    public static Contact createContact(String type) {
        return new ContactCreator(type).createContact();
    }

    private Contact createContact() {
        return contactBuilder != null ? contactBuilder.create() : null;
    }
}
