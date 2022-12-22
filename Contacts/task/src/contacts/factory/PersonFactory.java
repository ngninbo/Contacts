package contacts.factory;

import contacts.domain.Contact;
import contacts.domain.Person;
import contacts.utils.InputValidator;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PersonFactory implements ContactFactory {

    @Override
    public Contact createContact() {

        Person person = new Person();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name: ");
        person.setName(scanner.nextLine());
        System.out.print("Enter the surname: ");
        person.setSurname(scanner.nextLine());
        System.out.print("Enter the birth date: ");
        person.setBirthdate(scanner.nextLine());
        System.out.print("Enter the gender (M, F): ");
        person.setGender(scanner.nextLine());
        System.out.print("Enter the number: ");
        person.setNumber(scanner.nextLine());

        return person;
    }

    public static Person edit(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = scanner.nextLine();

        if (InputValidator.isValidPersonField(field)) {
            System.out.printf("Enter %s: ", field);
            String value = scanner.nextLine();

            switch (field) {
                case "name":
                    person.setName(value);
                    break;
                case "surname":
                    person.setSurname(value);
                    break;
                case "birth":
                    person.setBirthdate(value);
                    break;
                case "gender":
                    person.setGender(value);
                    break;
                case "number":
                    person.setNumber(value);
                    break;
            }

            person.setLastEditTime(LocalDateTime.now());
        }

        return person;
    }
}
