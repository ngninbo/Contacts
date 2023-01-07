package contacts.model;

import java.time.LocalDateTime;
import java.util.Objects;

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
        System.out.printf("Organization name: %s\nAddress: %s\nNumber: %s\nTime created: %s\nTime last edit: %s\n",
                organizationName, address, number, createdTime, lastEditTime);
    }

    @Override
    public String getFullName() {
        return organizationName;
    }

    @Override
    public String getEditableFields() {
        return "address, number";
    }

    @Override
    public void setFieldValue(String field, String value) {
        if ("address".equals(field)) {
            setAddress(value);
        } else if ("number".equals(field)) {
            setNumber(value);
        }

        setLastEditTime(LocalDateTime.now());
    }

    @Override
    public String appendFieldValues() {
        return getFullName() + " " + getNumber() + " " + getAddress();
    }
}
