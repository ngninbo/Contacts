package contacts.service;

import contacts.domain.Contact;

public interface ContactService<T extends Contact> {

    void add();
    void count();
    void search();
    void list();
    void update(T contact);
    boolean remove(T contact);

    void save();
}
