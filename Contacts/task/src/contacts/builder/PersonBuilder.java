package contacts.builder;

import contacts.domain.ContactField;
import contacts.model.Contact;
import contacts.model.Person;

import static contacts.factory.RequestFactory.*;

public class PersonBuilder extends ContactBuilder {

    private Person person;

    @Override
    public void init() {
        person = new Person();
    }

    @Override
    public void setName() {
        person.setName(request(ContactField.NAME));
    }

    @Override
    public void setNumber() {
        person.setNumber(validate(ContactField.NUMBER, request(ContactField.NUMBER)));
    }

    public void setSurname() {
        person.setSurname(request(ContactField.SURNAME));
    }

    public void setBirthdate() {
        person.setBirthdate(validate(ContactField.BIRTH, requestBirthdateInput()));
    }

    public void setGender() {
        person.setGender(validate(ContactField.GENDER, request(ContactField.GENDER)));
    }

    @Override
    public Contact create() {
        init();
        setName();
        setSurname();
        setBirthdate();
        setGender();
        setNumber();
        return person;
    }
}
