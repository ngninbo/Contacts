package contacts.core;

import contacts.model.Contact;
import contacts.utils.SerializationUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactLoader {

    public static ContactList load(String filename) {
        File file = new File(filename);

        if (file.exists()) {
            try {
                final Contact[] contacts = SerializationUtils.deserialize(filename);
                return new ContactList(filename, Arrays.stream(contacts).collect(Collectors.toList()));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return new ContactList(filename);
    }
}
