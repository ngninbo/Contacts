package contacts.domain;

import contacts.utils.InputValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(LocalDateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public abstract void info();
}
