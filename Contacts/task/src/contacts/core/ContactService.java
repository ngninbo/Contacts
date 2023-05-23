package contacts.core;

import contacts.model.Contact;

public interface ContactService<T extends Contact> {
    boolean remove(T contact);
}
