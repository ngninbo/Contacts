package contacts.menu;

import contacts.domain.Organization;
import contacts.domain.Person;
import contacts.factory.OrganizationFactory;
import contacts.factory.PersonFactory;
import contacts.domain.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookMenuOption {

    private final List<Contact> contacts;
    private Scanner scanner;

    {
        contacts = new ArrayList<>();
    }

    public void add() {

        scanner = new Scanner(System.in);
        Contact contact = null;
        System.out.print("Enter the type (person, organization): ");

        String type = scanner.nextLine();

        switch (type) {
            case "person":
                contact = new PersonFactory().createContact();
                break;
            case "organization":
                contact = new OrganizationFactory().createContact();
                break;
        }

        if (contact != null) {
            contacts.add(contact);
            System.out.println("The record added.");
        }
    }

    public void remove() {
        if (contacts.isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            scanner = new Scanner(System.in);
            list();
            System.out.print("Select a record: ");
            int choice = scanner.nextInt();
            Contact contact = contacts.remove(choice - 1);
            if (contact != null) {
                System.out.println("The record removed!");
            }
        }
    }


    public void edit() {
        if (contacts.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            scanner = new Scanner(System.in);
            list();
            System.out.print("Select a record: ");
            int contactIndex = Integer.parseInt(scanner.nextLine());
            if (contactIndex > contacts.size()) {
                return;
            }
            Contact contact = contacts.get(contactIndex - 1);
            Contact updatedContact;

            if (contact instanceof Person) {
                updatedContact = PersonFactory.edit((Person) contact);
            } else {
                updatedContact = OrganizationFactory.edit((Organization) contact);
            }

            contacts.set(contactIndex - 1, updatedContact);

            System.out.println("The record updated!");
        }
    }

    public void count() {
        System.out.printf("The Phone Book has %s records.\n", contacts.size());
    }

    public void list() {
        for (int i = 0, contactsSize = contacts.size(); i < contactsSize; i++) {
            Contact contact = contacts.get(i);

            if (contact instanceof Person) {
                Person person = (Person) contact;
                System.out.printf("%s. %s %s\n", i + 1, person.getName(), person.getSurname());
            } else {
                Organization org = (Organization) contact;
                System.out.printf("%s. %s\n", i + 1, org.getOrganizationName());
            }
        }
    }

    public void info() {
        list();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter index to show info: ");
        int index = scanner.nextInt() - 1;
        if (index < 0 || index > contacts.size()) {
            return;
        }

        info(index);
    }

    public void info(int contactIndex) {
        Contact contact = contacts.get(contactIndex);
        if (contact instanceof Person) {
            Person person = (Person) contact;
            person.info();
        } else {
            Organization org = (Organization) contact;
            org.info();
        }
    }
}
