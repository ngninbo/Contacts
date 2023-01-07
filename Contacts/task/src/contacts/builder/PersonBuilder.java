package contacts.builder;

import contacts.model.Contact;
import contacts.model.Person;

import static contacts.utils.PhoneBookUtils.requestInput;

public class PersonBuilder implements ContactBuilder {

    @Override
    public Contact create() {
        Person person = new Person();
        person.setName(requestInput("Enter the name: "));
        person.setSurname(requestInput("Enter the surname: "));
        person.setBirthdate(requestInput("Enter the birth date: "));
        person.setGender(requestInput("Enter the gender (M, F): "));
        person.setNumber(requestInput("Enter the number: "));
        return person;
    }
}
