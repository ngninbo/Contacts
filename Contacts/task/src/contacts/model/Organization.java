package contacts.model;

import contacts.domain.ContactField;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

public class Organization extends Contact {

    private String address;

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
        return Objects.equals(getName(), that.getName()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress());
    }

    @Override
    public String toString() {
        return "Organization{" +
                "number='" + number + '\'' +
                ", organizationName='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public String getFullName() {
        return getName();
    }

    @Override
    public Stream<String> getEditableFields() {
        return stringify(Stream.of(ContactField.NAME, ContactField.ADDRESS, ContactField.NUMBER));
    }

    @Override
    public void setFieldValue(ContactField field, String value) {

        switch (field) {
            case NAME:
                setName(value);
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
        return String.join(" ", getFullName(), getAddress(), getNumber());
    }
}
