package contacts.model;

import contacts.domain.ContactField;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
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

    public void setLastEditTime(LocalDateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public abstract void info();

    public abstract String getFullName();

    public abstract String getEditableFields();

    public abstract void setFieldValue(ContactField field, String value);

    public abstract String appendFieldValues();

    public String stringify(ContactField... fields) {
        return Stream.of(fields).map(Enum::name)
                .map(String::toLowerCase)
                .collect(Collectors.joining(", "));
    }
}
