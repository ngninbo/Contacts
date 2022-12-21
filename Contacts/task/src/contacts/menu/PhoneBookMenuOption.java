package contacts.menu;

import contacts.utils.InputValidator;
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
        Contact contact = new Contact();
        scanner = new Scanner(System.in);

        System.out.print("Enter the name: ");
        contact.setName(scanner.nextLine());
        System.out.print("Enter the surname: ");
        contact.setSurname(scanner.nextLine());
        System.out.print("Enter the number: ");
        contact.setNumber(scanner.nextLine());

        contacts.add(contact);
        System.out.println("The record added.");
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
            System.out.print("Select a field (name, surname, number): ");
            String field = scanner.nextLine();

            if (InputValidator.isValidField(field)) {
                System.out.printf("Enter %s: ", field);
                String value = scanner.nextLine();

                switch (field) {
                    case "name":
                        contact.setName(value);
                        break;
                    case "surname":
                        contact.setSurname(value);
                        break;
                    case "number":
                        contact.setNumber(value);
                        break;
                }

                System.out.println("The record updated!");
            }
        }
    }

    public void count() {
        System.out.printf("The Phone Book has %s records.\n", contacts.size());
    }

    public void list() {
        for (int i = 0, contactsSize = contacts.size(); i < contactsSize; i++) {
            Contact contact = contacts.get(i);
            System.out.printf("%s. %s %s, ", i + 1, contact.getName(), contact.getSurname());
            System.out.println(contact.getNumber());
        }
    }
}
