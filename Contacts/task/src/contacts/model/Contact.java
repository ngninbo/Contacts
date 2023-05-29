package contacts.model;

import contacts.domain.ContactField;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public abstract class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String name;
    protected String number;
    protected LocalDateTime createdTime;
    protected LocalDateTime lastEditTime;

    {
        this.createdTime = LocalDateTime.now();
        this.lastEditTime = this.createdTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(LocalDateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getFullName();

    public abstract Stream<String> getEditableFields();

    public abstract void setFieldValue(ContactField field, String value);

    public abstract String appendFieldValues();

    public Stream<String> stringify(Stream<ContactField> fields) {
        return fields.map(ContactField::getLabel);
    }
}
