package contacts.controller;

import contacts.model.Contact;
import contacts.core.ContactList;
import contacts.core.PhoneBookOption;

public class ContactController {

    private static final ContactController controllerInstance = new ContactController();
    private final PhoneBookOption option = new ContactList();

    private ContactController() {
    }

    public static ContactController getControllerInstance() {
        return controllerInstance;
    }

    public void update(Contact contact) {
        option.update(contact);
    }

    public void add() {
        option.add();
    }

    public void count() {
        option.count();
    }

    public void search() {
        option.search();
    }

    public void list() {
        option.list();
    }

    public void load(String filename) {
       option.load(filename);
    }

    public void save() {
        option.save();
    }
}
