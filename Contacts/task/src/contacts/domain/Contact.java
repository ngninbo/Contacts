package contacts.domain;

import contacts.utils.InputValidator;

import java.time.LocalDateTime;

public abstract class Contact {

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
        if (!InputValidator.isValidNumber(number)) {
            System.out.println("Wrong number format!");
            number = "[no number]";
        }

        this.number = number;
    }

    public void setLastEditTime(LocalDateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public abstract void info();

    public abstract String getFullName();

    public abstract String getEditableFields();
    public abstract void setFieldValue(String field, String value);

    public abstract String appendFieldValues();
}
