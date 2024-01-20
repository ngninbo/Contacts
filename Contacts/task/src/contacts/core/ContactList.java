package contacts.core;

import contacts.factory.MessageFactory;
import contacts.model.Contact;
import contacts.utils.InputValidator;
import contacts.utils.SerializationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactList extends ArrayList<Contact> {

    private String filename;

    public ContactList() {
        super();
    }

    private ContactList(List<Contact> contacts) {
        super(contacts);
    }

    public ContactList(String filename, List<Contact> contacts) {
        this(contacts);
        this.filename = filename;
    }

    public ContactList(String filename) {
        this();
        this.filename = filename;
    }

    public static ContactList load(String filename) {
        System.out.println(MessageFactory.format("file.open.msg", filename));
        return ContactLoader.load(filename);
    }

    public void update(Contact contact) {
        int contactIndex = indexOf(contact);
        if (contactIndex < 0) {
            return;
        }
        set(contactIndex, contact);
    }

    public List<Contact> search(String regex) {
        return stream()
                .filter(contact -> InputValidator.match(contact.appendFieldValues(), regex))
                .sorted(Comparator.comparing(Contact::getFullName))
                .collect(Collectors.toList());
    }

    public Contact[] toArray() {
        return toArray(new Contact[0]);
    }

    public int count() {
        return size();
    }

    public String getFilename() {
        return filename;
    }

    public void save() {
        try {
            SerializationUtils.serialize(this.toArray(), getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
