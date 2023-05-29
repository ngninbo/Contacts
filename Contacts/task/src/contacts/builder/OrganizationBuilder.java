package contacts.builder;

import contacts.domain.ContactField;
import contacts.model.Contact;
import contacts.model.Organization;

import static contacts.factory.RequestFactory.*;

public class OrganizationBuilder extends ContactBuilder {

    private Organization organization;

    @Override
    public void init() {
       organization = new Organization();
    }

    @Override
    public void setName() {
        organization.setName(requestOrganisationName());
    }

    @Override
    public void setNumber() {
        organization.setNumber(validate(ContactField.NUMBER, request(ContactField.NUMBER)));
    }

    public void setAddress() {
        organization.setAddress(request(ContactField.ADDRESS));
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
