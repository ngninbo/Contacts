package contacts.builder;

import contacts.model.Contact;
import contacts.model.Organization;

import static contacts.utils.PhoneBookUtils.*;

public class OrganizationBuilder extends ContactBuilder {

    private Organization organization;

    @Override
    public void init() {
       organization = new Organization();
    }

    @Override
    public void setName() {
        organization.setOrganizationName(requestOrganisationName());
    }

    @Override
    public void setNumber() {
        organization.setNumber(validate(requestNumberInput()));
    }

    public void setAddress() {
        organization.setAddress(requestAddressInput());
    }

    @Override
    public Contact create() {
        init();
        setName();
        setAddress();
        setNumber();
        return organization;
    }
}
