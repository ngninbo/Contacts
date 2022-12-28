package contacts.builder;

import contacts.domain.Contact;
import contacts.factory.ContactFactory;

public class ContactCreator implements ContactFactory {

    private String type;

    public ContactCreator setType(String type) {
        this.type = type;

        return this;
    }

    @Override
    public Contact createContact() {

        ContactBuilder contactBuilder = null;
        if ("person".equals(type)) {
            contactBuilder = new PersonBuilder();
        } else if ("organization".equals(type)) {
            contactBuilder = new OrganizationBuilder();
        }

        if (contactBuilder != null) {
            return contactBuilder.create();
        }

        return null;
    }
}
