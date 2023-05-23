package contacts.core;

import contacts.model.Contact;
import contacts.utils.InputValidator;
import contacts.utils.SerializationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactList extends ArrayList<Contact> {

    public ContactList(List<Contact> contacts) {
        this.addAll(contacts);
    }

    public void update(Contact contact) {
        int contactIndex = indexOf(contact);
        if (contactIndex < 0) {
            return;
        }
        set(contactIndex, contact);
    }

    public List<Contact> search(String query) {
        return stream()
                .filter(contact -> InputValidator.match(contact.appendFieldValues(), query))
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
        return ContactLoader.getInstance().getFilename();
    }

    public void save() {
        try {
            SerializationUtils.serialize(this.toArray(), getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
