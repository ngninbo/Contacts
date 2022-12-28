package contacts.controller;

import contacts.domain.Contact;
import contacts.factory.OrganizationFactory;
import contacts.factory.PersonFactory;
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

    public static final List<Contact> contacts;

    static {
        contacts = new ArrayList<>();
    }

    public static ContactService getControllerInstance() {

        return controllerInstance == null ? new ContactController() : controllerInstance;

    }

    @Override
    public void add() {
        Contact contact = null;
        String type = requestInput("Enter the type (person, organization): ");

        if ("person".equals(type)) {
            contact = new PersonFactory().createContact();
        } else if ("organization".equals(type)) {
            contact = new OrganizationFactory().createContact();
        }

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
    public void info() {
        PhoneBookUtils.list(contacts);
        int index = Integer.parseInt(requestInput("Enter index to show info: ")) - 1;
        if (index < 0 || index > contacts.size()) {
            return;
        }

        contacts.get(index).info();
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
