package contacts.builder;

import contacts.domain.ContactField;
import contacts.model.Contact;
import contacts.utils.InputValidator;

public abstract class ContactBuilder {

    public abstract void init();
    public abstract void setName();
    public abstract void setNumber();

    public abstract Contact create();

    public static String validate(ContactField field, String value) {
        return InputValidator.validate(field, value);
    }
}
