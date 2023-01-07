package contacts.core;

import contacts.model.Contact;

public interface PhoneBookOption extends ContactService<Contact> {

    void add();
    void count();
    void search();
    void list();
    void save();
    void load(String filename);
}
