package contacts.core;

import contacts.model.Contact;
import contacts.utils.SerializationUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContactLoader {

    private static final ContactLoader INSTANCE = new ContactLoader();

    private String filename;

    public static ContactLoader getInstance() {
        return INSTANCE;
    }

    public String getFilename() {
        return filename;
    }

    public List<Contact> load(String filename) {
        this.filename = filename;
        final Contact[] contacts;
        File file = new File(filename);

        if (file.exists()) {
            try {
                contacts = SerializationUtils.deserialize(filename);
                return Arrays.stream(contacts).collect(Collectors.toList());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<>();
    }
}
