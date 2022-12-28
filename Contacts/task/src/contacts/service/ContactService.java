package contacts.service;

import contacts.domain.Contact;

public interface ContactService {

    void add();
    void count();
    void search();
    void list();
    void update(Contact contact);
    boolean remove(Contact contact);
}
