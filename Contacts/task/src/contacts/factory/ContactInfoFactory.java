package contacts.factory;

import contacts.domain.ContactInfo;
import contacts.domain.ContactType;
import contacts.domain.OrganizationInfo;
import contacts.domain.PersonInfo;
import contacts.model.Contact;
import contacts.model.Organization;
import contacts.model.Person;

import java.util.Optional;

public class ContactInfoFactory {

    public static Optional<ContactInfo> of(Contact contact) {

        ContactInfo contactInfo;

        ContactType contactType = ContactType.valueOf(contact.getClass().getSimpleName().toUpperCase());

        switch (contactType) {
            case PERSON:
                contactInfo = new PersonInfo((Person) contact);
                break;
            case ORGANIZATION:
                contactInfo = new OrganizationInfo((Organization) contact);
                break;
            default:
                contactInfo = null;
        }

        return Optional.ofNullable(contactInfo);
    }
}
