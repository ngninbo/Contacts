package contacts.core;

import contacts.model.Contact;

public interface ContactService<T extends Contact> {
    void update(T contact);
    boolean remove(T contact);
    void edit(T contact);
}
