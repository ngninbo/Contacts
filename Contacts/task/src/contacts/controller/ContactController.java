package contacts.controller;

import contacts.domain.Contact;
import contacts.builder.ContactCreator;
import contacts.service.ContactService;
import contacts.utils.PhoneBookUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static contacts.utils.PhoneBookUtils.requestInput;

public class ContactController implements ContactService {

    private static final ContactService controllerInstance = new ContactController();

    public final List<Contact> contacts;

    {
        contacts = new ArrayList<>();
    }

    public static ContactService getControllerInstance() {

        return controllerInstance == null ? new ContactController() : controllerInstance;

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
    public void add() {
        String type = requestInput("Enter the type (person, organization): ");

        Contact contact = new ContactCreator().setType(type).createContact();

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
        final String regex = String.format(".*%s.*", query);
        List<Contact> contactItems = contacts.stream()
                .filter(contact -> match(contact.appendFieldValues(), regex))
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
        } else {
            new ContactModificationAction(contactItems).setAction(action).execute();
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
        new ContactModificationAction(contacts).setAction(action).execute();
    }

    private boolean match(String name, String regex) {
        final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
