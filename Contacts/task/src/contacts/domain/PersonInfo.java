package contacts.domain;

import contacts.model.Person;

import java.util.List;

public class PersonInfo extends ContactInfo {

    private final Person person;

    public PersonInfo(Person person) {
        super(person);
        this.person = person;
    }

    @Override
    protected String[] getValues() {
        return new String[]{person.getName(), person.getSurname(), person.getBirthdate(), person.getGender(), person.getNumber()};
    }

    @Override
    protected List<String> getFieldLabels() {
        return ContactField.getFieldLabels(ContactType.PERSON);
    }
}
