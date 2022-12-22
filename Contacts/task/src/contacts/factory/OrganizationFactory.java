package contacts.factory;

import contacts.domain.Contact;
import contacts.domain.Organization;
import contacts.utils.InputValidator;

import java.time.LocalDateTime;
import java.util.Scanner;

public class OrganizationFactory implements ContactFactory {

    public static Contact edit(Organization organization) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (address, number): ");
        String field = scanner.nextLine();

        if (InputValidator.isOrganizationField(field)) {
            System.out.printf("Enter %s: ", field);
            String value = scanner.nextLine();

            switch (field) {
                case "address":
                    organization.setAddress(value);
                    break;
                case "number":
                    organization.setNumber(value);
                    break;
            }

            organization.setLastEditTime(LocalDateTime.now());
        }

        return organization;
    }

    @Override
    public Contact createContact() {
        Organization organization = new Organization();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the organization name: ");
        organization.setOrganizationName(scanner.nextLine());
        System.out.print("Enter the address: ");
        organization.setAddress(scanner.nextLine());
        System.out.print("Enter the number: ");
        organization.setNumber(scanner.nextLine());
        return organization;
    }
}
