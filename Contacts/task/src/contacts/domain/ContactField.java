package contacts.domain;

import contacts.factory.PatternFactory;

import java.util.List;

public enum ContactField {

    NAME,
    SURNAME,
    ADDRESS,
    NUMBER,
    BIRTH,
    GENDER;

    public String getLabel() {
        return "contact.".concat(name().toLowerCase());
    }

    public static List<ContactField> getFieldsToBeValidated() {
        return List.of(ContactField.BIRTH, ContactField.GENDER, ContactField.NUMBER);
    }

    public String getRegex() {
        final String patternKey = getLabel().concat(".regex");
        return ContactField.GENDER.equals(this) ?
                PatternFactory.format(patternKey, Gender.joinGender().replace(", ", "")) :
                PatternFactory.from(patternKey);
    }
}
