package contacts.builder;

import contacts.model.Contact;
import contacts.domain.Gender;
import contacts.model.Person;
import contacts.utils.InputValidator;

import static contacts.utils.PhoneBookUtils.*;

public class PersonBuilder extends ContactBuilder {

    private Person person;

    @Override
    public void init() {
        person = new Person();
    }

    @Override
    public void setName() {
        person.setName(requestNameInput());
    }

    @Override
    public void setNumber() {
        person.setNumber(validate(requestNumberInput()));
    }

    public void setSurname() {
        person.setSurname(requestSurnameInput());
    }

    public void setBirthdate() {
        String birthdate = requestBirthdateInput();
        if (!InputValidator.isValidBirthDate(birthdate)) {
            System.out.println(resourcesBundle.get("birthdate.validation.error"));
            birthdate = resourcesBundle.get("missing.value.msg");
        }

        person.setBirthdate(birthdate);
    }

    public void setGender() {
        String gender = requestGenderInput();

        if (!InputValidator.isValidGender(gender)) {
            System.out.println(resourcesBundle.get("gender.validation.error"));
            gender = resourcesBundle.get("missing.value.msg");
        }

        person.setGender(gender);
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
