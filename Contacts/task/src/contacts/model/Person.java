package contacts.model;

import contacts.domain.ContactField;
import contacts.utils.PhoneBookUtils;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

public class Person extends Contact {

    private String name;
    private String surname;
    private String birthdate;
    private String gender;

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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(), person.getSurname()) &&
                Objects.equals(getBirthdate(), person.getBirthdate()) && Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthdate(), getGender());
    }

    @Override
    public String toString() {
        return "Person{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public void info() {
        System.out.println(PhoneBookUtils.format("person.info",
                name, surname, birthdate, gender, number, createdTime, lastEditTime));
    }

    @Override
    public String getFullName() {
        return String.join(" ", name, surname);
    }

    @Override
    public Stream<String> getEditableFields() {
        return stringify(Stream.of(ContactField.NAME, ContactField.SURNAME, ContactField.BIRTH, ContactField.GENDER, ContactField.NUMBER));
    }

    @Override
    public void setFieldValue(ContactField field, String value) {
        switch (field) {
            case NAME:
                setName(value);
                break;
            case SURNAME:
                setSurname(value);
                break;
            case BIRTH:
                setBirthdate(value);
                break;
            case GENDER:
                setGender(value);
                break;
            case NUMBER:
                setNumber(value);
                break;
            default:
        }

        setLastEditTime(LocalDateTime.now());
    }

    @Override
    public String appendFieldValues() {
        return String.join(" ", getFullName(), getBirthdate(), getGender(), getNumber());
    }
}
