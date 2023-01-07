package contacts.core;

import contacts.factory.ContactCreator;
import contacts.model.Contact;
import contacts.utils.PhoneBookUtils;
import contacts.utils.SerializationUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static contacts.utils.PhoneBookUtils.requestInput;

public class ContactList implements PhoneBookOption {

    private List<Contact> contacts;
    private String filename;

    public ContactList() {
    }

    @Override
    public void update(Contact contact) {
        int contactIndex = contacts.indexOf(contact);
        if (contactIndex < 0) {
            return;
        }
        contacts.set(contactIndex, contact);
    }

    @Override
    public boolean remove(Contact contact) {
        return contacts.remove(contact);
    }

    @Override
    public void edit(Contact contact) {
        String field = requestInput(String.format("Select a field (%s): ", contact.getEditableFields()));
        if (!field.isEmpty()) {
            String value = requestInput(String.format("Enter %s: ", field));
            contact.setFieldValue(field, value);
            update(contact);
            System.out.println("Saved");
            contact.info();
        }
    }

    @Override
    public void add() {
        String type = requestInput("Enter the type (person, organization): ");
        Contact contact = ContactCreator.of(type);

        if (contact != null) {
            contacts.add(contact);
            System.out.println("The record added.");
        }
    }

    @Override
    public void count() {
        System.out.printf("The Phone Book has %s records.\n", contacts.size());
    }

    @Override
    public void search() {
        String query = requestInput("Enter search query: ");
        List<Contact> contactItems = contacts.stream()
                .filter(contact -> contact.match(query))
                .sorted(Comparator.comparing(Contact::getFullName))
                .collect(Collectors.toList());
        System.out.printf("Found %s results:\n", contactItems.size());

        if (contactItems.isEmpty()) {
            return;
        }

        PhoneBookUtils.list(contactItems);
        String action = requestInput("\n[search] Enter action ([number], back, again): ");

        if ("again".equals(action)) {
            search();
        } else if (action.matches("\\d")){
            int number = Integer.parseInt(action) - 1;

            if (number < 0 || number >= contactItems.size()) {
                return;
            }

            new Record(contactItems.get(number)).modify();
        }
    }

    @Override
    public void list() {

        if (contacts.isEmpty()) {
            System.out.println("Contacts list is empty");
            return;
        }

        PhoneBookUtils.list(contacts);

        String action = requestInput("\n[list] Enter action ([number], back): ");

        if (action.matches("\\d")) {
            int number = Integer.parseInt(action) - 1;

            if (number < 0 || number >= contacts.size()) {
                return;
            }

            new Record(contacts.get(number)).modify();
        }
    }

    @Override
    public void save() {
        try {
            SerializationUtils.serialize((contacts.toArray(new Contact[0])), filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void load(String filename) {
        this.filename = filename;
        System.out.printf("open %s\n", filename);
        final Contact[] contacts;
        try {
            contacts = SerializationUtils.deserialize(filename);
            this.contacts = Arrays.stream(contacts).collect(Collectors.toList());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            this.contacts = new ArrayList<>();
        }
    }

    class Record {

        private final Contact contact;

        public Record(Contact contact) {
            this.contact = contact;
        }

        public void modify() {
            contact.info();

            String action = null;

            while (!"menu".equals(action)) {
                action = requestInput("\n[record] Enter action (edit, delete, menu): ");

                switch (action) {
                    case "edit":
                        edit(contact);
                        break;
                    case "delete":
                        boolean deletionSucceed = remove(contact);
                        if (deletionSucceed) {
                            System.out.println("The record removed!");
                        }
                        break;
                    default:
                }
            }
        }
    }
}
