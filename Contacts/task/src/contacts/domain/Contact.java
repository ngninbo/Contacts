package contacts.domain;

import contacts.utils.InputValidator;

import java.util.Objects;

public class Contact {

    private String name;
    private String surname;
    private String number;

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getName(), contact.getName()) && Objects.equals(getSurname(), contact.getSurname()) && Objects.equals(getNumber(), contact.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getNumber());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
