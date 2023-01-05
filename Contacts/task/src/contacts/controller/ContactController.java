package contacts.controller;

import contacts.domain.Contact;
import contacts.domain.ContactList;

public class ContactController {

    private static final ContactController controllerInstance = new ContactController();
    private final ContactList contactList = new ContactList();

    private ContactController() {
    }

    public static ContactController getControllerInstance() {
        return controllerInstance == null ? new ContactController() : controllerInstance;
    }

    public void update(Contact contact) {
        contactList.update(contact);
    }

    public boolean remove(Contact contact) {
        return contactList.remove(contact);
    }

    public void add() {
        contactList.add();
    }

    public void count() {
        contactList.count();
    }

    public void search() {
        contactList.search();
    }

    public void list() {
        contactList.list();
    }

    public void load(String filename) {
       contactList.load(filename);
    }

    public void save() {
        contactList.save();
    }
}
