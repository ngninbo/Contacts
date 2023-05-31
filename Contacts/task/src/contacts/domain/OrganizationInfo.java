package contacts.domain;

import contacts.model.Organization;

import java.util.List;

public class OrganizationInfo extends ContactInfo {

    Organization organization;

    public OrganizationInfo(Organization organization) {
        super(organization);
        this.organization = organization;
    }

    @Override
    protected List<String> getFieldLabels() {
        return ContactField.getFieldLabels(ContactType.ORGANIZATION);
    }

    @Override
    protected String[] getValues() {
        return new String[]{organization.getName(), organization.getAddress(), organization.getNumber()};
    }
}
