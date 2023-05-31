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

    public static final String CONTACT = "contact";

    public String getLabel() {
        return (CONTACT + ".").concat(name().toLowerCase());
    }

    public static List<ContactField> getFieldsToBeValidated() {
        return List.of(ContactField.BIRTH, ContactField.GENDER, ContactField.NUMBER);
    }

    public static List<String> getFieldLabels(ContactType contactType) {
        switch (contactType) {
            case PERSON:
                return List.of(ContactField.NAME.getLabel(), ContactField.SURNAME.getLabel(),
                        CONTACT + ".creation.birth", ContactField.GENDER.getLabel(), ContactField.NUMBER.getLabel());
            case ORGANIZATION:
                return List.of(ContactField.NAME.getLabel().replace(CONTACT, "organization"),
                        ContactField.ADDRESS.getLabel(), ContactField.NUMBER.getLabel());
            default:
                return List.of();
        }
    }

    public String getRegex() {
        final String patternKey = getLabel().concat(".regex");
        return ContactField.GENDER.equals(this) ?
                PatternFactory.format(patternKey, Gender.joinGender().replace(", ", "")) :
                PatternFactory.from(patternKey);
    }
}
