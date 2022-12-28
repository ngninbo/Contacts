package contacts.factory;

import contacts.domain.Contact;
import contacts.domain.Person;

import static contacts.utils.PhoneBookUtils.requestInput;

public class PersonFactory implements ContactFactory {

    @Override
    public Contact createContact() {

        Person person = new Person();
        person.setName(requestInput("Enter the name: "));
        person.setSurname(requestInput("Enter the surname: "));
        person.setBirthdate(requestInput("Enter the birth date: "));
        person.setGender(requestInput("Enter the gender (M, F): "));
        person.setNumber(requestInput("Enter the number: "));

        return person;
    }
}
