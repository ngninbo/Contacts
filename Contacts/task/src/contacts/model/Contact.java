package contacts.model;

import contacts.utils.InputValidator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

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

    public boolean match(String query) {
        final String regex = String.format(".*%s.*", query);
        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
                .matcher(appendFieldValues())
                .matches();
    }
}
