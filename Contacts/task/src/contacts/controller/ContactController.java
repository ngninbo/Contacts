package contacts.controller;

import contacts.domain.Contact;
import contacts.domain.ContactList;
import contacts.utils.SerializationUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactController {

    private static final ContactController controllerInstance = new ContactController();
    private final ContactList contactList;

    public ContactController() {
        this.contactList = new ContactList(load());
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

    private List<Contact> load() {
        final Contact[] contacts;
        try {
            contacts = SerializationUtils.deserialize("phonebook.db");
            return Arrays.stream(contacts).collect(Collectors.toList());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }
    }

    public void save() {
        contactList.save();
    }
}
