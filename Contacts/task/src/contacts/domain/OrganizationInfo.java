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
        return List.of("organization.name", ContactField.ADDRESS.getLabel(), ContactField.NUMBER.getLabel());
    }

    @Override
    protected String[] getValues() {
        return new String[]{organization.getName(), organization.getAddress(), organization.getNumber()};
    }
}
