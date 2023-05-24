package contacts.model;

import contacts.domain.ContactField;
import contacts.factory.MessageFactory;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

public class Organization extends Contact {

    private String organizationName;
    private String address;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        Organization that = (Organization) o;
        return Objects.equals(getOrganizationName(), that.getOrganizationName()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrganizationName(), getAddress());
    }

    @Override
    public String toString() {
        return "Organization{" +
                "number='" + number + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public void info() {
        System.out.println(MessageFactory.format("organization.info",
                organizationName, address, number, createdTime, lastEditTime));
    }

    @Override
    public String getFullName() {
        return getOrganizationName();
    }

    @Override
    public Stream<String> getEditableFields() {
        return stringify(Stream.of(ContactField.NAME, ContactField.ADDRESS, ContactField.NUMBER));
    }

    @Override
    public void setFieldValue(ContactField field, String value) {

        switch (field) {
            case NAME:
                setOrganizationName(value);
                break;
            case NUMBER:
                setNumber(value);
                break;
            case ADDRESS:
               setAddress(value);
            default:
        }

        setLastEditTime(LocalDateTime.now());
    }

    @Override
    public String appendFieldValues() {
        return String.join(" ", getFullName(), getNumber(), getAddress());
    }
}
