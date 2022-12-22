package contacts.domain;

import java.util.Objects;

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
        if (!birthdate.matches("^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")) {
            System.out.println("Bad birth date!");
            birthdate = "[no data]";
        }
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        if (!gender.matches("[FM]")) {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }

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
        System.out.printf("Name: %s\nSurname: %s\nBirth date: %s\nGender: " +
                "%s\nNumber: %s\nTime created: %s\nTime last edit: %s\n",
                name, surname, birthdate, gender, number, createdTime, lastEditTime);
    }
}
