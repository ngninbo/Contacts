package contacts.domain;

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
}
