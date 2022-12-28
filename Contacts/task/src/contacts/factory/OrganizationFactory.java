package contacts.factory;

import contacts.domain.Contact;
import contacts.domain.Organization;

import static contacts.utils.PhoneBookUtils.requestInput;

public class OrganizationFactory implements ContactFactory {

    @Override
    public Contact createContact() {
        Organization organization = new Organization();
        organization.setOrganizationName(requestInput("Enter the organization name: "));
        organization.setAddress(requestInput("Enter the address: "));
        organization.setNumber(requestInput("Enter the number: "));
        return organization;
    }
}
